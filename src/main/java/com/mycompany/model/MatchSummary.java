/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import cricscorer.enumvalues.MatchBowlAction;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private MatchBowlAction matchBowlAction;
    @OneToMany
    private Player batsMenId;
    @OneToMany
    private Player bowlerId;
    @OneToMany
    private CricketMatch matchId;
    @Id
    private Long id;

    public MatchSummary() {
    }

    public MatchSummary(Integer id, Integer run, Double over, MatchBowlAction action, Player batsMenId, Player bowlerId, CricketMatch matchId) {
        this.run = run;
        this.over = over;
        this.matchBowlAction = action;
        this.batsMenId = batsMenId;
        this.bowlerId = bowlerId;
        this.matchId = matchId;
    }

    public MatchBowlAction getMatchBowlAction() {
        return matchBowlAction;
    }

    public Player getBatsMenId() {
        return batsMenId;
    }

    public Player getBowlerId() {
        return bowlerId;
    }

    public CricketMatch getMatchId() {
        return matchId;
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

    public void setBatsMenId(Player batsMenId) {
        this.batsMenId = batsMenId;
    }

    public void setBowlerId(Player bowlerId) {
        this.bowlerId = bowlerId;
    }

    public void setMatchId(CricketMatch matchId) {
        this.matchId = matchId;
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
