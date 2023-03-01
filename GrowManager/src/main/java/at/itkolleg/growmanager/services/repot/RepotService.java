package at.itkolleg.growmanager.services.repot;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Repot;
import at.itkolleg.growmanager.exceptions.repot.DuplicatedRepotException;
import at.itkolleg.growmanager.exceptions.repot.RepotNotFound;

import java.util.List;

public interface RepotService {

    List<Repot> allRepots();
    Repot insertRepot(Repot repot) throws DuplicatedRepotException;
    Repot updateRepot(Repot repot) throws RepotNotFound, DuplicatedRepotException;
    Repot repotWithId(Long id) throws RepotNotFound;
    List<Repot> allRepotsWithGrows(Grow grow);
    Repot deleteRepotWithId(Long id) throws RepotNotFound;
}
