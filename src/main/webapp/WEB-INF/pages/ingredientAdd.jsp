<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


<form method="post" action="ingAdd">
    <div id="mystyle" class="myform">
        <form id="form" name="form" action="ingAdd" method="post">
            <h1>Ингредиент</h1>
            <label>Наименование<span class="small">Введите наименование</span></label>
            <input type="text" name="ingName" id="ingName" value="" />
            <button type="submit">Сохранить</button>
            <div class="spacer"></div>
        </form>
    </div>
</form>
</body>
</html>