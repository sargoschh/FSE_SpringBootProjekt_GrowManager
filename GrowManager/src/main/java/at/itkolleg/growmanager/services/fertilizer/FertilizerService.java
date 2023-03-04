package at.itkolleg.growmanager.services.fertilizer;

import at.itkolleg.growmanager.domain.Fertilizer;
import at.itkolleg.growmanager.repositories.fertilizer.FertilizerJPARepo;

import java.util.List;

public interface FertilizerService {

    List<Fertilizer> allFertilizer();

    Fertilizer insertFertilizer(Fertilizer fertilizer);

    Fertilizer updateFertilizer(Fertilizer fertilizer);

    Fertilizer fertilizerWithId(Long id);

    List<Fertilizer> allFertilizerWithName(String name);

    Fertilizer deleteFertilizerWithid(Long id);
}
