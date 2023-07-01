package com.dwm.gestionreservations.repositories;


import com.dwm.gestionreservations.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByOffreNomContaining(String offre_nom);
}