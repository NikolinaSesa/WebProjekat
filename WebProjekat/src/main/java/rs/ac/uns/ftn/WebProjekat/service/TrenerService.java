package rs.ac.uns.ftn.WebProjekat.service;

import java.util.List;
import rs.ac.uns.ftn.WebProjekat.model.Trener;

public interface TrenerService{
    
    List<Trener> findByAktivanAndFitnesscentarId(Boolean aktivan, Long fitnesscentarId);

    void delete(Long id);

    Trener update(Trener trener) throws Exception;

    Trener findOne(Long id);

    Trener create(Trener trener) throws Exception;

    Trener findByKorisnickoime(String korisnickoime);

    Trener updateProsecneOcene(Trener trener) throws Exception;
}
