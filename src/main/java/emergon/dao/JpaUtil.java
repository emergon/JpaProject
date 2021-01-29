/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.dao;

import emergon.entity.Customer;
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

    public EntityManager getEntityManager() {
        em = getEmf().createEntityManager();//One for each connection to DB
        return em;
    }
    
    public void closeEntityManager(){
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
}
