package at.itkolleg.growmanager.services;

import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.exceptions.DuplicatedPlantTypeException;
import at.itkolleg.growmanager.exceptions.PlantTypeNotFound;
import at.itkolleg.growmanager.repositories.DbAccessPlantType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantTypeServiceImpl implements PlantTypeService {

    private DbAccessPlantType dbAccessPlantType;

    public PlantTypeServiceImpl(DbAccessPlantType dbAccessPlantType) {
        this.dbAccessPlantType = dbAccessPlantType;
    }

    @Override
    public List<PlantType> allPlantTypes() {
        return this.dbAccessPlantType.allPlantTypes();
    }

    @Override
    public PlantType insertPlantType(PlantType plantType) throws DuplicatedPlantTypeException {
        return this.dbAccessPlantType.savePlantType(plantType);
    }

    @Override
    public PlantType updatePlantType(PlantType plantType) throws PlantTypeNotFound, DuplicatedPlantTypeException {
        PlantType plantTypeFromDb = this.dbAccessPlantType.plantTypesWithId(plantType.getId());
        plantTypeFromDb.setName(plantType.getName());
        return this.dbAccessPlantType.savePlantType(plantTypeFromDb);
    }

    @Override
    public PlantType plantTypeWithId(Long id) throws PlantTypeNotFound {
        return this.dbAccessPlantType.plantTypesWithId(id);
    }

    @Override
    public List<PlantType> allPlantTypesWithName(String name) {
        return this.dbAccessPlantType.allPlantTypesWithName(name);
    }

    @Override
    public PlantType deletePlantTypeWithId(Long id) throws PlantTypeNotFound {
        return this.dbAccessPlantType.deletePlantTypeWithId(id);
    }
}
