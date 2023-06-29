/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojo;

import com.mycompany.model.Player;
import com.mycompany.model.TeamTournament;


/**
 *
 * @author prabin
 */
public class PlayerTeamTournamentDetailRequestPojo {
    private Player player;
    
    private TeamTournament  teamTournament;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public TeamTournament getTeamTournament() {
        return teamTournament;
    }

    public void setTeamTournament(TeamTournament teamTournament) {
        this.teamTournament = teamTournament;
    }
    
    
}
