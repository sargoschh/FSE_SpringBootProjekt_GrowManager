package at.itkolleg.growmanager.services.user;

import at.itkolleg.growmanager.domain.User;
import at.itkolleg.growmanager.exceptions.user.DuplicatedUserException;
import at.itkolleg.growmanager.exceptions.user.UserNotFound;
import at.itkolleg.growmanager.repositories.user.DbAccessUser;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return this.dbAccessUser.allUsersWithName(name);
    }

    @Override
    public User deleteUserWithId(Long id) throws UserNotFound {
        return this.dbAccessUser.deleteUserTypeWithId(id);
    }
}
