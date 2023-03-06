package at.itkolleg.growmanager.services.user;

import at.itkolleg.growmanager.domain.User;
import at.itkolleg.growmanager.exceptions.user.DuplicatedUserException;
import at.itkolleg.growmanager.exceptions.user.UserNotFound;
import at.itkolleg.growmanager.repositories.user.DbAccessUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private DbAccessUser dbAccessUser;

    public UserServiceImpl(DbAccessUser dbAccessUser) {
        this.dbAccessUser = dbAccessUser;
    }

    @Override
    public List<User> allUsers() {
        return this.dbAccessUser.allUsers();
    }

    @Override
    public User insertUser(User user) throws DuplicatedUserException {
        return this.dbAccessUser.saveUser(user);
    }

    @Override
    public User updateUser(User user) throws UserNotFound, DuplicatedUserException {
        User userFromDb = this.dbAccessUser.userWithId(user.getId());
        userFromDb.setUsername(user.getUsername());
        userFromDb.setPassword(user.getPassword());
        return this.dbAccessUser.saveUser(userFromDb);
    }

    @Override
    public User userWithId(Long id) throws UserNotFound {
        return this.dbAccessUser.userWithId(id);
    }

    @Override
    public List<User> allUserWithName(String name) {
        return this.dbAccessUser.allUsersWithUsername(name);
    }

    @Override
    public User deleteUserWithId(Long id) throws UserNotFound {
        return this.dbAccessUser.deleteUserTypeWithId(id);
    }

    @Override
    public Boolean isUserAlreadyInDb(User user) throws UserNotFound {
        Optional<User> userInDb = this.dbAccessUser.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(userInDb.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
