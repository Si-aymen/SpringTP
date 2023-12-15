package com.example.foyer.IService;

import com.example.foyer.Entity.Reservation;

public interface IReservationService {
    public Reservation ajouterReservation (long idChambre, long cinEtudiant) ;
    public void annulerReservation(long cinEtudiant);

}
