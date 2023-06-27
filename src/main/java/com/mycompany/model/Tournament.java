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
public class Tournament extends GenericAbstractClass implements GenericInterface {

    @Enumerated(EnumType.STRING)
    private TournamentType tournamentType;

    private LocalDate fromDate;

    private LocalDate toDate;

    public Tournament() {
    }

    public Tournament(Long id, TournamentType tournamentType, LocalDate fromDate, LocalDate toDate) {
        this.setId(id);
        this.tournamentType = tournamentType;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public TournamentType getTournamentType() {
        return tournamentType;
    }

    public void setTournamentType(TournamentType tournamentType) {
        this.tournamentType = tournamentType;
    }

    @Override
    public String getTableName() {
        return "tournament";
    }
}
