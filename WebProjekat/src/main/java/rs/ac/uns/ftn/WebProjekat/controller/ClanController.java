package rs.ac.uns.ftn.WebProjekat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.uns.ftn.WebProjekat.model.dto.ClanDTO;
import rs.ac.uns.ftn.WebProjekat.model.dto.TerminDTO;
import org.springframework.web.bind.annotation.RequestBody;
import rs.ac.uns.ftn.WebProjekat.model.Administrator;
import rs.ac.uns.ftn.WebProjekat.model.Clan;
import rs.ac.uns.ftn.WebProjekat.model.Termin;
import rs.ac.uns.ftn.WebProjekat.model.Trener;
import rs.ac.uns.ftn.WebProjekat.model.Uloga;
import rs.ac.uns.ftn.WebProjekat.service.AdminService;
import rs.ac.uns.ftn.WebProjekat.service.ClanService;
import rs.ac.uns.ftn.WebProjekat.service.TerminService;
import rs.ac.uns.ftn.WebProjekat.service.TrenerService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/clan")
public class ClanController {

    private final ClanService clanService;
    private final TrenerService trenerService;
    private final AdminService adminService;
    private final TerminService terminService;

    @Autowired
    public ClanController(ClanService clanService, TrenerService trenerService, AdminService adminService, TerminService terminService){
        this.clanService=clanService;
        this.trenerService=trenerService;
        this.adminService=adminService;
        this.terminService=terminService;
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
    @GetMapping(value = "/id/{clanId}/{uloga}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> getClan(@PathVariable Long clanId, @PathVariable Uloga uloga){

        if(uloga==Uloga.CLAN){
            Clan clan=this.clanService.findOne(clanId);
            if(clan==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
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
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        
    }

    //Za pregled prijavljenih termina
    @GetMapping(value = "/prijavljeni/{id}/{uloga}/{fitnesscentarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getListaPrijava(@PathVariable Long id, @PathVariable Uloga uloga, @PathVariable Long fitnesscentarId){

        if(uloga==Uloga.CLAN){
            Clan clan=this.clanService.findOne(id);
            if(clan==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                Set<Termin> prijavljeniTremini=clan.getListaPrijava();
                List<TerminDTO> prijavljeniTerminiDTO=new ArrayList<>();

                for(Termin termin : prijavljeniTremini){
                    if(termin.getTrening().getTrener().getFitnessCentar().getId()==fitnesscentarId){
                        LocalDate localDate=LocalDate.now();
                        Date date=Date.valueOf(localDate);
                        if(date.before(termin.getDatum())){

                            TerminDTO terminDTO=new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDatum(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
                            prijavljeniTerminiDTO.add(terminDTO); 
                        }  
                    } 
                }
                return new ResponseEntity<>(prijavljeniTerminiDTO, HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    //izmena profila
    @PutMapping(value = "/izmeni/{id}/{uloga}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> updateClan(@RequestBody ClanDTO clanDTO, @PathVariable Long id, @PathVariable Uloga uloga) throws Exception{
        if(uloga==Uloga.CLAN){
            Clan tmplclan=this.clanService.findOne(id);
            if(tmplclan==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                Clan clan=new Clan(clanDTO.getKorisnickoIme(), clanDTO.getLozinka(), clanDTO.getIme(), clanDTO.getPrezime(), clanDTO.getBrTelefona(), clanDTO.getEmail(), clanDTO.getDatumRodjenja(), tmplclan.getUloga(), true);
                clan.setId(id);

                Clan upDateClan=this.clanService.update(clan);
                ClanDTO upDateClanDTO=new ClanDTO(upDateClan.getId(), upDateClan.getKorisnickoIme(), upDateClan.getLozinka(), upDateClan.getIme(), upDateClan.getPrezime(), upDateClan.getBrTelefona(), upDateClan.getEmail(), upDateClan.getDatum(), upDateClan.getUloga(), true);
                return new ResponseEntity<>(upDateClanDTO, HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    
     //Clanovi koji su prijavljeni za dati termin
     @GetMapping(value = "/prijavljeniClanovi/{id}/{uloga}/{terminId}", produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<List<ClanDTO>> prijavljeniClanovi(@PathVariable Long id, @PathVariable Uloga uloga, @PathVariable Long terminId){

        if(uloga==Uloga.TRENER){
            Trener trener=this.trenerService.findOne(id);
            if(trener==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                Termin termin=this.terminService.findById(terminId);
                Set<Clan> clanovi=termin.getPrijavljeni();
                List<ClanDTO> clanoviDTO=new ArrayList<>();
                for(Clan clan : clanovi){
                    ClanDTO clanDTO= new ClanDTO(clan.getId(), clan.getIme(), clan.getPrezime(), clan.getBrTelefona(), clan.getEmail(), clan.getDatum());
                    clanoviDTO.add(clanDTO);
                }
                return new ResponseEntity<>(clanoviDTO, HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
     }
}
