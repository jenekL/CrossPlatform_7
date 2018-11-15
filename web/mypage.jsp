<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 15.11.2018
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>123</title>
</head>
<body>
<h3>parametrs</h3>
<%
    String name = request.getParameter("userName");
%>
User Name: <%=name%>
</body>
</html>
