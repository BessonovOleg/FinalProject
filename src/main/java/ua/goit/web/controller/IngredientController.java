package ua.goit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.homework62.Ingredient;
import ua.goit.homework62.JdbcDAO;

@Controller
public class IngredientController {

    @RequestMapping(value = "ingredients",method = RequestMethod.GET)
    public ModelAndView ingredients(){
        return getAllIngredients();
    }

    @RequestMapping(value = "ingredientUpdatePage",method = RequestMethod.POST)
    public ModelAndView ingredientUpdatePage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("ingredientUpdate");
        return model;
    }

    @RequestMapping(value = "updateIngredient",method = RequestMethod.POST)
    public ModelAndView ingredientUpdate(@RequestParam("ingId") int updateIngredientID,
                                         @RequestParam("ingName") String ingName){
        JdbcDAO dao = new JdbcDAO();
        Ingredient ingredient = new Ingredient();
        ingredient.setIng_id(updateIngredientID);
        ingredient.setIng_name(ingName);
        dao.updateIngredient(ingredient);
        return getAllIngredients();
    }

    @RequestMapping(value = "deleteIngredient",method = RequestMethod.POST)
    public ModelAndView deleteWorker(@RequestParam("delId") int delId) {
        JdbcDAO dao = new JdbcDAO();
        dao.deleteIngredient(delId);
        return getAllIngredients();
    }

    @RequestMapping(value = "ingredientAddPage",method = RequestMethod.POST)
    public ModelAndView ingredientAddPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("ingredientAdd");
        return model;
    }

    @RequestMapping(value = "ingAdd",method = RequestMethod.POST)
    public ModelAndView ingredientUpdate(@RequestParam("ingName") String ingName){
        JdbcDAO dao = new JdbcDAO();
        Ingredient ingredient = new Ingredient();
        ingredient.setIng_name(ingName);
        dao.updateIngredient(ingredient);
        return getAllIngredients();
    }

    private ModelAndView getAllIngredients() {
        ModelAndView model = new ModelAndView();
        model.setViewName("ingredients");
        return model;
    }
}
