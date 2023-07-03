/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.model.CricketMatch;
import com.mycompany.repository.MatchRepository;
import java.io.Serializable;
import javax.annotation.PostConstruct;
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
        matchRepository.saveData(cricketMatch);
        cricketMatch = new CricketMatch();
    }
}
