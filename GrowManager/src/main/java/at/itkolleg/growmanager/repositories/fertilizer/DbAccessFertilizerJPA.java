package at.itkolleg.growmanager.repositories.fertilizer;

import at.itkolleg.growmanager.domain.Fertilizer;
import at.itkolleg.growmanager.exceptions.fertilizer.DuplicatedFertilizerException;
import at.itkolleg.growmanager.exceptions.fertilizer.FertilizerNotFound;
import at.itkolleg.growmanager.repositories.fertilizerType.DbAccessFertilizerTypeJPA;
import at.itkolleg.growmanager.repositories.fertilizerType.FertilizerTypeJPARepo;
import at.itkolleg.growmanager.services.fertilizer.FertilizerService;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Component
public class DbAccessFertilizerJPA implements DbAccessFertilizer{

    private FertilizerJPARepo fertilizerJPARepo;

    public DbAccessFertilizerJPA(FertilizerJPARepo fertilizerJPARepo){
        this.fertilizerJPARepo = fertilizerJPARepo;
    }


    @Override
    public Fertilizer saveFertilizer(Fertilizer fertilizer) throws DuplicatedFertilizerException {
        try{
            return this.fertilizerJPARepo.save(fertilizer);
        }catch (Exception e){
            throw new DuplicatedFertilizerException("Dünger bereits vorhanden!");
        }
    }

    @Override
    public List<Fertilizer> allFertilizer() {
        return this.fertilizerJPARepo.findAll();
    }

    @Override
    public List<Fertilizer> allFertilizersWithName(String name) {
        return this.fertilizerJPARepo.findAllByName(name);
    }

    @Override
    public Fertilizer fertilizerWithId(Long id) throws FertilizerNotFound {
        Optional<Fertilizer> optFertilizer = this.fertilizerJPARepo.findById(id);
        if(optFertilizer.isPresent()){
            return optFertilizer.get();
        } else {
            throw new FertilizerNotFound("Dünger mit der ID " + id + " nicht gefunden!");
        }
    }

    @Override
    public Fertilizer deleteFertilizerWithId(Long id) throws FertilizerNotFound {
        Fertilizer fertilizerFromDb = this.fertilizerWithId(id);
        this.fertilizerJPARepo.deleteById(fertilizerFromDb.getId());
        return fertilizerFromDb;
    }
}
