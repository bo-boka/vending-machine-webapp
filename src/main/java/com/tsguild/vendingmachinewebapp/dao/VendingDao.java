/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachinewebapp.dao;

import com.tsguild.vendingmachinewebapp.dto.Item;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendingDao {

    Item addItem(Item item);

    List<Item> getAllItems();

    Item getItem(int id);

    void removeItem(int id);

    void updateItem(Item item);
    
}
