package rs.ac.uns.ftn.WebProjekat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.WebProjekat.model.Clan;
import rs.ac.uns.ftn.WebProjekat.repository.ClanRepository;
import rs.ac.uns.ftn.WebProjekat.service.ClanService;

@Service
public class ClanServiceImpl implements ClanService{
    
    private final ClanRepository clanRepository;

    @Autowired
    public ClanServiceImpl(ClanRepository clanRepository){
        this.clanRepository=clanRepository;
    }

    @Override
    public Clan create(Clan clan) throws Exception{
        if(clan.getId()!=null){
            throw new Exception("ID must be null!");
        }
        Clan newClan = this.clanRepository.save(clan);
        return newClan;
    }

    @Override
    public Clan findByKorisnickoime(String korisnickoime){
        Clan clan = this.clanRepository.findByKorisnickoime(korisnickoime);
        return clan;
    }

    @Override
    public Clan findOne(Long id){
        Clan clan=this.clanRepository.getOne(id);
        return clan;
    }

    @Override
    public Clan update(Clan clan) throws Exception{
        Clan clanToUpDate=this.clanRepository.getOne(clan.getId());
        if(clanToUpDate==null){
            throw new Exception("Clan doesn't exist!");
        }
        clanToUpDate.setKorisnickoIme(clan.getKorisnickoIme());
        clanToUpDate.setLozinka(clan.getLozinka());
        clanToUpDate.setIme(clan.getIme());
        clanToUpDate.setPrezime(clan.getPrezime());
        clanToUpDate.setBrTelefona(clan.getBrTelefona());
        clanToUpDate.setDatum(clan.getDatum());
        clanToUpDate.setEmail(clan.getEmail());

        Clan saveClan=this.clanRepository.save(clanToUpDate);
        return saveClan;
    }
}
