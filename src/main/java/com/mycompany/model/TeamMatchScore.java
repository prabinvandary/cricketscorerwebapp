///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.model;
//
//import cricscorer.enumvalues.TossAction;
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
//@Entity
//@Table(name = "team_match_score")
//public class TeamMatchScore implements Serializable {
//
//    @Id
//    @SequenceGenerator(sequenceName = "team_match_score_seq_gen", name = "team_match_score_seq_gen", allocationSize = 1)
//    @GeneratedValue(generator = "team_match_score_seq_gen", strategy = GenerationType.SEQUENCE)
//    @Column(name = "id")
//    private Long id;
//    @OneToOne
////    @Column(name="team_id")
////    @JoinColumn(name = "team_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_Team_Match_Score"))
//    @JoinColumn(name = "team_id")
//
//    private Team teamId;
//    @Column(name = "score")
//    private Integer score;
//    @OneToOne
////    @Column(name="match_id")
////    @JoinColumn(name = "match_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_Match_Team_Score"))
//    @JoinColumn(name = "match_id")
//
//    private CricketMatch matchId;
//    @Column(name = "is_winner")
//    private Boolean isWinner;
//    @Column(name = "toss_action")
//    @Enumerated(EnumType.STRING)
//    private TossAction tossAction;
//
//    public TeamMatchScore() {
//    }
//
//    public TeamMatchScore(Integer id, Team teamId, Integer score, CricketMatch matchId, Boolean isWinner, TossAction tossAction) {
//        this.teamId = teamId;
//        this.score = score;
//        this.matchId = matchId;
//        this.isWinner = isWinner;
//        this.tossAction = tossAction;
//    }
//
//    public Boolean getIsWinner() {
//        return isWinner;
//    }
//
//    public CricketMatch getMatchId() {
//        return matchId;
//    }
//
//    public Integer getScore() {
//        return score;
//    }
//
//    public Team getTeamId() {
//        return teamId;
//    }
//
//    public TossAction getTossAction() {
//        return tossAction;
//    }
//
//    public void setIsWinner(Boolean isWinner) {
//        this.isWinner = isWinner;
//    }
//
//    public void setMatchId(CricketMatch matchId) {
//        this.matchId = matchId;
//    }
//
//    public void setScore(Integer score) {
//        this.score = score;
//    }
//
//    public void setTeamId(Team teamId) {
//        this.teamId = teamId;
//    }
//
//    public void setTossAction(TossAction tossAction) {
//        this.tossAction = tossAction;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//}
