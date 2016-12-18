package Servletes;

import DataClasses.PMF;
import DataClasses.ValidData;
import Exceptions.IDException;
import Exceptions.PasswordException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by Илья on 18.12.2016.
 */
public class SignUp extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result="success";
        Pattern hasUppercase = Pattern.compile("[A-Z]");
        Pattern hasLowercase = Pattern.compile("[a-z]");
        Pattern hasNumber = Pattern.compile("\\d");
        String ID=request.getParameter("username");
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
            Key key = KeyFactory.createKey(ValidData.class.getSimpleName(), Password+ID);
            ValidData new_user = new ValidData(ID, Password);
            new_user.setKey(key);
            pm.makePersistent(new_user);
            request.setAttribute("result","success");
            request.getRequestDispatcher("checking.jsp").forward(request, response);
        }
        catch (PasswordException e){
            request.setAttribute("result",e.getMessage());
            request.getRequestDispatcher("checking.jsp").forward(request, response);
        }
        catch (IDException e){
            request.setAttribute("result",e.getMessage());
            request.getRequestDispatcher("checking.jsp").forward(request, response);
        }

    }
}
