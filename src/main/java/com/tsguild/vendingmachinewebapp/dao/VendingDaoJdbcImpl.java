/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachinewebapp.dao;

import com.tsguild.vendingmachinewebapp.model.Item;
import com.tsguild.vendingmachinewebapp.model.ItemCount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
public class VendingDaoJdbcImpl implements VendingDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_ADD_ITEM = "INSERT INTO Items (`name`, `cost`, `inventory`, `image_url`)\n"
            + "		VALUES (?, ?, ?, ?)";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Item addItem(Item item) {
        jdbcTemplate.update(SQL_ADD_ITEM,
                item.getName(),
                item.getCost(),
                item.getInventory(),
                item.getImage()
        );

        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        item.setId(id);
        return item;
    }

    private static final String SQL_SELECT_ALL_ITEMS = "SELECT * FROM Items";

    @Override
    public List<Item> getAllItems() {
        List<Item> allItems;
        allItems = jdbcTemplate.query(SQL_SELECT_ALL_ITEMS, new ItemMapper());
        return allItems;
    }

    private static final String SQL_SELECT_ITEM_BY_ID = "SELECT * FROM Items \n"
            + "	WHERE id = ?";

    @Override
    public Item getItem(int id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ITEM_BY_ID, new ItemMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private static final String SQL_REMOVE_ITEM = "DELETE FROM Items WHERE id = ?";

    @Override
    public void removeItem(int id) {
        jdbcTemplate.update(SQL_REMOVE_ITEM, id);
    }

    private static final String SQL_UPDATE_ITEM_BY_ID
            = "UPDATE Items SET name = ?, cost = ?, inventory = ?, image_url = ?"
            + "		WHERE id = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateItem(Item item) {
        jdbcTemplate.update(SQL_UPDATE_ITEM_BY_ID,
                item.getName(),
                item.getCost(),
                item.getInventory(),
                item.getImage(),
                item.getId());
    }

    private static final class ItemMapper implements RowMapper<Item> {

        @Override
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            Item mappedItem = new Item();

            int id = rs.getInt("id");
            String name = rs.getString("name");
            Double cost = rs.getDouble("cost");
            int inventory = rs.getInt("inventory");
            String image = rs.getString("image_url");

            mappedItem.setId(id);
            mappedItem.setName(name);
            mappedItem.setCost(cost);
            mappedItem.setInventory(inventory);
            mappedItem.setImage(image);

            return mappedItem;
        }

    }
    
    //stats page statement/mapper
    
    private static final String SQL_SELECT_ITEM_COUNTS = "SELECT name, inventory FROM Items";
    
    @Override
    public List<ItemCount> getItemCounts() {
        return jdbcTemplate.query(SQL_SELECT_ITEM_COUNTS, new ItemCountMapper());
    }
    
    private static final class ItemCountMapper implements RowMapper<ItemCount> {
        
        @Override
        public ItemCount mapRow(ResultSet rs, int i) throws SQLException {
            ItemCount mappedCount = new ItemCount();
            mappedCount.setItemName(rs.getString("name"));
            mappedCount.setNumItems(rs.getInt("inventory"));
            return mappedCount;
        }
    }

}
