package ua.goit.web.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.homework62.DishCategory;
import ua.goit.homework62.JdbcDAO;

@Controller
public class DishCategoryController {

    @RequestMapping(value = "dishcategories",method = RequestMethod.GET)
    public ModelAndView dishCategories() {
        return getAllDishCategories();
    }

    @RequestMapping(value = "dishCategoryAddPage",method = RequestMethod.POST)
    public ModelAndView addDishCategoryPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("dishCategoryAdd");
        return model;
    }

    @RequestMapping(value = "addDishCategory", method = RequestMethod.POST)
    public ModelAndView addDishCategory(@RequestParam("catName") String catName){
        JdbcDAO dao = new JdbcDAO();
        DishCategory dc = new DishCategory();
        dc.setCatName(catName);
        dao.updateDishCategory(dc);

        ModelAndView model = new ModelAndView();
        model.setViewName("dishCategory");
        return model;
    }

    @RequestMapping(value = "deleteDishCategory",method = RequestMethod.POST)
    public ModelAndView deleteDishCategory(@RequestParam("delId") int delId) {
        JdbcDAO dao = new JdbcDAO();
        dao.deleteDishCategory(delId);
        return getAllDishCategories();
    }

    @RequestMapping(value = "dishCategoryUpdatePage",method = RequestMethod.POST)
    public ModelAndView updateDishCategoryPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("dishCategoryUpdate");
        return model;
    }

    @RequestMapping(value = "updateDishCategory",method = RequestMethod.POST)
    public ModelAndView updateDishCategory(@RequestParam("catId") int updateId,@RequestParam("catName") String catName) {
        JdbcDAO dao = new JdbcDAO();
        DishCategory dc = new DishCategory();
        dc.setCatID(updateId);
        dc.setCatName(catName);
        dao.updateDishCategory(dc);
        return getAllDishCategories();
    }

    private ModelAndView getAllDishCategories() {
        ModelAndView model = new ModelAndView();
        model.setViewName("dishCategory");
        return model;
    }

}
