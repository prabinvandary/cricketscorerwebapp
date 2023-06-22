/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass;
import com.mycompany.model.generic.GenericInterface;
import com.mycompany.enumvalues.MatchBowlAction;
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
@Table(name = "match_summary")
public class MatchSummary extends GenericAbstractClass implements GenericInterface {

    private Integer run;

    private Double over;

    @Enumerated(EnumType.STRING)
    private MatchBowlAction matchBowlAction;

    @ManyToOne(cascade = CascadeType.ALL)
    @CascadeOnDelete
    @JoinColumn(name = "bats_men_id")
    private Player playerBatsMen;

    @ManyToOne(cascade = CascadeType.ALL)
    @CascadeOnDelete
    @JoinColumn(name = "bowler_id")
    private Player playerBolwer;

    @ManyToOne(cascade = CascadeType.ALL)
    @CascadeOnDelete
    @JoinColumn(name = "cricket_match_id")
    private CricketMatch cricketMatch;

    public MatchSummary() {
    }

    public MatchSummary(Long id, Integer run, Double over, MatchBowlAction action, Player batsMenId, Player bowlerId, CricketMatch matchId) {
        this.setId(id);
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

    @Override
    public String getTableName() {
        return "match_summary";
    }
}
