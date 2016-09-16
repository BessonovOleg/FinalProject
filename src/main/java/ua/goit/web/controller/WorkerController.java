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
public class WorkerController {
    @RequestMapping(value = "workers",method = RequestMethod.GET)
    public ModelAndView workers() {
        ModelAndView model = new ModelAndView();
        model.setViewName("workers");
        return model;
    }

    @RequestMapping(value = "workerAdd",method = RequestMethod.POST)
    public ModelAndView workerAdd() {
        ModelAndView model = new ModelAndView();
        model.setViewName("workerAdd");
        return model;
    }


    @RequestMapping(value = "workerUpdatePage",method = RequestMethod.POST)
    public ModelAndView workerUpdatePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("workerUpdate");
        return model;
    }

    @RequestMapping(value = "updateWorker",method = RequestMethod.POST)
    public ModelAndView workerUpdate(@RequestParam("workId") int updateWorkerID,
                                     @RequestParam("firstName") String firstName ,
                                     @RequestParam("lastName") String lastName,
                                     @RequestParam("dob") String dob,
                                     @RequestParam("phone") String phone,
                                     @RequestParam("position") String position,
                                     @RequestParam("salary") Double salary) {

        JdbcDAO dao = new JdbcDAO();
        Worker workerUpdated = new Worker();
        workerUpdated.setWork_id(updateWorkerID);
        workerUpdated.setFirst_name(firstName);
        workerUpdated.setLast_name(lastName);
        workerUpdated.setDob(Date.valueOf(dob));
        workerUpdated.setPhone(phone);
        workerUpdated.setPosition(position);
        workerUpdated.setSalary(salary);
        dao.updateWorker(workerUpdated);

        ModelAndView model = new ModelAndView();
        model.setViewName("workers");
        return model;
    }

    @RequestMapping(value = "addWorker",method = RequestMethod.POST)
    public ModelAndView addWorker(@RequestParam("firstName") String firstName ,
                                  @RequestParam("lastName") String lastName,
                                  @RequestParam("dob") String dob,
                                  @RequestParam("phone") String phone,
                                  @RequestParam("position") String position,
                                  @RequestParam("salary") Double salary) {

        JdbcDAO dao = new JdbcDAO();
        Worker worker = new Worker();
        worker.setFirst_name(firstName);
        worker.setLast_name(lastName);
        worker.setDob(Date.valueOf(dob));
        worker.setPhone(phone);
        worker.setPosition(position);
        worker.setSalary(salary);
        dao.updateWorker(worker);

        ModelAndView model = new ModelAndView();
        model.setViewName("workers");
        return model;
    }

    @RequestMapping(value = "deleteWorker",method = RequestMethod.POST)
    public ModelAndView deleteWorker(@RequestParam("delId") int delId) {
        JdbcDAO dao = new JdbcDAO();
        dao.deleteWorker(delId);

        ModelAndView model = new ModelAndView();
        model.setViewName("workers");
        return model;
    }
}
