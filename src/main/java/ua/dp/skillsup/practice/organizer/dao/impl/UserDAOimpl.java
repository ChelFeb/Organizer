package ua.dp.skillsup.practice.organizer.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.dp.skillsup.practice.organizer.dao.UserDAO;
import ua.dp.skillsup.practice.organizer.domain.Role;
import ua.dp.skillsup.practice.organizer.domain.User;
import java.util.Date;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDAOimpl implements UserDAO {

    private static final Logger LOG = LoggerFactory.getLogger(UserDAOimpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(User user){
        entityManager.persist(user);
    }

    @Override
    public void create(String email, String password, Date date) {
        Role role = (Role) entityManager.createQuery("SELECT r FROM Role r where r.role = :rol")
                .setParameter("rol", "ROLE_USER")
                .getSingleResult();
        entityManager.persist(new User(email, password, new Date(), role));
    }

    @Override
    public User getById(Integer id){
        return entityManager.find(User.class, id);
    }

    @Override
    public User getByEmail(String email){
        try {
        return (User) entityManager.createQuery("SELECT t FROM User t where t.email = :email")
            .setParameter("email", email)
            .getSingleResult();
        } catch (NoResultException e) {
           LOG.info("context", e.getMessage());
            return null;
        }
    }

    @Override
    public List<User> getAllUsers(){
        return entityManager.createQuery("SELECT u FROM User AS u").getResultList();
    }

    @Override
    public void update(User user){
            entityManager.merge(user);
    }

    @Override
    public void delete(User user){
        entityManager.remove(user);
    }

    @Override
    public void deleteById(Integer id){
        entityManager.remove(entityManager.find(User.class, id));
    }
}
