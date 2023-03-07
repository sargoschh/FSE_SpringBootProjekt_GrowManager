package at.itkolleg.growmanager.repositories.plantType;

import at.itkolleg.growmanager.domain.PlantType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantTypeJPARepo extends JpaRepository<PlantType, Long> {

    List<PlantType> findAllByName(String name);
    //Page<PlantType> findAll(Pageable pageable);
}
