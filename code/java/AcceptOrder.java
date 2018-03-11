package test3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AcceptOrder")
public class AcceptOrder extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

		int flag;

        System.out.println("AcceptOrder " + req.getContextPath());
        
        req.setCharacterEncoding("gb2312");
        resp.setContentType("text/html");
        
        String username = req.getParameter("username");
        int oid = Integer.parseInt(req.getParameter("oid"));
        
        System.out.println("AcceptOrder " + username + " " + oid);
        
        OrderDAO orderDAOProxy = null;
        try {
            orderDAOProxy = DAOFactory.getOrderDAOInstance();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        Order order;
        
        try {
        	System.out.println("AcceptOrder Before");
            order = orderDAOProxy.SelectByID(oid);
            
            if (order.getIsOrdered() == true){
            	req.setAttribute("accept_log", "数据错误，接单失败");
            }else if (order.getNID().equals(username)){
            	req.setAttribute("accept_log", "不能接受自己的需求");
            }else{
            	try {
                    orderDAOProxy = DAOFactory.getOrderDAOInstance();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            	if (orderDAOProxy.SetOrderedByID(oid, username) == 0){
            		req.setAttribute("accept_log", "接单成功");
            	}else{
            		req.setAttribute("accept_log", "数据错误，接单失败");
            	}
            }
        	req.setAttribute("username", username);
            req.getRequestDispatcher("/src/AcceptOrder.jsp").forward(req, resp);
            return;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ;
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
			doGet(req, resp);
	}

}
