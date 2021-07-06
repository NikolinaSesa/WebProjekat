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
    public List<Trener> findByAktivanAndFitnesscentarId(Boolean aktivan, Long fitnesscentarId){
        List<Trener> listaZahteva = this.trenerRepository.findByAktivanAndFitnesscentarId(aktivan, fitnesscentarId);
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

    @Override
    public Trener create(Trener trener) throws Exception{
        if(trener.getId()!=null){
            throw new Exception("ID must be null!");
        }
        Trener newTrener = this.trenerRepository.save(trener);
        return newTrener;
    }

    @Override
    public Trener findByKorisnickoime(String korisnickoime){
        Trener trener = this.trenerRepository.findByKorisnickoime(korisnickoime);
        return trener;
    }

    @Override
    public Trener updateProsecneOcene(Trener trener) throws Exception{
        Trener trenerToUpdate=this.trenerRepository.getOne(trener.getId());
        if(trenerToUpdate==null){
            throw new Exception("Trener doesn't exist!");
        }
        Trener saveTrener=this.trenerRepository.save(trener);
        return saveTrener;
    }
}
