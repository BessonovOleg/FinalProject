package ua.goit.homework62;

import java.sql.*;
import java.util.ArrayList;



//TODO добавить в удаления проверки - выводить сообщения!!!

public class JdbcDAO {
    Connection connection = null;
    String url          = "jdbc:postgresql://127.0.0.1:5432/restaurant";
    String userName     = "postgres";
    String userPassword = "123";

    private void openConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,userName,userPassword);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//WORKERS
    public ArrayList<Worker> getAllWorkers(){
        openConnection();
        ArrayList<Worker> result = new ArrayList<>();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String sqlStr = "select \"WORK_ID\",\"LAST_NAME\",\"FIRST_NAME\",\"DOB\",\"PHONE\",\"POSITION\",\"SALARY\" from \"Workers\" order by \"LAST_NAME\"";
                ResultSet rs = statement.executeQuery(sqlStr);
                while (rs.next()) {
                    Worker worker = new Worker();
                    fillWorkDataFromResultSet(worker,rs);
                    result.add(worker);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
        return result;
    }
    public ArrayList<Worker> findWorkerByLastName(String lastName) {
        openConnection();
        ArrayList<Worker> result = new ArrayList<>();
        String findText = "%" + lastName + "%";
        if (connection != null) {
            try {
                String sqlStr = "select \"WORK_ID\",\"LAST_NAME\",\"FIRST_NAME\",\"DOB\",\"PHONE\",\"POSITION\",\"SALARY\" from \"Workers\" where \"LAST_NAME\" like ? ";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setString(1,findText);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Worker worker = new Worker();
                    fillWorkDataFromResultSet(worker,rs);
                    result.add(worker);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }
            return result;
    }
    public Worker getWorker(int WORK_ID) {
        openConnection();
        Worker result = new Worker();
        if (connection != null) {
            try {
                String sqlStr = "select \"WORK_ID\",\"LAST_NAME\",\"FIRST_NAME\",\"DOB\",\"PHONE\",\"POSITION\",\"SALARY\" from \"Workers\" where \"WORK_ID\" = ? ";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setInt(1,WORK_ID);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    fillWorkDataFromResultSet(result,rs);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
           return result;
    }
    public void updateWorker(Worker worker) {
        openConnection();
        String sqlStr;
        if (connection != null) {
            //check worker_id. If = 0 then insert into database else update worker
            if(worker.getWork_id() == 0) {
                sqlStr = "insert into \"Workers\"(\"LAST_NAME\",\"FIRST_NAME\",\"DOB\",\"PHONE\",\"POSITION\",\"SALARY\") VALUES(?,?,?,?,?,?)";
            }else {
                sqlStr = "update \"Workers\" set \"LAST_NAME\" = ?,\"FIRST_NAME\" = ?,\"DOB\"=?,\"PHONE\"=?,\"POSITION\"=?,\"SALARY\"=? where \"WORK_ID\"= ? ";
            }

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setString(1,worker.getLast_name());
                preparedStatement.setString(2,worker.getFirst_name());
                preparedStatement.setDate(3,worker.getDob());
                preparedStatement.setString(4,worker.getPhone());
                preparedStatement.setString(5,worker.getPosition());
                preparedStatement.setDouble(6,worker.getSalary());
                if(worker.getWork_id() > 0) {
                    preparedStatement.setInt(7,worker.getWork_id());
                }
                preparedStatement.executeUpdate();

            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
    }
    public void deleteWorker(Worker worker) {
        deleteWorker(worker.getWork_id());
    }
    public void deleteWorker(int work_id) {
        openConnection();
        String sqlStr;
        if (connection != null) {
            sqlStr = "delete from \"Workers\" where \"WORK_ID\"= ? ";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setInt(1,work_id);
                preparedStatement.executeUpdate();
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
    }
    private void fillWorkDataFromResultSet(Worker worker,ResultSet resultSet) {
        try {
            worker.setWork_id(resultSet.getInt("WORK_ID"));
            worker.setLast_name(resultSet.getString("LAST_NAME"));
            worker.setFirst_name(resultSet.getString("FIRST_NAME"));
            worker.setDob(resultSet.getDate("DOB"));
            worker.setPhone(resultSet.getString("PHONE"));
            worker.setPosition(resultSet.getString("POSITION"));
            worker.setSalary(resultSet.getDouble("SALARY"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//end WORKERS

//DishCategory
    public ArrayList<DishCategory> getAllDishCategory(){
        openConnection();
        ArrayList<DishCategory> result = new ArrayList<>();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String sqlStr = "select \"CAT_ID\",\"CAT_NAME\" from \"Category\" order by \"CAT_NAME\"";
                ResultSet rs = statement.executeQuery(sqlStr);
                while (rs.next()) {
                    DishCategory cat = new DishCategory();
                    fillDishCategoryDataFromResultSet(cat,rs);
                    result.add(cat);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
        return result;
    }
    public DishCategory getDishCategory(int catID) {
        openConnection();
        DishCategory result = new DishCategory();
        if (connection != null) {
            try {
                String sqlStr = "select \"CAT_ID\",\"CAT_NAME\" from \"Category\" where \"CAT_ID\" = ? ";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setInt(1,catID);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    fillDishCategoryDataFromResultSet(result,rs);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
        return result;
    }
    public void updateDishCategory(DishCategory dishCategory){
        openConnection();
        String sqlStr;
        if (connection != null) {
            //check catID. If = 0 then insert into database else update
            if(dishCategory.getCatID() == 0) {
                sqlStr = "insert into \"Category\"(\"CAT_NAME\") VALUES(?)";
            }else {
                sqlStr = "update \"Category\" set \"CAT_NAME\" = ? where \"CAT_ID\"= ? ";
            }

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setString(1,dishCategory.getCatName());
                if(dishCategory.getCatID() > 0) {
                    preparedStatement.setInt(2,dishCategory.getCatID());
                }
                preparedStatement.executeUpdate();

            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
    }
    public void deleteDishCategory(int catId) {
        openConnection();
        String sqlStr;
        if (connection != null) {
            sqlStr = "delete from \"Category\" where \"CAT_ID\"= ? ";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setInt(1,catId);
                preparedStatement.executeUpdate();
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
    }
    public void deleteDishCategory(DishCategory dc) {
        deleteDishCategory(dc.getCatID());
    }
    private void fillDishCategoryDataFromResultSet(DishCategory dishCategory,ResultSet resultSet) {
        try {
            dishCategory.setCatID(resultSet.getInt("CAT_ID"));
            dishCategory.setCatName(resultSet.getString("CAT_NAME"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//end DishCategory

//Ingredients
    public ArrayList<Ingredient> getAllIngredient(){
        openConnection();
        ArrayList<Ingredient> result = new ArrayList<>();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String sqlStr = "select \"ING_ID\",\"ING_NAME\" from \"Ingredients\" order by \"ING_NAME\"";
                ResultSet rs = statement.executeQuery(sqlStr);
                while (rs.next()) {
                    Ingredient ing = new Ingredient();
                    fillIngredientDataFromResultSet(ing,rs);
                    result.add(ing);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
        return result;
    }
    public Ingredient getIngredient(int ingID) {
        openConnection();
        Ingredient result = new Ingredient();
        if (connection != null) {
            try {
                //String sqlStr = "select \"ING_ID\",\"ING_NAME\" from \"Ingredients\" where \"ING_ID\" = ? ";

                String sqlStr = "SELECT \"Ingredients\".\"ING_ID\", \"Ingredients\".\"ING_NAME\", \"Warehouse\".\"QTY\" FROM public.\"Ingredients\" LEFT JOIN public.\"Warehouse\" on \"Ingredients\".\"ING_ID\" = \"Warehouse\".\"ING_ID\" where \"Ingredients\".\"ING_ID\" = ? ";
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setInt(1,ingID);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    fillIngredientDataFromResultSet(result,rs);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
        return result;
    }
    public void updateIngredient(Ingredient ingredient){
        openConnection();
        String sqlStr;
        if (connection != null) {
            //check ID. If = 0 then insert into database else update
            if(ingredient.getIng_id() == 0) {
                sqlStr = "insert into \"Ingredients\"(\"ING_NAME\") VALUES(?)";
            }else {
                sqlStr = "update \"Ingredients\" set \"ING_NAME\" = ? where \"ING_ID\"= ? ";
            }

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setString(1,ingredient.getIng_name());
                if(ingredient.getIng_id() > 0) {
                    preparedStatement.setInt(2,ingredient.getIng_id());
                }
                preparedStatement.executeUpdate();

            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
    }
    public void deleteIngredient(int ingId) {
        openConnection();
        String sqlStr;
        if (connection != null) {
            sqlStr = "delete from \"Ingredients\" where \"ING_ID\"= ? ";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setInt(1,ingId);
                preparedStatement.executeUpdate();
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
    }
    public void deleteIngredient(Ingredient ing) {
        deleteIngredient(ing.getIng_id());
    }
    private void fillIngredientDataFromResultSet(Ingredient ingredient,ResultSet resultSet) {
        try {
            ingredient.setIng_id(resultSet.getInt("ING_ID"));
            ingredient.setIng_name(resultSet.getString("ING_NAME"));
            ingredient.setRest(resultSet.getDouble("QTY"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//end Ingredients

//Warehouse
    public ArrayList<Ingredient> getAllWarehouseRest() {
        openConnection();
        ArrayList<Ingredient> result = new ArrayList<>();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String sqlStr = "SELECT \"Ingredients\".\"ING_ID\", \"Ingredients\".\"ING_NAME\", \"Warehouse\".\"QTY\" FROM \"Ingredients\" INNER JOIN \"Warehouse\" on \"Ingredients\".\"ING_ID\" = \"Warehouse\".\"ING_ID\" ORDER BY \"Ingredients\".\"ING_NAME\"  ";
                ResultSet rs = statement.executeQuery(sqlStr);
                while (rs.next()) {
                    Ingredient ing = new Ingredient();
                    fillIngredientDataFromResultSet(ing,rs);
                    result.add(ing);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                closeConnection();
            }
        }
        return result;
    }


    public int isWhElementExists(int elId) {
        openConnection();
        int res = 0;
        if (connection != null) {
            try {
                String sqlStr = "SELECT \"ING_ID\" FROM \"Warehouse\" where \"ING_ID\" = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setInt(1, elId);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    res = rs.getInt("ING_ID");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }
        return res;
    }


    public void updateWarehouse(int ingId,Double qty) {
        int isExists = isWhElementExists(ingId);

        openConnection();
        if (connection != null) {
            try {
                String sqlStr;

                //if exists then update, else insert
                if (isExists > 0) {
                    sqlStr = "update \"Warehouse\" set \"QTY\" = ? where \"ING_ID\"= ? ";
                } else {
                    sqlStr = "insert into \"Warehouse\"(\"QTY\",\"ING_ID\") VALUES(?,?)";
                }

                    PreparedStatement pStatement = connection.prepareStatement(sqlStr);
                    pStatement.setDouble(1,qty);
                    pStatement.setInt(2,ingId);
                    pStatement.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }
    }
//end Warehouse

}
