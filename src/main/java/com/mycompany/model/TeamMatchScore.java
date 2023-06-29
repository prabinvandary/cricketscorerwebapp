/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass;
import com.mycompany.model.generic.GenericInterface;
import com.mycompany.enumvalues.TossAction;
import javax.persistence.CascadeType;
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
@Table(name = "team_match_score")
public class TeamMatchScore extends GenericAbstractClass implements GenericInterface {

    @ManyToOne(optional = false)
    @CascadeOnDelete
    @NotNull
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    private Team team;

    private Integer score;

    @ManyToOne(optional = false)
    @CascadeOnDelete
    @NotNull
    @JoinColumn(name = "cricket_match_id", referencedColumnName = "id", nullable = false)
    private CricketMatch cricketMatch;

    @Column(name = "is_winner")
    private Boolean isWinner;

    @Enumerated(EnumType.STRING)
    @Column(name = "toss_action",length = 50)
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
