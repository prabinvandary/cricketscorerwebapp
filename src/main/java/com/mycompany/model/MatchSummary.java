/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import cricscorer.enumvalues.MatchBowlAction;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    private Integer batsMenId;
    private Integer bowlerId;
    private Integer matchId;
    @Id
    private Long id;

    public MatchSummary() {
    }

    public MatchSummary(Integer id, Integer run, Double over, MatchBowlAction action, Integer batsMenId, Integer bowlerId, Integer matchId) {
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

    public Integer getBatsMenId() {
        return batsMenId;
    }

    public Integer getBowlerId() {
        return bowlerId;
    }

    public Integer getMatchId() {
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

    public void setBatsMenId(Integer batsMenId) {
        this.batsMenId = batsMenId;
    }

    public void setBowlerId(Integer bowlerId) {
        this.bowlerId = bowlerId;
    }

    public void setMatchId(Integer matchId) {
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
