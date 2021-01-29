package emergon;

import emergon.dao.CustomerDao;
import emergon.dao.JpaUtil;
import emergon.entity.Customer;
import java.util.List;

/** @author user */
public class MainClass {

    public static void main(String[] args) {
        
        
        CustomerDao cdao = new CustomerDao();
        Customer customer1 = new Customer("Jack");
        cdao.save(customer1);
        
        List<Customer> customers = cdao.findAll();
        for(Customer c: customers){
            System.out.println(">>"+c);
        }
        JpaUtil.closeEmf();
    }

}
