/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author prabin
 */
@Table(name = "team_tournament")
@Entity
public class TeamTournament implements Serializable {

    @Id
    private Long id;
    @OneToOne
    private Team teamId;
    @OneToOne
    private Tournament tournamentId;

    public TeamTournament() {
    }

    public TeamTournament(Integer id, Team teamId, Tournament tournamentId) {
        this.teamId = teamId;
        this.tournamentId = tournamentId;
    }

    public Team getTeamId() {
        return teamId;
    }

    public Tournament getTournamentId() {
        return tournamentId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    public void setTournamentId(Tournament tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
