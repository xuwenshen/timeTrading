package test3;

import java.util.ArrayList;

public interface OrderDAO {
	
	public ArrayList<Order> SelectOrders() throws Exception;
	
	public ArrayList<Order> SelectPublished(User user) throws Exception;
	
	public ArrayList<Order> SelectAccepted(User user) throws Exception;
	
	public int Create(Order order) throws Exception;
	
	public Order SelectByID(int oid) throws Exception;
	
	public int SetOrderedByID(int oid, String hid) throws Exception;
	
	public int DeleteByID(int oid) throws Exception;
	
	public void DeleteByNID(String nid) throws Exception;
	
	public void DeleteByHID(String hid) throws Exception;
}
