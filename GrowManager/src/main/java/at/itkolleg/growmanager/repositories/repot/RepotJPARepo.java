package at.itkolleg.growmanager.repositories.repot;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Repot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepotJPARepo extends JpaRepository<Repot, Long> {

    List<Repot> findAllByGrow(Grow grow);
}
