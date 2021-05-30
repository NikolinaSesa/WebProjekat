package rs.ac.uns.ftn.WebProjekat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.WebProjekat.model.Trener;
import java.util.List;
import rs.ac.uns.ftn.WebProjekat.repository.TrenerRepository;
import rs.ac.uns.ftn.WebProjekat.service.TrenerService;

@Service
public class TrenerServiceImpl implements TrenerService{

    private final TrenerRepository trenerRepository;

    @Autowired 
    public TrenerServiceImpl(TrenerRepository trenerRepository){
        this.trenerRepository = trenerRepository;
    }

    @Override
    public List<Trener> findByAktivan(Boolean aktivan){
        List<Trener> listaZahteva = this.trenerRepository.findByAktivan(aktivan);
        return listaZahteva;
    }

    @Override
    public void delete(Long id){
        this.trenerRepository.deleteById(id);
    }
    
    @Override
    public Trener update(Trener trener) throws Exception{
        Trener trenerToUpdate = this.trenerRepository.getOne(trener.getId());
        if(trenerToUpdate == null){
            throw new Exception("Trener doesn't exist!");
        }
        trenerToUpdate.setAktivan(trener.getAktivan());

        Trener saveTrener = this.trenerRepository.save(trenerToUpdate);
        return saveTrener;
    }

    @Override
    public Trener findOne(Long id){
        Trener trener = this.trenerRepository.getOne(id);
        return trener;
    }
}
