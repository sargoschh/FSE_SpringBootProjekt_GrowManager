package at.itkolleg.growmanager.services.water;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Water;
import at.itkolleg.growmanager.exceptions.water.DuplicatedWaterException;
import at.itkolleg.growmanager.exceptions.water.WaterNotFound;

import java.util.List;

public interface WaterService {

    List<Water> allWaters();

    Water insertWater(Water water) throws DuplicatedWaterException;

    Water updateWater(Water water) throws WaterNotFound, DuplicatedWaterException;

    Water waterWithId(Long id) throws WaterNotFound;

    List<Water> allWatersWithGrows(Grow grow);

    Water deleteWaterWithId(Long id) throws WaterNotFound;


}
