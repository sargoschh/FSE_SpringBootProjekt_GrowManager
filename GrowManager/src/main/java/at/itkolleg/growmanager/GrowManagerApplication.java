package at.itkolleg.growmanager;

import at.itkolleg.growmanager.domain.*;
import at.itkolleg.growmanager.repositories.fertilizer.DbAccessFertilizer;
import at.itkolleg.growmanager.repositories.fertilizerType.DbAccessFertilizerType;
import at.itkolleg.growmanager.repositories.grow.DbAccessGrow;
import at.itkolleg.growmanager.repositories.plant.DbAccessPlant;
import at.itkolleg.growmanager.repositories.plantType.DbAccessPlantType;
import at.itkolleg.growmanager.repositories.repot.DbAccessRepot;
import at.itkolleg.growmanager.repositories.benutzer.DbAccessBenutzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    DbAccessBenutzer dbAccessUser;


    public static void main(String[] args) {
        SpringApplication.run(GrowManagerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /*PlantType gemuese = new PlantType("Gemüse");
        PlantType obst = new PlantType("Obst");*/
        PlantType kraeuter = new PlantType("Kräuter");
        PlantType sonstiges = new PlantType("Sonstiges");

        /*this.dbAccessPlantType.savePlantType(gemuese);
        this.dbAccessPlantType.savePlantType(obst);*/
        this.dbAccessPlantType.savePlantType(kraeuter);
        this.dbAccessPlantType.savePlantType(sonstiges);

        PlantType blume = new PlantType("Blume");
        this.dbAccessPlantType.savePlantType(blume);

        PlantType strauch = new PlantType("Strauch");
        this.dbAccessPlantType.savePlantType(strauch);

        PlantType baum = new PlantType("Baum");
        this.dbAccessPlantType.savePlantType(baum);

        PlantType kaktus = new PlantType("Kaktus");
        this.dbAccessPlantType.savePlantType(kaktus);

        PlantType kraut = new PlantType("Kraut");
        this.dbAccessPlantType.savePlantType(kraut);

        PlantType gemuese = new PlantType("Gemüse");
        this.dbAccessPlantType.savePlantType(gemuese);

        PlantType obst = new PlantType("Obst");
        this.dbAccessPlantType.savePlantType(obst);

        PlantType zierpflanze = new PlantType("Zierpflanze");
        this.dbAccessPlantType.savePlantType(zierpflanze);

        PlantType kletterpflanze = new PlantType("Kletterpflanze");
        this.dbAccessPlantType.savePlantType(kletterpflanze);

        PlantType krautergarten = new PlantType("Kräutergarten");
        this.dbAccessPlantType.savePlantType(krautergarten);

        PlantType bienenpflanze = new PlantType("Bienenpflanze");
        this.dbAccessPlantType.savePlantType(bienenpflanze);

        PlantType heckenpflanze = new PlantType("Heckenpflanze");
        this.dbAccessPlantType.savePlantType(heckenpflanze);

        PlantType bonsai = new PlantType("Bonsai");
        this.dbAccessPlantType.savePlantType(bonsai);

        PlantType moos = new PlantType("Moos");
        this.dbAccessPlantType.savePlantType(moos);

        PlantType blatt = new PlantType("Blatt");
        this.dbAccessPlantType.savePlantType(blatt);

        PlantType wildblume = new PlantType("Wildblume");
        this.dbAccessPlantType.savePlantType(wildblume);

        PlantType tropenpflanze = new PlantType("Tropenpflanze");
        this.dbAccessPlantType.savePlantType(tropenpflanze);

        PlantType wuestenpflanze = new PlantType("Wüstenpflanze");
        this.dbAccessPlantType.savePlantType(wuestenpflanze);

        PlantType blumenstrauss = new PlantType("Blumenstrauß");
        this.dbAccessPlantType.savePlantType(blumenstrauss);

        /*Plant tomate = new Plant("Tomate", gemuese, 60);
        Plant erdbeere = new Plant("Erdbeere", obst, 45);
        Plant basilikum = new Plant("Basilikum", kraeuter, 20);
        Plant fliegenpilz = new Plant("Fliegenpilz", sonstiges, 30);

        this.dbAccessPlant.savePlant(tomate);
        this.dbAccessPlant.savePlant(erdbeere);
        this.dbAccessPlant.savePlant(basilikum);
        this.dbAccessPlant.savePlant(fliegenpilz);*/

        Plant rose = new Plant("Rose", blume, 50);
        this.dbAccessPlant.savePlant(rose);

        Plant tulpe = new Plant("Tulpe", blume, 30);
        this.dbAccessPlant.savePlant(tulpe);

        Plant sonnenblume = new Plant("Sonnenblume", blume, 70);
        this.dbAccessPlant.savePlant(sonnenblume);

        Plant ahorn = new Plant("Ahorn", baum, 100);
        this.dbAccessPlant.savePlant(ahorn);

        Plant kiefer = new Plant("Kiefer", baum, 80);
        this.dbAccessPlant.savePlant(kiefer);

        Plant apfelbaum = new Plant("Apfelbaum", obst, 120);
        this.dbAccessPlant.savePlant(apfelbaum);

        Plant kirschbaum = new Plant("Kirschbaum", obst, 110);
        this.dbAccessPlant.savePlant(kirschbaum);

        Plant zucchini = new Plant("Zucchini", gemuese, 40);
        this.dbAccessPlant.savePlant(zucchini);

        Plant tomatenpflanze = new Plant("Tomatenpflanze", gemuese, 35);
        this.dbAccessPlant.savePlant(tomatenpflanze);

        Plant basilikum = new Plant("Basilikum", kraut, 25);
        this.dbAccessPlant.savePlant(basilikum);

        Plant thymian = new Plant("Thymian", kraut, 20);
        this.dbAccessPlant.savePlant(thymian);

        Plant efeu = new Plant("Efeu", kletterpflanze, 60);
        this.dbAccessPlant.savePlant(efeu);

        Plant kletterrose = new Plant("Kletterrose", kletterpflanze, 45);
        this.dbAccessPlant.savePlant(kletterrose);

        Plant bienenweide = new Plant("Bienenweide", bienenpflanze, 30);
        this.dbAccessPlant.savePlant(bienenweide);

        Plant schneeball = new Plant("Schneeball", zierpflanze, 65);
        this.dbAccessPlant.savePlant(schneeball);

        Plant farn = new Plant("Farn", moos, 50);
        this.dbAccessPlant.savePlant(farn);

        Plant zimmerpflanze = new Plant("Zimmerpflanze", tropenpflanze, 40);
        this.dbAccessPlant.savePlant(zimmerpflanze);

        Plant kaktus1 = new Plant("Kaktus", wuestenpflanze, 90);
        this.dbAccessPlant.savePlant(kaktus1);

        Plant margerite = new Plant("Margerite", wildblume, 25);
        this.dbAccessPlant.savePlant(margerite);

        LocalDate startDate = LocalDate.of(2023, 02, 01);
        LocalDate estimatedEndDate = startDate.plusDays(30);

        /*Grow growTomate = new Grow(tomate, startDate, estimatedEndDate, 5.5F, false, null);
        Grow growErdbeere = new Grow(erdbeere, startDate, estimatedEndDate, 3.5F, false, null);
        Grow growBasilikum = new Grow(basilikum, startDate, estimatedEndDate, 8.5F, false, null);
        Grow growFliegenpilz = new Grow(fliegenpilz, startDate, estimatedEndDate, 1.5F, false, null);

        this.dbAccessGrow.saveGrow(growTomate);
        this.dbAccessGrow.saveGrow(growErdbeere);
        this.dbAccessGrow.saveGrow(growBasilikum);
        this.dbAccessGrow.saveGrow(growFliegenpilz);*/

        /*Repot repotTomate = new Repot(growTomate, 7.8F, LocalDate.of(2023, 03,02), "Repot von 1,5 auf 8,5l");
        Repot repotErdbeere = new Repot(growErdbeere, 9.5F, LocalDate.of(2023, 03,05), "Super Repot");
        Repot repotBasilikum = new Repot(growBasilikum, 4.6F, LocalDate.of(2023, 03,9), "Alle umgetopft!");
        Repot repotFliegenpilz = new Repot(growFliegenpilz, 15.2F, LocalDate.of(2023, 03,3), "Wahnsinn");

        this.dbAccessRepot.saveRepot(repotTomate);
        this.dbAccessRepot.saveRepot(repotErdbeere);
        this.dbAccessRepot.saveRepot(repotBasilikum);
        this.dbAccessRepot.saveRepot(repotFliegenpilz);*/

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


        Benutzer userSarah = new Benutzer("Sarah", "sarah", "schnaggl123");
        Benutzer userMarcel = new Benutzer("Marcel", "marcel", "schnaggl123");
        Benutzer userRomana = new Benutzer("Romana", "romana", "schnaggl123");
        Benutzer userAdrian = new Benutzer("Adrian", "adrian", "schnaggl123");

        this.dbAccessUser.saveBenutzer(userSarah);
        this.dbAccessUser.saveBenutzer(userMarcel);
        this.dbAccessUser.saveBenutzer(userRomana);
        this.dbAccessUser.saveBenutzer(userAdrian);
    }

}
