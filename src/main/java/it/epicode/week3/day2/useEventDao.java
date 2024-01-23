package it.epicode.week3.day2;


import it.epicode.week3.day2.dao.EventDao;
import it.epicode.week3.day2.entities.Event;
import it.epicode.week3.day2.entities.TypeEvent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class useEventDao {
    public static void main(String[] args) {

        EventDao eventDao = new EventDao();
        Event event1 = new Event("Giovanotti", LocalDate.of(2024,03,22),
                "Concerto", TypeEvent.PRIVATO,1000);
        Event event2 = new Event("Moto2", LocalDate.of(2024,05,22),
                "Sport", TypeEvent.PRIVATO,10000);
        eventDao.addElement(event2);

        System.out.println(event2);

        Event event1_2 = eventDao.getById(8L);
        System.out.println("Event before deletion: " + event1_2);

        eventDao.delete(18L);

        System.out.println("Event after deletion: " + event1_2);

        List<Event> eventList = eventDao.getAllEvent();
        for (Event event: eventList){
            eventDao.delete(event.getId());

        }
        eventList = eventDao.getAllEvent();
        for (Event event: eventList){
            System.out.println(event);
        }

    }
}
