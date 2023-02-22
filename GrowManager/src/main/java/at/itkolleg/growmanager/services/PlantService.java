package at.itkolleg.growmanager.services;

import at.itkolleg.growmanager.domain.Plant;
import at.itkolleg.growmanager.exceptions.DuplicatedPlantException;
import at.itkolleg.growmanager.exceptions.PlantNotFound;

import java.util.List;

public interface PlantService {

    List<Plant> allPlants();
    Plant insertPlant(Plant plant) throws DuplicatedPlantException;
    Plant updatePlant(Plant plant) throws PlantNotFound, DuplicatedPlantException;
    Plant plantWithId(Long id) throws PlantNotFound;
    List<Plant> allPlantWithName(String name);
    Plant deletePlantWithId(Long id) throws PlantNotFound;
}
