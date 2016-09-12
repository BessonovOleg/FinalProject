import org.junit.Test;
import ua.goit.homework62.DishCategory;
import ua.goit.homework62.JdbcDAO;
import ua.goit.homework62.Worker;

import java.util.ArrayList;


public class TestDAO {
    @Test
    public void testDAOWorkers(){
        JdbcDAO dao = new JdbcDAO();
        ArrayList<Worker> workers;
        workers = dao.getAllWorkers();
    }


    @Test
    public void tesDishCategory(){
        JdbcDAO dao = new JdbcDAO();
        ArrayList<DishCategory> dc ;
        dc = dao.getAllDishCategory();
/*
        for(DishCategory d:dc){
            System.out.println(d.toString());
        }
*/
    }
}
