package at.itkolleg.growmanager.repositories;

import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.exceptions.PlantTypeNotFound;

import java.util.List;

public interface DbAccessPlantType {

    PlantType savePlantType(PlantType plantType);
    List<PlantType> allPlantTypes();
    List<PlantType> allPlantTypesWithName(String name);
    PlantType plantTypesWithId(Long id) throws PlantTypeNotFound;
    PlantType deletePlantTypeWithId(Long id);
}
