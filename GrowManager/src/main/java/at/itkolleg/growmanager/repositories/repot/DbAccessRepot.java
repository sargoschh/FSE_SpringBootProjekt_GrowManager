package at.itkolleg.growmanager.repositories.repot;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Repot;
import at.itkolleg.growmanager.exceptions.repot.DuplicatedRepotException;
import at.itkolleg.growmanager.exceptions.repot.RepotNotFound;

import java.util.List;

public interface DbAccessRepot {

    Repot saveRepot(Repot repot) throws DuplicatedRepotException;
    List<Repot> allRepots();
    List<Repot> allRepotsWithGrow(Grow grow);
    Repot repotWithId(Long id) throws RepotNotFound;
    Repot deleteRepotTypeWithId(Long id) throws RepotNotFound;
}
