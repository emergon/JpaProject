package emergon;

import emergon.dao.CustomerDao;
import emergon.dao.JpaUtil;
import emergon.entity.Customer;
import java.util.List;

/**
 * @author user
 */
public class MainClass {

    public static void main(String[] args) {

        CustomerDao cdao = new CustomerDao();
        Customer customer1 = new Customer("Jack");
        cdao.save(customer1);

        List<Customer> customers = cdao.findAll();
        for (Customer c : customers) {
            System.out.println(">>" + c);
        }

        Customer temp = cdao.find(100123);
        System.out.println(">>>>>>>>" + temp);
//        temp.setCname("Peter");
//        temp = cdao.update(temp);
//        System.out.println("After Update");
//        //temp = cdao.find(100123);
//        System.out.println(">>>>>>>"+temp);
        System.out.println("Deleting 100123");
        cdao.delete(100123);
        System.out.println("Printing Customers after Deletion!!!!");
        customers = cdao.findAll();
        for (Customer c : customers) {
            System.out.println(">>" + c);
        }
        JpaUtil.closeEmf();
    }

}
