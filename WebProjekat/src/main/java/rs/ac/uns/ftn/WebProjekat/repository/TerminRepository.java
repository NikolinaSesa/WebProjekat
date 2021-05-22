package rs.ac.uns.ftn.WebProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import rs.ac.uns.ftn.WebProjekat.model.Termin;
import rs.ac.uns.ftn.WebProjekat.model.dto.Tip;

public interface TerminRepository extends JpaRepository<Termin, Long>{
    
    List<Termin> findByCena(Double cena);

    List<Termin> findByVreme(Double vreme);

    List<Termin> findByTreningNaziv(String naziv);

    List<Termin> findByTreningOpis(String opis);

    List<Termin> findByTreningTip(Tip tip);

}
