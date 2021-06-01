package rs.ac.uns.ftn.WebProjekat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.WebProjekat.model.dto.ClanDTO;
import org.springframework.web.bind.annotation.RequestBody;
import rs.ac.uns.ftn.WebProjekat.model.Clan;
import rs.ac.uns.ftn.WebProjekat.model.Uloga;
import rs.ac.uns.ftn.WebProjekat.service.ClanService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/clan")
public class ClanController {

    private final ClanService clanService;

    @Autowired
    public ClanController(ClanService clanService){
        this.clanService=clanService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> createClan(@RequestBody ClanDTO clanDTO) throws Exception{
        Clan clan = new Clan(clanDTO.getKorisnickoIme(), clanDTO.getLozinka(), clanDTO.getIme(), clanDTO.getPrezime(), clanDTO.getBrTelefona(), clanDTO.getEmail(), clanDTO.getDatumRodjenja(), Uloga.CLAN, true);

        Clan newClan = clanService.create(clan);

        ClanDTO newClanDTO = new ClanDTO(newClan.getId(), newClan.getKorisnickoIme(), newClan.getLozinka(), newClan.getIme(), newClan.getPrezime(), newClan.getBrTelefona(), newClan.getEmail(), newClan.getDatum(), newClan.getUloga(), newClan.getAktivan());
        
        return new ResponseEntity<>(newClanDTO, HttpStatus.CREATED);
    }
    
}
