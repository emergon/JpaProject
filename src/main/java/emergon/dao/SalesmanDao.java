/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.dao;

import emergon.entity.Salesman;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class SalesmanDao extends JpaUtil<Salesman>{
    
    public List<Salesman> findAll(){
        return super.findAll("SELECT c FROM Salesman c");
    }
    
    public List<Salesman> findAllWithNamedQuery(){
        List<Salesman> list;
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("Salesman.findAll");//We must give a NamedQuery to EntityManager
        list = query.getResultList();
        closeEntityManager();
        return list;
    }
    
    @Override
    public Salesman save(Salesman salesman){
        return super.save(salesman);
    }
    
    public Salesman find(int id){
        return super.find(Salesman.class, id);
    }
    
    @Override
    public Salesman update(Salesman c){
        return super.update(c);
    }
    
    public void delete(int id){
        super.delete(Salesman.class, id);
    }
    
}
