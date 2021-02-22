package app.dao;

import app.model.Role;
import app.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUserDao(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsersDao() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void saveUserDao(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findUserDao(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUserDao(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public Optional<User> findUserByUsernameOptional(String username) {
        User user = new User();
        try {
            user = (User) entityManager.createQuery("FROM User u WHERE u.username=:username").setParameter("username", username).getSingleResult();
        } catch (Exception E) {
        }
        return Optional.ofNullable(user);
    }

//    @Override
//    public Optional<Role> findRoleByUsername(Optional<String> userName) {
//        Role role = new Role();
//        try {
//            role = (Role) entityManager
//                    .createQuery("select r from Role r where lower(r.name) like :role")
//                    .setParameter("role", "%" + userName + "%")
//                    .getSingleResult();
//        } catch (Exception E) {
//        }
//        return Optional.ofNullable(role);
//    }

    @Override
    public User findUserByUsername(String username) {
        return (User) entityManager.createQuery("FROM User u WHERE u.username=:username").
                setParameter("username", username).
                getSingleResult();
    }
}






