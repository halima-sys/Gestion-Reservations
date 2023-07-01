package com.dwm.gestionreservations.web;

import com.dwm.gestionreservations.entities.Client;
import com.dwm.gestionreservations.entities.Offre;
import com.dwm.gestionreservations.entities.Reservation;
import com.dwm.gestionreservations.service.IGestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class GestionController {
    @Autowired
    IGestionService gestionService;

    @GetMapping(path = "/")
    public String home() {
        return "index";
    }

    @GetMapping(path = "/clients")
    public String clients(Model model, @RequestParam(name = "mc", defaultValue = "") String mc) {
        List<Client> clients = gestionService.searchClientsByQuery(mc);
        //Stocker une donnée dans le modèle
        model.addAttribute("clients", clients);
        return "clients_list";
    }

    @GetMapping(path = "deleteClient")
    public String deleteClient(@RequestParam(name = "id", defaultValue = "0") Long id) {
        gestionService.deleteClientById(id);
        return "redirect:/clients";
    }

    @GetMapping(path = "/addClient")
    public String clientForm(Model model) {
        Client p = new Client();
        model.addAttribute("client", p);
        return "client_new";
    }

    @PostMapping(path = "/saveClient")
    public String saveClient(@ModelAttribute Client client) {
        gestionService.addClient(client);
        return "redirect:/clients";
    }

    @GetMapping(path = "/offres")
    public String offres(Model model, @RequestParam(name = "mc", defaultValue = "") String mc) {
        List<Offre> offres = gestionService.searchOffresByQuery(mc);
        //Stocker une donnée dans le modèle
        model.addAttribute("offre", offres);
        return "offre_list";
    }

    @GetMapping(path = "deleteOffre")
    public String deleteOffreById(@RequestParam(name = "id", defaultValue = "0") Long id) {
        gestionService.deleteOffreById(id);
        return "redirect:/offres";
    }

    @GetMapping(path = "/addOffre")
    public String OffreForm(Model model) {
        Offre p = new Offre();
        model.addAttribute("offre", p);
        return "offre_new";
    }

    @PostMapping(path = "/saveOffre")
    public String saveOffre(@ModelAttribute Offre offre) {
        gestionService.addOffre(offre);
        return "redirect:/offres";
    }


    @GetMapping(path = "/reservations")
    public String reservations(Model model, @RequestParam(name = "offre_nom", defaultValue = "") String offre_nom) {
        List<Reservation> reservations = gestionService.searchReservationsByOffre(offre_nom);
        //Stocker une donnée dans le modèle
        model.addAttribute("reservations", reservations);
        return "reservations_list";
    }

    @GetMapping(path = "deleteReservation")
    public String deleteReservation(@RequestParam(name = "id", defaultValue = "0") Long id) {
        gestionService.deleteReservationById(id);
        return "redirect:/reservations";
    }

    @GetMapping(path = "/addReservation")
    public String reservationForm(Model model) {
        Reservation c = new Reservation();
        List<Offre> offres = gestionService.getAllOffres();
        List<Client> clients = gestionService.getAllClients();

        model.addAttribute("Reservation", c);
        model.addAttribute("offres", offres);
        model.addAttribute("clients", clients);
        return "reservation_new";
    }

    //
    //@GetMapping(path = "/consultations")
    //public String consultations(Model model, @RequestParam(name = "Querry", defaultValue = "") String Query) {
    // List<Consultation> consultations= cabinetService.searchConsultationsById(Query);
    //System.out.println("Consultations: " + consultations);
    //Stocker une donnée dans le modèle
    //model.addAttribute("consultations", consultations);
    //return "consultations_list";}

    //@GetMapping(path = "deleteConsultation")
    // public String deleteConsultation(@RequestParam(name = "id", defaultValue = "0") Long id) {
    //cabinetService.deleteConsultationById(id);
    //return "redirect:/consultations";}

    //@GetMapping(path = "/addConsultation")
    // public String consultationForm(Model model) {
    //Consultation c = new Consultation();
    // List<Medecin> medecins = cabinetService.getAllMedecins();
    // List<Patient> patients = cabinetService.getAllPatients();

    //model.addAttribute("consultation", c);
    //model.addAttribute("medecins", medecins);
    //model.addAttribute("patients", patients);
    //return "consultation_new";}

    @PostMapping(path = "/saveReservation")
    public String saveReservation(@ModelAttribute Reservation reservation, @RequestParam(name = "offreId") Long offreId,
                                   @RequestParam(name = "clientId") Long clientId) {
        Offre offre = gestionService.getOffreById(offreId);
        Client client = gestionService.getClientById(clientId);

        reservation.setOffre(offre);
        reservation.setClient(client);
        gestionService.addReservation(reservation);
        return "redirect:/reservations";
    }

}