<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page import="uk.ac.ucl.model.ModelFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>View List Contents</title>
</head>
<body>
<div class="main">
  <h2>List contains:</h2>

  <%
    //get selected list contents from the view lists page
    Integer list_id = Integer.parseInt((String) request.getAttribute("current_id"));
    String list_text = (String) request.getAttribute("list_text");
    String url = (String) request.getAttribute("url");
    String image_url = (String) request.getAttribute("image_url");
    Integer linked_list_id = Integer.parseInt((String) request.getAttribute("linked_list_id"));
  %>
  <p><%=list_text%></p>
  <a href=<%=url%>><%=url%></a>
  <div></div>
  <% if(linked_list_id != -999) //only show a linked list hyperlink if it is present in the current list
  {
    String linked_list_href = "/viewMyList.html?id=" + linked_list_id;
    Model model = ModelFactory.getModel();
    String linked_list_name = model.get_list_by_id(linked_list_id).getName();
  %>
  <p>Linked list: </p>
  <a href=<%=linked_list_href%>><%= linked_list_id + ")" + " " + linked_list_name%></a>
  <%}%>
  <div></div>
  <% if (!image_url.isEmpty()) { %>
  <img src="<%=image_url%>" alt="The list image">
  <% } %>
  <div></div>
  <footer>
    <%String edit_href = "editlist.jsp?id=" + list_id;%>
    <a href=<%=edit_href%>>Edit this list</a>
    <div></div>
    <%String del_href = "delete-list.html?id=" + list_id;%>
    <a href=<%=del_href%>>Delete this list</a>
  </footer>
</div>
</body>
</html>