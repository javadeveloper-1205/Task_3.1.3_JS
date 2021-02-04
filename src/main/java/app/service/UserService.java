package app.service;

import app.model.Role;
import app.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    void addUser(User user);

    void editUser(User user);

    User findUserById(int id);

    void deleteUserById(int id);

    User getUserByName(String name);

    User getUserByUsername(String username);

    Role findRoleByUsername(String role);
}

