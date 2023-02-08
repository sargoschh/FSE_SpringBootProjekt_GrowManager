package at.itkolleg.growmanager.repositories;

import at.itkolleg.growmanager.domain.PlantType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantTypeJPARepo extends JpaRepository<PlantType, Long> {

    List<PlantType> findAllByName(String name);
}
