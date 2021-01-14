package app.service;

import app.dao.UserDao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllUsers() {
        return userDao.getAllUsersDao();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUserDao(user);
    }

    @Override
    public void editUser(User user) {
        userDao.saveUserDao(user);
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserDao(id);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        userDao.deleteUserDao(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.findUserByNameDao(name);
    }
}
