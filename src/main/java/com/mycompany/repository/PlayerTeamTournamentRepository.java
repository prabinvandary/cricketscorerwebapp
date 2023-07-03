/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.model.PlayerTeamTournament;
import com.mycompany.model.TeamTournament;
import com.mycompany.repository.generic.GenericRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author prabin
 */
@Stateless
public class PlayerTeamTournamentRepository extends GenericRepository<PlayerTeamTournament> {

    @PersistenceContext(name = "cricketscorerwebapp")
    private EntityManager entityManager;

    public PlayerTeamTournamentRepository() {
        super(PlayerTeamTournament.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

//    public List<PlayerTeamTournament> getAllPlayerTeamTournamentByTournamentId(Long teamId) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<PlayerTeamTournament> cq = cb.createQuery(PlayerTeamTournament.class);
//        Root<PlayerTeamTournament> ptt = cq.from(PlayerTeamTournament.class);
//        Join<PlayerTeamTournament, TeamTournament> tt = ptt.join("teamTournament");
//        cq.where(cb.equal(tt.get("team"), teamId));
//        TypedQuery<PlayerTeamTournament> query = entityManager.createQuery(cq);
//        List<PlayerTeamTournament> listOfData = query.getResultList();
//        return listOfData;
//    }

    public List<PlayerTeamTournament> getAllPlayerTeamTournamentByTournamentId(Long teamTournamentId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PlayerTeamTournament> cq = cb.createQuery(PlayerTeamTournament.class);
        Root<PlayerTeamTournament> root = cq.from(PlayerTeamTournament.class);
        cq.where(cb.equal(root.get("teamTournament").get("id"), teamTournamentId));
        TypedQuery<PlayerTeamTournament> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
