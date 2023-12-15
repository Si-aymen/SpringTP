package com.example.foyer.Service;
import com.example.foyer.Entity.*;
import com.example.foyer.IService.IChambreService;
import com.example.foyer.Repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@AllArgsConstructor
@Slf4j

public class ChambreServiceImpl implements IChambreService {
    ChambreRepository chambreRepository;
    BlocRepository blocRepository ;
    @Scheduled(fixedDelay = 10000) // 10000 millisecondes
    public List<Chambre> retrieveAllChambres() {
        List<Chambre> listC = chambreRepository.findAll();
        for (Chambre c: listC) {
            log.info("Chambre :" + c);
        }
        return listC;
    }
    /*public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }*/
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public List<Chambre> getChambresParBlocEtType (long idBloc, TypeChambre typeC) {
        return chambreRepository.findAllByBloc_IdAndNumChambre(idBloc,typeC);

    }




}