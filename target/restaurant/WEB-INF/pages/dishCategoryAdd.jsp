<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        <%@include file='style.css' %>
    </style>
    <title>Добавленние категории</title>
</head>
<body>

<form method="post" action="addDishCategory">
    <div id="mystyle" class="myform">
        <form id="form" name="form" action="addDishCategory" method="post">
            <h1>Категория</h1>
            <p>Для добавления категории, заполните информацию</p>
            <label>Наименование<span class="small">Введите наименование категории</span></label>
            <input type="text" name="catName" id="catName" />

            <button type="submit">Добавить</button>
            <div class="spacer"></div>
        </form>
    </div>
</form>
</body>
</html>