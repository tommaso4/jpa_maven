package it.epicode.week3.day2.dao;

import it.epicode.week3.day2.entities.Event;
import it.epicode.week3.day2.entities.Location;

import javax.persistence.*;
import java.util.List;

public class EventDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EventDao(){
        emf = Persistence.createEntityManagerFactory("jpaD2");
        em = emf.createEntityManager();
    }

    public void addElement(Event event){
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(event);
            et.commit();
        }catch (Exception e){
            e.getMessage();
        }

    }

    public Event getById(Long id){
        em = emf.createEntityManager();
        Event event = em.find(Event.class, id);
        em.close();
        return event;
    }

    public void delete (Long id) {
        em = emf.createEntityManager();
        try{
            EntityTransaction et = em.getTransaction();
            et.begin();
            Event event = em.find(Event.class, id);
            em.remove(event);
            et.commit();
        }catch(Exception e){
            e.getMessage();
        }finally{
            em.close();
        }

    }

    public List<Event> getAllEvent (){
        em = emf.createEntityManager();
        try{
            Query query = em.createQuery("SELECT e FROM Event e", Event.class);
            return query.getResultList();
        }finally {
            em.close();
        }

    }


}
