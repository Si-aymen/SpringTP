package com.example.foyer.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="idReservation")
    private long idReservation ;
    private Date anneeUniversitaire ;
    private Boolean estValide ;
    @ManyToMany(mappedBy = "reservations",cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants ;
}
