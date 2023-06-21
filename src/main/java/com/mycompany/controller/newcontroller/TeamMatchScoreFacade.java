/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller.newcontroller;

import com.mycompany.model.TeamMatchScore;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author prabin
 */
@Stateless
public class TeamMatchScoreFacade extends AbstractFacade<TeamMatchScore> {

    @PersistenceContext(unitName = "cricscorerwebapp")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TeamMatchScoreFacade() {
        super(TeamMatchScore.class);
    }
    
}
