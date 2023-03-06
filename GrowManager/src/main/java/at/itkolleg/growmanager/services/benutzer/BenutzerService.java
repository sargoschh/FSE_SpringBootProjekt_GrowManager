package at.itkolleg.growmanager.services.benutzer;

import at.itkolleg.growmanager.domain.Benutzer;
import at.itkolleg.growmanager.exceptions.benutzer.DuplicatedBenutzerException;
import at.itkolleg.growmanager.exceptions.benutzer.BenutzerNotFound;

import java.util.List;

public interface BenutzerService {

    List<Benutzer> allBenutzer();
    Benutzer insertBenutzer(Benutzer benutzer) throws DuplicatedBenutzerException;
    Benutzer updateBenutzer(Benutzer benutzer) throws BenutzerNotFound, DuplicatedBenutzerException;
    Benutzer benutzerWithId(Long id) throws BenutzerNotFound;
    List<Benutzer> allBenutzerWithName(String name);
    Benutzer deleteBenutzerWithId(Long id) throws BenutzerNotFound;
    Boolean isBenutzerAlreadyInDb(Benutzer user) throws BenutzerNotFound;
}
