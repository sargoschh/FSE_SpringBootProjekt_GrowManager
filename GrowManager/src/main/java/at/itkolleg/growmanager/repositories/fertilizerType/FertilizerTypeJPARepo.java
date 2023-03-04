package at.itkolleg.growmanager.repositories.fertilizerType;

import at.itkolleg.growmanager.domain.FertilizerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FertilizerTypeJPARepo extends JpaRepository<FertilizerType, Long> {

    List<FertilizerType> findAllByName(String name);
}
