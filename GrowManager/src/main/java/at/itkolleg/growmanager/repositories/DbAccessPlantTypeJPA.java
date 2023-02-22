package at.itkolleg.growmanager.repositories;

import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.exceptions.DuplicatedPlantTypeException;
import at.itkolleg.growmanager.exceptions.PlantTypeNotFound;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DbAccessPlantTypeJPA implements DbAccessPlantType {

    private PlantTypeJPARepo plantTypeJPARepo;

    public DbAccessPlantTypeJPA(PlantTypeJPARepo plantTypeJPARepo) {
        this.plantTypeJPARepo = plantTypeJPARepo;
    }

    @Override
    public PlantType savePlantType(PlantType plantType) throws DuplicatedPlantTypeException {
        try {
            return this.plantTypeJPARepo.save(plantType);
        } catch (Exception e) {
            throw new DuplicatedPlantTypeException("Pflanzentyp bereits vorhanden");
        }
    }

    @Override
    public List<PlantType> allPlantTypes() {
        return this.plantTypeJPARepo.findAll();
    }

    @Override
    public List<PlantType> allPlantTypesWithName(String name) {
        return this.plantTypeJPARepo.findAllByName(name);
    }

    @Override
    public PlantType plantTypesWithId(Long id) throws PlantTypeNotFound {
        Optional<PlantType> optPlantType = this.plantTypeJPARepo.findById(id);
        if(optPlantType.isPresent()) {
            return optPlantType.get();
        } else {
            throw new PlantTypeNotFound("Pflanzentyp mit der ID " + id + " nicht gefunden!");
        }
    }

    @Override
    public PlantType deletePlantTypeWithId(Long id) throws PlantTypeNotFound {
        PlantType plantTypeFromDb = this.plantTypesWithId(id);
        this.plantTypeJPARepo.deleteById(plantTypeFromDb.getId());
        return plantTypeFromDb;
    }
}
