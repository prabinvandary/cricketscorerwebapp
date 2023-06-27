/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import com.mycompany.model.generic.GenericAbstractClass;
import com.mycompany.model.generic.GenericInterface;
import com.mycompany.enumvalues.TournamentType;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author prabin
 */
@Entity
@Table(name = "tournament")
public class Tournament extends GenericAbstractClass implements GenericInterface {

    @Enumerated(EnumType.STRING)
    private TournamentType tournamentType;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fromDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date toDate;

    public Tournament() {
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Tournament(Long id, TournamentType tournamentType, Date fromDate, Date toDate) {
        this.setId(id);
        this.tournamentType = tournamentType;
        this.fromDate = fromDate;
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
