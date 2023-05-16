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


@WebServlet("/edit-list.html")
public class EditListServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Model model = ModelFactory.getModel();

        String stringId = request.getParameter("id");   //get current list's ID from URL query string
        int listId = Integer.parseInt(stringId);

        //get list contents from webpage form
        String list_name = request.getParameter("list_name");
        String list_text = request.getParameter("list_text");
        String url = request.getParameter("url");
        String image_url = request.getParameter("image_url");
        String linked_list_id = request.getParameter("lists_available");
        int link_id = -999;
        if (!linked_list_id.isEmpty())
        {
            link_id = Integer.parseInt(linked_list_id);
        }

        model.edit_list(listId, list_name, list_text, url, image_url, link_id);

        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/list_edit_success.jsp");
        dispatcher.forward(request, response);
    }
}
