import org.junit.Test;
import ua.goit.homework62.DishCategory;
import ua.goit.homework62.Ingredient;
import ua.goit.homework62.JdbcDAO;
import ua.goit.homework62.Worker;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


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
    }

    @Test
    public void testIngredient() {
        JdbcDAO dao = new JdbcDAO();
        ArrayList<Ingredient> ingredients;
        ingredients = dao.getAllWarehouseRest();
    }

    @Test
    public void testIsWarehouseElementExists(){
        JdbcDAO dao = new JdbcDAO();
        int actual = 5;
        int expected = dao.isWhElementExists(5);
        assertEquals(expected, actual);
    }

    @Test
    public void testWareHouseUpdate() {
        JdbcDAO dao = new JdbcDAO();
        dao.updateWarehouse(5,52.0);
    }
}
