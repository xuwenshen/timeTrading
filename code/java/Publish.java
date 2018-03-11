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
	        // 设置lenient为false.
	        // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
	        format.setLenient(false);
	        format.parse(str);
	    } catch (ParseException e) {
	        // e.printStackTrace();
	        // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
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
            System.out.println("信息不完整 " + username + " " + keyword + " " + location + " " +
            price + " " + starttime + " " + endtime + " " + description);
        	req.setAttribute("publish_info", "信息不完整!");
        	req.setAttribute("usename", username);
        	req.getRequestDispatcher("/src/Publish.jsp").forward(req, resp);
        	return ;
        }else if ((location.length() > 50)){
        	System.out.println("地点太长 " + username + " " + keyword + " " + location + " " +
                    price + " " + starttime + " " + endtime + " " + description);
        	req.setAttribute("publish_info", "地点太长!");
        	req.setAttribute("usename", username);
        	req.getRequestDispatcher("/src/Publish.jsp").forward(req, resp);
        	return ;
        }else if ((price.length() > 50)){
        	System.out.println("价格太长 " + username + " " + keyword + " " + location + " " +
                    price + " " + starttime + " " + endtime + " " + description);
        	req.setAttribute("publish_info", "价格太长!");
        	req.setAttribute("usename", username);
        	req.getRequestDispatcher("/src/Publish.jsp").forward(req, resp);
        	return ;
        }else if ((keyword.length() > 50)){
        	System.out.println("关键词太长 " + username + " " + keyword + " " + location + " " +
                    price + " " + starttime + " " + endtime + " " + description);
        	req.setAttribute("publish_info", "关键词太长!");
        	req.setAttribute("usename", username);
        	req.getRequestDispatcher("/src/Publish.jsp").forward(req, resp);
        	return ;
        }else if ((description.length() > 50)){
        	System.out.println("备注太长 " + username + " " + keyword + " " + location + " " +
                    price + " " + starttime + " " + endtime + " " + description);
        	req.setAttribute("publish_info", "备注太长!");
        	req.setAttribute("usename", username);
        	req.getRequestDispatcher("/src/Publish.jsp").forward(req, resp);
        	return ;
        }else if(starttime.compareTo(endtime) >= 0){
        	System.out.println("开始时间应该在结束时间之前 " + username + " " + keyword + " " + location + " " +
                    price + " " + starttime + " " + endtime + " " + description);
        	req.setAttribute("publish_info", "开始时间应该在结束时间之前！");
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
        	System.out.println("时间格式不合法 " + username + " " + keyword + " " + location + " " +
                    price + " " + starttime + " " + endtime + " " + description);
        	req.setAttribute("publish_info", "时间格式不合法！");
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
