/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.mycompany.smartlaundry.app.conf.ConnectionConfig;
import com.mycompany.smartlaundry.domain.Category;
import com.mycompany.smartlaundry.repository.CategoryRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Khanya
 */
public class CategoryRepositoryTest {
    
    private static ApplicationContext ctx;
    private CategoryRepository repo;
    private Long id;
    
    public CategoryRepositoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreate() {
        repo = ctx.getBean(CategoryRepository.class);
        Category cat = new Category.Builder("Clothes")
                .rate(50.00)
                .build();
        repo.save(cat);
        id = cat.getId();
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
