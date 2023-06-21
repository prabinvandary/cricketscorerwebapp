/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.controller.exceptions.NonexistentEntityException;
import com.mycompany.controller.exceptions.RollbackFailureException;
import com.mycompany.model.PlayerTeamTournament;
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
public class PlayerTeamTournamentJpaController implements Serializable {

    public PlayerTeamTournamentJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PlayerTeamTournament playerTeamTournament) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(playerTeamTournament);
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

    public void edit(PlayerTeamTournament playerTeamTournament) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            playerTeamTournament = em.merge(playerTeamTournament);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = playerTeamTournament.getId();
                if (findPlayerTeamTournament(id) == null) {
                    throw new NonexistentEntityException("The playerTeamTournament with id " + id + " no longer exists.");
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
            PlayerTeamTournament playerTeamTournament;
            try {
                playerTeamTournament = em.getReference(PlayerTeamTournament.class, id);
                playerTeamTournament.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The playerTeamTournament with id " + id + " no longer exists.", enfe);
            }
            em.remove(playerTeamTournament);
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

    public List<PlayerTeamTournament> findPlayerTeamTournamentEntities() {
        return findPlayerTeamTournamentEntities(true, -1, -1);
    }

    public List<PlayerTeamTournament> findPlayerTeamTournamentEntities(int maxResults, int firstResult) {
        return findPlayerTeamTournamentEntities(false, maxResults, firstResult);
    }

    private List<PlayerTeamTournament> findPlayerTeamTournamentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PlayerTeamTournament.class));
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

    public PlayerTeamTournament findPlayerTeamTournament(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PlayerTeamTournament.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlayerTeamTournamentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PlayerTeamTournament> rt = cq.from(PlayerTeamTournament.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
