/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass;
import com.mycompany.model.generic.GenericInterface;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author prabin
 */
@Entity
@Table(name = "team_tournament")
public class TeamTournament extends GenericAbstractClass implements GenericInterface {

    @ManyToOne(cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Team team;

    @ManyToOne(cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Tournament tournament;

    public TeamTournament() {
    }

    public TeamTournament(Long id, Team team, Tournament tournament) {
        this.setId(id);
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

    @Override
    public String getTableName() {
        return "team_tournament";
    }
}
