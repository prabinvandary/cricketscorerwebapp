/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.enumvalues;

import com.mycompany.model.Tournament;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author prabin
 */
@Stateless
public class TournamentFacade extends AbstractFacade<Tournament> {

    @PersistenceContext(unitName = "cricscorerwebapp")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TournamentFacade() {
        super(Tournament.class);
    }
    
}
