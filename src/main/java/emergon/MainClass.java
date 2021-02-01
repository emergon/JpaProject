package emergon;

import emergon.dao.CustomerDao;
import emergon.dao.JpaUtil;
import emergon.dao.SalesmanDao;
import emergon.entity.Customer;
import emergon.entity.Family;
import emergon.entity.Salesman;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * @author user
 */
public class MainClass {

    public static void main(String[] args) {
        //printSalesmen();
        Salesman s = new Salesman("Panagiotis", "Manh", 10.5);
        Family son = new Family("Jack", "son", LocalDate.of(2015, Month.MARCH, 2));
        Family daughter = new Family("July", "daughter", LocalDate.of(2015, Month.MARCH, 2));
//        List<Family> members = new ArrayList();
//        members.add(son);
//        members.add(daughter);
//        s.setFamilyMembers(members);
        s.addFamilyMember(son);
        s.addFamilyMember(daughter);
        SalesmanDao sdao = new SalesmanDao();
        sdao.save(s);
        JpaUtil.closeEmf();
    }
    
    public static void printSalesmen(){
        SalesmanDao sdao = new SalesmanDao();
        List<Salesman> list = sdao.findAllWithNamedQuery();
        for(Salesman s: list){
            System.out.println(s);
        }
    }

    public void customerPlaying() {
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
    }

}
