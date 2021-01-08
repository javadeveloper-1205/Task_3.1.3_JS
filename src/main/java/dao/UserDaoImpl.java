package dao;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public User findUserByNameDao(String username) {
        TypedQuery<User> typedQuery = (TypedQuery<User>) entityManager.createQuery("FROM User u WHERE u.login=:username");
        typedQuery.setParameter("username", username);
        User user = typedQuery.getSingleResult();
        return user;
    }
}
