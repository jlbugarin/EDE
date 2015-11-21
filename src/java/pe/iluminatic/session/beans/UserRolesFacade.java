/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.iluminatic.session.beans;

import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pe.iluminatic.dao.entidades.UserRoles;
import pe.iluminatic.dao.entidades.Users;

/**
 *
 * @author JBugarinP
 */
@Stateless
public class UserRolesFacade extends AbstractFacade<UserRoles> {

    @PersistenceContext(unitName = "EDEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserRolesFacade() {
        super(UserRoles.class);
    }

    public List<UserRoles> findRol(Users user) {

        String jpql = "SELECT r FROM UserRoles r WHERE r.username = ?1";

        Query query = em.createQuery(jpql);
        query.setParameter(1, user.getUsername());
        List<UserRoles> roles = query.getResultList();

        return roles;

    }
}
