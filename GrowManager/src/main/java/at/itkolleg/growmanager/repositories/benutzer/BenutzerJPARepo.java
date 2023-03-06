package at.itkolleg.growmanager.repositories.benutzer;

import at.itkolleg.growmanager.domain.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BenutzerJPARepo extends JpaRepository<Benutzer, Long> {

    List<Benutzer> findAllByUsername(String username);
    List<Benutzer> findAllByPassword(String password);
}
