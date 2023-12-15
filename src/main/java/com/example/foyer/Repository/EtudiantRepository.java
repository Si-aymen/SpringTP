package com.example.foyer.Repository;

import com.example.foyer.Entity.Chambre;
import com.example.foyer.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findBycin(Long Cin);


}
