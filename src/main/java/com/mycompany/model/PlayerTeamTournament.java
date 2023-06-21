/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass;
import com.mycompany.model.generic.GenericInterface;
import cricscorer.enumvalues.PlayerPosition;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author prabin
 */
@Entity
@Table(name = "player_team_tournament")
public class PlayerTeamTournament {

    @ManyToOne
    private TeamTournament teamTournament;

    @ManyToOne
    private Player player;

    @Enumerated(EnumType.STRING)
    private PlayerPosition position;

    private Boolean isWicketKeeper;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public PlayerTeamTournament() {
    }

    public PlayerTeamTournament(Long id, TeamTournament teamTournament, Player player, PlayerPosition position, Boolean isWicketKeeper) {
        this.id = id;
        this.teamTournament = teamTournament;
        this.player = player;
        this.position = position;
        this.isWicketKeeper = isWicketKeeper;
    }

    public Player getPlayer() {
        return player;
    }

    public Boolean getIsWicketKeeper() {
        return isWicketKeeper;
    }

    public TeamTournament getTeamTournament() {
        return teamTournament;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setIsWicketKeeper(Boolean isWicketKeeper) {
        this.isWicketKeeper = isWicketKeeper;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setTeamTournament(TeamTournament teamTournament) {
        this.teamTournament = teamTournament;
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
