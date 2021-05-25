package rs.ac.uns.ftn.WebProjekat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.WebProjekat.model.Fitnesscentar;
import rs.ac.uns.ftn.WebProjekat.repository.FitnesscentarRepository;
import rs.ac.uns.ftn.WebProjekat.service.FitnesscentarService;

@Service
public class FitnesscentarServiceImpl implements FitnesscentarService{

    private final FitnesscentarRepository fitnesscentarRepository;

    @Autowired
    public FitnesscentarServiceImpl(FitnesscentarRepository fitnesscentarRepository){
        this.fitnesscentarRepository = fitnesscentarRepository;
    }
    
    @Override
    public Fitnesscentar create(Fitnesscentar fitnesscentar) throws Exception{
        if(fitnesscentar.getId()!=null){
            throw new Exception("ID must be null!");
        }
        Fitnesscentar newFitnesscentar = this.fitnesscentarRepository.save(fitnesscentar);
        return newFitnesscentar;
    }
}
