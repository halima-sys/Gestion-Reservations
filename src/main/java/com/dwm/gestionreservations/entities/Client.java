package com.dwm.gestionreservations.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;
    @NonNull
    private String cin;
    private String tel;
    private String email;
    private String passeport;

    @OneToMany(mappedBy = "client")
    private Collection<Reservation> Reservation;
}