package com.example.foyer.Repository;

import com.example.foyer.Entity.Bloc;
import com.example.foyer.Entity.Chambre;
import com.example.foyer.Entity.Reservation;
import com.example.foyer.Entity.TypeChambre;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ChambreRepository extends JpaRepository<Chambre,Long>{


    @Query("SELECT c FROM Chambre  c")
    List<Chambre> findAll();

      Chambre findBynumChambre(Long numChambre ) ;

    @Query("SELECT c FROM Chambre c JOIN c.reservations r WHERE r.idReservation = :reservationId")
    Optional<Chambre> findByReservationId(@Param("reservationId") Long reservationId);


     List<Chambre> findAllByBloc_IdAndNumChambre(Long blocId, TypeChambre typeChambre) ;

}
