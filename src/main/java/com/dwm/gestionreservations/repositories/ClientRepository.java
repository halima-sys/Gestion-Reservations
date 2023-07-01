package com.dwm.gestionreservations.repositories;


import com.dwm.gestionreservations.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findClientsByNomContainsOrPrenomContainsOrEmailContainsOrCinContains(String mc1, String mc2, String mc3, String mc4);

    List<Client> findClientsByNomContainsOrPrenomContains(String query, String query1);

    // List<Patient> findPatientsByNomContains(String query);
}
