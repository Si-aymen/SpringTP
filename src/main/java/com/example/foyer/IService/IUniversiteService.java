package com.example.foyer.IService;

import com.example.foyer.Entity.Foyer;
import com.example.foyer.Entity.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> retrieveAllUniversites();

    public Universite retrieveUniversite(Long idUniversite);

    public Universite addUniversite(Universite c);

    public void removeUniversite(Long idUniversite);

    public Universite modifyUniversite(Universite Universite);

    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    public Universite desaffecterFoyerAUniversite (long idUniversite) ;

    public Universite ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) ;


}
