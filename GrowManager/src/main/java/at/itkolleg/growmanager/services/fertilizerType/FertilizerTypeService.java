package at.itkolleg.growmanager.services.fertilizerType;

import at.itkolleg.growmanager.domain.FertilizerType;
import at.itkolleg.growmanager.exceptions.fertilizer.DuplicatedFertilizerException;
import at.itkolleg.growmanager.exceptions.fertilizer.FertilizerNotFound;
import at.itkolleg.growmanager.exceptions.fertilizerType.DuplicatedFertilizerTypeException;
import at.itkolleg.growmanager.exceptions.fertilizerType.FertilizerTypeNotFound;

import java.util.List;

public interface FertilizerTypeService {

    List<FertilizerType> allFertilizerTypes();

    FertilizerType insertFertilizerType(FertilizerType fertilizerType) throws DuplicatedFertilizerException, DuplicatedFertilizerTypeException;

    FertilizerType updateFertilizerType(FertilizerType fertilizerType) throws FertilizerTypeNotFound, DuplicatedFertilizerTypeException;

    FertilizerType fertilizerTypeWithId(Long id) throws FertilizerTypeNotFound;

    List<FertilizerType> allFertilizerTypesWithName(String name);

    FertilizerType deleteFertilizerTypeWithId(Long id) throws FertilizerTypeNotFound;
}
