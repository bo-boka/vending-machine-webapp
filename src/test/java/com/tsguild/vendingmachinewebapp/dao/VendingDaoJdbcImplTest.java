/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachinewebapp.dao;

import com.tsguild.vendingmachinewebapp.model.Item;
import java.util.List;
import junit.framework.Assert;
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
    
    VendingDao instance;
    
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
        instance = factory.getBean("vendingJdbcDao", VendingDao.class);
        JdbcTemplate cleaner = factory.getBean("jdbcTemplateBean", JdbcTemplate.class);
        cleaner.execute("DELETE FROM items WHERE 1=1");
        
    }
    
    
    @After
    public void tearDown() {
    }

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
    
    @Test
    public void testAgainstEmptyDAO() {

        Assert.assertNull("Asking for a non existant item should return null.", instance.getItem(445));
        Assert.assertNotNull("List of all items should not be null.", instance.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' is nonzero with empty DAO.", 0, instance.getAllItems().size());
    }
    
    @Test
    public void testAddOneItem() {
        Item itemToAdd = itemsForTesting[0];
        instance.addItem(itemToAdd);

        Assert.assertEquals("Returned item does not match expected.", itemToAdd, instance.getItem(itemToAdd.getId()));
        Assert.assertNotNull("List of all items should not be null.", instance.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' does not match after adding one item.", 1, instance.getAllItems().size());
        Assert.assertTrue("Returned item in getAllItems does not match expected.", instance.getAllItems().contains(itemToAdd));

    }

    @Test
    public void testUpdateItem() {
        instance.addItem(itemsForTesting[0]);
        similarItems[0].setId(itemsForTesting[0].getId());
        instance.updateItem(similarItems[0]);

        Assert.assertEquals("Updated item get does not match expected.", similarItems[0], instance.getItem(similarItems[0].getId()));
        Assert.assertNotNull("List of all items should not be null.", instance.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' does not match after replacing one item.", 1, instance.getAllItems().size());
        Assert.assertTrue("Returned item in getAllItems does not match expected.", instance.getAllItems().contains(similarItems[0]));
    }

    @Test
    public void testAddMultipleItems() {
        for (Item item : itemsForTesting) {
            instance.addItem(item);
        }

        Assert.assertNotNull("List of all items should not be null.", instance.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' does not match after adding several items.",
                itemsForTesting.length, instance.getAllItems().size());

        for (int i = 0; i < itemsForTesting.length; i++) {
            Assert.assertEquals("Returned item does not match expected.", itemsForTesting[i], instance.getItem(itemsForTesting[i].getId()));
            Assert.assertTrue("Returned item in getAllItems does not match expected.", instance.getAllItems().contains(itemsForTesting[i]));
        }

    }

    @Test
    public void testUpdateMultipleItems() {
        for (Item item : itemsForTesting) {
            instance.addItem(item);
        }

        for (int i = 0; i < itemsForTesting.length; i++) {
            similarItems[i].setId(itemsForTesting[i].getId());
            instance.updateItem(similarItems[i]);
        }

        Assert.assertNotNull("List of all items should not be null.", instance.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' does not match after replacing several items.",
                itemsForTesting.length, instance.getAllItems().size());

        for (int i = 0; i < similarItems.length; i++) {
            Assert.assertEquals("Get item does not match expected return on update.", similarItems[i], instance.getItem(similarItems[i].getId()));
            Assert.assertTrue("Returned item in getAllItems does not match expected.", instance.getAllItems().contains(similarItems[i]));
        }

    }

    @Test
    public void testAddSimilarItems() {
        for (Item item : itemsForTesting) {
            instance.addItem(item);
        }

        for (Item item : similarItems) {
            instance.addItem(item);
        }

        Assert.assertNotNull("List of all items should not be null.", instance.getAllItems());
        Assert.assertEquals("Expected item count does not match after adding several similar items.",
                itemsForTesting.length + similarItems.length, instance.getAllItems().size());
        Assert.assertEquals("Expected item count of 'all items' does not match after adding several similar items.",
                itemsForTesting.length + similarItems.length, instance.getAllItems().size());

        for (int i = 0; i < similarItems.length; i++) {
            Assert.assertEquals("Get item does not match expected return on addition of similar item.", similarItems[i],
                    instance.getItem(similarItems[i].getId()));
            Assert.assertTrue("Returned item in getAllItems does not match expected.", instance.getAllItems().contains(similarItems[i]));
        }

        for (int i = 0; i < itemsForTesting.length; i++) {
            Assert.assertEquals("Get item does not match expected return on addition of similar item.", itemsForTesting[i],
                    instance.getItem(itemsForTesting[i].getId()));
            Assert.assertTrue("Returned item in getAllItems does not match expected.", instance.getAllItems().contains(itemsForTesting[i]));
        }

    }

    @Test
    public void testAddAndRemoveOneItem() {
        instance.addItem(itemsForTesting[0]);
        instance.removeItem(itemsForTesting[0].getId());

        Assert.assertNotNull("List of all items should not be null.", instance.getAllItems());
        Assert.assertNull("Get item should return null after being removed.", instance.getItem(itemsForTesting[0].getId()));
        Assert.assertEquals("Expected item count of 'all items' should be zero when adding/removing a single item.", 0, instance.getAllItems().size());
    }

    @Test
    public void testAddAndRemoveItemTwice() {
        instance.addItem(itemsForTesting[0]);
        instance.removeItem(itemsForTesting[0].getId());
        instance.removeItem(itemsForTesting[0].getId());

        Assert.assertNotNull("List of all items should not be null.", instance.getAllItems());
        Assert.assertNull("Item should return null after being removed.", instance.getItem(itemsForTesting[0].getId()));
        Assert.assertEquals("Expected item count of 'all items' should be zero when adding/removing a single item twice.", 0, instance.getAllItems().size());
    }

    @Test
    public void testAddAndRemoveMultipleItems() {

        for (Item item : itemsForTesting) {
            instance.addItem(item);
        }

        int itemsAdded = itemsForTesting.length;
        for (int i = 0; i < itemsForTesting.length; i += 2) {
            instance.removeItem(itemsForTesting[i].getId());
            itemsAdded--;
        }

        Assert.assertNotNull("List of all items should not be null.", instance.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' does not match after adding & removing several items.",
                itemsAdded, instance.getAllItems().size());

        for (int i = 0; i < itemsForTesting.length; i++) {
            if (i % 2 == 1) {
                Assert.assertEquals("Returned item does not match expected.", itemsForTesting[i], instance.getItem(itemsForTesting[i].getId()));
            } else {
                Assert.assertNull("Item should be removed and return null.", instance.getItem(itemsForTesting[i].getId()));
            }
        }

    }

    @Test
    public void testAddAndRemoveItemsMultipleTimes() {

        for (Item item : itemsForTesting) {
            instance.addItem(item);
        }

        for (Item item : itemsForTesting) {
            instance.removeItem(item.getId());
        }

        for (Item item : itemsForTesting) {
            instance.addItem(item);
        }

        Assert.assertNotNull("List of all items should not be null.", instance.getAllItems());
        Assert.assertEquals("Expected item count of 'all items' should be zero when adding/removing a all items.",
                itemsForTesting.length, instance.getAllItems().size());

        for (int i = 0; i < itemsForTesting.length; i++) {
            Item item = itemsForTesting[i];
            Assert.assertEquals("Item should return after being re-added.", item, instance.getItem(item.getId()));
            instance.removeItem(item.getId());
            Assert.assertNull("Item should return null after being removed.", instance.getItem(item.getId()));
        }

        Assert.assertEquals("Expected item count of 'all items' should be zero when adding/removing a all items.", 0, instance.getAllItems().size());

    }

    @Test
    public void testItemCountOnAddition() {

        // Add all items and check that count increments appropriately
        for (int i = 0; i < itemsForTesting.length; i++) {
            instance.addItem(itemsForTesting[i]);
            Assert.assertEquals("Expected " + (i + 1) + " items after adding items.",
                    i + 1, instance.getAllItems().size());
        }

    }

    @Test
    public void testItemCountOnUpdate() {

        // Add all items and check that count increments appropriately
        for (int i = 0; i < itemsForTesting.length; i++) {
            instance.addItem(itemsForTesting[i]);
            similarItems[i].setId(itemsForTesting[i].getId());
            instance.updateItem(similarItems[i]);
            Assert.assertEquals("Expected " + (i + 1) + " items after updating items.",
                    i + 1, instance.getAllItems().size());
        }

    }

    @Test
    public void testItemCountAfterRemoval() {

        // Add all items
        for (int i = 0; i < itemsForTesting.length; i++) {
            instance.addItem(itemsForTesting[i]);
        }

        // Remove items one by one and test that count decrements properly
        for (int i = 0; i < itemsForTesting.length; i++) {
            instance.removeItem(itemsForTesting[i].getId());
            Assert.assertEquals("Expected " + (itemsForTesting.length - i - 1) + " items after removing items.",
                    itemsForTesting.length - i - 1, instance.getAllItems().size());
        }
    }

    @Test
    public void testItemsAfterRemovalOfNonExistent() {

        // Add all items
        for (int i = 0; i < itemsForTesting.length; i++) {
            instance.addItem(itemsForTesting[i]);
        }

        instance.removeItem(100);
        Assert.assertEquals("Expected " + itemsForTesting.length + " items after removing items.",
                itemsForTesting.length, instance.getAllItems().size());

    }

    @Test
    public void testItemCountAfterTwiceRemoved() {

        // Add all items
        for (int i = 0; i < itemsForTesting.length; i++) {
            instance.addItem(itemsForTesting[i]);
        }

        // Remove items one by one and test that count decrements properly
        for (int i = 0; i < itemsForTesting.length; i++) {
            instance.removeItem(itemsForTesting[i].getId());
        }

        Assert.assertEquals("Expected " + 0 + " items after removing items.",
                0, instance.getAllItems().size());

        // Remove items one by one and test that count decrements properly
        for (int i = 0; i < itemsForTesting.length; i++) {
            instance.removeItem(itemsForTesting[i].getId());
        }

        Assert.assertEquals("Expected " + 0 + " items after attempting to re-remove items.",
                0, instance.getAllItems().size());

    }

}
