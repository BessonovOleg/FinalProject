<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="ua.goit.homework62.JdbcDAO" %>
<%@ page import="ua.goit.homework62.DishCategory" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        <%@include file='style.css' %>
    </style>
    <title>Сотрудник</title>
</head>
<body>

    <%
        int id = Integer.parseInt(request.getParameter("updateId"));
        JdbcDAO dao = new JdbcDAO();
        DishCategory dc = dao.getDishCategory(id);
    %>

<form method="post" action="updateDishCategory">
    <div id="mystyle" class="myform">
        <form id="form" name="form" action="updateDishCategory" method="post">
            <h1>Категория</h1>
            <label><input type="hidden" name="catId" id="catId" value="<%=dc.getCatID()%>"/><span class="small"></span></label>
            <label>Наименование<span class="small">Введите наименование</span></label>
            <input type="text" name="catName" id="catName" value="<%=dc.getCatName()%>" />

            <button type="submit">Сохранить</button>
            <div class="spacer"></div>
        </form>
    </div>
</form>
</body>
</html>