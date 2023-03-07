package at.itkolleg.growmanager.repositories.plantType;

import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.exceptions.plantType.DuplicatedPlantTypeException;
import at.itkolleg.growmanager.exceptions.plantType.PlantTypeNotFound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DbAccessPlantType {

    PlantType savePlantType(PlantType plantType) throws DuplicatedPlantTypeException;
    List<PlantType> allPlantTypes();
    List<PlantType> allPlantTypesWithName(String name);
    PlantType plantTypesWithId(Long id) throws PlantTypeNotFound;
    PlantType deletePlantTypeWithId(Long id) throws PlantTypeNotFound;
}
