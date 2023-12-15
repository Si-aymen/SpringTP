package com.example.foyer.Repository;

import com.example.foyer.Entity.Chambre;
import com.example.foyer.Entity.Foyer;
import com.example.foyer.Entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    Universite findByNomUniversite(String nomUniversite);

    @Query("SELECT u FROM Universite  u")
    List<Universite> findAll();


}
