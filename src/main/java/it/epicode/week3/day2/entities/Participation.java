package it.epicode.week3.day2.entities;

import javax.persistence.*;

@Entity
@Table(name = "participation")
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(mappedBy = "participation")
    private Person person;
    @OneToOne
    @JoinColumn(name = "event_id", unique = true) 
    private Event event;
    @Enumerated(EnumType.STRING)
    private EState state;

    public Participation() {
    }

    public Participation(Person person, Event event, EState state) {
        this.person = person;
        this.event = event;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Partecipation{" +
                "id=" + id +
                ", person=" + person +
                ", event=" + event +
                ", state=" + state +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public EState getState() {
        return state;
    }

    public void setState(EState state) {
        this.state = state;
    }
}
