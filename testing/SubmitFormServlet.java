package testing;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SubmitFormServlet")
  public class SubmitFormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    
        // Do something with the user input
        //print the username and password in yourData.html
        request.setAttribute("username", username);
        request.setAttribute("password", password);
    
        // Get a RequestDispatcher for yourData.html and forward the request
        RequestDispatcher rd = request.getRequestDispatcher("/yourData.html");
        rd.forward(request, response);
    }
    
    }
    
