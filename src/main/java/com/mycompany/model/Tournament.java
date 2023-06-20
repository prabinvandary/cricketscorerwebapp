/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import cricscorer.enumvalues.TournamentType;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author prabin
 */
@Entity(name = "tournament")
@Table
public class Tournament implements Serializable {

    @Id
    private Long id;
    private TournamentType type;
    private LocalDate tournamentDate;

    public Tournament() {
    }

    public Tournament(Integer id, TournamentType type, LocalDate date) {
        this.type = type;
        this.tournamentDate = date;
    }

    public LocalDate getTournamentDate() {
        return tournamentDate;
    }

    public TournamentType getType() {
        return type;
    }

    public void setTournamentDate(LocalDate tournamentDate) {
        this.tournamentDate = tournamentDate;
    }

    public void setType(TournamentType type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
