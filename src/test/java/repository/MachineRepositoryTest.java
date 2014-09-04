/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.mycompany.smartlaundry.app.conf.ConnectionConfig;
import com.mycompany.smartlaundry.domain.Machine;
import com.mycompany.smartlaundry.repository.MachineRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Khanya
 */
public class MachineRepositoryTest {
    
    private static ApplicationContext ctx;
    private MachineRepository repo;
    private Long id;
    
    public MachineRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreate() {
        repo = ctx.getBean(MachineRepository.class);
        
        Machine machine = new Machine.Builder("Toshiba").capacity(2).duration(4).last_service_date("09/05/14").machine_type("washing").build();
        
        repo.save(machine);
        id = machine.getId();
        Assert.assertNotNull(id);
    
    }

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
