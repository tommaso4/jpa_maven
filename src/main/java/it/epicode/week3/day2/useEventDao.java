package it.epicode.week3.day2;


import it.epicode.week3.day2.dao.EventDao;
import it.epicode.week3.day2.dao.LocationDao;
import it.epicode.week3.day2.dao.ParticipationDao;
import it.epicode.week3.day2.dao.PersonDao;
import it.epicode.week3.day2.entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class useEventDao {
    public static void main(String[] args) {

        EventDao eventDao = new EventDao();
        LocationDao locationDao = new LocationDao();
        PersonDao personDao = new PersonDao();
        ParticipationDao participationDao = new ParticipationDao();


        Location l1 = new Location("Palaindor","Verona");
        locationDao.addElement(l1);

        Event event1 = new Event("Giovanotti", LocalDate.of(2024,03,22),
                "Concerto", TypeEvent.PRIVATO,1000,l1);
        Event event2 = new Event("Moto2", LocalDate.of(2024,05,22),
                "Sport", TypeEvent.PRIVATO,10000,l1);
        eventDao.addElement(event2);

        Person person1 = new Person("tom","can","dknkjd@gmail.com",LocalDate.of(2022,2,2), EGenres.M);
        personDao.addElement(person1);

        Participation participation1 = new Participation(person1,event1,EState.CONFERMA);
        participation1.setPerson(person1);
        participationDao.addElement(participation1);



        List<Event> eventList = eventDao.getAllEvent();
        eventList = eventDao.getAllEvent();
        for (Event event: eventList){
            System.out.println(event);
        }
    }
}
