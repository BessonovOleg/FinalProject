<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="ua.goit.homework62.JdbcDAO" %>
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

    <%
        int id = Integer.parseInt(request.getParameter("updateId"));
        JdbcDAO dao = new JdbcDAO();
        Ingredient ingredient = dao.getIngredient(id);
    %>

<form method="post" action="updateIngredient">
    <div id="mystyle" class="myform">
        <form id="form" name="form" action="updateIngredient" method="post">
            <h1>Ингредиент</h1>
            <label><input type="hidden" name="ingId" id="ingId" value="<%=ingredient.getIng_id()%>"/><span class="small"></span></label>
            <label>Наименование<span class="small">Введите наименование</span></label>
            <input type="text" name="ingName" id="ingName" value="<%=ingredient.getIng_name()%>" />
            <button type="submit">Сохранить</button>
            <div class="spacer"></div>
        </form>
    </div>
</form>
</body>
</html>