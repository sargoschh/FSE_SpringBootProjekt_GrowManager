package at.itkolleg.growmanager;

import at.itkolleg.growmanager.domain.*;
import at.itkolleg.growmanager.repositories.fertilizer.DbAccessFertilizer;
import at.itkolleg.growmanager.repositories.fertilizerType.DbAccessFertilizerType;
import at.itkolleg.growmanager.repositories.grow.DbAccessGrow;
import at.itkolleg.growmanager.repositories.plant.DbAccessPlant;
import at.itkolleg.growmanager.repositories.plantType.DbAccessPlantType;
import at.itkolleg.growmanager.repositories.repot.DbAccessRepot;
import at.itkolleg.growmanager.repositories.user.DbAccessUser;
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

    @Autowired
    DbAccessRepot dbAccessRepot;

    @Autowired
    DbAccessFertilizerType dbAccessFertilizerType;

    @Autowired
    DbAccessFertilizer dbAccessFertilizer;

    @Autowired
    DbAccessUser dbAccessUser;


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

        Repot repotTomate = new Repot(growTomate, 7.8F, LocalDate.of(2023, 03,02), "Repot von 1,5 auf 8,5l");
        Repot repotErdbeere = new Repot(growErdbeere, 9.5F, LocalDate.of(2023, 03,05), "Super Repot");
        Repot repotBasilikum = new Repot(growBasilikum, 4.6F, LocalDate.of(2023, 03,9), "Alle umgetopft!");
        Repot repotFliegenpilz = new Repot(growFliegenpilz, 15.2F, LocalDate.of(2023, 03,3), "Wahnsinn");

        this.dbAccessRepot.saveRepot(repotTomate);
        this.dbAccessRepot.saveRepot(repotErdbeere);
        this.dbAccessRepot.saveRepot(repotBasilikum);
        this.dbAccessRepot.saveRepot(repotFliegenpilz);

        FertilizerType natural = new FertilizerType("NATURAL");
        FertilizerType terra = new FertilizerType("TERRA");
        FertilizerType coco = new FertilizerType("COCO");
        FertilizerType hydro = new FertilizerType("HYDRO");
        FertilizerType universal = new FertilizerType("UNIVERSAL");

        this.dbAccessFertilizerType.saveFertilizerType(natural);
        this.dbAccessFertilizerType.saveFertilizerType(terra);
        this.dbAccessFertilizerType.saveFertilizerType(coco);
        this.dbAccessFertilizerType.saveFertilizerType(hydro);
        this.dbAccessFertilizerType.saveFertilizerType(universal);

        Fertilizer greenSensation = new Fertilizer("Green Sensation", universal, 100F);
        Fertilizer pureZym = new Fertilizer("Pure Zym", universal, 100F);
        Fertilizer terraGrow = new Fertilizer("Terra Grow", terra, 100F);
        Fertilizer terraBloom = new Fertilizer("Terra Bloom", terra, 1000F);


        this.dbAccessFertilizer.saveFertilizer(greenSensation);
        this.dbAccessFertilizer.saveFertilizer(pureZym);
        this.dbAccessFertilizer.saveFertilizer(terraGrow);
        this.dbAccessFertilizer.saveFertilizer(terraBloom);


        User userSarah = new User("Sarah", "sarah", "schnaggl123");

        this.dbAccessUser.saveUser(userSarah);
    }

}
