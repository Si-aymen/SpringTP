package com.example.foyer.IService;
import com.example.foyer.Entity.*;

import java.util.List;

public interface IChambreService {

    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);
    public List<Chambre> getChambresParBlocEtType (long idBloc, TypeChambre typeC) ;


}

