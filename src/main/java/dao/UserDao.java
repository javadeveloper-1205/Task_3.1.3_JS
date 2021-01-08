package dao;

import model.User;

import java.util.List;

public interface UserDao {
    void addUserDao(User user);

    List<User> getAllUsersDao();

    void saveUserDao(User user);

    User findUserDao(int id);

    void deleteUserDao(int id);

    User findUserByNameDao(String username);
}

