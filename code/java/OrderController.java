package test3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet{
	
	public AcceptOrder acceptOrder = new AcceptOrder();
	
	public CheckAccepted checkAccepted = new CheckAccepted();
	
	public CheckPublished checkPublished = new CheckPublished();
	
	public DeleteOrder deleteOrder = new DeleteOrder();
	
	public OrderDetail orderDetail = new OrderDetail();
	
	public CheckOrders checkOrders = new CheckOrders();
	
	public Publish publish = new Publish();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String func = req.getParameter("func");
		System.out.println("func " + func);
		
		if (func.equals("AcceptOrder")){
			acceptOrder.doPost(req, resp);		
			System.out.println("In AcceptOrder");
			return ;
		}
		else if (func.equals("CheckAccepted")){
			
			checkAccepted.doPost(req, resp);	
			System.out.println("In CheckAccepted");
			return ;
		}
		else if (func.equals("CheckPublished")){
			
			checkPublished.doPost(req, resp);	
			System.out.println("In CheckPublished");
			return ;
		}
		else if (func.equals("DeleteOrder")){
			
			deleteOrder.doPost(req, resp);
			System.out.println("In DeleteOrder");
			return ;
		}
		else if (func.equals("OrderDetail")){
			
			orderDetail.doPost(req, resp);	
			System.out.println("In OrderDetail");
			return ;
		}
		else if (func.equals("Publish")){
			
			publish.doPost(req, resp);	
			System.out.println("In Publish");
			return ;
		}else if(func.equals("Main")){
			
			checkOrders.doPost(req, resp);
			System.out.println("In Main");
			return ;
		}

	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
}
