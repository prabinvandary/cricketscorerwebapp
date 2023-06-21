/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.controller.exceptions.NonexistentEntityException;
import com.mycompany.controller.exceptions.RollbackFailureException;
import com.mycompany.model.TeamMatchScore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author prabin
 */
public class TeamMatchScoreJpaController implements Serializable {

    public TeamMatchScoreJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TeamMatchScore teamMatchScore) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(teamMatchScore);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TeamMatchScore teamMatchScore) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            teamMatchScore = em.merge(teamMatchScore);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = teamMatchScore.getId();
                if (findTeamMatchScore(id) == null) {
                    throw new NonexistentEntityException("The teamMatchScore with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            TeamMatchScore teamMatchScore;
            try {
                teamMatchScore = em.getReference(TeamMatchScore.class, id);
                teamMatchScore.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The teamMatchScore with id " + id + " no longer exists.", enfe);
            }
            em.remove(teamMatchScore);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TeamMatchScore> findTeamMatchScoreEntities() {
        return findTeamMatchScoreEntities(true, -1, -1);
    }

    public List<TeamMatchScore> findTeamMatchScoreEntities(int maxResults, int firstResult) {
        return findTeamMatchScoreEntities(false, maxResults, firstResult);
    }

    private List<TeamMatchScore> findTeamMatchScoreEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TeamMatchScore.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TeamMatchScore findTeamMatchScore(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TeamMatchScore.class, id);
        } finally {
            em.close();
        }
    }

    public int getTeamMatchScoreCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TeamMatchScore> rt = cq.from(TeamMatchScore.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
