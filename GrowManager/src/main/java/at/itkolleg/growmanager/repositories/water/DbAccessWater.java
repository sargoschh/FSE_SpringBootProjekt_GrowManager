package at.itkolleg.growmanager.repositories.water;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Water;
import at.itkolleg.growmanager.exceptions.water.DuplicatedWaterException;
import at.itkolleg.growmanager.exceptions.water.WaterNotFound;

import java.util.List;

public interface DbAccessWater {

    Water saveWater(Water water) throws DuplicatedWaterException;

    List<Water> allWaters();

    List<Water> allWatersWithGrow(Grow grow);

    Water waterWithId(Long id) throws WaterNotFound;

    Water deleteWaterById(Long id) throws WaterNotFound;
}
