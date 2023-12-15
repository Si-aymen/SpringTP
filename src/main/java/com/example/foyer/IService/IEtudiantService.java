package com.example.foyer.IService;

import com.example.foyer.Entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> retrieveAllEtudiants();
    public Etudiant retrieveEtudiant(Long EtudiantId);
    public Etudiant addEtudiant(Etudiant c);
    public void removeEtudiant(Long EtudiantId);
    public Etudiant modifyEtudiant(Etudiant Etudiant);
}
