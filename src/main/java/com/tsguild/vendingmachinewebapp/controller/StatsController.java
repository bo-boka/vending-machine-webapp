package com.tsguild.vendingmachinewebapp.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StatsController {
        
    public StatsController() {
    }
    
    @RequestMapping(value={"/stats"}, method=RequestMethod.GET)
    public String displayStats() { //Map<String, Object> model
//        model.put("message", "Hello from the controller" );
        return "stats";
    }
}
