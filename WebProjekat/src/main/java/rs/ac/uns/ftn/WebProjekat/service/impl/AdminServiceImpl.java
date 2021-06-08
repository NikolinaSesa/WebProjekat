package rs.ac.uns.ftn.WebProjekat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.WebProjekat.model.Administrator;
import rs.ac.uns.ftn.WebProjekat.repository.AdministratorRepository;
import rs.ac.uns.ftn.WebProjekat.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

    private final AdministratorRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdministratorRepository adminRepository){
        this.adminRepository=adminRepository;
    }

    @Override
    public Administrator findByKorisnickoime(String korisnickoime){
        Administrator admin = this.adminRepository.findByKorisnickoime(korisnickoime);
        return admin;
    }

    @Override
    public Administrator findOne(Long id){
        Administrator admin = this.adminRepository.getOne(id);
        return admin;
    }
    
}
