package emergon;

import emergon.dao.CustomerDao;
import emergon.dao.JpaUtil;
import emergon.entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/** @author user */
public class MainClass {

    public static void main(String[] args) {
        
        
        CustomerDao cdao = new CustomerDao();
        List<Customer> customers = cdao.findAll();
        for(Customer c: customers){
            System.out.println(">>"+c);
        }
        JpaUtil.closeEmf();
    }

}
