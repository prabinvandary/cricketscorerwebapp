/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.enumvalues.TournamentType;
import com.mycompany.model.Tournament;
import com.mycompany.repository.TournamentRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.UnselectEvent;

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

    private List<Long> teamId;

    private TournamentType[] getTournamentType;

    @Inject
    TeamTournamentController teamTournamentController;

    @Inject
    private TournamentRepository tournamentRepository;

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
        this.isTournamentListEmpty = (tournamentList.isEmpty() || 
                tournamentList == null) ? Boolean.TRUE : Boolean.FALSE;
    }

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

    public List<Long> getTeamId() {
        return teamId;
    }

    public void setTeamId(List<Long> teamId) {
        this.teamId = teamId;
    }

    public TournamentType[] getGetTournamentType() {
        return TournamentType.values();
    }

    @PostConstruct
    public void init() {
        tournament = new Tournament();
        teamId = new ArrayList<>();
    }

    public void beforeCreate() {
        tournament = new Tournament();
    }

    public void beforeEdit(Tournament t) {
        this.tournament = tournamentRepository.getById(t.getId());
    }

    public void saveTournament() {
        tournamentRepository.saveData(tournament);
    }

    public List<Tournament> getAllTournament() {
        setTournamentList(tournamentRepository.getAllData());
        return tournamentRepository.getAllData();
    }

    public void delete(Tournament t) {
        tournamentRepository.removeEntity(t);
    }
    

    public void onItemUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage();
        msg.setSummary("Item unselected: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
