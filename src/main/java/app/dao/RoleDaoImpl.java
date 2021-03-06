package app.dao;

import app.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> findRolesByRoleNames(String[] roleNames) {
        List<Role> roles = entityManager
                .createQuery("FROM Role role WHERE role.name IN (:names)")
                .setParameter("names", Arrays.asList(roleNames))
                .getResultList();
        return new HashSet<>(roles);
    }
    @Override
    public Set<Role> findAllRoles() {
        List<Role> roles = entityManager
                .createQuery("FROM Role")
                .getResultList();
        return new HashSet<>(roles);
    }
}
