package rs.ac.uns.ftn.WebProjekat.service;

import rs.ac.uns.ftn.WebProjekat.model.Administrator;

public interface AdminService{

    Administrator findByKorisnickoime(String korisnickoime);

    Administrator findOne(Long id);
    
}
