package rs.ac.uns.ftn.WebProjekat.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.WebProjekat.model.Sala;
import rs.ac.uns.ftn.WebProjekat.repository.SalaRepository;
import rs.ac.uns.ftn.WebProjekat.service.SalaService;

@Service
public class SalaServiceImpl implements SalaService{

    private final SalaRepository salaRepository;

    @Autowired
    public SalaServiceImpl(SalaRepository salaRepository){
        this.salaRepository = salaRepository;
    }

    @Override
    public Sala create(Sala sala) throws Exception{
        if(sala.getId()!=null){
            throw new Exception("ID must be null!");
        }
        Sala newSala = this.salaRepository.save(sala);
        return newSala;
    }

    @Override
    public Sala update(Sala sala) throws Exception{
        Sala salaToUpdate = this.salaRepository.getOne(sala.getId());
        if(salaToUpdate==null){
            throw new Exception("Sala doesn't exist!");
        }
        salaToUpdate.setKapacitet(sala.getKapacitet());
        salaToUpdate.setOznaka(sala.getOznaka());

        Sala savedSala = this.salaRepository.save(salaToUpdate);
        return savedSala;
    }

    @Override
    public void delete(Long id){
        this.salaRepository.deleteById(id);
    }

    @Override
    public List<Sala> findByFitnesscentarId(Long fitnesscentarId){
        List<Sala> sale = this.salaRepository.findByFitnesscentarId(fitnesscentarId);
        return sale;
    }

    @Override
    public Sala findById(Long id){
        Sala sala = this.salaRepository.getOne(id);
        return sala;
    }

    @Override
    public Sala findByOznaka(String oznaka){
        Sala sala=this.salaRepository.findByOznaka(oznaka);
        return sala;
    }
    
}
