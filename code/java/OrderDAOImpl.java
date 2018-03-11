package test3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class OrderDAOImpl implements OrderDAO{

	private Connection conn = null;
    private PreparedStatement pstmt = null;
	 
    public OrderDAOImpl(Connection conn) {//构造方法取得与数据库连接
       this.conn = conn;
    }
    
	@Override
	public ArrayList<Order> SelectOrders() throws Exception {
		// TODO Auto-generated method stub
		
        System.out.println("SelectOrders()");
		String sql = "SELECT * FROM userorder where is_ordered=?";  
        this.pstmt = this.conn.prepareStatement(sql);   //预编译
        this.pstmt.setBoolean(1, false);
        ResultSet rs = pstmt.executeQuery();
    	
        ArrayList<Order> orders = new ArrayList<Order>();
        while (rs.next()) {
        	
        	String nid = rs.getString("NID");
        	String starttime = rs.getString("StartTime");
        	String endtime = rs.getString("EndTime");
        	String price = rs.getString("Price");
        	String location = rs.getString("Location");
        	int oid = rs.getInt("OID");
        	String keyword = rs.getString("KeyWord");
        	
        	Order order = new Order();
        	order.setStarttime(starttime);
        	order.setEndtime(endtime);
        	order.setNID(nid);
        	order.setPrice(price);
        	order.setOID(oid);
        	order.setKeyword(keyword);
        	order.setLocation(location);
        	
        	orders.add(order);
        	
        	System.out.println(order.getStarttime());
        	
        }
		return orders;
	}

	@Override
	public ArrayList<Order> SelectPublished(User user) throws Exception {
		// TODO Auto-generated method stub
        System.out.println("SelectPublished()");
		String sql = "SELECT * FROM userorder where nid=?";  
        this.pstmt = this.conn.prepareStatement(sql);   //预编译
        this.pstmt.setString(1, user.getUsername());
        ResultSet rs = pstmt.executeQuery();
    	
        ArrayList<Order> orders = new ArrayList<Order>();
        while (rs.next()) {
        	
        	String nid = rs.getString("NID");
        	String starttime = rs.getString("StartTime");
        	String endtime = rs.getString("EndTime");
        	String price = rs.getString("Price");
        	String location = rs.getString("Location");
        	int oid = rs.getInt("OID");
        	String keyword = rs.getString("KeyWord");
        	
        	Order order = new Order();
        	order.setStarttime(starttime);
        	order.setEndtime(endtime);
        	order.setNID(nid);
        	order.setPrice(price);
        	order.setOID(oid);
        	order.setKeyword(keyword);
        	order.setLocation(location);
        	
        	orders.add(order);
        	
        	System.out.println(order.getStarttime());
        	
        }
		return orders;
	}

	@Override
	public ArrayList<Order> SelectAccepted(User user) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SelectPublished()");
		String sql = "SELECT * FROM userorder where hid=?";  
        this.pstmt = this.conn.prepareStatement(sql);   //预编译
        this.pstmt.setString(1, user.getUsername());
        ResultSet rs = pstmt.executeQuery();
    	
        ArrayList<Order> orders = new ArrayList<Order>();
        while (rs.next()) {
        	
        	String nid = rs.getString("NID");
        	String starttime = rs.getString("StartTime");
        	String endtime = rs.getString("EndTime");
        	String price = rs.getString("Price");
        	String location = rs.getString("Location");
        	int oid = rs.getInt("OID");
        	String keyword = rs.getString("KeyWord");
        	
        	Order order = new Order();
        	order.setStarttime(starttime);
        	order.setEndtime(endtime);
        	order.setNID(nid);
        	order.setPrice(price);
        	order.setOID(oid);
        	order.setKeyword(keyword);
        	order.setLocation(location);
        	
        	orders.add(order);
        	
        	System.out.println(order.getStarttime());
        	
        }
		return orders;
	}

	@Override
	public int Create(Order order) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int flag = 0; //0表示成功，1表示存在用户
		
		String starttime = order.getStarttime();
		String endtime = order.getEndtime();
		String nid = order.getNID();
		String hid = "";
		String price = order.getPrice();
		String description = order.getDescription();
		String location = order.getLocation();
		String keyword = order.getKeyword();
		
        System.out.println("Create before insert");
        
        String sql = "insert into UserOrder(starttime,endtime,nid, hid, description,location,keyword,price,is_ordered)"
        		+ " values (" + "'" + starttime + "',"
        		+ "'" + endtime + "',"
        		+ "'" + nid + "',"
        		+ "'" + hid + "',"
        		+ "'" + description + "',"
        		+ "'" + location + "',"
        		+ "'" + keyword + "',"
				+ "'" + price + "',"
				+ "'0')";
    	this.pstmt = this.conn.prepareStatement(sql);   //预编译
    	System.out.println(this.pstmt.toString());
    	
    	pstmt.executeUpdate();
    	System.out.println("Publish update ready");
    	
		return flag;
	}

	@Override
	public Order SelectByID(int oid) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SelectByID()");
		String sql = "SELECT * FROM userorder where oid=?";  
        this.pstmt = this.conn.prepareStatement(sql);   //预编译
        this.pstmt.setInt(1, oid);
        System.out.println(this.pstmt.toString());
        ResultSet rs = pstmt.executeQuery();
        
        Order order = new Order();
        if (rs.next()){
        	order = new Order();
        	order.setDescription(rs.getString("description"));
        	System.out.println(rs.getString("description"));
        	order.setEndtime(rs.getString("endtime"));
        	System.out.println(rs.getString("endtime"));
        	order.setStarttime(rs.getString("starttime"));
        	System.out.println(rs.getString("starttime"));
        	order.setKeyword(rs.getString("keyword"));
        	System.out.println(rs.getString("keyword"));
        	order.setLocation(rs.getString("location"));
        	System.out.println(rs.getString("location"));
        	order.setNID(rs.getString("nid"));
        	System.out.println(rs.getString("nid"));
        	order.setPrice(rs.getString("price"));
        	System.out.println(rs.getString("price"));
        	order.setHID(rs.getString("HID"));
        	System.out.println(rs.getString("HID"));
        	order.setOID(oid);
        }
		return order;
	}

	@Override
	public int SetOrderedByID(int oid, String hid) throws Exception {
		// TODO Auto-generated method stub
        
		String sql = "update UserOrder set hid=?,is_ordered=? where OID=?";
        this.pstmt = this.conn.prepareStatement(sql);   //预编译
        this.pstmt.setString(1, hid);
        this.pstmt.setBoolean(2, true);
        this.pstmt.setInt(3, oid);
		System.out.println(this.pstmt.toString());
        
        int cnt = pstmt.executeUpdate();
        if (cnt > 0){
    		System.out.println("AcceptOrder " + cnt);
    		return 0;
        }else{
        	return 1;
        }
	}

	@Override
	public int DeleteByID(int oid) throws Exception {
		// TODO Auto-generated method stub
		int flag;
		String sql = "delete from userorder where oid=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1, oid);
        int cnt = this.pstmt.executeUpdate();
        
        if (cnt > 0){
        	flag = 0;
        	return flag;
        }else{
        	flag = 1;
        	return flag;
        }
	}

	@Override
	public void DeleteByNID(String nid) throws Exception {
		// TODO Auto-generated method stub
		int flag; // 0 表示成功删除需求, 1表示无法从数据库删除需求   
		
		String sql = "Delete FROM userorder where nid=?";  
        this.pstmt = this.conn.prepareStatement(sql);   //预编译
        this.pstmt.setString(1, nid);
        int cnt = pstmt.executeUpdate();
    	
        return ;
        
	}

	@Override
	public void DeleteByHID(String hid) throws Exception {
		// TODO Auto-generated method stub
		int flag; // 0 表示成功删除需求, 1表示无法从数据库删除需求   
		String sql = "delete FROM userorder where hid=?";  
        this.pstmt = this.conn.prepareStatement(sql);   //预编译
        this.pstmt.setString(1, hid);
        int cnt = pstmt.executeUpdate();
    	
        return ;
        
	}
}
