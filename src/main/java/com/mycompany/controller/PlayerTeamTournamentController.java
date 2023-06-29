/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.enumvalues.PlayerPosition;
import com.mycompany.model.PlayerTeamTournament;
import com.mycompany.pojo.PlayerTeamTournamentDetailRequestPojo;
import com.mycompany.repository.PlayerTeamTournamentRepository;
import javax.inject.Inject;

/**
 *
 * @author prabin
 */
public class PlayerTeamTournamentController {

    @Inject
    PlayerTeamTournamentRepository playerTeamTournamentRepository;
    
    public void savePlayerTeamTournament(PlayerTeamTournamentDetailRequestPojo requestPojo) {
        PlayerTeamTournament playerTeamTournament = new PlayerTeamTournament();
        playerTeamTournament.setPlayer(requestPojo.getPlayer());
        playerTeamTournament.setTeamTournament(requestPojo.getTeamTournament());
        playerTeamTournament.setIsWicketKeeper(Boolean.FALSE);
        playerTeamTournament.setPlayerPosition(PlayerPosition.ONLY_PLAYER);
        playerTeamTournamentRepository.saveData(playerTeamTournament);
    }
}
