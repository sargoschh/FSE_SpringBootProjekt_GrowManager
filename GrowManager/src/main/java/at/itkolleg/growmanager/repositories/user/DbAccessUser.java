package at.itkolleg.growmanager.repositories.user;

import at.itkolleg.growmanager.domain.User;
import at.itkolleg.growmanager.exceptions.user.DuplicatedUserException;
import at.itkolleg.growmanager.exceptions.user.UserNotFound;

import java.util.List;

public interface DbAccessUser {

    User saveUser(User user) throws DuplicatedUserException;
    List<User> allUsers();
    List<User> allUsersWithName(String name);
    User userWithId(Long id) throws UserNotFound;
    User deleteUserTypeWithId(Long id) throws UserNotFound;
}
