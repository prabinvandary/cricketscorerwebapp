/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import cricscorer.enumvalues.PlayerPosition;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author prabin
 */
@Entity
@Table(name = "player_team_tournament")
public class PlayerTeamTournament implements Serializable {

    @Id
    private Long id;
    private Integer playerTeamTournamentId;
    @OneToMany
    private Player playerId;
    private PlayerPosition position;
    private Boolean isWicketKeeper;

    public PlayerTeamTournament() {
    }

    public PlayerTeamTournament(Integer id, Integer playerTeamTournamentId, Player playerId, PlayerPosition position, Boolean isWicketKeeper) {
        this.playerTeamTournamentId = playerTeamTournamentId;
        this.playerId = playerId;
        this.position = position;
        this.isWicketKeeper = isWicketKeeper;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public Boolean getIsWicketKeeper() {
        return isWicketKeeper;
    }

    public Integer getPlayerTeamTournamentId() {
        return playerTeamTournamentId;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setIsWicketKeeper(Boolean isWicketKeeper) {
        this.isWicketKeeper = isWicketKeeper;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }

    public void setPlayerTeamTournamentId(Integer playerTeamTournamentId) {
        this.playerTeamTournamentId = playerTeamTournamentId;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
