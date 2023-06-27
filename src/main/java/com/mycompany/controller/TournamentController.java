/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.enumvalues.TournamentType;
import com.mycompany.model.Tournament;
import com.mycompany.repository.TournamentRepository;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
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
    
    private Boolean isTournamentListEmpty;

    private List<Tournament> tournamentList;

    public Boolean getIsTournamentListEmpty() {
        return isTournamentListEmpty;
    }

    public List<Tournament> getTournamentList() {
        return tournamentList;
    }

    public void setTournamentList(List<Tournament> tournamentList) {
        this.tournamentList = tournamentList;
    }

    public void setIsTournamentListEmpty() {
        this.isTournamentListEmpty = (tournamentList.isEmpty() || tournamentList == null) ? Boolean.TRUE : Boolean.FALSE;
    }

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

    private TournamentType[] getTournamentType;

    public TournamentType[] getGetTournamentType() {
        return TournamentType.values();
    }

    public void beforeCreate() {
        tournament = new Tournament();
    }

    public Tournament beforeEdit(Tournament t) {
        return this.tournament = tournamentRepository.getById(t.getId());
    }

    public void saveTournament() {
        System.out.println("Hello");
        System.out.println(tournament.getFromDate() + " and " + tournament.getToDate());
        tournamentRepository.saveData(tournament);
    }

    public List<Tournament> getAllTournament() {
        setTournamentList(tournamentRepository.getAllData());
        return tournamentRepository.getAllData();
    }

    public void delete(Tournament t) {
        tournamentRepository.removeEntity(t);
    }  
     
}
