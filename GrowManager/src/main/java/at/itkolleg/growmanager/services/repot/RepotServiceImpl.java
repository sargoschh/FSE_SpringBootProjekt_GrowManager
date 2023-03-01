package at.itkolleg.growmanager.services.repot;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Repot;
import at.itkolleg.growmanager.exceptions.repot.DuplicatedRepotException;
import at.itkolleg.growmanager.exceptions.repot.RepotNotFound;
import at.itkolleg.growmanager.repositories.repot.DbAccessRepot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepotServiceImpl implements RepotService {

    private DbAccessRepot dbAccessRepot;

    public RepotServiceImpl(DbAccessRepot dbAccessRepot) {
        this.dbAccessRepot = dbAccessRepot;
    }

    @Override
    public List<Repot> allRepots() {
        return null;
    }

    @Override
    public Repot insertRepot(Repot repot) throws DuplicatedRepotException {
        return null;
    }

    @Override
    public Repot updateRepot(Repot repot) throws RepotNotFound, DuplicatedRepotException {
        return null;
    }

    @Override
    public Repot repotWithId(Long id) throws RepotNotFound {
        return null;
    }

    @Override
    public List<Repot> allRepotsWithPlants(Grow grow) {
        return null;
    }

    @Override
    public Repot deleteRepotWithId(Long id) throws RepotNotFound {
        return null;
    }
}
