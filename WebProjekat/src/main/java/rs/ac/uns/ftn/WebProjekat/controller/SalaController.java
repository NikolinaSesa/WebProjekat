package rs.ac.uns.ftn.WebProjekat.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.WebProjekat.model.Administrator;
import rs.ac.uns.ftn.WebProjekat.model.Fitnesscentar;
import rs.ac.uns.ftn.WebProjekat.model.Sala;
import rs.ac.uns.ftn.WebProjekat.model.Uloga;
import rs.ac.uns.ftn.WebProjekat.model.dto.SalaDTO;
import rs.ac.uns.ftn.WebProjekat.service.AdminService;
import rs.ac.uns.ftn.WebProjekat.service.FitnesscentarService;
import rs.ac.uns.ftn.WebProjekat.service.SalaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/sala")
public class SalaController {

    private final SalaService salaService;
    private final AdminService adminService;
    private final FitnesscentarService fitnesscentarService;

    @Autowired
    public SalaController(SalaService salaService, AdminService adminService, FitnesscentarService fitnesscentarService){
        this.salaService=salaService;
        this.adminService=adminService;
        this.fitnesscentarService=fitnesscentarService;
    }

    @PostMapping(value = "/dodaj/{id}/{uloga}/{fitnesscentarId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> createSala(@RequestBody SalaDTO salaDTO, @PathVariable Long id, @PathVariable Uloga uloga, @PathVariable Long fitnesscentarId) throws Exception{
        
        if(uloga==Uloga.ADMINISTRATOR){
            Administrator admin=this.adminService.findOne(id);
            if(admin==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                Fitnesscentar fitnesscentar = this.fitnesscentarService.findById(fitnesscentarId);
                Sala sala=new Sala(salaDTO.getKapacitet(), salaDTO.getOznaka(), fitnesscentar);
                Sala newSala=this.salaService.create(sala);

                SalaDTO newSalaDTO=new SalaDTO(newSala.getId(), newSala.getKapacitet(), newSala.getOznaka(), newSala.getFitnessCentar().getId());
                return new ResponseEntity<>(newSalaDTO, HttpStatus.CREATED);

            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping(value = "/izmeni/{salaId}/{id}/{uloga}/{fitnesscentarId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> updateSala(@RequestBody SalaDTO salaDTO, @PathVariable Long salaId, @PathVariable Long id, @PathVariable Uloga uloga, @PathVariable Long fitnesscentarId) throws Exception{

        if(uloga==Uloga.ADMINISTRATOR){
            Administrator admin=this.adminService.findOne(id);
            if(admin==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                Fitnesscentar fitnesscentar=this.fitnesscentarService.findById(fitnesscentarId);
                Sala sala=new Sala(salaDTO.getKapacitet(), salaDTO.getOznaka(), fitnesscentar);
                sala.setId(salaId);

                Sala updateSala=this.salaService.update(sala);
                SalaDTO updateSalaDTO=new SalaDTO(updateSala.getId(), updateSala.getKapacitet(), updateSala.getOznaka(), updateSala.getFitnessCentar().getId());
                return new ResponseEntity<>(updateSalaDTO, HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping(value = "/obrisi/{salaId}/{id}/{uloga}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long salaId, @PathVariable Long id, @PathVariable Uloga uloga){
        
        if(uloga==Uloga.ADMINISTRATOR){
            Administrator admin=this.adminService.findOne(id);
            if(admin!=null){
                this.salaService.delete(salaId);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/sve/{fitnesscentarId}/{id}/{uloga}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDTO>> getSale(@PathVariable Long fitnesscentarId, @PathVariable Long id, @PathVariable Uloga uloga){
        
        if(uloga==Uloga.ADMINISTRATOR){
            Administrator admin=this.adminService.findOne(id);
            if(admin==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                List<Sala> sale=this.salaService.findByFitnesscentarId(fitnesscentarId);
                List<SalaDTO> saleDTO=new ArrayList<>();

                for(Sala sala : sale){
                    SalaDTO salaDTO=new SalaDTO(sala.getId(), sala.getKapacitet(), sala.getOznaka(), sala.getFitnessCentar().getId());
                    saleDTO.add(salaDTO);
                }
                return new ResponseEntity<>(saleDTO, HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/{salaId}/{id}/{uloga}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> getSala(@PathVariable Long salaId, @PathVariable Long id, @PathVariable Uloga uloga){

        if(uloga==Uloga.ADMINISTRATOR){
            Administrator admin=this.adminService.findOne(id);
            if(admin==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            else{
                Sala sala=this.salaService.findById(salaId);
                SalaDTO salaDTO=new SalaDTO(sala.getId(), sala.getKapacitet(), sala.getOznaka(), sala.getFitnessCentar().getId());
                return new ResponseEntity<>(salaDTO, HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    
}
