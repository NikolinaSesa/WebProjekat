package rs.ac.uns.ftn.WebProjekat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.WebProjekat.model.dto.ClanDTO;
import org.springframework.web.bind.annotation.RequestBody;
import rs.ac.uns.ftn.WebProjekat.model.Administrator;
import rs.ac.uns.ftn.WebProjekat.model.Clan;
import rs.ac.uns.ftn.WebProjekat.model.Trener;
import rs.ac.uns.ftn.WebProjekat.model.Uloga;
import rs.ac.uns.ftn.WebProjekat.service.AdminService;
import rs.ac.uns.ftn.WebProjekat.service.ClanService;
import rs.ac.uns.ftn.WebProjekat.service.TrenerService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/clan")
public class ClanController {

    private final ClanService clanService;
    private final TrenerService trenerService;
    private final AdminService adminService;

    @Autowired
    public ClanController(ClanService clanService, TrenerService trenerService, AdminService adminService){
        this.clanService=clanService;
        this.trenerService=trenerService;
        this.adminService=adminService;
    }

    //za registraciju clana
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> createClan(@RequestBody ClanDTO clanDTO) throws Exception{
        
        Trener tmplTrener=this.trenerService.findByKorisnickoime(clanDTO.getKorisnickoIme());
        Administrator tmplAdmin=this.adminService.findByKorisnickoime(clanDTO.getKorisnickoIme());
        if(tmplTrener==null && tmplAdmin==null){
            Clan tmplClan=this.clanService.findByKorisnickoime(clanDTO.getKorisnickoIme());
            if(tmplClan==null){
                Clan clan = new Clan(clanDTO.getKorisnickoIme(), clanDTO.getLozinka(), clanDTO.getIme(), clanDTO.getPrezime(), clanDTO.getBrTelefona(), clanDTO.getEmail(), clanDTO.getDatumRodjenja(), Uloga.CLAN, true);
                Clan newClan = clanService.create(clan);
                ClanDTO newClanDTO = new ClanDTO(newClan.getId(), newClan.getKorisnickoIme(), newClan.getLozinka(), newClan.getIme(), newClan.getPrezime(), newClan.getBrTelefona(), newClan.getEmail(), newClan.getDatum(), newClan.getUloga(), newClan.getAktivan());
                return new ResponseEntity<>(newClanDTO, HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    //za prijavu clana
    @GetMapping(value = "/ki/{korisnickoime}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> getClan(@PathVariable("korisnickoime") String korisnickoime){
        Clan clan = this.clanService.findByKorisnickoime(korisnickoime);

        ClanDTO clanDTO = new ClanDTO(clan.getId(), clan.getKorisnickoIme(), clan.getLozinka(), clan.getIme(), clan.getPrezime(), clan.getBrTelefona(), clan.getEmail(), clan.getDatum(), clan.getUloga(), clan.getAktivan());

        return new ResponseEntity<>(clanDTO, HttpStatus.OK);
    }

    //Za pregled profila
    @GetMapping(value = "/id/{clanId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> getClan(@PathVariable Long clanId){

        Clan clan=this.clanService.findOne(clanId);

        ClanDTO clanDTO=new ClanDTO();
        clanDTO.setKorisnickoIme(clan.getKorisnickoIme());
        clanDTO.setLozinka(clan.getLozinka());
        clanDTO.setIme(clan.getIme());
        clanDTO.setPrezime(clan.getPrezime());
        clanDTO.setBrTelefona(clan.getBrTelefona());
        clanDTO.setEmail(clan.getEmail());
        clanDTO.setDatumRodjenja(clan.getDatum());

        return new ResponseEntity<>(clanDTO, HttpStatus.OK);
    }

    
}
