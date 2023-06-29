/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.model.Player;
import com.mycompany.model.PlayerTeamTournament;
import com.mycompany.repository.generic.GenericRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author prabin
 */
public class PlayerTeamTournamentRepository extends GenericRepository<PlayerTeamTournament> {
    @PersistenceContext(name = "cricketscorerwebapp")
    private static EntityManager entityManager;


    public PlayerTeamTournamentRepository() {
        super(PlayerTeamTournament.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }



  
}
