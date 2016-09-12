package ua.goit.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.homework62.JdbcDAO;
import ua.goit.homework62.Worker;

import java.sql.Date;


@Controller
public class MainController {

    @RequestMapping(value = {"/","index**"},method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Hello World");
        model.addObject("message", "This is protected page!");
        model.setViewName("index");
        return model;
    }


}
