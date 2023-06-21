///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.model;
//
//import cricscorer.enumvalues.PlayerPosition;
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
//@Table(name = "player_team_tournament")
//public class PlayerTeamTournament implements Serializable {
//
//    @Id
//    @SequenceGenerator(sequenceName = "player_team_seq_gen", name = "player_team_seq_gen", allocationSize = 1)
//    @GeneratedValue(generator = "player_team_seq_gen", strategy = GenerationType.SEQUENCE)
//    @Column(name = "id")
//    private Long id;
//    @OneToOne
////    @Column(name= "team_tournament_id")
////    @JoinColumn(name = "team_tournament_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_Team_Tournament_Player"))
//    @JoinColumn(name = "team_tournament_id")
//
//    private TeamTournament teamTournamentId;
//    @OneToOne
////    @Column(name = "player_id")
////    @JoinColumn(name = "player_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_Player_Team_Tournament"))
//    @JoinColumn(name = "player_id")
//    private Player playerId;
//    @Enumerated(EnumType.STRING)
//    @Column(name = "position")
//    private PlayerPosition position;
//    @Column(name = "is_wicketkeeper")
//    private Boolean isWicketKeeper;
//
//    public PlayerTeamTournament() {
//    }
//
//    public PlayerTeamTournament(Integer id, TeamTournament teamTournamentId, Player playerId, PlayerPosition position, Boolean isWicketKeeper) {
//        this.teamTournamentId = teamTournamentId;
//        this.playerId = playerId;
//        this.position = position;
//        this.isWicketKeeper = isWicketKeeper;
//    }
//
//    public Player getPlayerId() {
//        return playerId;
//    }
//
//    public Boolean getIsWicketKeeper() {
//        return isWicketKeeper;
//    }
//
//    public TeamTournament getPlayerTeamTournamentId() {
//        return teamTournamentId;
//    }
//
//    public PlayerPosition getPosition() {
//        return position;
//    }
//
//    public void setIsWicketKeeper(Boolean isWicketKeeper) {
//        this.isWicketKeeper = isWicketKeeper;
//    }
//
//    public void setPlayerId(Player playerId) {
//        this.playerId = playerId;
//    }
//
//    public void setPlayerTeamTournamentId(TeamTournament teamTournamentId) {
//        this.teamTournamentId = teamTournamentId;
//    }
//
//    public void setPosition(PlayerPosition position) {
//        this.position = position;
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
