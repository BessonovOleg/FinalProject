<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="ua.goit.homework62.JdbcDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ua.goit.homework62.Ingredient" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        <%@include file='style.css' %>
    </style>
    <title>Ингредиент</title>
</head>
<body>



<form method="post" action="updateWh">
    <div id="mystyle" class="myform">
        <form id="form" name="form" action="updateWh" method="post">

            <table>
                <thead>
                <tr>
                    <th>Ингредиент</th>
                    <th>Количество</th>
                </tr>
                </thead>
                <tbody>
                    <td>
                        <select name="ingId" id="ingId">
                            <%
                                JdbcDAO dao = new JdbcDAO();
                                ArrayList<Ingredient> ingredients;
                                request.setCharacterEncoding("UTF-8");
                                ingredients = dao.getAllIngredient();
                                for (Ingredient ing : ingredients) {
                            %>
                            <option value=<%=ing.getIng_id()%>><%=ing.getIng_name()%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                    <td>
                        <input type="number" name="qty" id="qty" />
                    </td>
                </tbody>
            </table>

            <button type="submit">Сохранить</button>
            <div class="spacer"></div>
        </form>
    </div>
</form>
</body>
</html>