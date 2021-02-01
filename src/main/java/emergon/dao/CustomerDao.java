/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.dao;

import emergon.entity.Customer;
import java.util.List;

/**
 *
 * @author user
 */
public class CustomerDao extends JpaUtil<Customer>{
    
    public List<Customer> findAll(){
        return super.findAll("SELECT c FROM Customer c");
    }
    
    @Override
    public Customer save(Customer customer){
        return super.save(customer);
    }
    
    public Customer find(int id){
        return super.find(Customer.class, id);
    }
    
    @Override
    public Customer update(Customer c){
        return super.update(c);
    }
    
    public void delete(int id){
        super.delete(Customer.class, id);
    }
    
}
