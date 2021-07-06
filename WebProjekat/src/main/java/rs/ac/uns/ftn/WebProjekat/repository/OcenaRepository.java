package rs.ac.uns.ftn.WebProjekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.WebProjekat.model.Ocena;

public interface OcenaRepository extends JpaRepository<Ocena, Long>{

    List<Ocena> findByTerminTreningTrenerId(Long id);
    
}
