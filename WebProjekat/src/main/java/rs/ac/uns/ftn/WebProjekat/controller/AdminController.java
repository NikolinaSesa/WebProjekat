package rs.ac.uns.ftn.WebProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import rs.ac.uns.ftn.WebProjekat.model.Administrator;
import rs.ac.uns.ftn.WebProjekat.model.dto.AdminDTO;
import rs.ac.uns.ftn.WebProjekat.service.AdminService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }

    //za prijavu administratora
    @GetMapping(value = "/ki/{korisnickoime}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminDTO> getAdmin(@PathVariable String korisnickoime){
        Administrator admin = this.adminService.findByKorisnickoime(korisnickoime);

        AdminDTO adminDTO = new AdminDTO(admin.getId(), admin.getKorisnickoIme(), admin.getLozinka(), admin.getIme(), admin.getPrezime(), admin.getBrTelefona(), admin.getEmail(), admin.getUloga());

        return new ResponseEntity<>(adminDTO, HttpStatus.OK);
    }
    
}
