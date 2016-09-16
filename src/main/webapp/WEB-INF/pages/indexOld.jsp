<%@ page import="ua.goit.homework62.JdbcDAO" %>
<%@ page import="ua.goit.homework62.Worker" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>
<html>
<body>



<select name="workId">
<%
    JdbcDAO dao = new JdbcDAO();
    ArrayList<Worker> workers;
    request.setCharacterEncoding("UTF-8");
    workers = dao.getAllWorkers();
    for (Worker w : workers) {
%>
    <option value=<%=w.getWork_id()%>><%=w.getFirst_name()%></option>
<%
    }
%>
</select>



</body>
</html>