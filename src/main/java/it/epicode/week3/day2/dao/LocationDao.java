package it.epicode.week3.day2.dao;

import it.epicode.week3.day2.entities.Event;
import it.epicode.week3.day2.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LocationDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public LocationDao(){
        emf = Persistence.createEntityManagerFactory("jpaD2");
        em = emf.createEntityManager();
    }

    public void addElement(Location location){
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(location);
            et.commit();
        }catch (Exception e){
            e.getMessage();
        }

    }

    public Location getById(Long id){
        em = emf.createEntityManager();
        Location location = em.find(Location.class, id);
        em.close();
        return location;
    }

    public void delete (Long id) {
        em = emf.createEntityManager();
        try{
            EntityTransaction et = em.getTransaction();
            et.begin();
            Location location = em.find(Location.class, id);
            em.remove(location);
            et.commit();
        }catch(Exception e){
            e.getMessage();
        }finally{
            em.close();
        }

    }
}
