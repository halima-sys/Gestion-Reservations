package com.dwm.gestionreservations.service;

import com.dwm.gestionreservations.entities.Client;
import com.dwm.gestionreservations.entities.Offre;
import com.dwm.gestionreservations.entities.Reservation;

import java.util.List;

public interface IGestionService {
    List<Client> getAllClients();
    List<Reservation> getAllReservations();

    void deleteReservation(Reservation reservation);

    Reservation getReservationById(Long id);
    List<Reservation> getReservationsByOffre(Offre offre);
    List<Reservation> getReservationsByPatient(Client client);

    List<Reservation> searchReservationsByClient(String co);

    List<Reservation> searchReservationsById(String query);

    List<Reservation> searchReservationsByQuery(Offre Query);

    List<Reservation> searchReservationsByQuery(String query);

    List<Client> searchClientsByQuery(String query);

    void addClient(Client client);

    void deleteClientById(Long id);

    void addOffre(Offre offre);

    List<Offre> getAllOffres();

    List<Offre> searchOffresByQuery(String query);

    void deleteOffreById(Long id);

    void addReservation(Reservation reservation);

    void deleteReservationById(Long id);

    Offre getOffreById(Long id);

    Client getClientById(Long id);

    List<Reservation> searchReservationsByOffre(String mc);

    //


    // List<Consultation> getConsultationsByPatient(Patient patient);

    //List<Consultation> getConsultationsByMedecin(Medecin medecin);

    //List<Consultation> getAllConsultations();

    //void deleteConsultation(Consultation consultation);

    // List<Medecin> getAllMedecin();

    ///**
    // * @param medecin
    //* @return
    // */
    //List<Consultation> getConsultationsByMedecin(Medecin medecin);

    ///**
    // * @param medecin
    //* @return
    // */





    ///**
    // * @param patient
    //* @return
    //*/



    // List<Consultation> searchConsultationsByQuery(Medecin Query);

    //List<Consultation> searchConsultationsByQuery(String query);

    // List<Consultation> searchConsultationsByPatient(String co);

    //List<Consultation> searchConsultationsById(String query);

    // List<Consultation> searchConsultationsByPatient(String mc);
}


