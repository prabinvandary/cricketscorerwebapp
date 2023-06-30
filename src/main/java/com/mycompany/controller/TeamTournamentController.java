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
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author prabin
 */
@Named
@Stateless
public class TeamTournamentController implements Serializable {

    @Inject
    private TeamRepository teamRepository;

    @Inject
    private TeamTournamentRepository teamTournamentRepository;

    @Inject
    private TournamentRepository tournamentRepository;

    private TeamTournamentDetailRequest requestPojo;

    private List<TeamTournamentDetailRequest> listOfRequestPojo;

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

    public List<TeamTournamentDetailRequest> getListOfRequestPojo() {
        return listOfRequestPojo;
    }

    public void setListOfRequestPojo(List<TeamTournamentDetailRequest> listOfRequestPojo) {
        this.listOfRequestPojo = listOfRequestPojo;
    }

    @PostConstruct
    public void init() {

    }

    public void beforeCreate() {
        requestPojo = new TeamTournamentDetailRequest();
        requestPojo.setTournamentId(getTournamentId());
    }

    public void saveTeamTournament() {
        for (TeamTournamentDetailRequest request : getListOfRequestPojo()) {
            try {
                TeamTournament teamTournament = new TeamTournament();
                Team team = teamRepository.getById(request.getTeamId());
                Tournament tournament = tournamentRepository.getById(request.getTournamentId());

                if (request.getId() != null) {
                    teamTournament = teamTournamentRepository.getById(request.getId());
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
                teamTournamentRepository.saveData(teamTournament);

            } catch (RuntimeException e) {
                throw new RuntimeException("Couldnot save data " + e.getLocalizedMessage());
            }
        }
    }

    public List<TeamTournament> getAllTeamOfTheTournamentByTournamentId() {
        return teamTournamentRepository.getTeamTournamentsByTournamentId(getTournamentId());
    }

    public void delete(TeamTournament t) {
        teamTournamentRepository.removeEntity(t);
    }

    public void setTournamentIDFrom(Tournament t) {
        this.setTournamentId(t.getId());
    }
}
