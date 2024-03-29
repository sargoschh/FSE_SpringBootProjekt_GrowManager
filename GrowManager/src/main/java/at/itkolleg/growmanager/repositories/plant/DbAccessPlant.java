package at.itkolleg.growmanager.repositories.plant;

import at.itkolleg.growmanager.domain.Plant;
import at.itkolleg.growmanager.exceptions.plant.DuplicatedPlantException;
import at.itkolleg.growmanager.exceptions.plant.PlantNotFound;

import java.util.List;

public interface DbAccessPlant {

    Plant savePlant(Plant plant) throws DuplicatedPlantException;
    List<Plant> allPlants();
    List<Plant> allPlantsWithName(String name);
    Plant plantWithId(Long id) throws PlantNotFound;
    Plant deletePlantTypeWithId(Long id) throws PlantNotFound;
}
