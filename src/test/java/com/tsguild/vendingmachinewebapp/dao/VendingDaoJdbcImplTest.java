/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachinewebapp.dao;

import com.tsguild.vendingmachinewebapp.dto.Item;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class VendingDaoJdbcImplTest {
    
    VendingDaoJdbcImpl instance;
    
    public VendingDaoJdbcImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext factory = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        instance = factory.getBean("vendingJdbcDao", VendingDaoJdbcImpl.class);
        JdbcTemplate cleaner = factory.getBean("jdbcTemplateBean", JdbcTemplate.class);
        cleaner.execute("DELETE FROM pages WHERE 1=1");
        
        Item[] itemsForTesting = {
            new Item(1, "Nutties", 2.2, 3),
            new Item(2, "Stick o Butter", 6.2, 5),
            new Item(3, "Fruities", 2.6, 7),
            new Item(4, "Eaties", 3.46, 2),
            new Item(5, "Nom Noms", 6.1, 11),
            new Item(6, "Munchies", 4.8, 9),
            new Item(7, "Yummies", 2.44, 14),
            new Item(8, "Sweetums", 1.62, 8),
            new Item(9, "Tasties", 5.97, 23),
            new Item(10, "Omnoms", 3.04, 46),
            new Item(11, "Crunchos", 2.69, 5),
            new Item(12, "Chompies", 7.5, 28),
        };
        
        Item[] duplicateItems = {
            new Item(1, "Nutties", 2.2, 3),
            new Item(2, "Stick o Butter", 6.2, 5),
            new Item(3, "Fruities", 2.6, 7),
            new Item(4, "Eaties", 3.46, 2),
            new Item(5, "Nom Noms", 6.1, 11),
            new Item(6, "Munchies", 4.8, 9),
            new Item(7, "Yummies", 2.44, 14),
            new Item(8, "Sweetums", 1.62, 8),
            new Item(9, "Tasties", 5.97, 23),
            new Item(10, "Omnoms", 3.04, 46),
            new Item(11, "Crunchos", 2.69, 5),
            new Item(12, "Chompies", 7.5, 28),
        };
        
        Item[] similarItems = {
            new Item(1, "Nuties", 2.2, 3),
            new Item(2, "Stick o Butter", 5.2, 5),
            new Item(3, "Fraties", 2.6, 7),
            new Item(4, "Eatiez", 3.46, 2),
            new Item(5, "Nom Nomz", 6.1, 11),
            new Item(6, "Moonchies", 4.8, 9),
            new Item(7, "Yammies", 2.44, 14),
            new Item(8, "Sweetums", 1.2, 8),
            new Item(9, "Taties", 5.97, 23),
            new Item(10, "Omnoms", 3.44, 46),
            new Item(11, "Cranchos", 2.69, 5),
            new Item(12, "Chompzies", 7.5, 28),
        };
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of addItem method, of class VendingDaoJdbcImpl.
     */
    @Test
    public void testAddItem() {
        
        Item testItem = new Item(-1, "Eat Emz", 3.3, 12);
        instance.addItem(testItem);
        Item retrieveTestItem = instance.getItem(testItem.getId());
        assertEquals("item stored is same as retrieved item", testItem, retrieveTestItem);
        
    }

    
//    @Test
//    public void testGetAllItems() {
//        System.out.println("getAllItems");
//        VendingDaoJdbcImpl instance = new VendingDaoJdbcImpl();
//        List<Item> expResult = null;
//        List<Item> result = instance.getAllItems();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getItem method, of class VendingDaoJdbcImpl.
//     */
//    @Test
//    public void testGetItem() {
//        System.out.println("getItem");
//        int id = 0;
//        VendingDaoJdbcImpl instance = new VendingDaoJdbcImpl();
//        Item expResult = null;
//        Item result = instance.getItem(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeItem method, of class VendingDaoJdbcImpl.
//     */
//    @Test
//    public void testRemoveItem() {
//        System.out.println("removeItem");
//        int id = 0;
//        VendingDaoJdbcImpl instance = new VendingDaoJdbcImpl();
//        instance.removeItem(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateItem method, of class VendingDaoJdbcImpl.
//     */
//    @Test
//    public void testUpdateItem() {
//        System.out.println("updateItem");
//        Item item = null;
//        VendingDaoJdbcImpl instance = new VendingDaoJdbcImpl();
//        instance.updateItem(item);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
