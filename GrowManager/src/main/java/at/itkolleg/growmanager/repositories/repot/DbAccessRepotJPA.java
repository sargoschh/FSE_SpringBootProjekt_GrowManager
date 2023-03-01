package at.itkolleg.growmanager.repositories.repot;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Repot;
import at.itkolleg.growmanager.exceptions.repot.DuplicatedRepotException;
import at.itkolleg.growmanager.exceptions.repot.RepotNotFound;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class DbAccessRepotJPA implements DbAccessRepot {

    private RepotJPARepo repotJPARepo;

    public DbAccessRepotJPA(RepotJPARepo repotJPARepo) {
        this.repotJPARepo = repotJPARepo;
    }

    @Override
    public Repot saveRepot(Repot repot) throws DuplicatedRepotException {
        return this.repotJPARepo.save(repot);
    }

    @Override
    public List<Repot> allRepots() {
        return this.repotJPARepo.findAll();
    }

    @Override
    public List<Repot> allRepotsWithGrow(Grow grow) {
        return this.repotJPARepo.findAllByGrow(grow);
    }

    @Override
    public Repot repotWithId(Long id) throws RepotNotFound {
        Optional<Repot> optRepot = this.repotJPARepo.findById(id);
        if(optRepot.isPresent()) {
            return optRepot.get();
        } else {
            throw new RepotNotFound("Repot mit der ID " + id + " nicht gefunden!");
        }
    }

    @Override
    public Repot deleteRepotTypeWithId(Long id) throws RepotNotFound {
        Repot repotFromDb = this.repotWithId(id);
        this.repotJPARepo.deleteById(repotFromDb.getId());
        return repotFromDb;
    }
}
