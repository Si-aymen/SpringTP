package com.example.foyer.Control;


import com.example.foyer.Entity.Foyer;
import com.example.foyer.Entity.Universite;
import com.example.foyer.IService.IFoyerService;
import com.example.foyer.IService.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Universite")

public class UniversiteRestController {
    IUniversiteService universiteService;
    IFoyerService foyerService ;
    // http://localhost:8089/tpfoyer/bniversite/retrieve-all-bniversites
    @GetMapping("/retrieve-all-bniversites")
    public List<Universite> getUniversites() {
        List<Universite> listUniversites = universiteService.retrieveAllUniversites();
        return listUniversites;
    }
    // http://localhost:8089/tpfoyer/bniversite/retrieve-bniversite/8
    @GetMapping("/retrieve-bniversite/{bniversite-id}")
    public Universite retrieveUniversite(@PathVariable("bniversite-id") Long chId) {
        Universite bniversite = universiteService.retrieveUniversite(chId);
        return bniversite;
    }
    // http://localhost:8089/tpfoyer/bniversite/add-bniversite
    @PostMapping("/add-bniversite")
    public Universite addUniversite(@RequestBody Universite c) {
        Universite bniversite = universiteService.addUniversite(c);
        return bniversite;
    }
    // http://localhost:8089/tpfoyer/bniversite/remove-bniversite/{bniversite-id}
    @DeleteMapping("/remove-bniversite/{bniversite-id}")
    public void removeUniversite(@PathVariable("bniversite-id") Long chId) {
        universiteService.removeUniversite(chId);
    }
    // http://localhost:8089/tpfoyer/bniversite/modify-bniversite
    @PutMapping("/modify-bniversite")
    public Universite modifyUniversite(@RequestBody Universite c) {
        Universite bniversite = universiteService.modifyUniversite(c);
        return bniversite;
    }


    // http://localhost:8089/tpfoyer/bniversite/Affecter-Foyer-university/1/Esprit
    @PutMapping("/affecter-Foyer-To-University/{FoyerID}/{UniversiteNom}")
    public Universite affecterFoyerToUniversity ( @PathVariable("FoyerID") Long FoyerID,@PathVariable("UniversiteNom") String universiteNom) {
        Universite uni = universiteService.affecterFoyerAUniversite(FoyerID,universiteNom);
        return uni ;

    }

    // http://localhost:8089/tpfoyer/bniversite/desaffecter-Foyer-university/1
    @PutMapping("/desaffecter-Foyer-To-University/{University_id}")
    public Universite desaffecterFoyerToUniversity ( @PathVariable("University_id") Long uni_id) {
        Universite uni = universiteService.desaffecterFoyerAUniversite(uni_id);
        return uni ;

    }

    // http://localhost:8089/tpfoyer/Foyer/AddFoyer&AffectToUniversity/1
    @PutMapping("/Add-Foyer&Affect-University/{ID-uni}")
    public Universite AddFoyerAffectToUniversity  (@RequestBody Foyer foyer   , @PathVariable("ID-uni") Long uniID) {
        Universite uni = universiteService.ajouterFoyerEtAffecterAUniversite(foyer,uniID);
        return uni;

    }

}

