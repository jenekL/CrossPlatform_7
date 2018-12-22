<%@ page import="data.Prodaja" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Tom
  Date: 15.11.2018
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Prodaja> tableData = (ArrayList<Prodaja>) request.getAttribute("tableData");
    List<Integer> ids = (List<Integer>) request.getAttribute("ids");
%>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Tables</title>

</head>
<body>
<div class="w3-container w3-light-grey">
<h1>Table show
    <div class="w3-container w3-right-align w3-padding">
        <button class="w3-btn w3-round-large" onclick="location.href='/add'">Add row</button>
    </div>
</h1>
</div>

<%--<form method="post">--%>
    <%--&lt;%&ndash;<p><select name="deletable">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<option disabled>Choose to delete</option>&ndash;%&gt;--%>
        <%--&lt;%&ndash;&lt;%&ndash;%>--%>
            <%--&lt;%&ndash;for (Integer id : ids) {&ndash;%&gt;--%>
        <%--&lt;%&ndash;%>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<option value="<%=id%>"><%=id%></option >&ndash;%&gt;--%>

        <%--&lt;%&ndash;<%} %>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</select></p>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<p><input type="submit" value="Удалить"></p>&ndash;%&gt;--%>
<%--</form>--%>

<div>
<table class="w3-table-all w3-centered" >


    <tr>
        <th></th>
        <th>id</th>
        <th>Дата</th>
        <th>Количество</th>
        <th>Наименование товара</th>
        <th>Наименование фирмы</th>
    </tr>
    <%
        for (Prodaja prodaja: tableData){
            System.out.println(tableData.size());

    %>
    <tr><td>

        <button class="w3-button w3-white w3-border w3-round-large" onclick="location.href='/delete?del=<%=prodaja.getId()%>'" ><img src="images/del.png" width="20" height="12"></button>

        </td><td><%=prodaja.getId()%></td><td><%=prodaja.getDate()%></td><td><%=prodaja.getQuantity()%></td><td><%=prodaja.getName()%></td><td><%=prodaja.getFirm()%></td></tr>
    <% }%>
</table>
<div class="w3-container w3-opacity w3-right-align w3-padding">
    <button class="w3=btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
</div>
</body>
</html>
