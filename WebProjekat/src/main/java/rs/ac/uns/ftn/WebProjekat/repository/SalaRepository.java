package rs.ac.uns.ftn.WebProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.WebProjekat.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long>{
    
    List<Sala> findByFitnesscentarId(Long fitnesscentarId);

    Sala findByOznaka(String oznaka);
}
