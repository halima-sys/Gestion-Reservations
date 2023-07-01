package com.dwm.gestionreservations.repositories;


import com.dwm.gestionreservations.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findClientsByNomContainsOrPrenomContainsOrEmailContainsOrCinContains(String mc1, String mc2, String mc3, String mc4);

    List<Client> findPatientsByNomContainsOrPrenomContains(String query, String query1);

    // List<Patient> findPatientsByNomContains(String query);
}
