package rs.ac.uns.ftn.WebProjekat.service;

import rs.ac.uns.ftn.WebProjekat.model.*;
import java.util.List;
import rs.ac.uns.ftn.WebProjekat.model.dto.Tip;

public interface TerminService {
    
    List<Termin> findByCena(Double cena);

    List<Termin> findByVreme(Double vreme);

    List<Termin> findByTreningNaziv(String naziv);

    List<Termin> findByTreningOpis(String opis);

    List<Termin> findByTreningTip(Tip tip);

    List<Termin> findAllAndSortByCena();

    List<Termin> findAllAndSortByVreme();
}
