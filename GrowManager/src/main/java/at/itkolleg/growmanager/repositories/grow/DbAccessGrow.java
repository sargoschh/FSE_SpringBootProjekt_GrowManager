package at.itkolleg.growmanager.repositories.grow;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Plant;
import at.itkolleg.growmanager.exceptions.grow.DuplicatedGrowException;
import at.itkolleg.growmanager.exceptions.grow.GrowNotFound;

import java.util.List;

public interface DbAccessGrow {

    Grow saveGrow(Grow grow) throws DuplicatedGrowException;
    List<Grow> allGrows();
    List<Grow> allGrowsWithPlant(Plant plant);
    Grow growWithId(Long id) throws GrowNotFound;
    Grow deleteGrowTypeWithId(Long id) throws GrowNotFound;
}
