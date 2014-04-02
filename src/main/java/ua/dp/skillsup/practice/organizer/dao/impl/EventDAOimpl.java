package ua.dp.skillsup.practice.organizer.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.dp.skillsup.practice.organizer.dao.EventDAO;
import ua.dp.skillsup.practice.organizer.domain.Event;
import ua.dp.skillsup.practice.organizer.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Repository
public class EventDAOimpl implements EventDAO {

    private static final Logger LOG = LoggerFactory.getLogger(EventDAOimpl.class);

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void create(Event event){
        entityManager.persist(event);
    }

    @Override
    public Event getById(Integer id){
        return entityManager.find(Event.class, id);
    }


    @Override
    public List<Event> getAllEvents(){
        return entityManager.createQuery("SELECT u FROM Event AS u").getResultList();
    }


    @Override
    public void update(Event event){
            entityManager.merge(event);
    }

    @Override
    public void delete(Event event){
        entityManager.remove(event);
    }

    @Override
    public void deleteById(Integer id){
        entityManager.remove(entityManager.find(Event.class, id));
    }

    @Override
    public List<Event> getEventsForUserByDate(Date startDate, Date endDate, User user) {
        Query query = entityManager.createQuery("SELECT e FROM Event AS e WHERE e.dateStart >= :startDate AND e.dateEnd <= :dateEnd AND e.ownerId = :userId");
        query.setParameter("startDate", startDate);
        query.setParameter("dateEnd", endDate);
        query.setParameter("userId", user);
        return query.getResultList();
    }

    @Override
    public List<Event> getUserEvents(User user) {
        List<Event> list = entityManager.createQuery("SELECT u FROM Event AS u WHERE u.ownerId = :userId")
                .setParameter("userId", user).getResultList();
        Iterator<Event> iter = list.iterator();
        while(iter.hasNext()){
            iter.next().setShortDescription();
        }
        return list;
    }

}
