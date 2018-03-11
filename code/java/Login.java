package test3;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import test3.*;

@WebServlet("/Login")
public class Login extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        System.out.println(req.getContextPath());
        
        req.setCharacterEncoding("gb2312");
        resp.setContentType("text/html");
        
        String username = req.getParameter("username");
        String passward = req.getParameter("passwd");
        String str_null = new String();
        if ((username.equals(str_null)) || (passward.equals(str_null))){
        	//req.getSession().setAttribute("login_info", "��Ϣ������!");
        	req.setAttribute("login_info", "��Ϣ������!");
        	System.out.println("��Ϣ������!");
        	req.getRequestDispatcher("/src/Login.jsp").forward(req, resp);
        	return ;
        }
        
        UserDAO userDAOProxy = null;
        try {
            userDAOProxy = DAOFactory.getUserDAOInstance();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        User user = new User();
        
        try {
        	System.out.println("Before");
        	user = userDAOProxy.SelectByID(username);
            
            if (user.getUsername().equals(username) && user.getPwd().equals(passward)) {
            	req.setAttribute("username", username);
                req.getRequestDispatcher("CheckOrders").forward(req, resp);
            } else if (user.getUsername().equals(username) && !user.getPwd().equals(passward)){
            	req.setAttribute("login_info", "�������");
            	System.out.println("�������");
            	req.getRequestDispatcher("/src/Login.jsp").forward(req, resp);
            }else{
            	req.setAttribute("login_info", "�û�������");
            	System.out.println("�û�������");
            	req.getRequestDispatcher("/src/Login.jsp").forward(req, resp);
            }
            
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
