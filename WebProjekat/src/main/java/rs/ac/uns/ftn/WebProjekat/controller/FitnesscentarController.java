package rs.ac.uns.ftn.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import rs.ac.uns.ftn.WebProjekat.model.Administrator;
import rs.ac.uns.ftn.WebProjekat.model.Fitnesscentar;
import rs.ac.uns.ftn.WebProjekat.model.Uloga;
import rs.ac.uns.ftn.WebProjekat.model.dto.FitnesscentarDTO;
import rs.ac.uns.ftn.WebProjekat.service.AdminService;
import rs.ac.uns.ftn.WebProjekat.service.FitnesscentarService;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/fitnesscentar")
public class FitnesscentarController {

    private final FitnesscentarService fitnesscentarService;
    private final AdminService adminService;

    @Autowired
    public FitnesscentarController(FitnesscentarService fitnesscentarService, AdminService adminService){
        this.fitnesscentarService = fitnesscentarService;
        this.adminService=adminService;
    }
    
    @PostMapping(value = "/dodaj/{id}/{uloga}" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesscentarDTO> createFitnesscentar(@RequestBody FitnesscentarDTO fitnesscentarDTO, @PathVariable Long id, @PathVariable Uloga uloga) throws Exception{

        if(uloga==Uloga.ADMINISTRATOR){

            Administrator admin = this.adminService.findOne(id);
            if(admin==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                Fitnesscentar fitnesscentar = new Fitnesscentar(fitnesscentarDTO.getNaziv(), fitnesscentarDTO.getAdresa(), fitnesscentarDTO.getBrTelefona(), fitnesscentarDTO.getEmail());

                Fitnesscentar newFitnesscentar = fitnesscentarService.create(fitnesscentar);

                FitnesscentarDTO newFitnesscentarDTO = new FitnesscentarDTO(newFitnesscentar.getId(), newFitnesscentar.getNaziv(), newFitnesscentar.getAdresa(), newFitnesscentar.getBrTelefona(), newFitnesscentar.getEmail());

                return new ResponseEntity<>(newFitnesscentarDTO, HttpStatus.CREATED);
            }
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping(value = "/izmeni/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesscentarDTO> updateFitnesscentar(@PathVariable Long id, @RequestBody FitnesscentarDTO fitnesscentarDTO) throws Exception{

        Fitnesscentar fitnesscentar = new Fitnesscentar(fitnesscentarDTO.getNaziv(), fitnesscentarDTO.getAdresa(), fitnesscentarDTO.getBrTelefona(), fitnesscentarDTO.getEmail());

        fitnesscentar.setId(id);

        Fitnesscentar updateFitnesscentar = fitnesscentarService.update(fitnesscentar);

        FitnesscentarDTO updateFitnesscentarDTO = new FitnesscentarDTO(updateFitnesscentar.getId(), updateFitnesscentar.getNaziv(), updateFitnesscentar.getAdresa(), updateFitnesscentar.getBrTelefona(), updateFitnesscentar.getEmail());

        return new ResponseEntity<>(updateFitnesscentarDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/obrisi/{id}")
    public ResponseEntity<Void> deleteFitnesscentar(@PathVariable Long id){
        this.fitnesscentarService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/svi/{id}/{uloga}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnesscentarDTO>> getFitnesscentri(@PathVariable Long id, @PathVariable Uloga uloga){

        if(uloga==Uloga.ADMINISTRATOR){

            Administrator admin =this.adminService.findOne(id);
            if(admin==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{

                List<Fitnesscentar> fitnesscentri = this.fitnesscentarService.findAll();

                List<FitnesscentarDTO> fitnesscentriDTO = new ArrayList<>();

                for(Fitnesscentar fitnesscentar : fitnesscentri){
                    FitnesscentarDTO fitnesscentarDTO = new FitnesscentarDTO(fitnesscentar.getId(), fitnesscentar.getNaziv(), fitnesscentar.getAdresa(), fitnesscentar.getBrTelefona(), fitnesscentar.getEmail());
                    fitnesscentriDTO.add(fitnesscentarDTO);
                }
                return new ResponseEntity<>(fitnesscentriDTO, HttpStatus.OK);
            }
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping(value = "/id/{fitnesscentarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesscentarDTO> getFitnesscentarById(@PathVariable Long fitnesscentarId){
        Fitnesscentar fitnesscentar = this.fitnesscentarService.findById(fitnesscentarId);

        FitnesscentarDTO fitnesscentarDTO = new FitnesscentarDTO(fitnesscentar.getId(), fitnesscentar.getNaziv(), fitnesscentar.getAdresa(), fitnesscentar.getBrTelefona(), fitnesscentar.getEmail());

        return new ResponseEntity<>(fitnesscentarDTO, HttpStatus.OK);
    }
}
