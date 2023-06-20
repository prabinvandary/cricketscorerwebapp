/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    private Integer teamId;
    private Integer tournamentId;

    public TeamTournament() {
    }

    public TeamTournament(Integer id, Integer teamId, Integer tournamentId) {
        this.teamId = teamId;
        this.tournamentId = tournamentId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
