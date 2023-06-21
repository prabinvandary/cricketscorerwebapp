/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.io.Serializable;
import javax.persistence.Entity;
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
@Table(name = "team_tournament")
public class TeamTournament implements Serializable {

    @ManyToOne
    private Team team;

    @ManyToOne
    private Tournament tournament;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public TeamTournament() {
    }

    public TeamTournament(Long id, Team team, Tournament tournament) {
        this.id = id;
        this.team = team;
        this.tournament = tournament;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
