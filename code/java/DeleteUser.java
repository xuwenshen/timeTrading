package test3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
        
        System.out.println(req.getContextPath());
        String username = req.getParameter("username");
        System.out.println("DeleteUser " + username);
        if (username.equals(null)){
        	username = (String)req.getAttribute("username");
        	System.out.println("DeleteUser " + username);
        }
        
        System.out.println("DeleteUser " + username);
        if (!username.equals("root")){
        	req.setAttribute("username", username);
        	req.setAttribute("deleteuser_log", "您不是管理员");
        	req.getRequestDispatcher("/src/Manage.jsp").forward(req, resp);
        	return ;
        }
        
        String[] to_delete_usernames = null;
        Object info;
        info = req.getParameterValues("users");
        
        if (info == null){
        	req.setAttribute("username", username);
        	req.setAttribute("deleteuser_log", "未选择任何用户");
        	req.getRequestDispatcher("ViewAllUsers").forward(req, resp);
        	return ;
        }else{
        	to_delete_usernames = (String [])info;
        }
        
        try {
        	System.out.println(" DeleteUser Before");
        	for (int i = 0; i < to_delete_usernames.length; i++){
        		System.out.println(to_delete_usernames[i]);
        	}
        	for (int i = 0; i < to_delete_usernames.length; i++){
        		UserDAO userDAOProxy = null;
                try {
                    userDAOProxy = DAOFactory.getUserDAOInstance();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
        		userDAOProxy.DeleteByID(to_delete_usernames[i]);
        		System.out.println(" DeleteUser User " + i);
        		OrderDAO orderDAOProxy = null;
                try {
                    orderDAOProxy = DAOFactory.getOrderDAOInstance();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
        		orderDAOProxy.DeleteByHID(to_delete_usernames[i]);
        		System.out.println(" DeleteUser " + i);
                try {
                    orderDAOProxy = DAOFactory.getOrderDAOInstance();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
        		orderDAOProxy.DeleteByNID(to_delete_usernames[i]);
        		System.out.println(" DeleteUser UID " + i);
        	}
        	req.setAttribute("username", username);
        	req.getRequestDispatcher("ViewAllUsers").forward(req, resp);
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
