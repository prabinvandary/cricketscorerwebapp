///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.model;
//
//import cricscorer.enumvalues.TournamentType;
//import java.time.LocalDate;
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
///**
// *
// * @author prabin
// */
////@Entity
//@Table(name = "tournament")
//public class Tournament implements Serializable {
//
//    @Id
//    @SequenceGenerator(sequenceName = "tournament_seq_gen", name = "tournament_seq_gen", allocationSize = 1)
//    @GeneratedValue(generator = "tournament_seq_gen", strategy = GenerationType.SEQUENCE)
//    @Column(name = "id")
//    private Long id;
//    @Enumerated(EnumType.STRING)
//    @Column(name = "tournament_type")
//    private TournamentType tournamentType;
//    
//    @Column(name = "tournament_date")
//    private LocalDate tournamentDate;
//
//    public Tournament() {
//    }
//
//    public Tournament(Integer id, TournamentType type, LocalDate date) {
//        this.tournamentType = type;
//        this.tournamentDate = date;
//    }
//
//    public LocalDate getTournamentDate() {
//        return tournamentDate;
//    }
//
//    public TournamentType getTournamentType() {
//        return tournamentType;
//    }
//
//    public void setTournamentDate(LocalDate tournamentDate) {
//        this.tournamentDate = tournamentDate;
//    }
//
//    public void setTournamentType(TournamentType tournamentType) {
//        this.tournamentType = tournamentType;
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
