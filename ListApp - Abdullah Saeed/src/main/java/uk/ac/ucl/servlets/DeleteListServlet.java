package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Json_list;
import uk.ac.ucl.model.Json_listFactory;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete-list.html")
public class DeleteListServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Model model = ModelFactory.getModel();
        int listId = Integer.parseInt(request.getParameter("id"));  //gets current id from query string
        model.delete_list(listId);

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/list_delete_success.jsp");
        dispatcher.forward(request, response);
    }
}
