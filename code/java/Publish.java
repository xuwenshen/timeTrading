package test3;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@WebServlet("/Publish")
public class Publish  extends HttpServlet{
	

	private static boolean isValidDate(String str) throws java.text.ParseException {
	    boolean convertSuccess = true;
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    try {
	        // ����lenientΪfalse.
	        // ����SimpleDateFormat��ȽϿ��ɵ���֤���ڣ�����2007/02/29�ᱻ���ܣ���ת����2007/03/01
	        format.setLenient(false);
	        format.parse(str);
	    } catch (ParseException e) {
	        // e.printStackTrace();
	        // ���throw java.text.ParseException����NullPointerException����˵����ʽ����
	        convertSuccess = false;
	    }
	    return convertSuccess;
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println(req.getContextPath());
        
        req.setCharacterEncoding("utf-8");
    
        String username = req.getParameter("username");
        String keyword = req.getParameter("keyword");
        String location = req.getParameter("location");
        String price = req.getParameter("price");
        String starttime = req.getParameter("start");
        String endtime = req.getParameter("end");
        String description = req.getParameter("memo");

        System.out.println(username + " " + keyword + " " + location + " " +
        price + " " + starttime + " " + endtime + " " + description);
        
        if ((keyword.length() == 0) || (location.length()==0) || (price.length()==0)
        		|| (starttime.length()==0) || (endtime.length()==0) || (description.length()==0)){
            System.out.println("��Ϣ������ " + username + " " + keyword + " " + location + " " +
            price + " " + starttime + " " + endtime + " " + description);
        	req.setAttribute("publish_info", "��Ϣ������!");
        	req.setAttribute("usename", username);
        	req.getRequestDispatcher("/src/Publish.jsp").forward(req, resp);
        	return ;
        }else if ((location.length() > 50)){
        	System.out.println("�ص�̫�� " + username + " " + keyword + " " + location + " " +
                    price + " " + starttime + " " + endtime + " " + description);
        	req.setAttribute("publish_info", "�ص�̫��!");
        	req.setAttribute("usename", username);
        	req.getRequestDispatcher("/src/Publish.jsp").forward(req, resp);
        	return ;
        }else if ((price.length() > 50)){
        	System.out.println("�۸�̫�� " + username + " " + keyword + " " + location + " " +
                    price + " " + starttime + " " + endtime + " " + description);
        	req.setAttribute("publish_info", "�۸�̫��!");
        	req.setAttribute("usename", username);
        	req.getRequestDispatcher("/src/Publish.jsp").forward(req, resp);
        	return ;
        }else if ((keyword.length() > 50)){
        	System.out.println("�ؼ���̫�� " + username + " " + keyword + " " + location + " " +
                    price + " " + starttime + " " + endtime + " " + description);
        	req.setAttribute("publish_info", "�ؼ���̫��!");
        	req.setAttribute("usename", username);
        	req.getRequestDispatcher("/src/Publish.jsp").forward(req, resp);
        	return ;
        }else if ((description.length() > 50)){
        	System.out.println("��ע̫�� " + username + " " + keyword + " " + location + " " +
                    price + " " + starttime + " " + endtime + " " + description);
        	req.setAttribute("publish_info", "��ע̫��!");
        	req.setAttribute("usename", username);
        	req.getRequestDispatcher("/src/Publish.jsp").forward(req, resp);
        	return ;
        }else if(starttime.compareTo(endtime) >= 0){
        	System.out.println("��ʼʱ��Ӧ���ڽ���ʱ��֮ǰ " + username + " " + keyword + " " + location + " " +
                    price + " " + starttime + " " + endtime + " " + description);
        	req.setAttribute("publish_info", "��ʼʱ��Ӧ���ڽ���ʱ��֮ǰ��");
        	req.setAttribute("usename", username);
        	req.getRequestDispatcher("/src/Publish.jsp").forward(req, resp);
        	return ;
        }
        
        boolean start_valid = false;
        boolean end_valid = false;
        try {
        	start_valid = isValidDate(starttime);
        	end_valid = isValidDate(endtime);
		} catch (java.text.ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        if (!start_valid || !end_valid){
        	System.out.println("ʱ���ʽ���Ϸ� " + username + " " + keyword + " " + location + " " +
                    price + " " + starttime + " " + endtime + " " + description);
        	req.setAttribute("publish_info", "ʱ���ʽ���Ϸ���");
        	req.setAttribute("usename", username);
        	req.getRequestDispatcher("/src/Publish.jsp").forward(req, resp);
        	return ;
        }
        System.out.println("start time " + start_valid + "  end_valid " + end_valid);
        
        
        System.out.println("Publish to insert");
        OrderDAO orderDAOProxy = null;
        try {
            orderDAOProxy = DAOFactory.getOrderDAOInstance();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        Order order = new Order();
        order.setDescription(description);
        order.setEndtime(endtime);
        order.setNID(username);
        order.setIsOrdered(false);
        order.setKeyword(keyword);
        order.setPrice(price);
        order.setLocation(location);
        order.setStarttime(starttime);
        
        try {
        	System.out.println("Publish Before");
            int flag = orderDAOProxy.Create(order);
            
        	req.setAttribute("usename", username);
        	req.getRequestDispatcher("CheckOrders").forward(req, resp);
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
