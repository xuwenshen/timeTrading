package test3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrderDetail")
public class OrderDetail extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println(req.getContextPath());
        
        String username = req.getParameter("username");
        System.out.println("OrderDetail " + username);
        int oid = Integer.parseInt(req.getParameter("oid"));
        System.out.println("OrderDetail " + oid);
        
        OrderDAO orderDAOProxy = null;
        try {
        	orderDAOProxy = DAOFactory.getOrderDAOInstance();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        try {
        	System.out.println("OrderDetail Before");
        	System.out.println("OrderDetail " + username + " " + oid);
            Order order = orderDAOProxy.SelectByID(oid);
            
    		String starttime = order.getStarttime();
    		String endtime = order.getEndtime();
    		String nid = order.getNID();
    		String price = order.getPrice();
    		String keyword = order.getKeyword();
    		String location = order.getLocation();
    		String description = order.getDescription();
    		String hid = order.getHID();

    		System.out.println(starttime + " " + endtime + " " + nid + " " + price + " " + keyword + " " 
    		+ location + " " + description + " " + hid);
    		
        	req.setAttribute("username", username);
        	req.setAttribute("starttime", starttime);
        	req.setAttribute("endtime", endtime);
        	req.setAttribute("nid", nid);
        	req.setAttribute("price", price);
        	req.setAttribute("keyword", keyword);
        	req.setAttribute("location", location);
        	req.setAttribute("oid", oid);
        	req.setAttribute("description", description);
        	req.setAttribute("hid", hid);
        	System.out.println("OrderDetail price " + price);
        	req.getRequestDispatcher("/src/OrderDetail.jsp").forward(req, resp);
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
