package at.itkolleg.growmanager.repositories.fertilizerType;

import at.itkolleg.growmanager.domain.FertilizerType;

import at.itkolleg.growmanager.exceptions.fertilizer.FertilizerNotFound;
import at.itkolleg.growmanager.exceptions.fertilizerType.DuplicatedFertilizerTypeException;
import at.itkolleg.growmanager.exceptions.fertilizerType.FertilizerTypeNotFound;

import java.util.List;

public interface DbAccessFertilizerType {

    FertilizerType saveFertilizerType(FertilizerType fertilizerType) throws DuplicatedFertilizerTypeException;

    List<FertilizerType> allFertilizerTypes();

    List<FertilizerType> allFertilizerTypesWithName(String name);

    FertilizerType fertilizerTypesWithId(Long id) throws FertilizerTypeNotFound;

    FertilizerType deleteFertilizerTypeWithId(Long id) throws FertilizerTypeNotFound;
}
