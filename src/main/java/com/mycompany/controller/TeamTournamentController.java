/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.model.Team;
import com.mycompany.model.TeamTournament;
import com.mycompany.model.Tournament;
import com.mycompany.pojo.TeamTournamentDetailRequest;
import com.mycompany.repository.TeamRepository;
import com.mycompany.repository.TeamTournamentRepository;
import com.mycompany.repository.TournamentRepository;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
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
public class TeamTournamentController implements Serializable {

    @Inject
    private TeamRepository teamRepository;

    @Inject
    private TeamTournamentRepository teamTournamentRepository;

    @Inject
    private TournamentRepository tournamentRepository;

    private TeamTournamentDetailRequest requestPojo;

    private List<TeamTournament> teamTournamentList;

    @ManagedProperty(name = "tournamentId", value = "param.tournamentId")
    private Long tournamentId;

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public TeamTournamentDetailRequest getRequestPojo() {
        return requestPojo;
    }

    public void setRequestPojo(TeamTournamentDetailRequest requestPojo) {
        this.requestPojo = requestPojo;
    }

    public List<TeamTournament> getTeamTournamentList() {
        return teamTournamentList;
    }

    public void setTeamTournamentList(List<TeamTournament> teamTournamentList) {
        this.teamTournamentList = teamTournamentList;
    }

    @PostConstruct
    public void init() {

    }

    public void beforeCreate() {
        requestPojo = new TeamTournamentDetailRequest();
    }

    public void initialize() {
        if (tournamentId!=null) {
            return;
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        this.tournamentId = Long.valueOf(facesContext.getExternalContext().getRequestParameterMap().get("tournamentId"));
        if (tournamentId == null) {
            throw new IllegalArgumentException("The tournamentId parameter is not set.");
        }
    }

    public void saveTeamTournament() {
        try {
            TeamTournament teamTournament = new TeamTournament();
            Team team = teamRepository.getById(requestPojo.getTeamId());
            Tournament tournament = tournamentRepository.getById(this.getTournamentId());

            if (requestPojo.getId() != null) {
                teamTournament = teamTournamentRepository.getById(requestPojo.getId());
                if (teamTournament == null) {
                    teamTournament = new TeamTournament();
                }
            }

            if (tournament == null) {
                throw new RuntimeException("Tournament not found by given id");
            }
            if (team == null) {
                throw new RuntimeException("Team not found by given id");
            }
            teamTournament.setTeam(team);
            teamTournament.setTournament(tournament);
            teamTournament=teamTournamentRepository.saveData(teamTournament);
             if (teamTournament != null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Team Tournament save successful.",
                            " Team Tournament saved successfully"));

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            " Team Tournament save unsuccessful.",
                            "Team Tournament is not saved."));

        }

        } catch (RuntimeException e) {
            throw new RuntimeException("Couldnot save data " + e.getLocalizedMessage());
        }
    }

    public List<TeamTournament> getAllTeamOfTheTournamentByTournamentId() {
        return teamTournamentRepository.getTeamTournamentsByTournamentId(tournamentId);
    }

    public void delete(TeamTournament t) {
        teamTournamentRepository.removeEntity(t);
    }

    public void setTournamentIDFrom(Tournament t) {
        this.setTournamentId(t.getId());
    }
}
