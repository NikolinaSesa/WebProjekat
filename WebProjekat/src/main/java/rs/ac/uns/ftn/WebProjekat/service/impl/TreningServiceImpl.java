package rs.ac.uns.ftn.WebProjekat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.WebProjekat.repository.TreningRepository;
import rs.ac.uns.ftn.WebProjekat.service.TreningService;
import rs.ac.uns.ftn.WebProjekat.model.Trening;
import java.util.List;

@Service
public class TreningServiceImpl implements TreningService{

    private final TreningRepository treningRepository;

    @Autowired
    public TreningServiceImpl(TreningRepository treningRepository){
        this.treningRepository=treningRepository;
    }

    @Override
    public List<Trening> findAll(){
        List<Trening> treninzi = this.treningRepository.findAll();
        return treninzi;
    }
    
}
