package rs.ac.uns.ftn.WebProjekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.WebProjekat.model.Ocena;
import rs.ac.uns.ftn.WebProjekat.repository.OcenaRepository;
import rs.ac.uns.ftn.WebProjekat.service.OcenaService;

@Service
public class OcenaServiceImpl implements OcenaService {

    private final OcenaRepository ocenaRepository;

    @Autowired
    public OcenaServiceImpl(OcenaRepository ocenaRepository){
        this.ocenaRepository=ocenaRepository;
    }

    @Override
    public Ocena create(Ocena ocena) throws Exception{
        if(ocena.getId()!=null){
            throw new Exception("ID must be null!");
        }
        Ocena newOcena=this.ocenaRepository.save(ocena);
        return newOcena;
    }

    @Override
    public List<Ocena> findByTerminTreningTrenerId(Long id){
        List<Ocena> ocene=this.ocenaRepository.findByTerminTreningTrenerId(id);
        return ocene;
    }
}
