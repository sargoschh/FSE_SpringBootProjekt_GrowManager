package at.itkolleg.growmanager;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Plant;
import at.itkolleg.growmanager.domain.PlantType;
import at.itkolleg.growmanager.repositories.grow.DbAccessGrow;
import at.itkolleg.growmanager.repositories.plant.DbAccessPlant;
import at.itkolleg.growmanager.repositories.plantType.DbAccessPlantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
public class GrowManagerApplication implements ApplicationRunner {

    @Autowired
    DbAccessPlantType dbAccessPlantType;

    @Autowired
    DbAccessPlant dbAccessPlant;

    @Autowired
    DbAccessGrow dbAccessGrow;

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

        LocalDate startDate = LocalDate.of(2023, 02, 01);
        LocalDate estimatedEndDate = startDate.plusDays(30);

        Grow growTomate = new Grow(tomate, startDate, estimatedEndDate, 5.5F, false, null);
        Grow growErdbeere = new Grow(erdbeere, startDate, estimatedEndDate, 3.5F, false, null);
        Grow growBasilikum = new Grow(basilikum, startDate, estimatedEndDate, 8.5F, false, null);
        Grow growFliegenpilz = new Grow(fliegenpilz, startDate, estimatedEndDate, 1.5F, false, null);

        this.dbAccessGrow.saveGrow(growTomate);
        this.dbAccessGrow.saveGrow(growErdbeere);
        this.dbAccessGrow.saveGrow(growBasilikum);
        this.dbAccessGrow.saveGrow(growFliegenpilz);

    }

}
