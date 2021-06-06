package rs.ac.uns.ftn.WebProjekat.service;

import java.util.List;
import rs.ac.uns.ftn.WebProjekat.model.Fitnesscentar;

public interface FitnesscentarService {
    
    Fitnesscentar create(Fitnesscentar fitnesscentar) throws Exception;

    Fitnesscentar update(Fitnesscentar fitnesscentar) throws Exception;

    void delete(Long id);

    List<Fitnesscentar> findAll();

    Fitnesscentar findById(Long fitnesscentarId);
}
