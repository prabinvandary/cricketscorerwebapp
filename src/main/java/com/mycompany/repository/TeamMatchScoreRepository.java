/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.model.CricketMatch;
import com.mycompany.model.Team;
import com.mycompany.model.TeamMatchScore;
import com.mycompany.repository.generic.GenericRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author prabin
 */
public class TeamMatchScoreRepository extends GenericRepository<TeamMatchScore> {

    @PersistenceContext(name = "cricketscorerwebapp")
    private static EntityManager entityManager;

    public TeamMatchScoreRepository() {
        super(TeamMatchScore.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public TeamMatchScore getByMatch(CricketMatch cricketMatch,Team team) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TeamMatchScore> cq = cb.createQuery(TeamMatchScore.class);
        Root<TeamMatchScore> root = cq.from(TeamMatchScore.class);
        Predicate predicateForTeam=cb.equal(root.get("team"),team);
        Predicate predicateCricketMatch=cb.equal(root.get("cricketMatch"), cricketMatch);
        Predicate finalPredicate=cb.and(predicateForTeam, predicateCricketMatch);
        cq.where(finalPredicate);
        TypedQuery<TeamMatchScore> query = entityManager.createQuery(cq);
        return query.getSingleResult();
    }

}
