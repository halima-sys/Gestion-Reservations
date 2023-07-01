package com.dwm.gestionreservations.entities;

import lombok.*;
import javax.persistence.*;


import java.util.Collection;

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
    private String nom;
    @NonNull
    private String prenom;
    private String email;
    private String tel;

    @OneToMany(mappedBy = "offre")
    private Collection<Reservation> reservations;
}