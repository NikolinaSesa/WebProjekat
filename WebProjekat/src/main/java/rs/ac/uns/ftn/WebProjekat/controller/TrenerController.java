package rs.ac.uns.ftn.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.uns.ftn.WebProjekat.service.TrenerService;

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
import rs.ac.uns.ftn.WebProjekat.model.Trener;
import rs.ac.uns.ftn.WebProjekat.model.Uloga;
import rs.ac.uns.ftn.WebProjekat.model.dto.TrenerDTO;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/trener")
public class TrenerController{

    private final TrenerService trenerService;

    @Autowired
    public TrenerController(TrenerService trenerService){
        this.trenerService=trenerService;
    }

    @PostMapping(value = "/dodaj", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> createTrener(@RequestBody TrenerDTO trenerDTO) throws Exception{
        Trener trener = new Trener(trenerDTO.getKorisnickoIme(), trenerDTO.getLozinka(), trenerDTO.getIme(), trenerDTO.getPrezime(),trenerDTO.getBrTelefona(), trenerDTO.getEmail(), trenerDTO.getDatumRodjenja(), Uloga.TRENER, false);
        
        Trener newTrener = trenerService.create(trener);

        TrenerDTO newTrenerDTO = new TrenerDTO(newTrener.getId(), newTrener.getKorisnickoIme(), newTrener.getLozinka(), newTrener.getIme(), newTrener.getPrezime(), newTrener.getBrTelefona(), newTrener.getEmail(), newTrener.getDatum(), newTrener.getUloga(), newTrener.getAktivan());

        return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
    }

    @PostMapping(value = "/dodajKaoAdmin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> adminCreateTrener(@RequestBody TrenerDTO trenerDTO) throws Exception{
        Trener trener = new Trener(trenerDTO.getKorisnickoIme(), trenerDTO.getLozinka(), trenerDTO.getIme(), trenerDTO.getPrezime(),trenerDTO.getBrTelefona(), trenerDTO.getEmail(), trenerDTO.getDatumRodjenja(), Uloga.TRENER, true);
        
        Trener newTrener = trenerService.create(trener);

        TrenerDTO newTrenerDTO = new TrenerDTO(newTrener.getId(), newTrener.getKorisnickoIme(), newTrener.getLozinka(), newTrener.getIme(), newTrener.getPrezime(), newTrener.getBrTelefona(), newTrener.getEmail(), newTrener.getDatum(), newTrener.getUloga(), newTrener.getAktivan());

        return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/aktivan/fcid/{aktivan}/{fitnesscentarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrenerDTO>> getListaZahteva(@PathVariable Boolean aktivan, @PathVariable Long fitnesscentarId){
        List<Trener> treneri = this.trenerService.findByAktivanAndFitnesscentarId(aktivan, fitnesscentarId);

        List<TrenerDTO> treneriDTO = new ArrayList<>(); 

        for(Trener trener : treneri){
            TrenerDTO trenerDTO = new TrenerDTO(trener.getId(), trener.getKorisnickoIme(), trener.getIme(), trener.getPrezime(), trener.getBrTelefona(), trener.getEmail(), trener.getDatum(), trener.getUloga(), trener.getAktivan());
            treneriDTO.add(trenerDTO);
        }
        return new ResponseEntity<>(treneriDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> getTrener(@PathVariable("id") Long id){
        Trener trener = this.trenerService.findOne(id);

        TrenerDTO trenerDTO = new TrenerDTO();
        trenerDTO.setId(trener.getId());
        trenerDTO.setKorisnickoIme(trener.getKorisnickoIme());
        trenerDTO.setIme(trener.getIme());
        trenerDTO.setPrezime(trener.getPrezime());
        trenerDTO.setBr(trener.getBrTelefona());
        trenerDTO.setEmail(trener.getEmail());
        trenerDTO.setDatum(trener.getDatum());
        trenerDTO.setUloga(trener.getUloga());
        trenerDTO.setAktivan(trener.getAktivan());

        return new ResponseEntity<>(trenerDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteZahtev(@PathVariable Long id){
        this.trenerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping( value = "/put/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> updateTrener(@PathVariable Long id, @RequestBody TrenerDTO trenerDTO) throws Exception{
        Trener trener = new Trener(trenerDTO.getKorisnickoIme(), trenerDTO.getIme(), trenerDTO.getPrezime(), trenerDTO.getBrTelefona(), trenerDTO.getEmail(), trenerDTO.getDatumRodjenja(), trenerDTO.getUloga(), trenerDTO.getAktivan());
        trener.setId(id);

        Trener updateTrener = trenerService.update(trener);

        TrenerDTO updateTrenerDTO = new TrenerDTO(updateTrener.getId(), updateTrener.getKorisnickoIme(), updateTrener.getIme(), updateTrener.getPrezime(), updateTrener.getBrTelefona(), updateTrener.getEmail(), updateTrener.getDatum(), updateTrener.getUloga(), updateTrener.getAktivan());

        return new ResponseEntity<>(updateTrenerDTO, HttpStatus.OK);
    }

}
