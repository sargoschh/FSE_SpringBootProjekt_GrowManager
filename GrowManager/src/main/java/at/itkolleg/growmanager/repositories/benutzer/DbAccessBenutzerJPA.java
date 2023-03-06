package at.itkolleg.growmanager.repositories.benutzer;

import at.itkolleg.growmanager.domain.Benutzer;
import at.itkolleg.growmanager.exceptions.benutzer.DuplicatedBenutzerException;
import at.itkolleg.growmanager.exceptions.benutzer.BenutzerNotFound;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DbAccessBenutzerJPA implements DbAccessBenutzer {

    private BenutzerJPARepo benutzerJPARepo;

    public DbAccessBenutzerJPA(BenutzerJPARepo benutzerJPARepo) {
        this.benutzerJPARepo = benutzerJPARepo;
    }

    @Override
    public Benutzer saveBenutzer(Benutzer benutzer) throws DuplicatedBenutzerException {
        try {
            return this.benutzerJPARepo.save(benutzer);
        } catch (Exception e) {
            throw new DuplicatedBenutzerException("Benutzer bereits vorhanden!");
        }
    }

    @Override
    public List<Benutzer> allBenutzer() {
        return this.benutzerJPARepo.findAll();
    }

    @Override
    public List<Benutzer> allBenutzerWithUsername(String name) {
        return this.benutzerJPARepo.findAllByUsername(name);
    }

    @Override
    public Benutzer benutzerWithId(Long id) throws BenutzerNotFound {
        Optional<Benutzer> optBenutzer = this.benutzerJPARepo.findById(id);
        if(optBenutzer.isPresent()) {
            return optBenutzer.get();
        } else {
            throw new BenutzerNotFound("Benutzer mit der ID " + id + " nicht gefunden!");
        }
    }

    @Override
    public Benutzer deleteBenutzerTypeWithId(Long id) throws BenutzerNotFound {
        Benutzer benutzerFromDb = this.benutzerWithId(id);
        this.benutzerJPARepo.deleteById(benutzerFromDb.getId());
        return benutzerFromDb;
    }

    @Override
    public Optional<Benutzer> findBenutzerByUsernameAndPassword(String username, String password) throws BenutzerNotFound {
        List<Benutzer> allBenutzerWithUsername = this.benutzerJPARepo.findAllByUsername(username);
        for (Benutzer u : allBenutzerWithUsername) {
            if(u.getPassword().equals(password)) {
                return Optional.of(u);
            } else {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
