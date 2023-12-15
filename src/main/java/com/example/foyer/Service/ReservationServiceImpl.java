package com.example.foyer.Service;

import com.example.foyer.Entity.Chambre;
import com.example.foyer.Entity.Etudiant;
import com.example.foyer.Entity.Reservation;
import com.example.foyer.IService.IReservationService;
import com.example.foyer.Repository.ChambreRepository;
import com.example.foyer.Repository.EtudiantRepository;
import com.example.foyer.Repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor

public class ReservationServiceImpl implements IReservationService {
    ChambreRepository chambreRepository;
    EtudiantRepository etudiantRepository;
    ReservationRepository reservationRepository;

    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        Optional<Chambre> chambreOpt = chambreRepository.findById(idChambre);
        if (!chambreOpt.isPresent()) {
            return null;
        }
        Chambre chambre = chambreOpt.get();

        Etudiant etudiant = etudiantRepository.findBycin(cinEtudiant);
        if (etudiant == null) {
            return null;
        }

        Reservation reservation = new Reservation();
        //String nomBloc = chambre.getBloc().getNomBloc();
        reservation.setAnneeUniversitaire(new Date());
        reservation.setEstValide(true);

        Set<Reservation> reservations = new HashSet<>() ;
        reservations.add(reservation);

        // Link the reservation with the student and the room
        etudiant.setReservations(reservations);
        chambre.setReservations(reservations);

        // Save the entities
        etudiantRepository.save(etudiant);
        chambreRepository.save(chambre);
        return reservationRepository.save(reservation);
    }

    public void annulerReservation(long cinEtudiant) {
        Etudiant etudiant = etudiantRepository.findBycin(cinEtudiant);

        //etudiant.getReservations()
        if (etudiant != null) {
            Set<Reservation> reservations = etudiant.getReservations();


            if (reservations != null && !reservations.isEmpty()) {
                for (Reservation res : reservations) {
                    Optional<Chambre> chambre = chambreRepository.findByReservationId(res.getIdReservation()) ;

                    chambre.get().setReservations(null);
                    etudiant.setReservations(null);
                    res.setEstValide(false);

                    reservationRepository.save(res);
                }

            }
            etudiant.setReservations(null);



        }
    }

}
