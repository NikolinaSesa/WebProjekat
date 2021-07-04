package rs.ac.uns.ftn.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import rs.ac.uns.ftn.WebProjekat.model.dto.TerminDTO;
import rs.ac.uns.ftn.WebProjekat.model.dto.TerminDTO2;
import rs.ac.uns.ftn.WebProjekat.model.Clan;
import rs.ac.uns.ftn.WebProjekat.model.Sala;
import rs.ac.uns.ftn.WebProjekat.model.Termin;
import rs.ac.uns.ftn.WebProjekat.model.Trener;
import rs.ac.uns.ftn.WebProjekat.model.Trening;
import rs.ac.uns.ftn.WebProjekat.model.Uloga;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import rs.ac.uns.ftn.WebProjekat.service.ClanService;
import rs.ac.uns.ftn.WebProjekat.service.SalaService;
import rs.ac.uns.ftn.WebProjekat.service.TerminService;
import rs.ac.uns.ftn.WebProjekat.service.TrenerService;
import rs.ac.uns.ftn.WebProjekat.service.TreningService;
import rs.ac.uns.ftn.WebProjekat.model.dto.Tip;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/termin")
public class TerminController{

    private final TerminService terminService;
    private final ClanService clanService;
    private final TrenerService trenerService;
    private final SalaService salaService;
    private final TreningService treningService;

    @Autowired
    public TerminController(TerminService terminService, ClanService clanService, TrenerService trenerService, SalaService salaService, TreningService treningService){
        this.terminService=terminService;
        this.clanService=clanService;
        this.trenerService=trenerService;
        this.salaService=salaService;
        this.treningService=treningService;
    }

