package com.example.foyer.Service;

import com.example.foyer.Entity.Etudiant;
import com.example.foyer.IService.IEtudiantService;
import com.example.foyer.Repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class EtudiantServiceImpl implements IEtudiantService {
    EtudiantRepository etudiantRepository;
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }
    public Etudiant retrieveEtudiant(Long EtudiantId) {
        return etudiantRepository.findById(EtudiantId).get();
    }
    public Etudiant addEtudiant(Etudiant c) {
        return etudiantRepository.save(c);
    }
    public void removeEtudiant(Long EtudiantId) {
        etudiantRepository.deleteById(EtudiantId);
    }
    public Etudiant modifyEtudiant(Etudiant Etudiant) {
        return etudiantRepository.save(Etudiant);
    }
}
