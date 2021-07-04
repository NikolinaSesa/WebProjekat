package rs.ac.uns.ftn.WebProjekat.service;

import rs.ac.uns.ftn.WebProjekat.model.Trening;
import java.util.List;

public interface TreningService{
    
    List<Trening> findByTrenerFitnesscentarId(Long fitnesscentarId);
  
    Trening findByNazivAndTrenerId(String naziv, Long trenerId);
}
