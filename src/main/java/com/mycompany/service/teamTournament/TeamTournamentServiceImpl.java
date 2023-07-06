/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.teamTournament;

import com.mycompany.model.Team;
import com.mycompany.model.TeamTournament;
import com.mycompany.model.Tournament;
import com.mycompany.pojo.TeamTournamentDetailRequest;
import com.mycompany.repository.TeamRepository;
import com.mycompany.repository.TeamTournamentRepository;
import com.mycompany.repository.TournamentRepository;
import javax.inject.Inject;

/**
 *
 * @author prabin
 */
public class TeamTournamentServiceImpl implements TeamTournamentService{

    @Inject
    private TeamTournamentRepository teamTournamentRepository;
    
    @Inject
    private TeamRepository teamRepository;
    
    @Inject
    private TournamentRepository tournamentRepository;
       
    @Override
    public TeamTournament saveTeamTournament(TeamTournamentDetailRequest request) {
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
          return teamTournamentRepository.saveData(teamTournament);
        } catch (RuntimeException e) {
            throw new RuntimeException("Couldnot save data " + e.getLocalizedMessage());
        }
        
    }
}
