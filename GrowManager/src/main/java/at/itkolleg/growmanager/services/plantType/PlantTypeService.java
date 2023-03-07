package at.itkolleg.growmanager.services.plantType;

import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.exceptions.plantType.DuplicatedPlantTypeException;
import at.itkolleg.growmanager.exceptions.plantType.PlantTypeNotFound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlantTypeService {

    List<PlantType> allPlantTypes();
    PlantType insertPlantType(PlantType plantType) throws DuplicatedPlantTypeException;
    PlantType updatePlantType(PlantType plantType) throws PlantTypeNotFound, DuplicatedPlantTypeException;
    PlantType plantTypeWithId(Long id) throws PlantTypeNotFound;
    List<PlantType> allPlantTypesWithName(String name);
    PlantType deletePlantTypeWithId(Long id) throws PlantTypeNotFound;

}
