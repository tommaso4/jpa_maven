package it.epicode.week3.day2.dao;

import it.epicode.week3.day2.entities.Location;
import it.epicode.week3.day2.entities.Participation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ParticipationDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ParticipationDao(){
        emf = Persistence.createEntityManagerFactory("jpaD2");
        em = emf.createEntityManager();
    }

    public void addElement(Participation participation){
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(participation);
            et.commit();
        }catch (Exception e){
            e.getMessage();
        }

    }

    public Participation getById(Long id){
        em = emf.createEntityManager();
        Participation participation = em.find(Participation.class, id);
        em.close();
        return participation;
    }

    public void delete (Long id) {
        em = emf.createEntityManager();
        try{
            EntityTransaction et = em.getTransaction();
            et.begin();
            Participation participation = em.find(Participation.class, id);
            em.remove(participation);
            et.commit();
        }catch(Exception e){
            e.getMessage();
        }finally{
            em.close();
        }

    }
}
