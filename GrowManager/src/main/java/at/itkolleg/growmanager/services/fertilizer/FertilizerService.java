package at.itkolleg.growmanager.services.fertilizer;

import at.itkolleg.growmanager.domain.Fertilizer;
import at.itkolleg.growmanager.exceptions.fertilizer.DuplicatedFertilizerException;
import at.itkolleg.growmanager.exceptions.fertilizer.FertilizerNotFound;
import at.itkolleg.growmanager.repositories.fertilizer.FertilizerJPARepo;

import java.util.List;

public interface FertilizerService {

    List<Fertilizer> allFertilizer();

    Fertilizer insertFertilizer(Fertilizer fertilizer) throws DuplicatedFertilizerException;

    Fertilizer updateFertilizer(Fertilizer fertilizer) throws FertilizerNotFound, DuplicatedFertilizerException;

    Fertilizer fertilizerWithId(Long id) throws FertilizerNotFound;

    List<Fertilizer> allFertilizerWithName(String name);

    Fertilizer deleteFertilizerWithid(Long id) throws FertilizerNotFound;
}
