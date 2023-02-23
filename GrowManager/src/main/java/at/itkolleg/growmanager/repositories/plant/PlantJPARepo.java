package at.itkolleg.growmanager.repositories.plant;

import at.itkolleg.growmanager.domain.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantJPARepo extends JpaRepository<Plant, Long> {

    List<Plant> findAllByName(String name);
}
