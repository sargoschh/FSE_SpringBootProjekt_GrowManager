package at.itkolleg.growmanager.repositories.grow;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Plant;
import at.itkolleg.growmanager.exceptions.grow.DuplicatedGrowException;
import at.itkolleg.growmanager.exceptions.grow.GrowNotFound;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DbAccessGrowJPA implements DbAccessGrow {

    private GrowJPARepo growJPARepo;

    public DbAccessGrowJPA(GrowJPARepo growJPARepo) {
        this.growJPARepo = growJPARepo;
    }

    @Override
    public Grow saveGrow(Grow grow) throws DuplicatedGrowException {
        try {
            return this.growJPARepo.save(grow);
        } catch (Exception e) {
            throw new DuplicatedGrowException("Grow bereits vorhanden!");
        }
    }

    @Override
    public List<Grow> allGrows() {
        return this.growJPARepo.findAll();
    }

    @Override
    public List<Grow> allGrowsWithPlant(Plant plant) {
        return this.growJPARepo.findAllByPlant(plant);
    }

    @Override
    public Grow growWithId(Long id) throws GrowNotFound {
        Optional<Grow> optGrow = this.growJPARepo.findById(id);
        if(optGrow.isPresent()) {
            return optGrow.get();
        } else {
            throw new GrowNotFound("Grow mit der ID " + id + " nicht gefunden!");
        }
    }

    @Override
    public Grow deleteGrowTypeWithId(Long id) throws GrowNotFound {
        Grow growFromDb = this.growWithId(id);
        this.growJPARepo.deleteById(growFromDb.getId());
        return growFromDb;
    }
}
