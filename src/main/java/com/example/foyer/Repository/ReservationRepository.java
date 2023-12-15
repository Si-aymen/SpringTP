package com.example.foyer.Repository;

import com.example.foyer.Entity.Chambre;
import com.example.foyer.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query("SELECT r FROM Reservation  r")
    List<Reservation> findAll();


}
