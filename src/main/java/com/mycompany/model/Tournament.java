/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass;
import com.mycompany.model.generic.GenericInterface;
import com.mycompany.enumvalues.TournamentType;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author prabin
 */
@Entity
@Table(name = "tournament")
public class Tournament extends GenericAbstractClass implements GenericInterface{

    @Enumerated(EnumType.STRING)
    private TournamentType tournamentType;

    private LocalDate tournamentDate;

    public Tournament() {
    }

    public Tournament(Long id, TournamentType tournamentType, LocalDate tournamentDate) {
        this.setId(id);
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
    
    @Override
    public String getTableName() {
        return "tournament";
    }
}
