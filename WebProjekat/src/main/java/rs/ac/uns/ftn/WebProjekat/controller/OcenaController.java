package rs.ac.uns.ftn.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import rs.ac.uns.ftn.WebProjekat.model.Clan;
import rs.ac.uns.ftn.WebProjekat.model.Ocena;
import rs.ac.uns.ftn.WebProjekat.model.Termin;
import rs.ac.uns.ftn.WebProjekat.model.Uloga;
import rs.ac.uns.ftn.WebProjekat.model.dto.OcenaDTO;
import rs.ac.uns.ftn.WebProjekat.service.ClanService;
import rs.ac.uns.ftn.WebProjekat.service.OcenaService;
import rs.ac.uns.ftn.WebProjekat.service.TerminService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/ocena")
public class OcenaController {

    private final OcenaService ocenaService;
    private final TerminService terminService;
    private final ClanService clanService;

    @Autowired
    public OcenaController(OcenaService ocenaService, TerminService terminService, ClanService clanService){
        this.ocenaService=ocenaService;
        this.terminService=terminService;
        this.clanService=clanService;
    }
    
     //Za ocenjivanje termina
     @PostMapping(value = "/oceni/{id}/{uloga}/{terminId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<OcenaDTO> createOcena(@RequestBody OcenaDTO ocenaDTO, @PathVariable Long id, @PathVariable Uloga uloga, @PathVariable Long terminId) throws Exception{

        if(uloga==Uloga.CLAN){
            Clan clan=this.clanService.findOne(id);
            if(clan==null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else{
                Termin termin=this.terminService.findById(terminId);
                Ocena ocena=new Ocena(ocenaDTO.getOcena(), clan, termin);
                Ocena newOcena=this.ocenaService.create(ocena);

                OcenaDTO newOcenaDTO=new OcenaDTO(newOcena.getId(), newOcena.getOcena());
                
                return new ResponseEntity<>(newOcenaDTO, HttpStatus.CREATED);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
     }
}
