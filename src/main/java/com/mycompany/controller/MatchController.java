/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.model.CricketMatch;
import com.mycompany.repository.MatchRepository;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author prabin
 */
@Named
@ViewScoped
public class MatchController implements Serializable {

    @Inject
    private MatchRepository matchRepository;

    private CricketMatch cricketMatch;

    public CricketMatch getCricketMatch() {
        return cricketMatch;
    }

    public void setCricketMatch(CricketMatch cricketMatch) {
        this.cricketMatch = cricketMatch;
    }

    @PostConstruct
    public void init() {
        cricketMatch = new CricketMatch();
    }

    public void beforeCreate() {
        cricketMatch = new CricketMatch();
    }

    public void saveCricketMatch() {
        cricketMatch=matchRepository.saveData(cricketMatch);
         if (cricketMatch != null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Crickt match save successful.",
                            " Cricket match saved successfully"));

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            " Cricket matcch save unsuccessful.",
                            "Cricket match is not saved."));

        }
        cricketMatch = new CricketMatch();
    }

    public void onTournamentChange() {
        this.cricketMatch.getTournament();
    }
}
