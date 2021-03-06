package rs.ac.uns.ftn.WebProjekat.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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

    @Override
    public Fitnesscentar update(Fitnesscentar fitnesscentar) throws Exception{
        Fitnesscentar fitnesscentarToUpdate = this.fitnesscentarRepository.getOne(fitnesscentar.getId());
        if(fitnesscentarToUpdate==null){
            throw new Exception("Fitnesscentar doesn't exist!");
        }
        fitnesscentarToUpdate.setNaziv(fitnesscentar.getNaziv());
        fitnesscentarToUpdate.setAdresa(fitnesscentar.getAdresa());
        fitnesscentarToUpdate.setBrTelefona(fitnesscentar.getBrTelefona());
        fitnesscentarToUpdate.setEmail(fitnesscentar.getEmail());

        Fitnesscentar savedFitnesscentar = this.fitnesscentarRepository.save(fitnesscentarToUpdate);
        return savedFitnesscentar;
    }

    @Override
    public void delete(Long id){
        this.fitnesscentarRepository.deleteById(id);
    }

    @Override
    public List<Fitnesscentar> findAll(){
        List<Fitnesscentar> fitnesscentri = this.fitnesscentarRepository.findAll();
        return fitnesscentri;
    }

    @Override
    public Fitnesscentar findById(Long fitnesscentarId){
        Fitnesscentar fitnesscentar = this.fitnesscentarRepository.getOne(fitnesscentarId);
        return fitnesscentar;
    }
}
