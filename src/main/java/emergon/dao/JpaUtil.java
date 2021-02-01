/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.dao;

import emergon.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class JpaUtil<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;

    private static EntityManagerFactory getEmf() {
        if (emf == null) {
            System.out.println("------ Opening EntityManagerFactory-------");
            emf = Persistence.createEntityManagerFactory("JpaProjectPU");//One for all the project
        }
        return emf;
    }

    public static void closeEmf() {
        System.out.println("------ Closing EntityManagerFactory-------");
        emf.close();
    }

    protected EntityManager getEntityManager() {
        em = getEmf().createEntityManager();//One for each connection to DB
        return em;
    }
    
    protected void closeEntityManager(){
        em.close();
    }
    
    //Methods for CRUD operations
    protected List<E> findAll(String query){
        getEntityManager();
        Query myQuery = em.createQuery(query);
        List<E> list = myQuery.getResultList();
        closeEntityManager();
        return list;
    }
    
    protected E save(E entity){
        em = getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        closeEntityManager();
        return entity;
    }
    
    protected E find(Class<E> type, int id){
        em = getEntityManager();
        E e = em.find(type, id);
        closeEntityManager();
        return e;
    }
    
    protected E update(E e){
        em = getEntityManager();
        em.getTransaction().begin();
        e = em.merge(e);
        em.getTransaction().commit();
        closeEntityManager();
        return e;
    }
    
    public void delete(Class<E> type, int id){
        em = getEntityManager();
        em.getTransaction().begin();
        E e = em.find(type, id);
        em.remove(e);
        em.getTransaction().commit();
        closeEntityManager();
    }
    
    
}
