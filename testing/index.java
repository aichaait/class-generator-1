package testing;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class index {
    @WebServlet("/submit-form")
    public class SubmitFormServlet extends HttpServlet {
      @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    
        // Do something with the user input...
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
      }
    }
    
}
