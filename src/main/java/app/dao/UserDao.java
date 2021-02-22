package app.dao;

import app.model.Role;
import app.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserDao {

    void addUserDao(User user);

    List<User> getAllUsersDao();

    void saveUserDao(User user);

    User findUserDao(int id);

    void deleteUserDao(int id);

   User findUserByUsername(String username);

    Optional <User> findUserByUsernameOptional(String username);

}

