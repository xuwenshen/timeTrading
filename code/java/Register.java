package test3;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

import test3.*;


@WebServlet("/Register")
public class Register extends HttpServlet{
	
	private boolean checkChinese(String text) {  
		return text.matches("^[A-Za-z0-9]*");
    }  
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println(req.getContextPath());

        req.setCharacterEncoding("utf-8");
        
        String username = req.getParameter("username");
        String passward = req.getParameter("passwd");
        String passward2 = req.getParameter("passwd2");
        
        String str_null = new String();
        
        if ((username.equals(str_null)) || (passward.equals(str_null)) || (passward2.equals(str_null))){
        	req.setAttribute("reg_info", "信息不完整！");
        	System.out.println("信息不完整！");
        	req.getRequestDispatcher("/src/Reg.jsp").forward(req, resp);
        	return ;
        }else if (!passward.equals(passward2)){
        	req.setAttribute("reg_info", "两次密码不一致!");
        	System.out.println("两次密码不一致!");
        	req.getRequestDispatcher("/src/Reg.jsp").forward(req, resp);
        	return ;
        }
        else if (!checkChinese(username)){
        	req.setAttribute("reg_info", "用户名只能包含英文字母、数字及英文符号！");
        	System.out.println("用户名只能包含英文字母、数字及英文符号！");
        	req.getRequestDispatcher("/src/Reg.jsp").forward(req, resp);
        	return ;
        }else if ((username.length() > 50)){
        	req.setAttribute("reg_info", "用户名太长!");
        	System.out.println("用户名太长!");
        	req.getRequestDispatcher("/src/Reg.jsp").forward(req, resp);
        	return ;
        }else if ((passward.length() > 100)){
        	req.setAttribute("reg_info", "密码太长!");
        	System.out.println("密码太长!");
        	req.getRequestDispatcher("/src/Reg.jsp").forward(req, resp);
        	return ;
        }
        
        UserDAO userDAOProxy = null;
        try {
            userDAOProxy = DAOFactory.getUserDAOInstance();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        User user = new User();
        user.setUsername(username);
        user.setPwd(passward);
        
        try {
        	System.out.println("Before");
            int flag = userDAOProxy.Create(user);
            
            if (flag == 0) {
            	req.setAttribute("username", username);
                req.getRequestDispatcher("CheckOrders").forward(req, resp);
            } else if (flag == 1){
                req.setAttribute("reg_info", "用户名已存在!");
            	System.out.println("用户名已存在!");
            	req.getRequestDispatcher("/src/Reg.jsp").forward(req, resp);
            	return ;
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
