package com.example.foyer.IService;

import com.example.foyer.Entity.Foyer;

import java.util.List;

public interface IFoyerService {
    public List<Foyer> retrieveAllFoyers();
    public Foyer retrieveFoyer(Long idFoyer);
    public Foyer addFoyer(Foyer c);
    public void removeFoyer(Long idFoyer);
    public Foyer modifyFoyer(Foyer Foyer);

    //public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
