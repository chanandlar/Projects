package com.springboot.firstwebapp.Hello;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.Logger;


@Controller
public class a4LoginControlller {
    //private Logger logger= LoggerFactory.getLogger(getClass());
    //http://localhost
    @RequestMapping("login")
    public String gotoLoginPage(@RequestParam String name, ModelMap model){
        System.out.println("RequestParam: "+name );
        model.put("name",name);
//        logger.debug("RequestParam is "+name);
//        logger.info("RequestParam(info-level) is "+name);
//        logger.warn("RequestParam(warn-level) is "+name);
        return "login";
    }
}
