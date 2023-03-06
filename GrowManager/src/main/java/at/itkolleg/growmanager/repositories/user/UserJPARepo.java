package at.itkolleg.growmanager.repositories.user;

import at.itkolleg.growmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserJPARepo extends JpaRepository<User, Long> {

    List<User> findAllByName(String name);
}
