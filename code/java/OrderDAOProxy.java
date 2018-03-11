package test3;

import java.util.ArrayList;

public class OrderDAOProxy implements OrderDAO {

	private DataBaseConnection dbc = null; //定义数据库连接类
    private OrderDAO orderDAOImpl = null;    //声明DAO
 
    public OrderDAOProxy() throws Exception {  //构造方法中实例化连接与实例化DAO对象
        this.dbc = new DataBaseConnection();  //连接数据库
        this.orderDAOImpl = new OrderDAOImpl(this.dbc.getConnection());//实例化真实类
     }
    
    
	@Override
	public ArrayList<Order> SelectOrders() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Order> orders;
		try {
			orders = orderDAOImpl.SelectOrders(); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
		return orders;
	}


	@Override
	public ArrayList<Order> SelectPublished(User user) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Order> orders;
		try {
			orders = orderDAOImpl.SelectPublished(user); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
		return orders;
	}


	@Override
	public ArrayList<Order> SelectAccepted(User user) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Order> orders;
		try {
			orders = orderDAOImpl.SelectAccepted(user); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
		return orders;
	}


	@Override
	public int Create(Order order) throws Exception {
		// TODO Auto-generated method stub
		int flag;
		try {
            flag = orderDAOImpl.Create(order); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
        return flag;
	}


	@Override
	public Order SelectByID(int oid) throws Exception {
		// TODO Auto-generated method stub
		Order order;
		try {
			order = orderDAOImpl.SelectByID(oid); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
		return order;
	}


	@Override
	public int SetOrderedByID(int oid, String hid) throws Exception {
		// TODO Auto-generated method stub
		int flag;
		try {
			flag = orderDAOImpl.SetOrderedByID(oid, hid); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
		return flag;
	}


	@Override
	public int DeleteByID(int oid) throws Exception {
		// TODO Auto-generated method stub
		int flag;
		try {
			flag = orderDAOImpl.DeleteByID(oid); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
		return flag;
	}


	@Override
	public void DeleteByNID(String nid) throws Exception {
		// TODO Auto-generated method stub
		try {
			orderDAOImpl.DeleteByNID(nid); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
		return ;
	}


	@Override
	public void DeleteByHID(String hid) throws Exception {
		// TODO Auto-generated method stub
		try {
			orderDAOImpl.DeleteByHID(hid); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
		return ;
	}
}
