/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import cricscorer.enumvalues.MatchBowlAction;
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
@Table(name = "match_summary")
public class MatchSummary implements Serializable {

    private Integer run;

    private Double over;

    @Enumerated(EnumType.STRING)
    private MatchBowlAction matchBowlAction;

    @ManyToOne
    @JoinColumn(name = "bats_men_id")
    private Player playerBatsMen;

    @ManyToOne
    @JoinColumn(name = "bowler_id")
    private Player playerBolwer;

    @ManyToOne
    @JoinColumn(name = "cricket_match_id")
    private CricketMatch cricketMatch;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public MatchSummary() {
    }

    public MatchSummary(Long id, Integer run, Double over, MatchBowlAction action, Player batsMenId, Player bowlerId, CricketMatch matchId) {
        this.id = id;
        this.run = run;
        this.over = over;
        this.matchBowlAction = action;
        this.playerBatsMen = batsMenId;
        this.playerBolwer = bowlerId;
        this.cricketMatch = matchId;
    }

    public MatchBowlAction getMatchBowlAction() {
        return matchBowlAction;
    }

    public Player getBatsMenId() {
        return playerBatsMen;
    }

    public Player getBowlerId() {
        return playerBolwer;
    }

    public CricketMatch getMatchId() {
        return cricketMatch;
    }

    public Integer getRun() {
        return run;
    }

    public Double getOver() {
        return over;
    }

    public void setMatchBowlAction(MatchBowlAction matchBowlAction) {
        this.matchBowlAction = matchBowlAction;
    }

    public void setBatsMenId(Player playerBatsmen) {
        this.playerBatsMen = playerBatsmen;
    }

    public void setBowlerId(Player playerBowler) {
        this.playerBolwer = playerBowler;
    }

    public void setMatchId(CricketMatch cricketMatch) {
        this.cricketMatch = cricketMatch;
    }

    public void setOver(Double over) {
        this.over = over;
    }

    public void setRun(Integer run) {
        this.run = run;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
