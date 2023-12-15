package com.example.foyer.Service;

import com.example.foyer.Entity.Foyer;
import com.example.foyer.Entity.Universite;
import com.example.foyer.IService.IUniversiteService;
import com.example.foyer.Repository.FoyerRepository;
import com.example.foyer.Repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniversityServiceImpl implements IUniversiteService {
    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;

    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    public Universite addUniversite(Universite c) {
        return universiteRepository.save(c);
    }

    public void removeUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    public Universite modifyUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {

        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        Optional<Foyer> foyer = foyerRepository.findById(idFoyer);

        universite.setFoyer(foyer.get());
        universiteRepository.save(universite);
        return universite;
    }

    public Universite desaffecterFoyerAUniversite(long idUniversite) {

        Universite universite = universiteRepository.findById(idUniversite).get();

        universite.setFoyer(null);

        universiteRepository.save(universite);

        return universite;
    }

    public Universite ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite uni = universiteRepository.findById(idUniversite).get();
        //foyer.setUniversite(uni);
        uni.setFoyer(foyer);
        return universiteRepository.save(uni);
    }


}

