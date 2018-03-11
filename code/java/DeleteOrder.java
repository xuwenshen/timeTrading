package test3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DeleteOrder")
public class DeleteOrder extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

		int flag;

        System.out.println(req.getContextPath());
        String username = req.getParameter("username");
        if (username.equals(null)){
        	username = (String)req.getAttribute("username");
        }
        
        req.setCharacterEncoding("gb2312");
        resp.setContentType("text/html");
        
        int oid = Integer.parseInt(req.getParameter("oid"));
        
        Order order;
        
        try {
        	System.out.println("DeleteOrder Before");
        	OrderDAO orderDAOProxy = null;
            try {
                orderDAOProxy = DAOFactory.getOrderDAOInstance();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            
            if(username.equals("root")){
            	flag = orderDAOProxy.DeleteByID(oid);
            	if (flag == 0){
            		req.setAttribute("delete_log", "ɾ���ɹ�");
            	}else if(flag == 1){
            		req.setAttribute("delete_log", "���ݴ���ɾ��ʧ��");
            	}
            }else{
            	order = orderDAOProxy.SelectByID(oid);
            	if (!order.getNID().equals(username)){
            		req.setAttribute("delete_log", "��ͨ�û�����ɾ�������û�������");
            	}else if(order.getIsOrdered() == true){
            		req.setAttribute("delete_log", "����ɾ���ѱ����ܵ�����");
            	}else{
            		try {
                        orderDAOProxy = DAOFactory.getOrderDAOInstance();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
            		flag = orderDAOProxy.DeleteByID(oid);
                	if (flag == 0){
                		req.setAttribute("delete_log", "ɾ���ɹ�");
                	}else if(flag == 1){
                		req.setAttribute("delete_log", "���ݴ���ɾ��ʧ��");
                	}
            	}
            }
        	req.setAttribute("username", username);
        	
            req.getRequestDispatcher("/src/DeleteOrder.jsp").forward(req, resp);
            return ;
            
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
