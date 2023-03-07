package at.itkolleg.growmanager.repositories.water;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Water;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaterJPARepo extends JpaRepository<Water, Long> {
    List<Water> findAllByGrow(Grow grow);
}
