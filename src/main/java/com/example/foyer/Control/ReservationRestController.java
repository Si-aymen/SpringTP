package com.example.foyer.Control;

import com.example.foyer.Entity.Reservation;
import com.example.foyer.Entity.Universite;
import com.example.foyer.IService.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/Reservation")

public class ReservationRestController {

    IReservationService reservationService ;


    // http://localhost:8089/tpfoyer/bniversite/add-bniversite
    @PostMapping("/add-Reservation/{ChambreID}/{EtudiantID}")
    public Reservation addReservation(@RequestBody Reservation reservation, @PathVariable("ChambreID")Long ChambreID ,@PathVariable("EtudiantID")Long EtudiantID) {
        Reservation res = reservationService.ajouterReservation(ChambreID,EtudiantID);
        return res;
    }
    // http://localhost:8089/tpfoyer/bniversite/add-bniversite
    @PostMapping("/cancel-Reservation/{EtudiantID}")
    public void CancelReservation(@PathVariable("EtudiantID")Long EtudiantID) {
        reservationService.annulerReservation(EtudiantID);

    }
}
