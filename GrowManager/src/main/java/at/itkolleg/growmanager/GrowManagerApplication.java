package at.itkolleg.growmanager;

import at.itkolleg.growmanager.domain.Plant;
import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.repositories.plant.DbAccessPlant;
import at.itkolleg.growmanager.repositories.plantType.DbAccessPlantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrowManagerApplication implements ApplicationRunner {

    @Autowired
    DbAccessPlantType dbAccessPlantType;

    @Autowired
    DbAccessPlant dbAccessPlant;

    public static void main(String[] args) {
        SpringApplication.run(GrowManagerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        PlantType gemuese = new PlantType("Gemüse");
        PlantType obst = new PlantType("Obst");
        PlantType kraeuter = new PlantType("Kräuter");
        PlantType sonstiges = new PlantType("Sonstiges");

        this.dbAccessPlantType.savePlantType(gemuese);
        this.dbAccessPlantType.savePlantType(obst);
        this.dbAccessPlantType.savePlantType(kraeuter);
        this.dbAccessPlantType.savePlantType(sonstiges);

        Plant tomate = new Plant("Tomate", gemuese, 60);
        Plant erdbeere = new Plant("Erdbeere", obst, 45);
        Plant basilikum = new Plant("Basilikum", kraeuter, 20);
        Plant fliegenpilz = new Plant("Fliegenpilz", sonstiges, 30);

        this.dbAccessPlant.savePlant(tomate);
        this.dbAccessPlant.savePlant(erdbeere);
        this.dbAccessPlant.savePlant(basilikum);
        this.dbAccessPlant.savePlant(fliegenpilz);

    }

}
