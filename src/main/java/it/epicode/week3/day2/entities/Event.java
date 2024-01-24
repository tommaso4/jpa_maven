package it.epicode.week3.day2.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titolo;
    @Column(name = "data_inizio", nullable = false)
    private LocalDate dataInizio;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private TypeEvent tipoEvento;
    @Column(name = "numero_massimo_partecipanti")
    private Integer numeroMassimoPartecipanti;
    @ManyToOne
    @JoinColumn(name = "location_fx")
    private Location location;
    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
    private Participation participation;

    public Event() {
    }

    public Event(String titolo, LocalDate dataInizio, String descrizione, TypeEvent tipoEvento, Integer numeroMassimoPartecipanti,Location location) {
        this.titolo = titolo;
        this.dataInizio = dataInizio;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
        location.addEvent(this);
    }

    public void setParticipation(Participation participation) {
        this.participation = participation;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataInizio=" + dataInizio +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                ", location=" + location +
                '}';
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setTipoEvento(TypeEvent tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Integer getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public TypeEvent getTipoEvento() {
        return tipoEvento;
    }

    public Long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
