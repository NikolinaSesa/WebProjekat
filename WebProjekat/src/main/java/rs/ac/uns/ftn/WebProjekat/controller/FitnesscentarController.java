package rs.ac.uns.ftn.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import rs.ac.uns.ftn.WebProjekat.model.Fitnesscentar;
import rs.ac.uns.ftn.WebProjekat.model.dto.FitnesscentarDTO;
import rs.ac.uns.ftn.WebProjekat.service.FitnesscentarService;

@RestController
@RequestMapping(value = "/api/fitnesscentar")
public class FitnesscentarController {

    private final FitnesscentarService fitnesscentarService;

    @Autowired
    public FitnesscentarController(FitnesscentarService fitnesscentarService){
        this.fitnesscentarService = fitnesscentarService;
    }
    
    @PostMapping(value = "/dodaj" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesscentarDTO> createFitnesscentar(@RequestBody FitnesscentarDTO fitnesscentarDTO) throws Exception{
        Fitnesscentar fitnesscentar = new Fitnesscentar(fitnesscentarDTO.getNaziv(), fitnesscentarDTO.getAdresa(), fitnesscentarDTO.getBrTelefona(), fitnesscentarDTO.getEmail());

        Fitnesscentar newFitnesscentar = fitnesscentarService.create(fitnesscentar);

        FitnesscentarDTO newFitnesscentarDTO = new FitnesscentarDTO(newFitnesscentar.getId(), newFitnesscentar.getNaziv(), newFitnesscentar.getAdresa(), newFitnesscentar.getBrTelefona(), newFitnesscentar.getEmail());

        return new ResponseEntity<>(newFitnesscentarDTO, HttpStatus.CREATED);
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
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
