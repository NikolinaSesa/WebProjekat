package rs.ac.uns.ftn.WebProjekat.service;

import rs.ac.uns.ftn.WebProjekat.model.*;
import java.sql.Time;
import java.util.List;
import rs.ac.uns.ftn.WebProjekat.model.dto.Tip;

public interface TerminService {
    
    List<Termin> findByCena(Double cena);

    List<Termin> findByVreme(Time vreme);

    List<Termin> findByTreningNaziv(String naziv);

    List<Termin> findByTreningOpis(String opis);

    List<Termin> findByTreningTip(Tip tip);

    List<Termin> findAllAndSortByCenaRastuce(Long fitnesscentarId);

    List<Termin> findAllAndSortByCenaOpadajuce(Long fitnesscentarId);

    List<Termin> findAllAndSortByVremeRastuce(Long fitnesscentarId);

    List<Termin> findAllAndSortByVremeOpadajuce(Long fitnesscentarId);
}
