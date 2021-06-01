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
}
