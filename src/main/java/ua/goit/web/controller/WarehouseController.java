package ua.goit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.homework62.JdbcDAO;

@Controller
public class WarehouseController {

    @RequestMapping(value = "warehouse",method = RequestMethod.GET)
    public ModelAndView warehouse(){
        ModelAndView model = new ModelAndView();
        model.setViewName("warehouse");
        return model;
    }

    @RequestMapping(value = "whAdd",method = RequestMethod.POST)
    public ModelAndView whAdd() {
        ModelAndView model = new ModelAndView();
        model.setViewName("warehouseUpdate");
        return model;
    }

    @RequestMapping(value = "updateWh",method = RequestMethod.POST)
    public ModelAndView whUpdate(@RequestParam("ingId") int ingId,
                                 @RequestParam("qty") Double qty){

        JdbcDAO dao = new JdbcDAO();
        dao.updateWarehouse(ingId, qty);

        ModelAndView model = new ModelAndView();
        model.setViewName("warehouse");
        return model;
    }

}
