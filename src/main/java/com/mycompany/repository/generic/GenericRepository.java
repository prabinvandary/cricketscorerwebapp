/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.generic;

import com.mycompany.model.generic.GenericInterface;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author prabin
 * @param <T>
 * @param <ID>
 */
public abstract class GenericRepository<T extends GenericInterface, ID> implements GenericRepositoryInterface<T, ID> {

    private Class<T> entityClass;

    protected abstract EntityManager getEntityManager();

    public GenericRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Boolean saveData(T t) {
        try {
            getEntityManager().persist(t);
            System.out.println("Data saved successfully.");
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public Boolean saveAllData(List<T> t) {
        System.out.println(getEntityManager());

        try {
            for (T t1 : t) {
                getEntityManager().persist(t1);
                System.out.println("Data saved successfully.");
            }
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage() + e.getClass());
            System.out.println("Data save failed.");
            return Boolean.FALSE;
        }
    }

    @Override
    public List<T> getAllData() {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T getById(Long id) {
        System.out.println("Data fetched successfully.");
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public Boolean deleteById(ID id) {
        return true;
    }

}
