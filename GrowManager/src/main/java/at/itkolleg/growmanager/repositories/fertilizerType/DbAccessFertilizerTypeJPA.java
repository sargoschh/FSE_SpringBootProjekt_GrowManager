package at.itkolleg.growmanager.repositories.fertilizerType;

import at.itkolleg.growmanager.domain.FertilizerType;
import at.itkolleg.growmanager.exceptions.fertilizer.DuplicatedFertilizerException;
import at.itkolleg.growmanager.exceptions.fertilizer.FertilizerNotFound;
import at.itkolleg.growmanager.exceptions.fertilizerType.DuplicatedFertilizerTypeException;
import at.itkolleg.growmanager.exceptions.fertilizerType.FertilizerTypeNotFound;
import at.itkolleg.growmanager.repositories.fertilizer.DbAccessFertilizerJPA;
import at.itkolleg.growmanager.repositories.fertilizer.FertilizerJPARepo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DbAccessFertilizerTypeJPA implements DbAccessFertilizerType{

    private FertilizerTypeJPARepo fertilizerTypeJPARepo;

    public DbAccessFertilizerTypeJPA(FertilizerTypeJPARepo fertilizerTypeJPARepo){
        this.fertilizerTypeJPARepo = fertilizerTypeJPARepo;
    }

    @Override
    public FertilizerType saveFertilizerType(FertilizerType fertilizerType) throws DuplicatedFertilizerTypeException {
        try{
            return this.fertilizerTypeJPARepo.save(fertilizerType);
        }catch(Exception e){
            throw new DuplicatedFertilizerTypeException("Düngertyp bereits vorhanden!");
        }
    }

    @Override
    public List<FertilizerType> allFertilizerTypes() {
        return this.fertilizerTypeJPARepo.findAll();
    }

    @Override
    public List<FertilizerType> allFertilizerTypesWithName(String name) {
        return this.fertilizerTypeJPARepo.findAllByName(name);
    }

    @Override
    public FertilizerType fertilizerTypesWithId(Long id) throws FertilizerTypeNotFound {
        Optional<FertilizerType> optFertilizerType = this.fertilizerTypeJPARepo.findById(id);
        if(optFertilizerType.isPresent()){
            return optFertilizerType.get();
        } else {
            throw new FertilizerTypeNotFound("Düngertyp mit der ID " + id + " nicht gefunden!");
        }
    }

    @Override
    public FertilizerType deleteFertilizerTypeWithId(Long id) throws FertilizerTypeNotFound, FertilizerNotFound {
        FertilizerType fertilizerTypeFromDb = this.fertilizerTypesWithId(id);
        this.fertilizerTypeJPARepo.deleteById(fertilizerTypeFromDb.getId());
        return fertilizerTypeFromDb;
    }
}
