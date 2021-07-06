package rs.ac.uns.ftn.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.uns.ftn.WebProjekat.service.AdminService;
import rs.ac.uns.ftn.WebProjekat.service.ClanService;
import rs.ac.uns.ftn.WebProjekat.service.FitnesscentarService;
import rs.ac.uns.ftn.WebProjekat.service.OcenaService;
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
import rs.ac.uns.ftn.WebProjekat.model.Administrator;
import rs.ac.uns.ftn.WebProjekat.model.Fitnesscentar;
import rs.ac.uns.ftn.WebProjekat.model.Ocena;
import rs.ac.uns.ftn.WebProjekat.model.Trener;
import rs.ac.uns.ftn.WebProjekat.model.Clan;
import rs.ac.uns.ftn.WebProjekat.model.Uloga;
import rs.ac.uns.ftn.WebProjekat.model.dto.TrenerDTO;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/trener")
public class TrenerController{

    private final TrenerService trenerService;
    private final AdminService adminService;
    private final FitnesscentarService fitnesscentarService;
    private final ClanService calnService;
    private final OcenaService ocenaService;

    @Autowired
    public TrenerController(TrenerService trenerService, AdminService adminService, FitnesscentarService fitnesscentarService, ClanService clanService, OcenaService ocenaService){
        this.trenerService=trenerService;
        this.adminService=adminService;
        this.fitnesscentarService=fitnesscentarService;
        this.calnService=clanService;
        this.ocenaService=ocenaService;
    }

