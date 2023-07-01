package com.dwm.gestionreservations.repositories;


import com.dwm.gestionreservations.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffreRepository extends JpaRepository<Offre, Long> {
    List<Offre> findOffresByNomContainsOrPrenomContainsOrEmailContains(String mc1, String mc2, String mc3);

    List<Offre> findOffresByNomContainsOrPrenomContains(String query, String query1);

    // List<Medecin> findMedecinsByIdContains(String mc);
}
