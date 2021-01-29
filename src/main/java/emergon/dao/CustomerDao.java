/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.dao;

import emergon.entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author user
 */
public class CustomerDao extends JpaUtil<Customer>{
    
    public List<Customer> findAll(){
        return super.findAll("SELECT c FROM Customer c");
    }
    
    public Customer save(Customer customer){
        //save object in DB
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        closeEntityManager();
        return customer;
    }
    
}
