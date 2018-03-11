package test3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewAllUsers")
public class ViewAllUsers extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println(req.getContextPath());
        String username = req.getParameter("username");
        if (username.equals(null)){
        	username = (String)req.getAttribute("username");
        }
        System.out.println("ViewAllUsers " + username);
        
        if (!username.equals("root")){
        	req.setAttribute("viewusers_log", "您不是管理员");
        	req.setAttribute("is_admin", "no");
        	System.out.println("ViewAllUsers " + username);
        	req.getRequestDispatcher("/src/Manage.jsp").forward(req, resp);
        	return ;
        }
        
        UserDAO userDAOProxy = null;
        try {
        	userDAOProxy = DAOFactory.getUserDAOInstance();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        try {
        	System.out.println("ViewAllUsers Before");
            ArrayList<User> users = userDAOProxy.SelectUsers();
            
        	List<String> usernames = new ArrayList<String>();
        	
        	for (int i = 0; i < users.size(); i++){
        		usernames.add(users.get(i).getUsername());
        	}
        	req.setAttribute("users", usernames);
        	req.setAttribute("is_admin", "yes");
        	System.out.println("ViewAllUsers " + usernames.toString());
        	req.getRequestDispatcher("/src/Manage.jsp").forward(req, resp);
        	return ;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ;
    }
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		doPost(req, resp);
	}
}
