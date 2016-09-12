package ua.goit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IngredientController {

    @RequestMapping(value = "ingredients",method = RequestMethod.GET)
    public ModelAndView ingredients(){
        return getAllIngredients();
    }


    private ModelAndView getAllIngredients() {
        ModelAndView model = new ModelAndView();
        model.setViewName("ingredients");
        return model;
    }
}
