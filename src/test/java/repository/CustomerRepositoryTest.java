/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.mycompany.smartlaundry.app.conf.ConnectionConfig;
import com.mycompany.smartlaundry.domain.Contact;
import com.mycompany.smartlaundry.domain.Customer;
import com.mycompany.smartlaundry.domain.CustomerOrder;
import com.mycompany.smartlaundry.domain.DeliveryLog;
import com.mycompany.smartlaundry.domain.Demographic;
import com.mycompany.smartlaundry.domain.Name;
import com.mycompany.smartlaundry.repository.CustomerRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.derby.client.am.DateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author Khanya
 */
public class CustomerRepositoryTest {
    
    private static ApplicationContext ctx;
    private CustomerRepository repo;
    private Long id;
    
    public CustomerRepositoryTest() {
    
        repo = ctx.getBean(CustomerRepository.class);
        
        DeliveryLog delivery = new DeliveryLog.Builder("true").deliveryTime(Calendar.getInstance()).build();
        
        List<DeliveryLog> deliveries = new ArrayList<>();
        deliveries.add(delivery);
        
        List<CustomerOrder> orders = new ArrayList<>();
        CustomerOrder order = new CustomerOrder.Builder("1221").fine(BigDecimal.ZERO).deliveryLog(deliveries).build();
        orders.add(order);
        
        Name nam = new Name.Builder("Khanya").lastname("Mvumbi").build();
        Demographic demo = new Demographic.Builder("male").race("Black").build();
        Contact con = new Contact.Builder("0783732323").address("27 Mdundu street").phone("0414628119").build();
        Customer cust = new Customer.Builder("staySoft").contact(con).demographic(demo).name(nam).orders(orders).build();
        
        repo.save(cust);
        id = cust.getCustomerId();
        Assert.assertNotNull(id);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
