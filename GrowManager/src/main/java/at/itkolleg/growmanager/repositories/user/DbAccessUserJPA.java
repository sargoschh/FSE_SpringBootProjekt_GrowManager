package at.itkolleg.growmanager.repositories.user;

import at.itkolleg.growmanager.domain.User;
import at.itkolleg.growmanager.exceptions.user.DuplicatedUserException;
import at.itkolleg.growmanager.exceptions.user.UserNotFound;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DbAccessUserJPA implements DbAccessUser {

    private UserJPARepo userJPARepo;

    public DbAccessUserJPA(UserJPARepo userJPARepo) {
        this.userJPARepo = userJPARepo;
    }

    @Override
    public User saveUser(User user) throws DuplicatedUserException {
        try {
            return this.userJPARepo.save(user);
        } catch (Exception e) {
            throw new DuplicatedUserException("User bereits vorhanden!");
        }
    }

    @Override
    public List<User> allUsers() {
        return this.userJPARepo.findAll();
    }

    @Override
    public List<User> allUsersWithName(String name) {
        return this.userJPARepo.findAllByName(name);
    }

    @Override
    public User userWithId(Long id) throws UserNotFound {
        Optional<User> optUser = this.userJPARepo.findById(id);
        if(optUser.isPresent()) {
            return optUser.get();
        } else {
            throw new UserNotFound("User mit der ID " + id + " nicht gefunden!");
        }
    }

    @Override
    public User deleteUserTypeWithId(Long id) throws UserNotFound {
        User userFromDb = this.userWithId(id);
        this.userJPARepo.deleteById(userFromDb.getId());
        return userFromDb;
    }
}
