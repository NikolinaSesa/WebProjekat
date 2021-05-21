package rs.ac.uns.ftn.WebProjekat.service;

import rs.ac.uns.ftn.WebProjekat.model.*;
import java.util.List;

public interface TerminService {
    
    List<Termin> findByCena(Double cena);

    List<Termin> findByVreme(Double vreme);

    List<Termin> findByTreningNaziv(String naziv);

}
