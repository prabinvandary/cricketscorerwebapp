package com.mycompany.repository;

import com.mycompany.model.MatchSummary;
import com.mycompany.model.Player;
import com.mycompany.repository.generic.GenericRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MatchSummaryRepository extends GenericRepository<MatchSummary, Long> {
 
    @PersistenceContext(name = "cricketscorerwebapp")
    private static EntityManager entityManager;


    public MatchSummaryRepository() {
        super(MatchSummary.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

 
}
