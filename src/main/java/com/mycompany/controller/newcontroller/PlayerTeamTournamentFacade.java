/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller.newcontroller;

import com.mycompany.model.PlayerTeamTournament;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author prabin
 */
@Stateless
public class PlayerTeamTournamentFacade extends AbstractFacade<PlayerTeamTournament> {

    @PersistenceContext(unitName = "cricscorerwebapp")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlayerTeamTournamentFacade() {
        super(PlayerTeamTournament.class);
    }
    
}