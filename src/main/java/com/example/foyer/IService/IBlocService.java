package com.example.foyer.IService;

import com.example.foyer.Entity.Bloc;

import java.util.List;

public interface IBlocService {

    public List<Bloc> retrieveAllBlocs();

    public Bloc retrieveBloc(Long BlocId);

    public Bloc addBloc(Bloc c);

    public void removeBloc(Long BlocId);

    public Bloc modifyBloc(Bloc chambre);
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc);

}
