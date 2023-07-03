package com.mycompany.repository;

import com.mycompany.model.CricketMatch;
import com.mycompany.repository.generic.GenericRepository;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MatchRepository extends GenericRepository<CricketMatch> {

    @PersistenceContext(name = "cricketscorerwebapp")
    private EntityManager entityManager;

    public MatchRepository() {
        super(CricketMatch.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
