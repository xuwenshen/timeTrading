package test3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewUserInfo")
public class ViewUserInfo extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println(req.getContextPath());
        req.setCharacterEncoding("utf-8");
        
        String username = req.getParameter("username");
        System.out.println("ViewUserInfo " + username);
        
        UserDAO userDAOProxy = null;
        try {
            userDAOProxy = DAOFactory.getUserDAOInstance();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        User user = new User();
        user.setUsername(username);
        
        try {
        	System.out.println(" ViewUserInfo Before");
            user = userDAOProxy.ViewUserInfo(user);
            req.setAttribute("username", username);
        	req.setAttribute("skills", user.getSkill());
        	req.setAttribute("nickname", user.getNickname());
        	req.setAttribute("signature", user.getSignature());
        	System.out.println("signature " + user.getSignature());
            req.getRequestDispatcher("/src/UserInfo.jsp").forward(req, resp);
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
