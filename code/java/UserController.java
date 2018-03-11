package test3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserController")
public class UserController extends HttpServlet{
	
	Login login = new Login();
	
	Register register = new Register();
	
	ViewUserInfo viewUserInfo = new ViewUserInfo();
	
	UpdateUserInfo updateUserInfo = new UpdateUserInfo();
	
	ViewAllUsers viewAllUsers = new ViewAllUsers();
	
	DeleteUser deleteUser = new DeleteUser();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String func = req.getParameter("func");
		System.out.println("func " + func);
		
		if (func.equals("Login")){
			
			login.doPost(req, resp);		
			System.out.println("In Login");
			return ;
		}
		else if (func.equals("Register")){
			
			register.doPost(req, resp);	
			System.out.println("In Register");
			return ;
		}
		else if (func.equals("ViewUserInfo")){
			
			viewUserInfo.doPost(req, resp);	
			System.out.println("In ViewUserInfo");
			return ;
		}
		else if (func.equals("UpdateUserInfo")){
			
			updateUserInfo.doPost(req, resp);
			System.out.println("In UpdateUserInfo");
			return ;
		}
		else if (func.equals("ViewAllUsers")){
			
			viewAllUsers.doPost(req, resp);	
			System.out.println("In ViewAllUsers");
			return ;
		}else if (func.equals("DeleteUser")){
			
			deleteUser.doPost(req, resp);	
			System.out.println("In DeleteUser");
			return ;
		}

	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
}
