package at.itkolleg.growmanager.repositories;

import at.itkolleg.growmanager.domain.Plant;
import at.itkolleg.growmanager.exceptions.PlantNotFound;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DbAccessPlantJPA implements DbAccessPlant {

    private PlantJPARepo plantJPARepo;

    public DbAccessPlantJPA(PlantJPARepo plantJPARepo) {
        this.plantJPARepo = plantJPARepo;
    }

    @Override
    public Plant savePlant(Plant plant) {
        return this.plantJPARepo.save(plant);
    }

    @Override
    public List<Plant> allPlants() {
        return this.plantJPARepo.findAll();
    }

    @Override
    public List<Plant> allPlantsWithName(String name) {
        return this.plantJPARepo.findAllByName(name);
    }

    @Override
    public Plant plantWithId(Long id) throws PlantNotFound {
        Optional<Plant> optPlant = this.plantJPARepo.findById(id);
        if(optPlant.isPresent()) {
            return optPlant.get();
        } else {
            throw new PlantNotFound("Pflanze mit der ID " + id + " nicht gefunden!");
        }
    }

    @Override
    public Plant deletePlantTypeWithId(Long id) throws PlantNotFound {
        Plant plantFromDb = this.plantWithId(id);
        this.plantJPARepo.deleteById(plantFromDb.getId());
        return plantFromDb;
    }
}
