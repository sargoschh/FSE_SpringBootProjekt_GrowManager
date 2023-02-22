package at.itkolleg.growmanager.services;

import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.exceptions.DuplicatedPlantTypeException;
import at.itkolleg.growmanager.exceptions.PlantTypeNotFound;

import java.util.List;

public interface PlantTypeService {

    List<PlantType> allPlantTypes();
    PlantType insertPlantType(PlantType plantType) throws DuplicatedPlantTypeException;
    PlantType updatePlantType(PlantType plantType) throws PlantTypeNotFound, DuplicatedPlantTypeException;
    PlantType plantTypeWithId(Long id) throws PlantTypeNotFound;
    List<PlantType> allPlantTypesWithName(String name);
    PlantType deletePlantTypeWithId(Long id) throws PlantTypeNotFound;

}
