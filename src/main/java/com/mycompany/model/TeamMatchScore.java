/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass;
import com.mycompany.model.generic.GenericInterface;
import cricscorer.enumvalues.TossAction;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author prabin
 */
@Entity
@Table(name = "team_match_score")
public class TeamMatchScore extends GenericAbstractClass implements GenericInterface {

    @ManyToOne(cascade = CascadeType.ALL)
    @CascadeOnDelete
    @JoinColumn(name = "team_id")
    private Team team;

    private Integer score;

    @ManyToOne(cascade = CascadeType.ALL)
    @CascadeOnDelete
    @JoinColumn(name = "cricket_match_id")
    private CricketMatch cricketMatch;

    private Boolean isWinner;

    @Enumerated(EnumType.STRING)
    private TossAction tossAction;

    public TeamMatchScore() {
    }

    public TeamMatchScore(Long id, Team team, Integer score, CricketMatch cricketMatch, Boolean isWinner, TossAction tossAction) {
        this.setId(id);
        this.team = team;
        this.score = score;
        this.cricketMatch = cricketMatch;
        this.isWinner = isWinner;
        this.tossAction = tossAction;
    }

    public CricketMatch getCricketMatch() {
        return cricketMatch;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setCricketMatch(CricketMatch cricketMatch) {
        this.cricketMatch = cricketMatch;
    }

    public Boolean getIsWinner() {
        return isWinner;
    }

    public Team getTeam() {
        return team;
    }

    public Integer getScore() {
        return score;
    }

    public TossAction getTossAction() {
        return tossAction;
    }

    public void setIsWinner(Boolean isWinner) {
        this.isWinner = isWinner;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setTossAction(TossAction tossAction) {
        this.tossAction = tossAction;
    }

    @Override
    public String getTableName() {
        return "team_match_score";
    }

}