    @GetMapping(value = "/id/{id}/{uloga}/{terminId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> getTermin(@PathVariable Long id, @PathVariable Uloga uloga, @PathVariable Long terminId){
        if(uloga==Uloga.CLAN){
            Clan clan=this.clanService.findOne(id);
            if(clan==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                Termin termin=this.terminService.findById(terminId);
                TerminDTO terminDTO=new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDatum(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());

                return new ResponseEntity<>(terminDTO, HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/cena/{cena}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiPoCeni(@PathVariable("cena") Double cena){
        List<Termin> termini = this.terminService.findByCena(cena);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            LocalDate localDate=LocalDate.now();
            Date date=Date.valueOf(localDate);
            if(date.before(termin.getDatum())){

                TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(),termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDatum(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
                terminiDTO.add(terminDTO);
            }
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    } 
    
    @GetMapping(value = "/vreme/{vreme}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiPoVremenu(@PathVariable("vreme") Time vreme){
        List<Termin> termini = this.terminService.findByVreme(vreme);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            LocalDate localDate=LocalDate.now();
            Date date=Date.valueOf(localDate);
            if(date.before(termin.getDatum())){

                TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(),termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDatum(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
                terminiDTO.add(terminDTO);
            }
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    } 
    
    @GetMapping(value = "/naziv/{naziv}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiPoNazivu(@PathVariable("naziv") String naziv){
        List<Termin> termini = this.terminService.findByTreningNaziv(naziv);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            LocalDate localDate=LocalDate.now();
            Date date=Date.valueOf(localDate);
            if(date.before(termin.getDatum())){

                TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDatum(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
                terminiDTO.add(terminDTO);
            }
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/opis/{opis}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiPoOpisu(@PathVariable("opis") String opis){
        List<Termin> termini = this.terminService.findByTreningOpis(opis);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            LocalDate localDate=LocalDate.now();
            Date date=Date.valueOf(localDate);
            if(date.before(termin.getDatum())){

                TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDatum(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
                terminiDTO.add(terminDTO);
            }
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    } 

    @GetMapping(value = "/tip/{tip}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiPoTipu(@PathVariable("tip") Tip tip){
        List<Termin> termini = this.terminService.findByTreningTip(tip);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            LocalDate localDate=LocalDate.now();
            Date date=Date.valueOf(localDate);
            if(date.before(termin.getDatum())){

                TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDatum(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
                terminiDTO.add(terminDTO);
            }
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    } 

    @GetMapping(value = "/sort/rastuce/cena/{fitnesscentarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getSortTerminiPoCenaRastuce(@PathVariable Long fitnesscentarId){

            List<Termin> termini = this.terminService.findAllAndSortByCenaRastuce(fitnesscentarId);
            List<TerminDTO> terminiDTO = new ArrayList<>();

            for(Termin termin : termini){
                LocalDate localDate=LocalDate.now();
                Date date=Date.valueOf(localDate);
                if(date.before(termin.getDatum())){

                    TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDatum(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
                    terminiDTO.add(terminDTO);
                }
            }
            return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
        }
        
    @GetMapping(value = "/sort/opadajuce/cena/{fitnesscentarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getSortTerminiPoCenaOpadajuce(@PathVariable Long fitnesscentarId){
        List<Termin> termini = this.terminService.findAllAndSortByCenaOpadajuce(fitnesscentarId);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            LocalDate localDate=LocalDate.now();
            Date date=Date.valueOf(localDate);
            if(date.before(termin.getDatum())){

                TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDatum(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
                terminiDTO.add(terminDTO);
            }
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    } 

    @GetMapping(value = "/sort/rastuce/vreme/{fitnesscentarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getSortTerminiPoVremeRastuce(@PathVariable Long fitnesscentarId){
        List<Termin> termini = this.terminService.findAllAndSortByVremeRastuce(fitnesscentarId);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            LocalDate localDate=LocalDate.now();
            Date date=Date.valueOf(localDate);
            if(date.before(termin.getDatum())){

                TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDatum(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
                terminiDTO.add(terminDTO);
            }
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    } 

    @GetMapping(value = "/sort/opadajuce/vreme/{fitnesscentarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getSortTerminiPoVremeOpadajuce(@PathVariable Long fitnesscentarId){
        List<Termin> termini = this.terminService.findAllAndSortByVremeOpadajuce(fitnesscentarId);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            LocalDate localDate=LocalDate.now();
            Date date=Date.valueOf(localDate);
            if(date.before(termin.getDatum())){

                TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDatum(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
                terminiDTO.add(terminDTO);
            }
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    }
    
    //Prijava za termin treninga
    @GetMapping(value = "/prijava/{id}/{uloga}/{terminId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> prijavaZaTermin(@PathVariable Long id, @PathVariable Uloga uloga, @PathVariable Long terminId) throws Exception{

        if(uloga==Uloga.CLAN){
            Clan clan=this.clanService.findOne(id);
            if(clan==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                Termin termin=this.terminService.findById(terminId);

                if(termin.getBrPrijavljenihClanova()+1>=termin.getSala().getKapacitet()){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                else{
                    termin.setBrPrijavljenihClanova(termin.getBrPrijavljenihClanova()+1);
                    Termin terminUpdate=this.terminService.update(termin, clan);

                    TerminDTO terminDTO=new TerminDTO(terminUpdate.getId(), terminUpdate.getTrening().getNaziv(), terminUpdate.getTrening().getTip(), terminUpdate.getTrening().getOpis(), terminUpdate.getCena(), terminUpdate.getVreme(), terminUpdate.getDatum(), terminUpdate.getTrening().getTrener().getIme(), terminUpdate.getTrening().getTrener().getPrezime());        
                    return new ResponseEntity<>(terminDTO, HttpStatus.OK);
                }
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    //Otkazivanje termina
    @GetMapping(value = "/otkazi/{id}/{uloga}/{terminId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> otkazi(@PathVariable Long id, @PathVariable Uloga uloga, @PathVariable Long terminId) throws Exception{

        if(uloga==Uloga.CLAN){
            Clan clan=this.clanService.findOne(id);
            if(clan==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                Termin termin=this.terminService.findById(terminId);
                termin.setBrPrijavljenihClanova(termin.getBrPrijavljenihClanova()-1);
                Termin terminToUpdate=this.terminService.otkazi(termin, clan);

                TerminDTO terminDTO= new TerminDTO(terminToUpdate.getId(), terminToUpdate.getTrening().getNaziv(), terminToUpdate.getTrening().getTip(), terminToUpdate.getTrening().getOpis(), terminToUpdate.getCena(), terminToUpdate.getVreme(), terminToUpdate.getDatum(), terminToUpdate.getTrening().getTrener().getIme(), terminToUpdate.getTrening().getTrener().getPrezime());
                return new ResponseEntity<>(terminDTO, HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    //Lista odradjenih termina
    @GetMapping(value = "/odradjeni/{id}/{uloga}/{fitnesscentarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getListaOdradjenih(@PathVariable Long id, @PathVariable Uloga uloga, @PathVariable Long fitnesscentarId) throws Exception{

        if(uloga==Uloga.CLAN){
            Clan clan=this.clanService.findOne(id);
            if(clan==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                Set<Termin> prijavljeniTermini=clan.getListaPrijava();
                List<TerminDTO> odradjeniTerminiDTO=new ArrayList<>();

                for(Termin termin : prijavljeniTermini){
                    if(termin.getTrening().getTrener().getFitnessCentar().getId()==fitnesscentarId){
                        LocalDate localDate=LocalDate.now();
                        Date date=Date.valueOf(localDate);
                        if(date.after(termin.getDatum())){
                            Termin odradjen=this.terminService.odradjen(termin, clan);
                            TerminDTO terminDTO=new TerminDTO(odradjen.getId(), odradjen.getTrening().getNaziv(), odradjen.getTrening().getTip(), odradjen.getTrening().getOpis(), odradjen.getCena(), odradjen.getVreme(), odradjen.getDatum(), odradjen.getTrening().getTrener().getIme(), odradjen.getTrening().getTrener().getPrezime());
                            odradjeniTerminiDTO.add(terminDTO);
                        }
                    }
                }
                return new ResponseEntity<>(odradjeniTerminiDTO, HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    //Kreiranje novog termina
    @PostMapping(value = "/kreiraj/{id}/{uloga}/{salaOznaka}/{nazivTreninga}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> createTermin(@RequestBody TerminDTO2 terminDTO2, @PathVariable Long id, @PathVariable Uloga uloga, @PathVariable String salaOznaka, @PathVariable String nazivTreninga) throws Exception{

        if(uloga==Uloga.TRENER){
            Trener trener=this.trenerService.findOne(id);
            if(trener==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                Sala sala=this.salaService.findByOznaka(salaOznaka);
                Termin tmplTermin=this.terminService.findBySalaIdAndDatumAndVreme(sala.getId(), terminDTO2.getDatum(), terminDTO2.getVreme());
                if(tmplTermin==null){
                    Trening trening=this.treningService.findByNazivAndTrenerId(nazivTreninga, id);
                    if(trening==null){
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                    }
                    else{
                        Termin termin=new Termin(terminDTO2.getCena(), terminDTO2.getDatum(), terminDTO2.getVreme(), sala, trening);
                        Termin newTermin=this.terminService.create(termin);
                        TerminDTO newterminDTO=new TerminDTO(newTermin.getId(), newTermin.getTrening().getNaziv(), newTermin.getTrening().getTip(), newTermin.getTrening().getOpis(), newTermin.getCena(), newTermin.getVreme(), newTermin.getDatum(), newTermin.getTrening().getTrener().getIme(), newTermin.getTrening().getTrener().getPrezime());
                        newterminDTO.setSalaId(sala.getId());
                        newterminDTO.setTreningId(trening.getId());

                        return new ResponseEntity<>(newterminDTO, HttpStatus.CREATED);
                    }
                }
                else{
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
