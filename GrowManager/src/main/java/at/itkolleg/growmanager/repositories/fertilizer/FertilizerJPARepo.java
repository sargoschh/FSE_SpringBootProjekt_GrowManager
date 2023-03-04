package at.itkolleg.growmanager.repositories.fertilizer;

import at.itkolleg.growmanager.domain.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FertilizerJPARepo extends JpaRepository<Fertilizer, Long> {

    List<Fertilizer> findAllByName(String name);
}
