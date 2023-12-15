package com.example.foyer.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Universite")
public class Universite {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id ;
    private String nomUniversite ;
    private String adresse ;

    @OneToOne(cascade = CascadeType.ALL)
    private Foyer foyer ;

}
