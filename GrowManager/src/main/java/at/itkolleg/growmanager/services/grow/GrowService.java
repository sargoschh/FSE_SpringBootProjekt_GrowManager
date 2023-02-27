package at.itkolleg.growmanager.services.grow;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Plant;
import at.itkolleg.growmanager.exceptions.grow.DuplicatedGrowException;
import at.itkolleg.growmanager.exceptions.grow.GrowNotFound;

import java.util.List;

public interface GrowService {

    List<Grow> allGrows();
    Grow insertGrow(Grow grow) throws DuplicatedGrowException;
    Grow updateGrow(Grow grow) throws GrowNotFound, DuplicatedGrowException;
    Grow growWithId(Long id) throws GrowNotFound;
    List<Grow> allGrowsWithPlants(Plant plant);
    Grow deleteGrowWithId(Long id) throws GrowNotFound;
}
