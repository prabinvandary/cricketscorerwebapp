/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.model.TeamTournament;
import com.mycompany.repository.generic.GenericRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author prabin
 */
@Stateless
public class TeamTournamentRepository extends GenericRepository<TeamTournament> {

    @PersistenceContext(name = "cricketscorerwebapp")
    private EntityManager entityManager;

    public TeamTournamentRepository() {
        super(TeamTournament.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public List<TeamTournament> getTeamTournamentsByTournamentId(Long tournamentId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TeamTournament> cq = cb.createQuery(TeamTournament.class);
        Root<TeamTournament> root = cq.from(TeamTournament.class);
        cq.where(cb.equal(root.get("tournament").get("id"), tournamentId));
        TypedQuery<TeamTournament> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
