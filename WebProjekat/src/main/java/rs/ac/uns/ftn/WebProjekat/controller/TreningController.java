package rs.ac.uns.ftn.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.WebProjekat.service.TreningService;
import rs.ac.uns.ftn.WebProjekat.model.Trening;
import rs.ac.uns.ftn.WebProjekat.model.dto.TreningDTO;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/treninzi")
public class TreningController{
    
    private final TreningService treningService;

    @Autowired
    public TreningController(TreningService treningService){
        this.treningService = treningService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreninzi(){
        List<Trening> treninzi = this.treningService.findAll(); 

        List<TreningDTO> treninziDTO = new ArrayList<>();

        for(Trening trening : treninzi) {
            TreningDTO treningDTO = new TreningDTO(trening.getId(),trening.getNaziv(), trening.getOpis(), trening.getTrajanje(),trening.getTrener().getIme(), trening.getTrener().getPrezime());
            treninziDTO.add(treningDTO);
        }

        return new ResponseEntity<>(treninziDTO, HttpStatus.OK);
    }
    
}
