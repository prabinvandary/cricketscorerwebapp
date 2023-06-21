///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.model;
//
//import cricscorer.enumvalues.MatchBowlAction;
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.ForeignKey;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
///**
// *
// * @author prabin
// */
////@Entity
//@Table(name = "match_summary")
//public class MatchSummary implements Serializable {
//
//    @Id
//    @SequenceGenerator(sequenceName = "match_summary_seq_gen", name = "match_summary_seq_gen", allocationSize = 1)
//    @GeneratedValue(generator = "match_summary_seq_gen", strategy = GenerationType.SEQUENCE)
//    @Column(name = "id")
//    private Long id;
//    @Column(name = "run")
//    private Integer run;
//    @Column(name = "over")
//    private Double over;
//    @Column(name = "match_bowl_action")
//    @Enumerated(EnumType.STRING)
//    private MatchBowlAction matchBowlAction;
//    @OneToOne
////    @Column(name="batsmen_id")
////    @JoinColumn(name = "batsmen_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_Match_Summary_Batsmen"))
//    @JoinColumn(name = "batsmen_id")
//
//    private Player batsMenId;
//    @OneToOne
////    @Column(name="bowler_id")
////    @JoinColumn(name = "bowler_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_Match_Summary_Bowler"))
//    @JoinColumn(name = "bowler_id")
//
//    private Player bowlerId;
//    @OneToOne
////    @Column(name="match_id")
////    @JoinColumn(name = "match_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_Match_Summary_Cricket_Match"))
//    @JoinColumn(name = "match_id")
//    private CricketMatch matchId;
//
//    public MatchSummary() {
//    }
//
//    public MatchSummary(Integer id, Integer run, Double over, MatchBowlAction action, Player batsMenId, Player bowlerId, CricketMatch matchId) {
//        this.run = run;
//        this.over = over;
//        this.matchBowlAction = action;
//        this.batsMenId = batsMenId;
//        this.bowlerId = bowlerId;
//        this.matchId = matchId;
//    }
//
//    public MatchBowlAction getMatchBowlAction() {
//        return matchBowlAction;
//    }
//
//    public Player getBatsMenId() {
//        return batsMenId;
//    }
//
//    public Player getBowlerId() {
//        return bowlerId;
//    }
//
//    public CricketMatch getMatchId() {
//        return matchId;
//    }
//
//    public Integer getRun() {
//        return run;
//    }
//
//    public Double getOver() {
//        return over;
//    }
//
//    public void setMatchBowlAction(MatchBowlAction matchBowlAction) {
//        this.matchBowlAction = matchBowlAction;
//    }
//
//    public void setBatsMenId(Player batsMenId) {
//        this.batsMenId = batsMenId;
//    }
//
//    public void setBowlerId(Player bowlerId) {
//        this.bowlerId = bowlerId;
//    }
//
//    public void setMatchId(CricketMatch matchId) {
//        this.matchId = matchId;
//    }
//
//    public void setOver(Double over) {
//        this.over = over;
//    }
//
//    public void setRun(Integer run) {
//        this.run = run;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//}
