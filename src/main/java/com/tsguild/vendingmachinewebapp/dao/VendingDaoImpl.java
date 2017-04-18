/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachinewebapp.dao;

import com.tsguild.vendingmachinewebapp.model.Item;
import com.tsguild.vendingmachinewebapp.model.ItemCount;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendingDaoImpl implements VendingDao {

    private HashMap<Integer, Item> items = new HashMap<>();
    
    private static int counter = 0;

    @Override
    public List<Item> getAllItems() {
        Collection<Item> i = items.values();
        return new ArrayList(i);
    }

    @Override
    public Item addItem(Item item) {
        item.setId(counter);
        counter++;
        items.put(item.getId(), item);
        return item;
    }

    @Override
    public void removeItem(int id) {
        items.remove(id);
    }

    @Override
    public Item getItem(int id) {
        return items.get(id);
    }

    @Override
    public void updateItem(Item item) {
        items.put(item.getId(), item);
    }

    @Override
    public List<ItemCount> getItemCounts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
