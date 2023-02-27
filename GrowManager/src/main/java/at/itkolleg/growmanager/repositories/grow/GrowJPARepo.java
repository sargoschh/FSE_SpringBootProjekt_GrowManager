package at.itkolleg.growmanager.repositories.grow;

import at.itkolleg.growmanager.domain.Grow;
import at.itkolleg.growmanager.domain.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrowJPARepo extends JpaRepository<Grow, Long> {

    List<Grow> findAllByPlant(Plant plant);
}
