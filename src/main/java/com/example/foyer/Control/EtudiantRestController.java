package com.example.foyer.Control;

import com.example.foyer.Entity.Etudiant;
import com.example.foyer.IService.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Etudiant")

public class EtudiantRestController {
    IEtudiantService etudiantService;

    // http://localhost:8089/tpfoyer/Etudiant/retrieve-all-Etudiants
    @GetMapping("/retrieve-all-Etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiants();
        return listEtudiants;
    }
    // http://localhost:8089/tpfoyer/Etudiant/retrieve-Etudiant/8
    @GetMapping("/retrieve-Etudiant/{Etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("Etudiant-id") Long chId) {
        Etudiant Etudiant = etudiantService.retrieveEtudiant(chId);
        return Etudiant;
    }
    //http://localhost:8089/tpfoyer/Etudiant/add-Etudiant
    @PostMapping("/add-Etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant c) {
        Etudiant Etudiant = etudiantService.addEtudiant(c);
        return Etudiant;
    }

    // http://localhost:8089/tpfoyer/Etudiant/remove-Etudiant/{Etudiant-id}
    @DeleteMapping("/remove-Etudiant/{Etudiant-id}")
    public void removeEtudiant(@PathVariable("Etudiant-id") Long chId) {
        etudiantService.removeEtudiant(chId);
    }
    // http://localhost:8089/tpfoyer/Etudiant/modify-Etudiant
    @PutMapping("/modify-Etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant c) {
        Etudiant Etudiant = etudiantService.modifyEtudiant(c);
        return Etudiant;
    }
}
