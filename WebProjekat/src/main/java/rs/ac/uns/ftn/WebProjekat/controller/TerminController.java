package rs.ac.uns.ftn.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import rs.ac.uns.ftn.WebProjekat.model.dto.TerminDTO;
import rs.ac.uns.ftn.WebProjekat.model.Termin;
import java.util.ArrayList;
import java.util.List;
import rs.ac.uns.ftn.WebProjekat.service.TerminService;

@RestController
public class TerminController{

    private final TerminService terminService;

    @Autowired
    public TerminController(TerminService terminService){
        this.terminService=terminService;
    }

    @GetMapping(value = "/api/terminicena/{cena}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiPoCeni(@PathVariable("cena") Double cena){
        List<Termin> termini = this.terminService.findByCena(cena);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
            terminiDTO.add(terminDTO);
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    } 
    
    @GetMapping(value = "/api/terminivreme/{vreme}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiPoVremenu(@PathVariable("vreme") Double vreme){
        List<Termin> termini = this.terminService.findByVreme(vreme);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
            terminiDTO.add(terminDTO);
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    } 
    
    @GetMapping(value = "api/termininaziv/{naziv}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiPoNazivu(@PathVariable("naziv") String naziv){
        List<Termin> termini = this.terminService.findByTreningNaziv(naziv);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
            terminiDTO.add(terminDTO);
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    }

}