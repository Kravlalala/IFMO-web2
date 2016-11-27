package Servletes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import Exceptions.IDException;
import Exceptions.PasswordException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import DataClasses.PMF;
import DataClasses.ValidData;
/**
 * Created by kravlala on 20.11.16.
 */
public class SignUpServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result="success";
        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
        Pattern hasUppercase = Pattern.compile("[A-Z]");
        Pattern hasLowercase = Pattern.compile("[a-z]");
        Pattern hasNumber = Pattern.compile("\\d");
        String ID=request.getParameter("id");
        String Password=request.getParameter("password");
        String Confirm=request.getParameter("password2");
        try {
            if(ID.isEmpty())
                throw new IDException("ID field is empty");
            if (Password.isEmpty())
                throw new PasswordException("Password field is empty");
            if (hasUppercase.matcher(Password).find() == false)
                throw new PasswordException("Password needs an upper case");
            if (hasLowercase.matcher(Password).find() == false)
                throw new PasswordException("Password needs a lowercase");
            if (hasNumber.matcher(Password).find() == false)
                throw new PasswordException("Password needs a number");
            if (!Password.equals(Confirm))
                throw new PasswordException("Passwords doesn't matched, please try again");
            PersistenceManager pm = PMF.get().getPersistenceManager();
            Key key = KeyFactory.createKey(ValidData.class.getSimpleName(), ID);
            ValidData new_user = new ValidData(ID, Password);
            new_user.setKey(key);
            pm.makePersistent(new_user);
            response.getWriter().write(result);
          /*  RequestDispatcher dispatcher = request.getRequestDispatcher("complete.jsp");
            if (dispatcher == null) {
                response.sendError(response.SC_NO_CONTENT);
            }
            else
                try {
                    dispatcher.include(request, response);
                } catch (IOException e) {
                } catch (ServletException e) {
                }*/
        }
        catch (PasswordException e){
            response.getWriter().write(e.getMessage());
        }
        catch (IDException e){
            response.getWriter().write(e.getMessage());
        }
    }
}
