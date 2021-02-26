package app.dao;

import app.model.Role;

import java.util.Set;

public interface RoleDao {
    Set<Role> findRolesByRoleNames(String [] roleNames);
    Set<Role> findAllRoles();
}
