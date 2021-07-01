package rs.ac.uns.ftn.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import rs.ac.uns.ftn.WebProjekat.model.dto.TerminDTO;
import rs.ac.uns.ftn.WebProjekat.model.Clan;
import rs.ac.uns.ftn.WebProjekat.model.Termin;
import rs.ac.uns.ftn.WebProjekat.model.Uloga;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import rs.ac.uns.ftn.WebProjekat.service.ClanService;
import rs.ac.uns.ftn.WebProjekat.service.TerminService;
import rs.ac.uns.ftn.WebProjekat.model.dto.Tip;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/termin")
public class TerminController{

    private final TerminService terminService;
    private final ClanService clanService;

    @Autowired
    public TerminController(TerminService terminService, ClanService clanService){
        this.terminService=terminService;
        this.clanService=clanService;
    }

    @GetMapping(value = "/cena/{cena}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiPoCeni(@PathVariable("cena") Double cena){
        List<Termin> termini = this.terminService.findByCena(cena);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(),termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDan(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
            terminiDTO.add(terminDTO);
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    } 
    
    @GetMapping(value = "/vreme/{vreme}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiPoVremenu(@PathVariable("vreme") Time vreme){
        List<Termin> termini = this.terminService.findByVreme(vreme);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(),termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDan(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
            terminiDTO.add(terminDTO);
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    } 
    
    @GetMapping(value = "/naziv/{naziv}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiPoNazivu(@PathVariable("naziv") String naziv){
        List<Termin> termini = this.terminService.findByTreningNaziv(naziv);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDan(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
            terminiDTO.add(terminDTO);
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/opis/{opis}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiPoOpisu(@PathVariable("opis") String opis){
        List<Termin> termini = this.terminService.findByTreningOpis(opis);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDan(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
            terminiDTO.add(terminDTO);
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    } 

    @GetMapping(value = "/tip/{tip}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiPoTipu(@PathVariable("tip") Tip tip){
        List<Termin> termini = this.terminService.findByTreningTip(tip);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDan(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
            terminiDTO.add(terminDTO);
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    } 

    @GetMapping(value = "/sort/rastuce/cena/{fitnesscentarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getSortTerminiPoCenaRastuce(@PathVariable Long fitnesscentarId){

            List<Termin> termini = this.terminService.findAllAndSortByCenaRastuce(fitnesscentarId);
            List<TerminDTO> terminiDTO = new ArrayList<>();

            for(Termin termin : termini){
                TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDan(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
                terminiDTO.add(terminDTO);
            }
            return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
        }
        
    @GetMapping(value = "/sort/opadajuce/cena/{fitnesscentarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getSortTerminiPoCenaOpadajuce(@PathVariable Long fitnesscentarId){
        List<Termin> termini = this.terminService.findAllAndSortByCenaOpadajuce(fitnesscentarId);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDan(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
            terminiDTO.add(terminDTO);
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    } 

    @GetMapping(value = "/sort/rastuce/vreme/{fitnesscentarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getSortTerminiPoVremeRastuce(@PathVariable Long fitnesscentarId){
        List<Termin> termini = this.terminService.findAllAndSortByVremeRastuce(fitnesscentarId);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDan(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
            terminiDTO.add(terminDTO);
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    } 

    @GetMapping(value = "/sort/opadajuce/vreme/{fitnesscentarId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getSortTerminiPoVremeOpadajuce(@PathVariable Long fitnesscentarId){
        List<Termin> termini = this.terminService.findAllAndSortByVremeOpadajuce(fitnesscentarId);

        List<TerminDTO> terminiDTO = new ArrayList<>();

        for(Termin termin : termini){
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getTrening().getNaziv(), termin.getTrening().getTip(), termin.getTrening().getOpis(), termin.getCena(), termin.getVreme(), termin.getDan(), termin.getTrening().getTrener().getIme(), termin.getTrening().getTrener().getPrezime());
            terminiDTO.add(terminDTO);
        }
        return new ResponseEntity<>(terminiDTO, HttpStatus.OK);
    }
    
    //Prijava za termin treninga
    @GetMapping(value = "/prijava/{id}/{uloga}/{terminId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> getTermin(@PathVariable Long id, @PathVariable Uloga uloga, @PathVariable Long terminId) throws Exception{

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
                    Termin terminUpdate=this.terminService.update(termin, clan);

                    TerminDTO terminDTO=new TerminDTO(terminUpdate.getId(), terminUpdate.getTrening().getNaziv(), terminUpdate.getTrening().getTip(), terminUpdate.getTrening().getOpis(), terminUpdate.getCena(), terminUpdate.getVreme(), terminUpdate.getDan(), terminUpdate.getTrening().getTrener().getIme(), terminUpdate.getTrening().getTrener().getPrezime());        
                    return new ResponseEntity<>(terminDTO, HttpStatus.OK);
                }
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
