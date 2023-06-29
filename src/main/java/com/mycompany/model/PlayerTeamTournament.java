/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass;
import com.mycompany.model.generic.GenericInterface;
import com.mycompany.enumvalues.PlayerPosition;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author prabin
 */
@Entity
@Table(name = "player_team_tournament")
public class PlayerTeamTournament extends GenericAbstractClass implements GenericInterface {

    @ManyToOne(optional = false)
    @CascadeOnDelete
    @NotNull
    @JoinColumn(name = "team_tournament_id", referencedColumnName = "id", nullable = false)
    private TeamTournament teamTournament;

    @ManyToOne(optional = false)
    @CascadeOnDelete
    @NotNull
    @JoinColumn(name = "player_id", referencedColumnName = "id", nullable = false)
    private Player player;

    @Enumerated(EnumType.STRING)
    @Column(name = "player_position",length = 50,nullable = false)
    private PlayerPosition playerPosition;

    @Column(name = "is_wicket_keeper",columnDefinition = "boolean default false")
    private Boolean isWicketKeeper;

    public PlayerTeamTournament() {
    }

    public PlayerTeamTournament(Long id, TeamTournament teamTournament, Player player, PlayerPosition position, Boolean isWicketKeeper) {
        this.setId(id);
        this.teamTournament = teamTournament;
        this.player = player;
        this.playerPosition = position;
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

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
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

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
    }

    @Override
    public String getTableName() {
        return "player";
    }

}
