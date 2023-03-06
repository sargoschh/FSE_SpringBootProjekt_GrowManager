package at.itkolleg.growmanager.repositories.benutzer;

import at.itkolleg.growmanager.domain.Benutzer;
import at.itkolleg.growmanager.exceptions.benutzer.DuplicatedBenutzerException;
import at.itkolleg.growmanager.exceptions.benutzer.BenutzerNotFound;

import java.util.List;
import java.util.Optional;

public interface DbAccessBenutzer {

    Benutzer saveBenutzer(Benutzer benutzer) throws DuplicatedBenutzerException;
    List<Benutzer> allBenutzer();
    List<Benutzer> allBenutzerWithUsername(String name);
    Benutzer benutzerWithId(Long id) throws BenutzerNotFound;
    Benutzer deleteBenutzerTypeWithId(Long id) throws BenutzerNotFound;
    Optional<Benutzer> findBenutzerByUsernameAndPassword(String username, String password) throws BenutzerNotFound;
}
