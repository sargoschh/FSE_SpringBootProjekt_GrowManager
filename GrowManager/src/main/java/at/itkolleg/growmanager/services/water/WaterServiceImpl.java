package at.itkolleg.growmanager.services.water;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Water;
import at.itkolleg.growmanager.exceptions.water.DuplicatedWaterException;
import at.itkolleg.growmanager.exceptions.water.WaterNotFound;
import at.itkolleg.growmanager.repositories.water.DbAccessWater;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class WaterServiceImpl implements WaterService{

    private DbAccessWater dbAccessWater;

    public WaterServiceImpl(DbAccessWater dbAccessWater){
        this.dbAccessWater = dbAccessWater;
    }

    @Override
    public List<Water> allWaters() {
        return this.dbAccessWater.allWaters();
    }

    @Override
    public Water insertWater(Water water) throws DuplicatedWaterException {
        return this.dbAccessWater.saveWater(water);
    }

    @Override
    public Water updateWater(Water water) throws WaterNotFound, DuplicatedWaterException {
        Water waterFromDb = this.dbAccessWater.waterWithId(water.getId());
        waterFromDb.setAmountOfWater(water.getAmountOfWater());
        waterFromDb.setDate(water.getDate());
        waterFromDb.setComment(water.getComment());
        return this.dbAccessWater.saveWater(waterFromDb);
    }

    @Override
    public Water waterWithId(Long id) throws WaterNotFound {
        return this.dbAccessWater.waterWithId(id);
    }

    @Override
    public List<Water> allWatersWithGrows(Grow grow) {
        return this.dbAccessWater.allWatersWithGrow(grow);
    }

    @Override
    public Water deleteWaterWithId(Long id) throws WaterNotFound {
        return this.dbAccessWater.deleteWaterById(id);
    }
}
