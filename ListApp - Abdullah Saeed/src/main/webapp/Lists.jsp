<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>View Lists</title>
</head>
<body>
<div class="main">
  <h2>Lists:</h2>
  <ul>
    <%
      List<String> listNames = (List<String>) request.getAttribute("listNames");
      List<Integer> listIds = (List<Integer>) request.getAttribute("listIds");
      for (int i = 0; i < listIds.size(); i++)
      {
        String href = "/viewMyList.html?id=" + listIds.get(i);  //list ID added to query string for each list's URL
    %>
    <li><a href="<%=href%>"><%=listIds.get(i) + ")" + " " + listNames.get(i)%></a>
    </li>
    <% } %>
  </ul>
</div>
</body>
</html>
