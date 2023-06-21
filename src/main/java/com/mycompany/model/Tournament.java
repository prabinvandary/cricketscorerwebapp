/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import cricscorer.enumvalues.TournamentType;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author prabin
 */
@Entity
@Table(name = "tournament")
public class Tournament implements Serializable{

    @Enumerated(EnumType.STRING)
    private TournamentType tournamentType;

    private LocalDate tournamentDate;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Tournament() {
    }

    public Tournament(Long id, TournamentType tournamentType, LocalDate tournamentDate) {
        this.id=id;
        this.tournamentType = tournamentType;
        this.tournamentDate = tournamentDate;
    }

    public TournamentType getTournamentType() {
        return tournamentType;
    }

    public void setTournamentType(TournamentType tournamentType) {
        this.tournamentType = tournamentType;
    }

    public LocalDate getTournamentDate() {
        return tournamentDate;
    }

    public void setTournamentDate(LocalDate tournamentDate) {
        this.tournamentDate = tournamentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
