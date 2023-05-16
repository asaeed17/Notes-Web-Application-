<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Search Result</title>
</head>
<body>
<div class="main">
  <h1>Search Result</h1>
  <ul>
    <%
      List<String> result_names = (List<String>) request.getAttribute("result_names");
      List<Integer> resultIds = (List<Integer>) request.getAttribute("result_ids");
      if (!result_names.isEmpty())
      {
        for (int i = 0; i < result_names.size(); i++)
        {
        String href = "/viewMyList.html?id=" + resultIds.get(i);  //matching list ID added to query string for each matching list's URL
    %>
    <li><a href="<%=href%>"><%=resultIds.get(i) + ")" + " " + result_names.get(i)%></a>
    </li>
    <% }
    }
    else
    {%>
    <p>Nothing found</p>
    <%}%>
  </ul>
</div>
</body>
</html>