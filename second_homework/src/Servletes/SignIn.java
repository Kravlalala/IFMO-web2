package Servletes;

import DataClasses.PMF;
import DataClasses.ValidData;
import Exceptions.InvalidException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Илья on 18.12.2016.
 */
public class SignIn extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        String user=request.getParameter("id");
        String password=request.getParameter("password");
        Key key = KeyFactory.createKey(ValidData.class.getSimpleName(), password+user);
        try {
            ValidData author_user = pm.getObjectById(ValidData.class, key);
            request.setAttribute("result","success");
            request.getRequestDispatcher("complete.jsp").forward(request, response);
        }
        catch (JDOObjectNotFoundException e){
            request.setAttribute("result","Uncorrect username or password");
            request.getRequestDispatcher("complete.jsp").forward(request, response);

        }



    }
}
