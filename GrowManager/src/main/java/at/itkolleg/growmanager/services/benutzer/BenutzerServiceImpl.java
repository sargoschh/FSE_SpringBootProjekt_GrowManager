package at.itkolleg.growmanager.services.benutzer;

import at.itkolleg.growmanager.domain.Benutzer;
import at.itkolleg.growmanager.exceptions.benutzer.DuplicatedBenutzerException;
import at.itkolleg.growmanager.exceptions.benutzer.BenutzerNotFound;
import at.itkolleg.growmanager.repositories.benutzer.DbAccessBenutzer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BenutzerServiceImpl implements BenutzerService {

    private DbAccessBenutzer dbAccessBenutzer;

    public BenutzerServiceImpl(DbAccessBenutzer dbAccessBenutzer) {
        this.dbAccessBenutzer = dbAccessBenutzer;
    }

    @Override
    public List<Benutzer> allBenutzer() {
        return this.dbAccessBenutzer.allBenutzer();
    }

    @Override
    public Benutzer insertBenutzer(Benutzer benutzer) throws DuplicatedBenutzerException {
        return this.dbAccessBenutzer.saveBenutzer(benutzer);
    }

    @Override
    public Benutzer updateBenutzer(Benutzer benutzer) throws BenutzerNotFound, DuplicatedBenutzerException {
        Benutzer benutzerFromDb = this.dbAccessBenutzer.benutzerWithId(benutzer.getId());
        benutzerFromDb.setUsername(benutzer.getUsername());
        benutzerFromDb.setPassword(benutzer.getPassword());
        return this.dbAccessBenutzer.saveBenutzer(benutzerFromDb);
    }

    @Override
    public Benutzer benutzerWithId(Long id) throws BenutzerNotFound {
        return this.dbAccessBenutzer.benutzerWithId(id);
    }

    @Override
    public List<Benutzer> allBenutzerWithName(String name) {
        return this.dbAccessBenutzer.allBenutzerWithUsername(name);
    }

    @Override
    public Benutzer deleteBenutzerWithId(Long id) throws BenutzerNotFound {
        return this.dbAccessBenutzer.deleteBenutzerTypeWithId(id);
    }

    @Override
    public Boolean isBenutzerAlreadyInDb(Benutzer user) throws BenutzerNotFound {
        Optional<Benutzer> benutzerInDb = this.dbAccessBenutzer.findBenutzerByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(benutzerInDb.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
