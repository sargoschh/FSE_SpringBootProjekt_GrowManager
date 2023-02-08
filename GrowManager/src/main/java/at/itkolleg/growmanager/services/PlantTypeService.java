package at.itkolleg.growmanager.services;

import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.exceptions.PlantTypeNotFound;

import java.util.List;

public interface PlantTypeService {

    List<PlantType> allPlantTypes();
    PlantType insertPlantType(PlantType plantType);
    PlantType updatePlantType(PlantType plantType) throws PlantTypeNotFound;
    PlantType plantTypeWithId(Long id) throws PlantTypeNotFound;
    List<PlantType> allPlantTypesWithName(String name);
    PlantType deletePlantTypeWithId(Long id) throws PlantTypeNotFound;

}
