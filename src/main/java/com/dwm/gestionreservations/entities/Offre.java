package com.dwm.gestionreservations.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;


import java.util.Collection;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data

public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String destination;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date dateDepart;
    @NonNull
    private Long nbNuitee;
    private double prix;
    private Boolean promo;

    @OneToMany(mappedBy = "offre")
    private Collection<Reservation> reservations;
}