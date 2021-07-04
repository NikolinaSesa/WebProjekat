package rs.ac.uns.ftn.WebProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.uns.ftn.WebProjekat.model.Trening;
import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long>{

    List<Trening> findByTrenerFitnesscentarId(Long fitnesscentarId);

    Trening findByTrenerIdAndNaziv(Long trenerId, String naziv);
    
}
