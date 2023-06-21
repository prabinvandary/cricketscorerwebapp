/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import cricscorer.enumvalues.TossAction;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author prabin
 */
@Entity
@Table(name = "team_match_score")
public class TeamMatchScore implements Serializable {

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "cricket_match_id")
    private CricketMatch cricketMatch;

    private Boolean isWinner;

    @Enumerated(EnumType.STRING)
    private TossAction tossAction;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public TeamMatchScore() {
    }

    public TeamMatchScore(Long id, Team team, Integer score, CricketMatch cricketMatch, Boolean isWinner, TossAction tossAction) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
