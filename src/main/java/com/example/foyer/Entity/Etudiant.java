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
@Table(name = "Etudiant")
public class Etudiant {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant ;
    private String nomEt ;
    private String prenomEt ;
    private Long cin ;
    private String ecole ;
    private Date dateNaissance ;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations ;



}
