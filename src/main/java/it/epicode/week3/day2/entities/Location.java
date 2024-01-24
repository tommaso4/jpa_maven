package it.epicode.week3.day2.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String city;
    @OneToMany(mappedBy = "location",cascade = CascadeType.ALL)
    private List<Event> events;

    public Location(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void addEvent(Event event) {
        if (events == null) {
            events = new ArrayList<>();
        }
        events.add(event);
        event.setLocation(this);
    }


    public List<Event> getEvents() {
        return events;
    }

    public Location() {     }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
