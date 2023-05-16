package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.MyList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewMyList.html")
public class ViewMyListServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Model model = ModelFactory.getModel();
        MyList myList;
        String stringId = request.getParameter("id");   //get current list's ID from URL query string

        int listId = Integer.parseInt(stringId); //current list id

        myList = model.get_list_by_id(listId);
        String string_linkedId = Integer.toString(myList.getLinked_list_id());

        request.setAttribute("current_id", stringId);
        request.setAttribute("list_text", myList.getText());
        request.setAttribute("url", myList.getUrl());
        request.setAttribute("image_url", myList.getImage_url());
        request.setAttribute("linked_list_id", string_linkedId);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/viewMyList.jsp");
        dispatch.forward(request, response);

    }
}
