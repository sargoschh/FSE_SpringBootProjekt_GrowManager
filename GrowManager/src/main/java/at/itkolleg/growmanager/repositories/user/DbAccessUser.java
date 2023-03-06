package at.itkolleg.growmanager.repositories.user;

import at.itkolleg.growmanager.domain.User;
import at.itkolleg.growmanager.exceptions.user.DuplicatedUserException;
import at.itkolleg.growmanager.exceptions.user.UserNotFound;

import java.util.List;
import java.util.Optional;

public interface DbAccessUser {

    User saveUser(User user) throws DuplicatedUserException;
    List<User> allUsers();
    List<User> allUsersWithUsername(String name);
    User userWithId(Long id) throws UserNotFound;
    User deleteUserTypeWithId(Long id) throws UserNotFound;
    Optional<User> findUserByUsernameAndPassword(String username, String password) throws UserNotFound;
}
