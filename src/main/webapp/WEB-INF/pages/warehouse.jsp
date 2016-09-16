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
    <title>Склад</title>
</head>
<body>
<center>
    <h1>Склад</h1>
<div>
    <table>
        <thead>
        <tr>
            <th>Ингредиент</th>
            <th>Количество</th>
        </tr>
        </thead>
        <tbody>
        <%
            JdbcDAO dao = new JdbcDAO();
            ArrayList<Ingredient> ing;
            ing = dao.getAllWarehouseRest();

            for (Ingredient ingredient : ing) {
        %>
        <tr>
            <td><%=ingredient.getIng_name()%></td>
            <td><%=String.valueOf(ingredient.getRest())%></td>

            <td style="border: none;">
                <div>
                    <form method="post" action="deleteRestFromWh">
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
    <form method="post" action="whAdd">
        <input type="submit" value="Добавить (изменить) ингредиент"/>
    </form>
</div>





</center>
</body>
</html>