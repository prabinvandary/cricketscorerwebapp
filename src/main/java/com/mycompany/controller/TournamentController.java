/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.model.Tournament;
import com.mycompany.repository.TournamentRepository;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author prabin
 */
@Named
@ViewScoped
public class TournamentController implements Serializable {

    private Tournament tournament;

    @Inject
    private TournamentRepository tournamentRepository;

    public TournamentRepository getTournamentRepository() {
        return tournamentRepository;
    }

    public void setTournamentRepository(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    @PostConstruct
    public void init() {
        tournament = new Tournament();
    }

    public void saveTournament() {
        tournamentRepository.saveData(tournament);
    }

}
