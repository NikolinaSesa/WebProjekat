package rs.ac.uns.ftn.WebProjekat.service;

import java.util.List;
import rs.ac.uns.ftn.WebProjekat.model.*;

public interface OcenaService {

    Ocena create(Ocena ocena) throws Exception;

    List<Ocena> findByTerminTreningTrenerId(Long id);
}
