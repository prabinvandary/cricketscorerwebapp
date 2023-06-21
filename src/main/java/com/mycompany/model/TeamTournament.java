///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.model;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
///**
// *
// * @author prabin
// */
////@Table(name = "team_tournament")
//
//public class TeamTournament implements Serializable {
//
//    @Id
//    @SequenceGenerator(sequenceName = "team_tournament_seq_gen", name = "team_tournament_seq_gen", allocationSize = 1)
//    @GeneratedValue(generator = "team_tournament_seq_gen", strategy = GenerationType.SEQUENCE)
//    @Column(name = "id")
//    private Long id;
//    @ManyToOne
////    @Column(name="team_id")
////    @JoinColumn(name = "team_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_Team_Tournament"))
//    @JoinColumn(name = "team_id")
//
//    private Team team;
//    @ManyToOne
////    @Column(name="tournament_id")
////    @JoinColumn(name = "tournament_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_Tournament_Team"))
//    @JoinColumn(name = "tournament_id")
//    private Tournament tournamentId;
//
//    public TeamTournament() {
//    }
//
//    public TeamTournament(Integer id, Team teamId, Tournament tournamentId) {
//        this.team = teamId;
//        this.tournamentId = tournamentId;
//    }
//
//    public Team getTeam() {
//        return team;
//    }
//
//    public Tournament getTournamentId() {
//        return tournamentId;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
//
//    public void setTournamentId(Tournament tournamentId) {
//        this.tournamentId = tournamentId;
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