    //za registraciju trenera
    @PostMapping(value = "/dodaj", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> createTrener(@RequestBody TrenerDTO trenerDTO) throws Exception{

        Clan tmplClan=this.calnService.findByKorisnickoime(trenerDTO.getKorisnickoIme());
        Administrator tmplAdmin=this.adminService.findByKorisnickoime(trenerDTO.getKorisnickoIme());
        if(tmplClan==null && tmplAdmin==null){
            Trener tmplTrener = this.trenerService.findByKorisnickoime(trenerDTO.getKorisnickoIme());
            if(tmplTrener!=null){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }else{
                Trener trener = new Trener(trenerDTO.getKorisnickoIme(), trenerDTO.getLozinka(), trenerDTO.getIme(), trenerDTO.getPrezime(),trenerDTO.getBrTelefona(), trenerDTO.getEmail(), trenerDTO.getDatumRodjenja(), Uloga.TRENER, false);
                Trener newTrener = trenerService.create(trener);
                TrenerDTO newTrenerDTO = new TrenerDTO(newTrener.getId(), newTrener.getKorisnickoIme(), newTrener.getIme(), newTrener.getPrezime(), newTrener.getBrTelefona(), newTrener.getEmail(), newTrener.getDatum(), newTrener.getUloga(), newTrener.getAktivan());
                newTrenerDTO.setLozinka(trener.getLozinka());                  
                return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
    }

    //za registraciju trenera od strane admina
    @PostMapping(value = "/dodajKaoAdmin/{fitnesscentarId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> adminCreateTrener(@RequestBody TrenerDTO trenerDTO, @PathVariable Long fitnesscentarId) throws Exception{

        Trener tmplTrener = this.trenerService.findByKorisnickoime(trenerDTO.getKorisnickoIme());
        Clan tmplClan = this.calnService.findByKorisnickoime(trenerDTO.getKorisnickoIme());
        Administrator tmplAdmin = this.adminService.findByKorisnickoime(trenerDTO.getKorisnickoIme());
        if(tmplTrener!=null && tmplClan!=null && tmplAdmin!=null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        else{
            Fitnesscentar fitnesscentar = this.fitnesscentarService.findById(fitnesscentarId);
            Trener trener = new Trener(trenerDTO.getKorisnickoIme(), trenerDTO.getLozinka(), trenerDTO.getIme(), trenerDTO.getPrezime(),trenerDTO.getBrTelefona(), trenerDTO.getEmail(), trenerDTO.getDatumRodjenja(), Uloga.TRENER, true);
            trener.setFitnessCentar(fitnesscentar);
            Trener newTrener = trenerService.create(trener);
            TrenerDTO newTrenerDTO = new TrenerDTO(newTrener.getId(), newTrener.getKorisnickoIme(), newTrener.getLozinka(), newTrener.getIme(), newTrener.getPrezime(), newTrener.getBrTelefona(), newTrener.getEmail(), newTrener.getDatum(), newTrener.getUloga(), newTrener.getAktivan(), newTrener.getFitnessCentar().getId());
            return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
        }   
    }

    //za dobavljane svih trenera po aktivnosti u datom fc
    @GetMapping(value = "/aktivan/fcid/{aktivan}/{fitnesscentarId}/{id}/{uloga}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrenerDTO>> getListaZahteva(@PathVariable Boolean aktivan, @PathVariable Long fitnesscentarId, @PathVariable Long id, @PathVariable Uloga uloga){

        if(uloga == Uloga.ADMINISTRATOR){

            Administrator admin = this.adminService.findOne(id);
            if(admin==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{

                List<Trener> treneri = this.trenerService.findByAktivanAndFitnesscentarId(aktivan, fitnesscentarId);

                List<TrenerDTO> treneriDTO = new ArrayList<>(); 

                for(Trener trener : treneri){
                    TrenerDTO trenerDTO = new TrenerDTO(trener.getId(), trener.getKorisnickoIme(), trener.getIme(), trener.getPrezime(), trener.getBrTelefona(), trener.getEmail(), trener.getDatum(), trener.getUloga(), trener.getAktivan());
                    treneriDTO.add(trenerDTO);
                }
                return new ResponseEntity<>(treneriDTO, HttpStatus.OK);
            }
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    //za dodatne informacije o treneru
    @GetMapping(value = "/id/{trenerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> getTrener(@PathVariable Long trenerId){

        Trener trener = this.trenerService.findOne(trenerId);

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

    //za brisanje trenera od strane admina
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

    //za prijavu trenera
    @GetMapping(value = "/ki/{korisnickoime}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> getTrener(@PathVariable String korisnickoime){
        Trener trener = this.trenerService.findByKorisnickoime(korisnickoime);
        if(trener.getAktivan()==true){
            TrenerDTO trenerDTO = new TrenerDTO(trener.getId(), trener.getKorisnickoIme(), trener.getLozinka(), trener.getIme(), trener.getPrezime(), trener.getBrTelefona(), trener.getEmail(), trener.getDatum(), trener.getUloga(), trener.getAktivan(), trener.getFitnessCentar().getId());
            return new ResponseEntity<>(trenerDTO, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    //za azuriranje prosecne ocene trenera
    @GetMapping(value = "/azurirajProsecnuOcenu/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> azurirajPrOcenu(@PathVariable Long id) throws Exception{

        Trener trener=this.trenerService.findOne(id);
        List<Ocena> ocene=this.ocenaService.findByTerminTreningTrenerId(id);
        int n=0;
        int suma=0;
        double prOcena=0;
        for(Ocena ocena : ocene){
            n++;
            suma=suma+ocena.getOcena();
        }
        prOcena=suma/n;
        trener.setPrOcena(prOcena);
        Trener updateTrener=this.trenerService.updateProsecneOcene(trener);
        TrenerDTO trenerDTO=new TrenerDTO(updateTrener.getId(), updateTrener.getKorisnickoIme(), updateTrener.getIme(), trener.getPrezime(), updateTrener.getBrTelefona(), updateTrener.getEmail(), updateTrener.getDatum(), updateTrener.getUloga(), updateTrener.getAktivan());
        trenerDTO.setPrOcena(prOcena);
        return new ResponseEntity<>(trenerDTO, HttpStatus.OK);
    }
}
