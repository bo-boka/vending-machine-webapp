package com.tsguild.vendingmachinewebapp.controller;

import com.tsguild.vendingmachinewebapp.dao.VendingDao;
import com.tsguild.vendingmachinewebapp.model.Item;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
        
    private VendingDao dao;
        
    @Inject
    public HomeController(VendingDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
    public String displayHome() { 
        return "home";
    }
    
    @ResponseBody
    @RequestMapping(value="/items", method=RequestMethod.GET)
    public List<Item> getAllItems(){
        return dao.getAllItems();
    }

}
