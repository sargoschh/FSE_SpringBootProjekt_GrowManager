package at.itkolleg.growmanager.services.fertilizerType;

import at.itkolleg.growmanager.domain.FertilizerType;
import at.itkolleg.growmanager.exceptions.fertilizer.DuplicatedFertilizerException;
import at.itkolleg.growmanager.exceptions.fertilizer.FertilizerNotFound;
import at.itkolleg.growmanager.exceptions.fertilizerType.DuplicatedFertilizerTypeException;
import at.itkolleg.growmanager.exceptions.fertilizerType.FertilizerTypeNotFound;
import at.itkolleg.growmanager.repositories.fertilizerType.DbAccessFertilizerType;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FertilizerTypeServiceImpl implements FertilizerTypeService{

    private DbAccessFertilizerType dbAccessFertilizerType;

    public FertilizerTypeServiceImpl(DbAccessFertilizerType dbAccessFertilizerType){
        this.dbAccessFertilizerType = dbAccessFertilizerType;
    }

    @Override
    public List<FertilizerType> allFertilizerTypes() {
        return this.dbAccessFertilizerType.allFertilizerTypes();
    }

    @Override
    public FertilizerType insertFertilizerType(FertilizerType fertilizerType) throws DuplicatedFertilizerTypeException {
        return this.dbAccessFertilizerType.saveFertilizerType(fertilizerType);
    }

    @Override
    public FertilizerType updateFertilizerType(FertilizerType fertilizerType) throws FertilizerTypeNotFound, DuplicatedFertilizerTypeException{
        FertilizerType fertilizerTypeFromDb = this.dbAccessFertilizerType.fertilizerTypesWithId(fertilizerType.getId());
        fertilizerTypeFromDb.setName(fertilizerType.getName());
        return this.dbAccessFertilizerType.saveFertilizerType(fertilizerTypeFromDb);
    }

    @Override
    public FertilizerType fertilizerTypeWithId(Long id) throws FertilizerTypeNotFound {
        return this.dbAccessFertilizerType.fertilizerTypesWithId(id);
    }

    @Override
    public List<FertilizerType> allFertilizerTypesWithName(String name) {
        return this.dbAccessFertilizerType.allFertilizerTypesWithName(name);
    }

    @Override
    public FertilizerType deleteFertilizerTypeWithId(Long id) throws FertilizerTypeNotFound {
        return this.dbAccessFertilizerType.deleteFertilizerTypeWithId(id);
    }
}
