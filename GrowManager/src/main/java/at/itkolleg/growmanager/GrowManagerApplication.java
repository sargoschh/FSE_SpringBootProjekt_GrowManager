package at.itkolleg.growmanager;

import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.repositories.DbAccessPlantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrowManagerApplication implements ApplicationRunner {

    @Autowired
    DbAccessPlantType dbAccessPlantType;

    public static void main(String[] args) {
        SpringApplication.run(GrowManagerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.dbAccessPlantType.savePlantType(new PlantType("Gemüse"));
        this.dbAccessPlantType.savePlantType(new PlantType("Obst"));
        this.dbAccessPlantType.savePlantType(new PlantType("Kräuter"));
        this.dbAccessPlantType.savePlantType(new PlantType("Sonstiges"));
    }

}
