package rs.ac.uns.ftn.WebProjekat.service;

import rs.ac.uns.ftn.WebProjekat.model.Clan;

public interface ClanService {
    
    Clan create(Clan clan) throws Exception;

    Clan findByKorisnickoime(String korisnickoime);

    Clan findOne(Long id);

    Clan update(Clan clan) throws Exception;

}
