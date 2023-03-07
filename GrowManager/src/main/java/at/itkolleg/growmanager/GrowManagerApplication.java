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

        LocalDate date1 = LocalDate.of(2023, 3, 1);
        LocalDate date2 = LocalDate.of(2023, 2, 25);
        LocalDate date3 = LocalDate.of(2023, 1, 31);
        LocalDate date4 = LocalDate.of(2023, 2, 20);
        LocalDate date5 = LocalDate.of(2023, 2, 18);
        LocalDate date6 = LocalDate.of(2023, 1, 30);
        LocalDate date7 = LocalDate.of(2023, 2, 22);
        LocalDate date8 = LocalDate.of(2023, 3, 4);
        LocalDate date9 = LocalDate.of(2023, 2, 15);
        LocalDate date10 = LocalDate.of(2023, 2, 1);
        LocalDate date11 = LocalDate.of(2023, 2, 27);
        LocalDate date12 = LocalDate.of(2023, 2, 5);
        LocalDate date13 = LocalDate.of(2023, 1, 28);
        LocalDate date14 = LocalDate.of(2023, 2, 3);
        LocalDate date15 = LocalDate.of(2023, 2, 10);
        LocalDate date16 = LocalDate.of(2023, 2, 13);
        LocalDate date17 = LocalDate.of(2023, 2, 24);
        LocalDate date18 = LocalDate.of(2023, 3, 3);
        LocalDate date19 = LocalDate.of(2023, 2, 6);
        LocalDate date20 = LocalDate.of(2023, 2, 17);

        float floatVal1 = 19.3f;
        float floatVal2 = 32.1f;
        float floatVal3 = 12.8f;
        float floatVal4 = 23.7f;
        float floatVal5 = 5.6f;
        float floatVal6 = 41.9f;
        float floatVal7 = 14.5f;
        float floatVal8 = 48.2f;
        float floatVal9 = 9.4f;
        float floatVal10 = 29.6f;
        float floatVal11 = 35.7f;
        float floatVal12 = 17.3f;
        float floatVal13 = 3.1f;
        float floatVal14 = 45.8f;
        float floatVal15 = 11.2f;
        float floatVal16 = 27.9f;
        float floatVal17 = 6.5f;
        float floatVal18 = 38.6f;
        float floatVal19 = 21.0f;
        float floatVal20 = 49.1f;


        PlantType kraeuter = new PlantType("Kräuter");
        this.dbAccessPlantType.savePlantType(kraeuter);

        PlantType sonstiges = new PlantType("Sonstiges");
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



        Plant rose = new Plant("Rose", blume, 50);
        this.dbAccessPlant.savePlant(rose);

        Grow rosen = new Grow(rose, date1, date1.plusDays(rose.getGrowthPeriod()), floatVal1, false, null);
        this.dbAccessGrow.saveGrow(rosen);

        Plant tulpe = new Plant("Tulpe", blume, 30);
        this.dbAccessPlant.savePlant(tulpe);

        Grow tulpen = new Grow(tulpe, date2, date2.plusDays(tulpe.getGrowthPeriod()), floatVal2, false, null);
        this.dbAccessGrow.saveGrow(tulpen);

        Plant sonnenblume = new Plant("Sonnenblume", blume, 70);
        this.dbAccessPlant.savePlant(sonnenblume);

        Grow sonnenblumen = new Grow(sonnenblume, date3, date3.plusDays(sonnenblume.getGrowthPeriod()), floatVal3, false, null);
        this.dbAccessGrow.saveGrow(sonnenblumen);

        Plant ahorn = new Plant("Ahorn", baum, 100);
        this.dbAccessPlant.savePlant(ahorn);

        Grow ahorn1 = new Grow(ahorn, date4, date4.plusDays(ahorn.getGrowthPeriod()), floatVal4, false, null);
        this.dbAccessGrow.saveGrow(ahorn1);

        Plant kiefer = new Plant("Kiefer", baum, 80);
        this.dbAccessPlant.savePlant(kiefer);

        Grow kiefern = new Grow(kiefer, date5, date5.plusDays(kiefer.getGrowthPeriod()), floatVal5, false, null);
        this.dbAccessGrow.saveGrow(kiefern);

        Plant apfelbaum = new Plant("Apfelbaum", obst, 120);
        this.dbAccessPlant.savePlant(apfelbaum);

        Grow apfelbäume = new Grow(apfelbaum, date6, date6.plusDays(apfelbaum.getGrowthPeriod()), floatVal6, false, null);
        this.dbAccessGrow.saveGrow(apfelbäume);

        Plant kirschbaum = new Plant("Kirschbaum", obst, 110);
        this.dbAccessPlant.savePlant(kirschbaum);

        Grow kirschbäume = new Grow(kirschbaum, date7, date7.plusDays(kirschbaum.getGrowthPeriod()), floatVal7, false, null);
        this.dbAccessGrow.saveGrow(kirschbäume);

        Plant zucchini = new Plant("Zucchini", gemuese, 40);
        this.dbAccessPlant.savePlant(zucchini);

        Grow zucchinii = new Grow(zucchini, date8, date8.plusDays(zucchini.getGrowthPeriod()), floatVal8, false, null);
        this.dbAccessGrow.saveGrow(zucchinii);

        Plant tomatenpflanze = new Plant("Tomatenpflanze", gemuese, 35);
        this.dbAccessPlant.savePlant(tomatenpflanze);

        Grow tomaten = new Grow(tomatenpflanze, date9, date9.plusDays(tomatenpflanze.getGrowthPeriod()), floatVal9, false, null);
        this.dbAccessGrow.saveGrow(tomaten);

        Plant basilikum = new Plant("Basilikum", kraut, 25);
        this.dbAccessPlant.savePlant(basilikum);

        Grow basilikum1 = new Grow(basilikum, date10, date10.plusDays(basilikum.getGrowthPeriod()), floatVal10, false, null);
        this.dbAccessGrow.saveGrow(basilikum1);

        Plant thymian = new Plant("Thymian", kraut, 20);
        this.dbAccessPlant.savePlant(thymian);

        Grow thymian1 = new Grow(thymian, date11, date11.plusDays(thymian.getGrowthPeriod()), floatVal11, false, null);
        this.dbAccessGrow.saveGrow(thymian1);

        Plant efeu = new Plant("Efeu", kletterpflanze, 60);
        this.dbAccessPlant.savePlant(efeu);

        Grow efeu1 = new Grow(efeu, date12, date12.plusDays(efeu.getGrowthPeriod()), floatVal12, false, null);
        this.dbAccessGrow.saveGrow(efeu1);

        Plant kletterrose = new Plant("Kletterrose", kletterpflanze, 45);
        this.dbAccessPlant.savePlant(kletterrose);

        Grow kletterrosen = new Grow(kletterrose, date13, date13.plusDays(kletterrose.getGrowthPeriod()), floatVal13, false, null);
        this.dbAccessGrow.saveGrow(kletterrosen);

        Plant bienenweide = new Plant("Bienenweide", bienenpflanze, 30);
        this.dbAccessPlant.savePlant(bienenweide);

        Grow bienenweiden = new Grow(bienenweide, date14, date14.plusDays(bienenweide.getGrowthPeriod()), floatVal14, false, null);
        this.dbAccessGrow.saveGrow(bienenweiden);

        Plant schneeball = new Plant("Schneeball", zierpflanze, 65);
        this.dbAccessPlant.savePlant(schneeball);

        Grow schneebaelle = new Grow(schneeball, date15, date15.plusDays(schneeball.getGrowthPeriod()), floatVal15, false, null);
        this.dbAccessGrow.saveGrow(schneebaelle);

        Plant farn = new Plant("Farn", moos, 50);
        this.dbAccessPlant.savePlant(farn);

        Grow farne = new Grow(farn, date16, date16.plusDays(farn.getGrowthPeriod()), floatVal16, false, null);
        this.dbAccessGrow.saveGrow(farne);

        Plant zimmerpflanze = new Plant("Zimmerpflanze", tropenpflanze, 40);
        this.dbAccessPlant.savePlant(zimmerpflanze);

        Grow zimmerpflanzen = new Grow(zimmerpflanze, date17, date17.plusDays(zimmerpflanze.getGrowthPeriod()), floatVal17, false, null);
        this.dbAccessGrow.saveGrow(zimmerpflanzen);

        Plant kaktus1 = new Plant("Kaktus", wuestenpflanze, 90);
        this.dbAccessPlant.savePlant(kaktus1);

        Grow kaktus2 = new Grow(kaktus1, date18, date18.plusDays(kaktus1.getGrowthPeriod()), floatVal18, false, null);
        this.dbAccessGrow.saveGrow(kaktus2);

        Plant margerite = new Plant("Margerite", wildblume, 25);
        this.dbAccessPlant.savePlant(margerite);

        Grow margeriten = new Grow(margerite, date19, date19.plusDays(margerite.getGrowthPeriod()), floatVal19, false, null);
        this.dbAccessGrow.saveGrow(margeriten);


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
