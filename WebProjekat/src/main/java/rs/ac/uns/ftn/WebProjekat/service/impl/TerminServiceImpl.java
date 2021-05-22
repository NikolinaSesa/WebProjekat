package rs.ac.uns.ftn.WebProjekat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.WebProjekat.model.*;
import java.util.List;
import rs.ac.uns.ftn.WebProjekat.repository.TerminRepository;
import rs.ac.uns.ftn.WebProjekat.service.TerminService;
import rs.ac.uns.ftn.WebProjekat.model.dto.Tip;

@Service
public class TerminServiceImpl implements TerminService{

    private final TerminRepository terminRepository;

    @Autowired
    public TerminServiceImpl(TerminRepository terminRepository){
        this.terminRepository = terminRepository;
    }

    @Override
    public List<Termin> findByCena(Double cena){
        List<Termin> terminiPoCeni = this.terminRepository.findByCena(cena);
        return terminiPoCeni;
    }

    @Override
    public List<Termin> findByVreme(Double vreme){
        List<Termin> terminiPoVremenu = this.terminRepository.findByVreme(vreme);
        return terminiPoVremenu;
    }

    @Override
    public List<Termin> findByTreningNaziv(String naziv){
        List<Termin> terminiPoNazivuTreninga = this.terminRepository.findByTreningNaziv(naziv);
        return terminiPoNazivuTreninga;
    }

    @Override
    public List<Termin> findByTreningOpis(String opis){
        List<Termin> terminiPoOpisuTreninga = this.terminRepository.findByTreningOpis(opis);
        return terminiPoOpisuTreninga;
    }

    @Override
    public List<Termin> findByTreningTip(Tip tip){
        List<Termin> terminiPoTipuTreninga = this.terminRepository.findByTreningTip(tip);
        return terminiPoTipuTreninga;
    }

    @Override
    public List<Termin> findAllAndSortByCena(){
        List<Termin> terminiSortiraniPoCeni = this.terminRepository.findAll(Sort.by(Sort.Direction.ASC, "cena"));
        return terminiSortiraniPoCeni;
    }

    @Override
    public List<Termin> findAllAndSortByVreme(){
        List<Termin> terminiSortiraniPoVemenu = this.terminRepository.findAll(Sort.by(Sort.Direction.ASC, "vreme"));
        return terminiSortiraniPoVemenu;
    }
}
