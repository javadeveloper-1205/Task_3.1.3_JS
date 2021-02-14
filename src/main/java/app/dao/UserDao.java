package app.dao;

import app.model.Role;
import app.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void addUserDao(User user);

    List<User> getAllUsersDao();

    void saveUserDao(User user);

    User findUserDao(int id);

    void deleteUserDao(int id);

   User findUserByUsername(String username);

    Role findRoleByUsername(String role);

}

