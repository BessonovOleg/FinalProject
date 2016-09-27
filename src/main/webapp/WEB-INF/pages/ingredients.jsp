<%@page import="ua.goit.homework62.JdbcDAO"%>
<%@page import="java.util.ArrayList" %>
<%@ page import="ua.goit.homework62.Ingredient" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        <%@include file='style.css' %>
    </style>
    <title>Ингредиенты</title>
</head>
<body>
<center>
    <h1>Ингредиенты</h1>
<div>
    <table>
        <thead>
        <tr>
            <th>Наименование</th>
        </tr>
        </thead>
        <tbody>
        <%
            JdbcDAO dao = new JdbcDAO();
            ArrayList<Ingredient> ing;
            request.setCharacterEncoding("UTF-8");
            ing = dao.getAllIngredient();
            for (Ingredient ingredient : ing) {
        %>
        <tr>
            <td><%=ingredient.getIng_name()%></td>
            <td style="border: none;">
                <div>
                    <form method="post" action="ingredientUpdatePage">
                        <input type="hidden" id="updateId" name="updateId" value="<%=String.valueOf(ingredient.getIng_id())%>"/>
                        <input type="submit" value="Редактировать..."/>
                    </form>
                </div>
            </td>
            <td style="border: none;">
                <div>
                    <form method="post" action="deleteIngredient">
                        <input type="hidden" id="delId" name="delId" value="<%=String.valueOf(ingredient.getIng_id())%>"/>
                        <input type="submit" value="Удалить"/>
                    </form>
                </div>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<div>
    <form method="post" action="ingredientAddPage">
        <input type="submit" value="Добавить ингредиент"/>
    </form>
</div>


<div align="center">
   <a href="/restaurant">На главную</a>
</div>




</center>
</body>
</html>