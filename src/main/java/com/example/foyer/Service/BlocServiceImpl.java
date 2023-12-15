package com.example.foyer.Service;

import com.example.foyer.Entity.Bloc;
import com.example.foyer.Entity.Chambre;
import com.example.foyer.Entity.Foyer;
import com.example.foyer.Entity.Universite;
import com.example.foyer.IService.IBlocService;
import com.example.foyer.Repository.BlocRepository;
import com.example.foyer.Repository.ChambreRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@Slf4j

public class BlocServiceImpl implements IBlocService {
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;

    @Scheduled(fixedDelay = 10000) // 10000 millisecondes
    public List<Bloc> retrieveAllChambres() {
        List<Bloc> listB = blocRepository.findAll();
        for (Bloc  B: listB) {
            log.info("Bloc  :" + B);
        }
        return listB;
    }

    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    public Bloc retrieveBloc(Long BlocId) {
        return blocRepository.findById(BlocId).get();
    }

    public Bloc addBloc(Bloc c) {
        return blocRepository.save(c);
    }

    public void removeBloc(Long BlocId) {
        blocRepository.deleteById(BlocId);
    }

    public Bloc modifyBloc(Bloc Bloc) {
        return blocRepository.save(Bloc);
    }

    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        // Initialize an empty list for Chambre
        List<Chambre> chambres = new ArrayList<>();

        // Retrieve the Bloc, handle the case where it might not be found
        Optional<Bloc> optionalBloc = blocRepository.findById(idBloc);
        System.out.println(optionalBloc.get());
        if (!optionalBloc.isPresent()) {
            // Handle the case where the bloc is not found
            // This could be throwing an exception or returning null
            throw new EntityNotFoundException("Bloc not found with id: " + idBloc);
        }
        Bloc bloc = optionalBloc.get();

        // Iterate over numChambre and add each Chambre to the list
        for (Long num : numChambre) {
            Chambre chambre = chambreRepository.findBynumChambre(num);
            if (chambre != null) {
                chambres.add(chambre);
                chambre.setBloc(bloc);
            } else {
                // Handle the case where a Chambre is not found
                // This could be logging, throwing an exception, etc.
            }
        }

        // Convert List to Set to avoid duplicates
        Set<Chambre> setChambres = new HashSet<>(chambres);

        // Set the Chambres to the Bloc and save
        bloc.setChambres(setChambres);
        blocRepository.save(bloc);

        return bloc;
    }


}
