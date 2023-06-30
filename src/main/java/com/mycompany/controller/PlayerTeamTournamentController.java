/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.enumvalues.PlayerPosition;
import com.mycompany.model.PlayerTeamTournament;
import com.mycompany.pojo.PlayerTeamTournamentDetailRequestPojo;
import com.mycompany.repository.PlayerTeamTournamentRepository;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author prabin
 */
@Named
@ViewScoped
public class PlayerTeamTournamentController implements Serializable {

    private PlayerTeamTournament playerTeamTournament;

    PlayerTeamTournamentDetailRequestPojo requestPojo;

    @Inject
    PlayerTeamTournamentRepository playerTeamTournamentRepository;

    public PlayerTeamTournament getPlayerTeamTournament() {
        return playerTeamTournament;
    }

    public void setPlayerTeamTournament(PlayerTeamTournament playerTeamTournament) {
        this.playerTeamTournament = playerTeamTournament;
    }

    public PlayerTeamTournamentDetailRequestPojo getRequestPojo() {
        return requestPojo;
    }

    public void setRequestPojo(PlayerTeamTournamentDetailRequestPojo requestPojo) {
        this.requestPojo = requestPojo;
    }

    
    public void savePlayerTeamTournament(PlayerTeamTournamentDetailRequestPojo requestPojo) {
        PlayerTeamTournament playerTeamTournament = new PlayerTeamTournament();
        playerTeamTournament.setPlayer(requestPojo.getPlayer());
        playerTeamTournament.setTeamTournament(requestPojo.getTeamTournament());
        playerTeamTournament.setIsWicketKeeper(Boolean.FALSE);
        playerTeamTournament.setPlayerPosition(PlayerPosition.ONLY_PLAYER);
        playerTeamTournamentRepository.saveData(playerTeamTournament);
    }

    public List<PlayerTeamTournament> getAllPlayerOfTheTeam() {
        System.out.println("Hello");
        return playerTeamTournamentRepository.getAllPlayerTeamTournamentByTournamentId(10L);
    }
}
