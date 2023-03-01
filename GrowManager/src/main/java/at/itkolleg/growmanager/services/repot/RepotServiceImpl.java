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
        return this.dbAccessRepot.allRepots();
    }

    @Override
    public Repot insertRepot(Repot repot) throws DuplicatedRepotException {
        return this.dbAccessRepot.saveRepot(repot);
    }

    @Override
    public Repot updateRepot(Repot repot) throws RepotNotFound, DuplicatedRepotException {
        Repot repotFromDb = this.dbAccessRepot.repotWithId(repot.getId());
        repotFromDb.setPotSize(repot.getPotSize());
        repotFromDb.setDate(repot.getDate());
        repotFromDb.setComment(repot.getComment());
        return this.dbAccessRepot.saveRepot(repotFromDb);
    }

    @Override
    public Repot repotWithId(Long id) throws RepotNotFound {
        return this.dbAccessRepot.repotWithId(id);
    }

    @Override
    public List<Repot> allRepotsWithGrows(Grow grow) {
        return this.dbAccessRepot.allRepotsWithGrow(grow);
    }

    @Override
    public Repot deleteRepotWithId(Long id) throws RepotNotFound {
        return this.dbAccessRepot.deleteRepotTypeWithId(id);
    }
}
