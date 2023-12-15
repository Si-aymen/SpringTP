package com.example.foyer.Repository;

import com.example.foyer.Entity.Chambre;
import com.example.foyer.Entity.Etudiant;
import com.example.foyer.Entity.Foyer;
import com.example.foyer.Entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoyerRepository extends JpaRepository<Foyer,Long> {
    @Query("SELECT f FROM Foyer  f")
    List<Foyer> findAll();
    @Query("SELECT f FROM Foyer f WHERE f.universite = :universite AND f.universite.nomUniversite = :nom")
    Foyer findAllUniversity(Universite un , String nom);


}
