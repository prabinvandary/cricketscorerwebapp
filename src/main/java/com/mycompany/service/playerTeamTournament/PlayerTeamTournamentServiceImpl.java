/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.playerTeamTournament;

import com.mycompany.model.Player;
import com.mycompany.model.PlayerTeamTournament;
import com.mycompany.model.TeamTournament;
import com.mycompany.pojo.PlayerTeamTournamentDetailRequestPojo;
import com.mycompany.repository.PlayerRepository;
import com.mycompany.repository.PlayerTeamTournamentRepository;
import com.mycompany.repository.TeamTournamentRepository;
import javax.inject.Inject;

/**
 *
 * @author prabin
 */
public class PlayerTeamTournamentServiceImpl implements PlayerTeamTournamentService {

    @Inject
    private PlayerTeamTournamentRepository playerTeamTournamentRepository;

    @Inject
    private PlayerRepository playerRepository;

    @Inject
    private TeamTournamentRepository teamTournamentRepository;

    @Override
    public PlayerTeamTournament savePlayerTeamTournament(PlayerTeamTournamentDetailRequestPojo requestPojo) {
        try {
            PlayerTeamTournament playerTeamTournament = new PlayerTeamTournament();
            if (requestPojo.getId() != null) {
                playerTeamTournament = playerTeamTournamentRepository.getById(requestPojo.getId());
                if (playerTeamTournament == null) {
                    playerTeamTournament = new PlayerTeamTournament();
                }
            }
            TeamTournament teamTournament = teamTournamentRepository.getById(requestPojo.getTeamTournamentId());
            if (teamTournament == null) {
                throw new RuntimeException("Team tournament not found by given Id");
            }
            Player player = playerRepository.getById(requestPojo.getPlayerId());
            if (player == null) {
                throw new RuntimeException("Player not found by given id.");
            }
            playerTeamTournament.setPlayer(player);
            playerTeamTournament.setTeamTournament(teamTournament);
            playerTeamTournament.setIsWicketKeeper(requestPojo.getIsWicketKeeper());
            playerTeamTournament.setPlayerPosition(requestPojo.getPlayerPosition());
            return playerTeamTournamentRepository.saveData(playerTeamTournament);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
