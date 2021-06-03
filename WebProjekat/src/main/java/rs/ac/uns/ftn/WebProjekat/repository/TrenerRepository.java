package rs.ac.uns.ftn.WebProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import rs.ac.uns.ftn.WebProjekat.model.Trener;

public interface TrenerRepository extends JpaRepository<Trener, Long>{
    
    List<Trener> findByAktivanAndFitnesscentarId(Boolean aktivan, Long fitnesscentarId);
}
