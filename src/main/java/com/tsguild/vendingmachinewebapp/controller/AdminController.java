package com.tsguild.vendingmachinewebapp.controller;

import com.tsguild.vendingmachinewebapp.dao.VendingDao;
import com.tsguild.vendingmachinewebapp.dto.Item;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class AdminController {
        
    private VendingDao dao;
        
    @Inject
    public AdminController(VendingDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value={"/admin"}, method=RequestMethod.GET)
    public String displayStats() { 
        return "admin";
    }
    
    //login page
    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String displayLoginPage(){
        return "loginPage";
    }
    
    @ResponseBody
    @RequestMapping(value="/item/{id}", method=RequestMethod.GET)
    public Item getItemById(@PathVariable("id")int itemId){
        return dao.getItem(itemId);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value="/item/{id}", method=RequestMethod.PUT)
    public void updateItem(@PathVariable int id, @RequestBody Item updatedItem){
        updatedItem.setId(id);
        dao.updateItem(updatedItem);
    }
    
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value="/item", method=RequestMethod.POST)
    public Item addItem(@Valid @RequestBody Item incomingItem){
        dao.addItem(incomingItem);
        return incomingItem;
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value="/item/{id}", method=RequestMethod.DELETE)
    public void deleteItem(@PathVariable int id){
        dao.removeItem(id);
    }
}
