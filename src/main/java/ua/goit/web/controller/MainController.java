package ua.goit.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.homework62.JdbcDAO;
import ua.goit.homework62.Worker;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@Controller
public class MainController {

    @RequestMapping(value = {"/","index**"},method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }


    @RequestMapping(value = "mapRestaurant",method = RequestMethod.GET)
    public ModelAndView mapRestaurant() {
        ModelAndView model = new ModelAndView();
        model.setViewName("mapRestaurant");
        return model;
    }


}
