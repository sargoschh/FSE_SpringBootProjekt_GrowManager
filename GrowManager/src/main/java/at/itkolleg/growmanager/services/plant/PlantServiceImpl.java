package at.itkolleg.growmanager.services.plant;

import at.itkolleg.growmanager.domain.Plant;
import at.itkolleg.growmanager.exceptions.plant.DuplicatedPlantException;
import at.itkolleg.growmanager.exceptions.plant.PlantNotFound;
import at.itkolleg.growmanager.repositories.plant.DbAccessPlant;
import at.itkolleg.growmanager.services.plant.PlantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantServiceImpl implements PlantService {

    private DbAccessPlant dbAccessPlant;

    public PlantServiceImpl(DbAccessPlant dbAccessPlant) {
        this.dbAccessPlant = dbAccessPlant;
    }

    @Override
    public List<Plant> allPlants() {
        return this.dbAccessPlant.allPlants();
    }

    @Override
    public Plant insertPlant(Plant plant) throws DuplicatedPlantException {
        return this.dbAccessPlant.savePlant(plant);
    }

    @Override
    public Plant updatePlant(Plant plant) throws PlantNotFound, DuplicatedPlantException {
        Plant plantFromDb = this.dbAccessPlant.plantWithId(plant.getId());
        plantFromDb.setName(plant.getName());
        plantFromDb.setType(plant.getType());
        plantFromDb.setGrowthPeriod(plant.getGrowthPeriod());
        return this.dbAccessPlant.savePlant(plantFromDb);
    }

    @Override
    public Plant plantWithId(Long id) throws PlantNotFound {
        return this.dbAccessPlant.plantWithId(id);
    }

    @Override
    public List<Plant> allPlantWithName(String name) {
        return this.dbAccessPlant.allPlantsWithName(name);
    }

    @Override
    public Plant deletePlantWithId(Long id) throws PlantNotFound {
        return this.dbAccessPlant.deletePlantTypeWithId(id);
    }
}
