<%@ page import="java.util.List" %>
<%@ page import="data.Klients" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="data.Zakupka" %><%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 15.11.2018
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<String> firms = (List<String>) request.getAttribute("firms");
    List<String> names = (List<String>) request.getAttribute("names");
    List<Integer> idsKlients = (List<Integer>) request.getAttribute("idsKlients");
    List<Integer> idsZakupkas = (List<Integer>) request.getAttribute("idsZakupkas");
%>
<html>
<head><title>Add row</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
<h3>ADD ROW</h3>
<form method="post">
    <label>Date: <input type="text" name="date"></label><br />
    <label>Quantity: <input type="text" name="quantity"></label> <br />
    <%
        for (int i = 0; i < firms.size(); i++){

        }
    %>
    <p><select name="addClient">
        <option disabled>Choose client</option>
        <%
            for (int i = 0; i < firms.size(); i++){
        %>
        <option value="<%=idsKlients.get(i)%>"><%=firms.get(i) + " " + idsKlients.get(i)%></option >
        <%} %>
    </select></p>
    <p><select name="addZakupka">
        <option disabled>Choose Zakupka</option>
        <%
            for (int i = 0; i < names.size(); i++){
        %>
        <option value="<%=idsZakupkas.get(i)%>"><%=names.get(i) + " " + idsZakupkas.get(i)%></option >
        <%} %>
    </select></p>
    <input type="submit" value="Add">
</form>
<div class="w3-container w3-opacity w3-right-align w3-padding">
    <button class="w3=btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>

