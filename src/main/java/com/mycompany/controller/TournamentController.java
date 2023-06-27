/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.enumvalues.TournamentType;
import com.mycompany.model.Team;
import com.mycompany.model.TeamTournament;
import com.mycompany.model.Tournament;
import com.mycompany.repository.TournamentRepository;
import java.io.Serializable;
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

    private List<Team> teams;

    private Team[] teamArray;

    public Team[] getTeamArray() {
        return teamArray;
    }

    public void setTeamArray(Team[] teamArray) {
        this.teamArray = teamArray;
    }
    
    
    
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

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
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
        Tournament saveData = tournamentRepository.saveData(tournament);
        saveTeamTournament(saveData);
    }

    public List<Tournament> getAllTournament() {
        setTournamentList(tournamentRepository.getAllData());
        return tournamentRepository.getAllData();
    }

    public void delete(Tournament t) {
        tournamentRepository.removeEntity(t);
    }

    private void saveTeamTournament(Tournament tournament) {
        TeamTournamentController teamTournamentController = new TeamTournamentController();
        for (Team team : teams) {
            teamTournamentController.saveTeamTournament(new TeamTournament(team, tournament));
        }

    }

    public void onItemUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage();
        msg.setSummary("Item unselected: " + event.getObject().toString());
        msg.setSeverity(FacesMessage.SEVERITY_INFO);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
