package rs.ac.uns.ftn.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.WebProjekat.service.AdminService;
import rs.ac.uns.ftn.WebProjekat.service.ClanService;
import rs.ac.uns.ftn.WebProjekat.service.TrenerService;
import rs.ac.uns.ftn.WebProjekat.service.TreningService;
import rs.ac.uns.ftn.WebProjekat.model.Administrator;
import rs.ac.uns.ftn.WebProjekat.model.Clan;
import rs.ac.uns.ftn.WebProjekat.model.Trener;
import rs.ac.uns.ftn.WebProjekat.model.Trening;
import rs.ac.uns.ftn.WebProjekat.model.Uloga;
import rs.ac.uns.ftn.WebProjekat.model.dto.TreningDTO;
import rs.ac.uns.ftn.WebProjekat.model.dto.TreningDTO2;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/treninzi")
public class TreningController{
    
    private final TreningService treningService;
    private final ClanService clanService;
    private final TrenerService trenerService;
    private final AdminService adminService;

    @Autowired
    public TreningController(TreningService treningService, ClanService clanService, TrenerService trenerService, AdminService adminService){
        this.treningService = treningService;
        this.clanService=clanService;
        this.trenerService=trenerService;
        this.adminService=adminService;
    }

    @GetMapping(value = "/{fitnesscentarId}/{id}/{uloga}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreninzi(@PathVariable Long fitnesscentarId, @PathVariable Long id, @PathVariable Uloga uloga){
        switch(uloga){
            case CLAN:
                Clan clan=this.clanService.findOne(id);
                if(clan==null){
                    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
                }
                else{
                    List<Trening> treninzi = this.treningService.findByTrenerFitnesscentarId(fitnesscentarId); 
                    List<TreningDTO> treninziDTO = new ArrayList<>();

                    for(Trening trening : treninzi) {
                        TreningDTO treningDTO = new TreningDTO(trening.getId(),trening.getNaziv(), trening.getTip(), trening.getOpis(), trening.getTrajanje(),trening.getTrener().getIme(), trening.getTrener().getPrezime());
                        treninziDTO.add(treningDTO);
                    }
                    return new ResponseEntity<>(treninziDTO, HttpStatus.OK);
                }  
            case TRENER:
                Trener trener=this.trenerService.findOne(id);
                if(trener==null){
                    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
                }
                else{
                    List<Trening> treninzi = this.treningService.findByTrenerFitnesscentarId(fitnesscentarId); 
                    List<TreningDTO> treninziDTO = new ArrayList<>();

                    for(Trening trening : treninzi) {
                        TreningDTO treningDTO = new TreningDTO(trening.getId(),trening.getNaziv(), trening.getTip(), trening.getOpis(), trening.getTrajanje(),trening.getTrener().getIme(), trening.getTrener().getPrezime());
                        treninziDTO.add(treningDTO);
                    }
                    return new ResponseEntity<>(treninziDTO, HttpStatus.OK);
                }
            default:
                Administrator admin=this.adminService.findOne(id);
                if(admin==null){
                    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
                }
                else{
                    List<Trening> treninzi = this.treningService.findByTrenerFitnesscentarId(fitnesscentarId); 
                    List<TreningDTO> treninziDTO = new ArrayList<>();

                    for(Trening trening : treninzi) {
                        TreningDTO treningDTO = new TreningDTO(trening.getId(),trening.getNaziv(), trening.getTip(), trening.getOpis(), trening.getTrajanje(),trening.getTrener().getIme(), trening.getTrener().getPrezime());
                        treninziDTO.add(treningDTO);
                    }
                    return new ResponseEntity<>(treninziDTO, HttpStatus.OK);
                }
        }   
    }

    @GetMapping(value = "/trenerPregledTreninga/{id}/{uloga}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> treninzi(@PathVariable Long id, @PathVariable Uloga uloga){

        if(uloga==Uloga.TRENER){
            Trener trener=this.trenerService.findOne(id);
            if(trener==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                List<Trening> treninzi=this.treningService.findByTrenerFitnesscentarId(trener.getFitnessCentar().getId());
                List<TreningDTO> treninziDTO=new ArrayList<>();
                for(Trening trening : treninzi){
                    TreningDTO treningDTO=new TreningDTO(trening.getId(), trening.getNaziv(), trening.getTip(), trening.getOpis(), trening.getTrajanje(), trening.getTrener().getIme(), trening.getTrener().getPrezime());
                    treninziDTO.add(treningDTO);
                }
                return new ResponseEntity<>(treninziDTO, HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping(value = "/dodajNoviTrening/{id}/{uloga}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> dodajNoviTrening(@RequestBody TreningDTO2 treningDTO2, @PathVariable Long id, @PathVariable Uloga uloga)throws Exception{

        if(uloga==Uloga.TRENER){
            Trener trener=this.trenerService.findOne(id);
            if(trener==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                Trening trening=new Trening(treningDTO2.getNaziv(), treningDTO2.getOpis(), treningDTO2.getTip(), treningDTO2.getTrajanje(), trener);
                Trening newTrening=this.treningService.create(trening);
                TreningDTO newTreningDTO=new TreningDTO(newTrening.getId(), newTrening.getNaziv(), newTrening.getTip(), newTrening.getOpis(), newTrening.getTrajanje(), newTrening.getTrener().getIme(), newTrening.getTrener().getPrezime());

                return new ResponseEntity<>(newTreningDTO, HttpStatus.CREATED);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    
}
