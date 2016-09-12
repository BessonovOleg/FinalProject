<%@page import="ua.goit.homework62.JdbcDAO"%>
<%@page import="java.util.ArrayList" %>
<%@ page import="ua.goit.homework62.DishCategory" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        <%@include file='style.css' %>
    </style>
    <title>Категории блюд</title>
</head>
<body>
<center>
    <h1>Категории блюд</h1>
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
            ArrayList<DishCategory> dc;
            request.setCharacterEncoding("UTF-8");
               dc = dao.getAllDishCategory();
            for (DishCategory d : dc) {
        %>
        <tr>
            <td><%=d.getCatName()%></td>
            <td style="border: none;">
                <div>
                    <form method="post" action="dishCategoryUpdatePage">
                        <input type="hidden" id="updateId" name="updateId" value="<%=String.valueOf(d.getCatID())%>"/>
                        <input type="submit" value="Редактировать..."/>
                    </form>
                </div>
            </td>
            <td style="border: none;">
                <div>
                    <form method="post" action="deleteDishCategory">
                        <input type="hidden" id="delId" name="delId" value="<%=String.valueOf(d.getCatID())%>"/>
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
    <form method="post" action="dishCategoryAddPage">
        <input type="submit" value="Добавить категорию"/>
    </form>
</div>





<center>
</body>
</html>