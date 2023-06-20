/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import cricscorer.enumvalues.TossAction;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author prabin
 */
@Entity
@Table(name = "team_match_score")
public class TeamMatchScore implements Serializable {

    @Id
    private Long id;
    @OneToMany
    private Team teamId;
    private Integer score;
    @OneToOne
    private CricketMatch matchId;
    private Boolean isWinner;
    private TossAction tossAction;

    public TeamMatchScore() {
    }

    public TeamMatchScore(Integer id, Team teamId, Integer score, CricketMatch matchId, Boolean isWinner, TossAction tossAction) {
        this.teamId = teamId;
        this.score = score;
        this.matchId = matchId;
        this.isWinner = isWinner;
        this.tossAction = tossAction;
    }

    public Boolean getIsWinner() {
        return isWinner;
    }

    public CricketMatch getMatchId() {
        return matchId;
    }

    public Integer getScore() {
        return score;
    }

    public Team getTeamId() {
        return teamId;
    }

    public TossAction getTossAction() {
        return tossAction;
    }

    public void setIsWinner(Boolean isWinner) {
        this.isWinner = isWinner;
    }

    public void setMatchId(CricketMatch matchId) {
        this.matchId = matchId;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    public void setTossAction(TossAction tossAction) {
        this.tossAction = tossAction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
