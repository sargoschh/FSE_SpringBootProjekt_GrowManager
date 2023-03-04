package at.itkolleg.growmanager.repositories.fertilizer;

import at.itkolleg.growmanager.domain.Fertilizer;
import at.itkolleg.growmanager.exceptions.fertilizer.DuplicatedFertilizerException;
import at.itkolleg.growmanager.exceptions.fertilizer.FertilizerNotFound;

import java.util.List;

public interface DbAccessFertilizer {
    Fertilizer saveFertilizer(Fertilizer fertilizer) throws DuplicatedFertilizerException;

    List<Fertilizer> allFertilizer();

    List<Fertilizer> allFertilizersWithName(String name);

    Fertilizer fertilizerWithId(Long id) throws FertilizerNotFound;

    Fertilizer deleteFertilizerWithId(Long id) throws FertilizerNotFound;
}
