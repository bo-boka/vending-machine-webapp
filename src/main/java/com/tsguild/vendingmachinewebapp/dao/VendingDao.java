/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachinewebapp.dao;

import com.tsguild.vendingmachinewebapp.model.Item;
import com.tsguild.vendingmachinewebapp.model.ItemCount;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public interface VendingDao {

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    Item addItem(Item item);

    List<Item> getAllItems();

    Item getItem(int id);

    void removeItem(int id);

    void updateItem(Item item);
    
    List<ItemCount> getItemCounts();
    
}
