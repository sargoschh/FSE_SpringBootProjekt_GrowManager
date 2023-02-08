package at.itkolleg.growmanager.repositories;

import at.itkolleg.growmanager.domain.PlantType;
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
    public PlantType savePlantType(PlantType plantType) {
        return this.plantTypeJPARepo.save(plantType);
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
    public PlantType deletePlantTypeWithId(Long id) {
        PlantType plantTypeFromDb = this.deletePlantTypeWithId(id);
        this.plantTypeJPARepo.deleteById(plantTypeFromDb.getId());
        return plantTypeFromDb;
    }
}
