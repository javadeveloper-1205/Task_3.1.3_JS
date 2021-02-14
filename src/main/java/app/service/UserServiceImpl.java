package app.service;

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

    @Override
    public List<User> findAllUsers() {
        return userDao.getAllUsersDao();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUserDao(user);
    }

    //        Set<Role> roleSet = new HashSet<>();
//        for (String role : roleNames) {
//            roleSet.add(userService.findRoleByUsername(role));
//        }
//        user.setRoles(roleSet);

    @Transactional
    public Set<Role> authorities(String[] roleNames) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roleNames) {
            roleSet.add(userDao.findRoleByUsername(role));
        }
        return roleSet;
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        User old = userDao.findUserByUsername(user.getUsername());
        old.setAge(user.getId());
        old.setEmail(user.getEmail());
        old.setLastName(user.getLastName());
        old.setName(user.getName());
        old.setPassword(user.getPassword());
        old.setRoles(user.getRoles());
        old.setUsername(user.getUsername());

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
