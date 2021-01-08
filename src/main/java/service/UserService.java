package service;

import model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    void addUser(User user);

    void editUser(User user);

    User findUserById(int id);

    void deleteUserById(int id);

    User getUserByName(String name);

}

