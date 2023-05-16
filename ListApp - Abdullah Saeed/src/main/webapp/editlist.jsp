<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Model" %>
<%@ page import="uk.ac.ucl.model.ModelFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Edit List</title>
</head>
<body>
<div class="main">
  <h2>Edit list: (leave field blank if no change required)</h2>
  <ul>
    <%
      String list_id = request.getParameter("id");
      String href = "edit-list.html?id=" + list_id;
    %>
  </ul>
  <form action=<%=href%> method="post">
    <label for="list_name">Enter list name:</label><br>
    <input type="text" id="list_name" name="list_name"/><br>             <!-- list name -->
    <label for="list_text">Enter text contents:</label><br>
    <input type="text" id="list_text" name="list_text"/><br>             <!-- text content -->
    <label for="url">Enter a URL:</label><br>
    <input type="url" id="url" name="url"/><br>                          <!-- url content -->
    <label for="image_url">Enter an image url:</label><br>
    <input type="url" id="image_url" name="image_url"/><br>              <!-- image content -->

    <label for="lists_available">Choose a list to link:</label><br>
    <select id="lists_available" name="lists_available">
      <option value="">None</option>
      <%
        Model model = ModelFactory.getModel();
        List<String> list_names = model.getListNames();
        List<Integer> list_ids = model.getListIds();
        for (int i = 0; i < list_names.size(); i++)
        {
          if (list_ids.get(i) != Integer.parseInt(list_id))
          {
            //drop-down menu shows all lists available to be linked to the current list (not including itself)
      %>
      <option value=<%=list_ids.get(i)%>><%=list_ids.get(i) + ")" + " " + list_names.get(i)%></option>
      <%}
      }%>
    </select>
    <div></div>
    <br>

    <input type = "submit" value="Submit">
  </form>
</div>
</body>
</html>
