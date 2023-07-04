/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.generic;

import com.mycompany.model.generic.GenericInterface;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author prabin
 * @param <T>
 */
public abstract class GenericRepository<T extends GenericInterface> implements GenericRepositoryInterface<T> {

    private Class<T> entityClass;

    protected abstract EntityManager getEntityManager();

    public GenericRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T saveData(T t) {

        try {
            if (t.getId() != null) {
                getEntityManager().merge(t);
            } else {
                getEntityManager().persist(t);
            }
            return t;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Boolean saveAllData(List<T> t) {
        System.out.println(getEntityManager());

        try {
            for (T t1 : t) {
                getEntityManager().persist(t1);
                getEntityManager().flush();
            }
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage() + e.getClass());
            return Boolean.FALSE;
        }
    }

    @Override
    public List<T> getAllData() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        return getEntityManager().createQuery(criteriaQuery).getResultList() == null
                || getEntityManager().createQuery(criteriaQuery).getResultList().isEmpty() ? new ArrayList<>()
                : getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T getById(Long id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public void removeEntity(T t) {
        getEntityManager().remove(getById(t.getId()));
        getEntityManager().flush();
    }

}
