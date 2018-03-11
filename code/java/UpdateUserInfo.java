package test3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateUserInfo")
public class UpdateUserInfo extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        System.out.println(req.getContextPath());
        
        req.setCharacterEncoding("utf-8");
        
        String username = req.getParameter("username");
        String nickname = req.getParameter("nickname");
        String skills = req.getParameter("skills");
        String signature = req.getParameter("signature");
        
        System.out.println("Update Info " + username + " " + nickname + " " + skills + " " + signature);
        
        if (nickname.length() > 50 || skills.length() > 100 || signature.length() > 100){
        	req.setAttribute("update_info_log", "个别信息太长！");
        	req.setAttribute("username", username);
            req.getRequestDispatcher("/src/UserInfo.jsp").forward(req, resp);
            return ;
        }
        
        System.out.println("Update Info " + username + " " + nickname + " " + skills + " " + signature);
        
        UserDAO userDAOProxy = null;
        try {
            userDAOProxy = DAOFactory.getUserDAOInstance();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        user.setSignature(signature);
        user.setSkill(skills);
        
        try {
        	System.out.println("Update Before");
            userDAOProxy.UpdateUserInfo(user);
        	req.setAttribute("username", username);
            req.getRequestDispatcher("ViewUserInfo").forward(req, resp);
            
            System.out.println("Update forward ViewUserInfo");
            return;
            
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
