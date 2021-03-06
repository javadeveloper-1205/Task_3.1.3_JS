package app.service;

import app.model.Role;
import app.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    List<User> findAllUsers();

    void addUser(User user);

    void editUser(User user, int id, String [] roleNames);

    User findUserById(int id);

    void deleteUserById(int id);

    User getUserByUsername(String username);

    Set<Role> authorities(String[] roleNames);

    Set<Role> getAllRoles();


}

