package at.itkolleg.growmanager.repositories.water;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Water;
import at.itkolleg.growmanager.exceptions.water.DuplicatedWaterException;
import at.itkolleg.growmanager.exceptions.water.WaterNotFound;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class DbAccessWaterJPA implements DbAccessWater{

    private WaterJPARepo waterJPARepo;

    public DbAccessWaterJPA(WaterJPARepo waterJPARepo){
        this.waterJPARepo = waterJPARepo;
    }

    @Override
    public Water saveWater(Water water) throws DuplicatedWaterException {
        return this.waterJPARepo.save(water);
    }

    @Override
    public List<Water> allWaters() {
        return this.waterJPARepo.findAll();
    }

    @Override
    public List<Water> allWatersWithGrow(Grow grow) {
        return this.waterJPARepo.findAllByGrow(grow);
    }

    @Override
    public Water waterWithId(Long id) throws WaterNotFound {
        Optional<Water> optWater = this.waterJPARepo.findById(id);
        if(optWater.isPresent()){
            return optWater.get();
        }else{
            throw new WaterNotFound("Wasster mit der ID " + id + " nicht gefunden!");
        }
    }

    @Override
    public Water deleteWaterById(Long id) throws WaterNotFound {
        Water waterFromDb = this.waterWithId(id);
        this.waterJPARepo.deleteById(waterFromDb.getId());
        return waterFromDb;
    }
}
