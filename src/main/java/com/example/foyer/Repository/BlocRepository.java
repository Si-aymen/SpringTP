package com.example.foyer.Repository;

import com.example.foyer.Entity.Bloc;
import com.example.foyer.Entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc, Long> {


}
