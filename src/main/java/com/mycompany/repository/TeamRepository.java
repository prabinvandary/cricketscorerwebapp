/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.model.Team;
import com.mycompany.repository.generic.GenericRepository;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author prabin
 */
@Stateless
public class TeamRepository extends GenericRepository<Team> {

    @PersistenceContext(name = "cricketscorerwebapp")
    private EntityManager entityManager;

    public TeamRepository() {
        super(Team.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
