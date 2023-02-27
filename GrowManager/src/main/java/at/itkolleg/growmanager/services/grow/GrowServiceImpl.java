package at.itkolleg.growmanager.services.grow;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Plant;
import at.itkolleg.growmanager.exceptions.grow.DuplicatedGrowException;
import at.itkolleg.growmanager.exceptions.grow.GrowNotFound;
import at.itkolleg.growmanager.repositories.grow.DbAccessGrow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrowServiceImpl implements GrowService {

    private DbAccessGrow dbAccessGrow;

    public GrowServiceImpl(DbAccessGrow dbAccessGrow) {
        this.dbAccessGrow = dbAccessGrow;
    }

    @Override
    public List<Grow> allGrows() {
        return this.dbAccessGrow.allGrows();
    }

    @Override
    public Grow insertGrow(Grow grow) throws DuplicatedGrowException {
        return this.dbAccessGrow.saveGrow(grow);
    }

    @Override
    public Grow updateGrow(Grow grow) throws GrowNotFound, DuplicatedGrowException {
        Grow growFromDb = this.dbAccessGrow.growWithId(grow.getId());
        growFromDb.setStartDate(grow.getStartDate());
        growFromDb.setHarvested(grow.getHarvested());
        growFromDb.setActualEndDate(grow.getActualEndDate());
        return this.dbAccessGrow.saveGrow(growFromDb);
    }

    @Override
    public Grow growWithId(Long id) throws GrowNotFound {
        return this.dbAccessGrow.growWithId(id);
    }

    @Override
    public List<Grow> allGrowsWithPlants(Plant plant) {
        return this.dbAccessGrow.allGrowsWithPlant(plant);
    }

    @Override
    public Grow deleteGrowWithId(Long id) throws GrowNotFound {
        return this.dbAccessGrow.deleteGrowTypeWithId(id);
    }
}
