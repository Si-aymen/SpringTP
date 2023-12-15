package com.example.foyer.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Chambre")
public class Chambre {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="idChambre")
    private Long idChambre;
    private Long numChambre ;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre ;

    @ManyToOne
    private Bloc bloc ;

    @OneToMany(cascade = CascadeType.ALL )
    private Set<Reservation> reservations ;


}
