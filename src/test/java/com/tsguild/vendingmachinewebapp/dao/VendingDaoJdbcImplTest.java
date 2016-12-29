///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.tsguild.vendingmachinewebapp.dao;
//
//import com.tsguild.vendingmachinewebapp.dto.Item;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.springframework.jdbc.core.JdbcTemplate;
//
///**
// *
// * @author apprentice
// */
//public class VendingDaoJdbcImplTest {
//    
//    public VendingDaoJdbcImplTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of setJdbcTemplate method, of class VendingDaoJdbcImpl.
//     */
//    @Test
//    public void testSetJdbcTemplate() {
//        System.out.println("setJdbcTemplate");
//        JdbcTemplate jdbcTemplate = null;
//        VendingDaoJdbcImpl instance = new VendingDaoJdbcImpl();
//        instance.setJdbcTemplate(jdbcTemplate);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addItem method, of class VendingDaoJdbcImpl.
//     */
//    @Test
//    public void testAddItem() {
//        System.out.println("addItem");
//        Item item = null;
//        VendingDaoJdbcImpl instance = new VendingDaoJdbcImpl();
//        Item expResult = null;
//        Item result = instance.addItem(item);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAllItems method, of class VendingDaoJdbcImpl.
//     */
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
//    
//}
