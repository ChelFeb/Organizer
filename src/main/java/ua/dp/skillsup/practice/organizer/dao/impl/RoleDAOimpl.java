package ua.dp.skillsup.practice.organizer.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.dp.skillsup.practice.organizer.dao.RoleDAO;
import ua.dp.skillsup.practice.organizer.domain.Role;
import ua.dp.skillsup.practice.organizer.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDAOimpl implements RoleDAO {
    private static final Logger LOG = LoggerFactory.getLogger(RoleDAOimpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getById(Integer id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getByName(String role) {
        try {
            return (Role) entityManager.createQuery("SELECT r FROM Role r where r.role = :role")
                    .setParameter("role", role)
                    .getSingleResult();
        } catch (NoResultException e) {
            LOG.info("context", e.getMessage());
            return null;
        }
    }
}
