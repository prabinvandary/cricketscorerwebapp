/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.model.Team;
import com.mycompany.model.TeamTournament;
import com.mycompany.pojo.TeamTournamentDetailRequest;
import com.mycompany.repository.TeamRepository;
import com.mycompany.repository.TeamTournamentRepository;
import java.io.Serializable;
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

    public void saveTeamTournament(TeamTournamentDetailRequest request) {
        Team team = teamRepository.getById(request.getTeamId());
        TeamTournament teamTournament = new TeamTournament();
        teamTournament.setTeam(team);
        teamTournament.setTournament(request.getTournament());
        teamTournamentRepository.saveData(teamTournament);
    }
}
