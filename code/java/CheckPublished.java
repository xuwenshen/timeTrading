package test3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheckPublished")
public class CheckPublished extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println(req.getContextPath());
        String username = req.getParameter("username");
        System.out.println("CheckPublished " + username);
        if (username.equals(null)){
        	username = (String)req.getAttribute("username");
        	System.out.println("CheckPublished " + username);
        }
        System.out.println("CheckPublished " + username);
        
        User user = new User();
        user.setUsername(username);
        OrderDAO orderDAOProxy = null;
        try {
        	orderDAOProxy = DAOFactory.getOrderDAOInstance();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
        try {
        	System.out.println("CheckPublished Before");
            ArrayList<Order> orders = orderDAOProxy.SelectPublished(user);
            
        	List<String> starttimes = new ArrayList<String>();
        	List<String> endtimes = new ArrayList<String>();
        	List<String> nids = new ArrayList<String>();
        	List<String> prices = new ArrayList<String>();
        	List<String> keywords = new ArrayList<String>();
        	List<String> locations = new ArrayList<String>();
        	int[] oids = new int[orders.size()];
        	
        	for (int i = 0; i < orders.size(); i++){
        		starttimes.add(orders.get(i).getStarttime());
        		endtimes.add(orders.get(i).getEndtime());
        		nids.add(orders.get(i).getNID());
        		prices.add(orders.get(i).getPrice());
        		keywords.add(orders.get(i).getKeyword());
        		locations.add(orders.get(i).getLocation());
        		oids[i] = orders.get(i).getOID();
        		
        	}

        	req.setAttribute("orders_counter", orders.size());
        	req.setAttribute("starttimes", starttimes);
        	req.setAttribute("endtimes", endtimes);
        	req.setAttribute("nids", nids);
        	req.setAttribute("prices", prices);
        	req.setAttribute("keywords", keywords);
        	req.setAttribute("locations", locations);
        	req.setAttribute("oids", oids);
        	System.out.println("CheckPublished " + starttimes.toString());
        	req.setAttribute("username", username);
        	req.getRequestDispatcher("/src/NeedHistory.jsp").forward(req, resp);
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

