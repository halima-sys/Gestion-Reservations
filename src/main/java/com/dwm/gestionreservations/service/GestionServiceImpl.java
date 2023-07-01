package com.dwm.gestionreservations.service;


import com.dwm.gestionreservations.entities.Client;
import com.dwm.gestionreservations.entities.Offre;
import com.dwm.gestionreservations.entities.Reservation;
import com.dwm.gestionreservations.repositories.ClientRepository;
import com.dwm.gestionreservations.repositories.OffreRepository;
import com.dwm.gestionreservations.repositories.ReservationRepository;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GestionServiceImpl implements IGestionService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    OffreRepository offreRepository;

    @Override
    public List<Client> getAllClients() {

        return clientRepository.findAll();
    }
    // @Override
    // public List<Medecin> getAllMedecin() {
    // return medecinRepository.findAll();}

    ///**
    // * @param medecin
    //* @return
    // */
    @Override
    public List<Reservation> getReservationsByOffre(Offre offre) {
        return null;
    }

    ///**
    //* @return
    // */
    @Override
    public List<Reservation> getAllReservations() {
        return null;
    }

    ///**
    //* @param consultation
    //*/
    @Override
    public void deleteReservation(Reservation reservation) {

    }

    ///**
    //* @param id
    //* @return
    //*/
    @Override
    public Reservation getReservationById(Long id) {
        return null;
    }

    ///**
    //* @param Query
    // * @return
    //*/
    @Override
    public List<Reservation> searchReservationsByQuery(Offre Query) {
        return null;
    }

    ///**
    //* @param query
    // * @return
    //*/
    @Override
    public List<Reservation> searchReservationsByQuery(String query) {
        return null;
    }

    @Override
    public List<Client> searchClientsByQuery(String query) {
        return clientRepository.findClientsByNomContainsOrPrenomContains(query, query);
    }

    @Override
    public void addClient(Client client) {
        clientRepository.save(client);

    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);

    }

    @Override
    public void addOffre(Offre offre) {
        offreRepository.save(offre);

    }

    ///**
    //* @return
    //*/
    @Override
    public List<Offre> getAllOffres() {
        return offreRepository.findAll();
    }

    //
    @Override
    public List<Offre> searchOffresByQuery(String query) {
        return offreRepository.findOffresByNomContainsOrPrenomContains(query, query);
    }

    @Override
    public void deleteOffreById(Long id) {
        offreRepository.deleteById(id);

    }

    @Override
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);

    }

    @Override
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);

    }

    //
    @Override
    public Offre getOffreById(Long id) {
        return offreRepository.findById(id).get();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<Reservation> searchReservationsByOffre(String offre_nom) {
        return reservationRepository.findByOffreNomContaining(offre_nom);
    }

    @Override
    public List<Reservation> searchReservationsByClient(String co) {
        return null;
    }


    @Override
    public List<Reservation> searchReservationsById(String query) {
        return null;
    }
    @Override
    public List<Reservation> getReservationsByPatient(Client client) {
        return null;
    }

    //

    // @Override
    // public List<Consultation> getConsultationsByPatient(Patient patient) {
    //return ConsultationRepository.findConsultationByPatient(patient);}

    //@Override
    //public List<Consultation> getConsultationsByMedecin(Medecin medecin) {
    //return ConsultationRepository.findConsultationsByMedecin(String.valueOf(medecin));}


    //@Override
    //public List<Consultation> getAllConsultations() {
    //return consultationRepository.findAll();}

    //@Override
    //public void deleteConsultation(Consultation consultation) {
    //consultationRepository.delete(consultation);}


    //@Override
    //public Consultation getConsultationById(Long id) {
    //return consultationRepository.findById(id).get();}


    // /**
    //* @param Query
    //* @return
    // */
    //@Override
    //public List<Consultation> searchConsultationsByQuery(Medecin Query) {
    //return null;//return consultationRepository.findConsultationsByIdContainsOrDateConsultationContainsOrDescriptionContainsOrMedecinIdContainingOrPatientIdContaining(Query, Query, Query, Query,Query);}
    //@Override
    //public List<Consultation> searchConsultationsByMedecin(String mc) {
    // List<Medecin> medecins = medecinRepository.findMedecinsByIdContains(mc);
    // List<Consultation> consultations = new ArrayList<>();
    // for (Medecin medecin : medecins) {
    //consultations.addAll(consultationRepository.findByMedecin(medecin));}
    //return consultations;}

    //@Override
    //public List<Consultation> searchConsultationsByQuery(String Query) {
    //return ConsultationRepository.findConsultationsByMedecin(String.valueOf(Query));}


    //@Override
    //public List<Consultation> searchConsultationsByMedecin(String co) {
    //return null;



    //@Override
    //public List<Consultation> searchConsultationsById(String query) {
    // return ConsultationRepository.findConsultationsByMedecin(query);}


}
