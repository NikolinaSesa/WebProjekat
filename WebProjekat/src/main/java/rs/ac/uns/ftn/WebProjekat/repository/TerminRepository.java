package rs.ac.uns.ftn.WebProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Time;
import java.util.List;
import rs.ac.uns.ftn.WebProjekat.model.Termin;
import rs.ac.uns.ftn.WebProjekat.model.dto.Tip;
import org.springframework.data.domain.Sort;

public interface TerminRepository extends JpaRepository<Termin, Long>{
    
    List<Termin> findByCena(Double cena);

    List<Termin> findByVreme(Time vreme);

    List<Termin> findByTreningNazivContaining(String naziv);

    List<Termin> findByTreningOpisContaining(String opis);

    List<Termin> findByTreningTipContaining(Tip tip);

    List<Termin> findByTreningTrenerFitnesscentarId(Sort sort, Long fitnesscentarId);
}
