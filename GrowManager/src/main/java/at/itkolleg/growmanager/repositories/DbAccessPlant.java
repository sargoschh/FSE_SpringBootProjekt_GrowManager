package at.itkolleg.growmanager.repositories;

import at.itkolleg.growmanager.domain.Plant;
import at.itkolleg.growmanager.exceptions.PlantNotFound;

import java.util.List;

public interface DbAccessPlant {

    Plant savePlant(Plant plant);
    List<Plant> allPlants();
    List<Plant> allPlantsWithName(String name);
    Plant plantWithId(Long id) throws PlantNotFound;
    Plant deletePlantTypeWithId(Long id) throws PlantNotFound;
}
