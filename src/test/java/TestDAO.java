import org.junit.Test;
import ua.goit.homework62.DishCategory;
import ua.goit.homework62.Ingredient;
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



    @Test
    public void testIngredient() {
        JdbcDAO dao = new JdbcDAO();
        ArrayList<Ingredient> ingredients;
        ingredients = dao.getAllWarehouseRest();
        for (Ingredient ing:ingredients) {
            System.out.println(ing.toString());
        }
    }

    @Test
    public void testIsWarehouseElementExists(){
        JdbcDAO dao = new JdbcDAO();
        System.out.println(dao.isWhElementExists(5));
        //System.out.println(res);
    }

    @Test
    public void testWareHouseUpdate() {
        JdbcDAO dao = new JdbcDAO();
        dao.updateWarehouse(5,52.0);
    }
}
