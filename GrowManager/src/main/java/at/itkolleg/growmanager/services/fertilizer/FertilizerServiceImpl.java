package at.itkolleg.growmanager.services.fertilizer;

import at.itkolleg.growmanager.domain.Fertilizer;
import at.itkolleg.growmanager.exceptions.fertilizer.DuplicatedFertilizerException;
import at.itkolleg.growmanager.exceptions.fertilizer.FertilizerNotFound;
import at.itkolleg.growmanager.repositories.fertilizer.DbAccessFertilizer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FertilizerServiceImpl implements  FertilizerService{

    private DbAccessFertilizer dbAccessFertilizer;

    public FertilizerServiceImpl(DbAccessFertilizer dbAccessFertilizer){
        this.dbAccessFertilizer = dbAccessFertilizer;
    }


    @Override
    public List<Fertilizer> allFertilizer() {
        return this.dbAccessFertilizer.allFertilizer();
    }

    @Override
    public Fertilizer insertFertilizer(Fertilizer fertilizer) throws DuplicatedFertilizerException {
        return this.dbAccessFertilizer.saveFertilizer(fertilizer);
    }

    @Override
    public Fertilizer updateFertilizer(Fertilizer fertilizer) throws FertilizerNotFound, DuplicatedFertilizerException {
        Fertilizer fertilizerFromDb = this.dbAccessFertilizer.fertilizerWithId(fertilizer.getId());
        fertilizerFromDb.setName(fertilizer.getName());
        fertilizerFromDb.setType(fertilizer.getType());
        return this.dbAccessFertilizer.saveFertilizer(fertilizerFromDb);
    }

    @Override
    public Fertilizer fertilizerWithId(Long id) throws FertilizerNotFound {
        return this.dbAccessFertilizer.fertilizerWithId(id);
    }

    @Override
    public List<Fertilizer> allFertilizerWithName(String name) {
        return this.dbAccessFertilizer.allFertilizersWithName(name);
    }

    @Override
    public Fertilizer deleteFertilizerWithid(Long id) throws FertilizerNotFound {
        return this.dbAccessFertilizer.deleteFertilizerWithId(id);
    }
}
