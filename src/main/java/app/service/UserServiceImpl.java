package app.service;

import app.dao.RoleDao;
import app.dao.UserDao;
import app.model.Role;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private RoleDao roleDao;

    @Autowired
    public UserServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.getAllUsersDao();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUserDao(user);
    }

    @Transactional
    public Set<Role> authorities(String[] roleNames) {
        Set<Role> roleSet = roleDao.findRolesByRoleNames(roleNames);
        System.out.println(roleSet);
        return roleSet;
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = userDao.findUserByUsernameOptional(username);
        return user.get();
    }

    @Override
    @Transactional
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

}














//        for (String role : roleNames) {
//            roleSet.add(userDao.findRoleByUsername(role));
//        }