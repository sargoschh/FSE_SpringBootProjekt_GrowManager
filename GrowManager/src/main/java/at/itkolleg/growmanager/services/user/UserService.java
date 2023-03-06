package at.itkolleg.growmanager.services.user;

import at.itkolleg.growmanager.domain.User;
import at.itkolleg.growmanager.exceptions.user.DuplicatedUserException;
import at.itkolleg.growmanager.exceptions.user.UserNotFound;

import java.util.List;

public interface UserService {

    List<User> allUsers();
    User insertUser(User user) throws DuplicatedUserException;
    User updateUser(User user) throws UserNotFound, DuplicatedUserException;
    User userWithId(Long id) throws UserNotFound;
    List<User> allUserWithName(String name);
    User deleteUserWithId(Long id) throws UserNotFound;
    Boolean isUserAlreadyInDb(User user) throws UserNotFound;
}
