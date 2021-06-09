package rs.ac.uns.ftn.WebProjekat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.WebProjekat.model.*;
import java.sql.Time;
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
    public List<Termin> findByVreme(Time vreme){
        List<Termin> terminiPoVremenu = this.terminRepository.findByVreme(vreme);
        return terminiPoVremenu;
    }

    @Override
    public List<Termin> findByTreningNaziv(String naziv){
        List<Termin> terminiPoNazivuTreninga = this.terminRepository.findByTreningNazivContainingIgnoreCase(naziv);
        return terminiPoNazivuTreninga;
    }

    @Override
    public List<Termin> findByTreningOpis(String opis){
        List<Termin> terminiPoOpisuTreninga = this.terminRepository.findByTreningOpisContainingIgnoreCase(opis);
        return terminiPoOpisuTreninga;
    }

    @Override
    public List<Termin> findByTreningTip(Tip tip){
        List<Termin> terminiPoTipuTreninga = this.terminRepository.findByTreningTip(tip);
        return terminiPoTipuTreninga;
    }

    @Override
    public List<Termin> findAllAndSortByCenaRastuce(Long fitnesscentarId){
        List<Termin> terminiSortiraniPoCeni = this.terminRepository.findByTreningTrenerFitnesscentarId(Sort.by(Sort.Direction.ASC, "cena"), fitnesscentarId);
        return terminiSortiraniPoCeni;
    }

    @Override
    public List<Termin> findAllAndSortByCenaOpadajuce(Long fitnesscentarId){
        List<Termin> terminiSortiraniPoCeni = this.terminRepository.findByTreningTrenerFitnesscentarId(Sort.by(Sort.Direction.DESC, "cena"), fitnesscentarId);
        return terminiSortiraniPoCeni;
    }

    @Override
    public List<Termin> findAllAndSortByVremeRastuce(Long fitnesscentarId){
        List<Termin> terminiSortiraniPoVemenu = this.terminRepository.findByTreningTrenerFitnesscentarId(Sort.by(Sort.Direction.ASC, "vreme"), fitnesscentarId);
        return terminiSortiraniPoVemenu;
    }

    @Override
    public List<Termin> findAllAndSortByVremeOpadajuce(Long fitnesscentarId){
        List<Termin> terminiSortiraniPoVemenu = this.terminRepository.findByTreningTrenerFitnesscentarId(Sort.by(Sort.Direction.DESC, "vreme"), fitnesscentarId);
        return terminiSortiraniPoVemenu;
    }
}
