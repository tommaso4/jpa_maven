package it.epicode.week3.day2.dao;

import it.epicode.week3.day2.entities.Location;
import it.epicode.week3.day2.entities.Participation;
import it.epicode.week3.day2.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public PersonDao(){
        emf = Persistence.createEntityManagerFactory("jpaD2");
        em = emf.createEntityManager();
    }

    public void addElement(Person person){
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.persist(person);
            et.commit();
        }catch (Exception e){
            e.getMessage();
        }

    }

    public Person getById(Long id){
        em = emf.createEntityManager();
        Person person = em.find(Person.class, id);
        em.close();
        return person;
    }

    public void delete (Long id) {
        em = emf.createEntityManager();
        try{
            EntityTransaction et = em.getTransaction();
            et.begin();
            Person person = em.find(Person.class, id);
            em.remove(person);
            et.commit();
        }catch(Exception e){
            e.getMessage();
        }finally{
            em.close();
        }

    }
}
