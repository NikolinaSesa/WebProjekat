package rs.ac.uns.ftn.WebProjekat.service;

import java.util.List;
import rs.ac.uns.ftn.WebProjekat.model.Sala;

public interface SalaService {

    Sala create(Sala sala) throws Exception;

    Sala update(Sala sala) throws Exception;

    void delete(Long id);

    List<Sala> findByFitnesscentarId(Long fitnesscentarId);

    Sala findById(Long id);

    Sala findByOznaka(String oznaka);
    
}
