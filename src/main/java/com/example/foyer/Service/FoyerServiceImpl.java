package com.example.foyer.Service;

import com.example.foyer.Entity.Foyer;
import com.example.foyer.Entity.Universite;
import com.example.foyer.IService.IFoyerService;
import com.example.foyer.Repository.FoyerRepository;
import com.example.foyer.Repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository ;

    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    public Foyer retrieveFoyer(Long FoyerId) {
        return foyerRepository.findById(FoyerId).get();
    }

    public Foyer addFoyer(Foyer c) {
        return foyerRepository.save(c);
    }

    public void removeFoyer(Long FoyertId) {
        foyerRepository.deleteById(FoyertId);
    }

    public Foyer modifyFoyer(Foyer Foyert) {
        return foyerRepository.save(Foyert);
    }


}
