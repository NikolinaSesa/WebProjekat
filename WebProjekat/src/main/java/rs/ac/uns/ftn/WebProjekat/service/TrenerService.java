package rs.ac.uns.ftn.WebProjekat.service;

import java.util.List;
import rs.ac.uns.ftn.WebProjekat.model.Trener;

public interface TrenerService{
    
    List<Trener> findByAktivan(Boolean aktivan);

    void delete(Long id);

    Trener update(Trener trener) throws Exception;

    Trener findOne(Long id);

    Trener create(Trener trener) throws Exception;
}
