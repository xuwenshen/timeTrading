package test3;

import java.util.ArrayList;

public class OrderDAOProxy implements OrderDAO {

	private DataBaseConnection dbc = null; //�������ݿ�������
    private OrderDAO orderDAOImpl = null;    //����DAO
 
    public OrderDAOProxy() throws Exception {  //���췽����ʵ����������ʵ����DAO����
        this.dbc = new DataBaseConnection();  //�������ݿ�
        this.orderDAOImpl = new OrderDAOImpl(this.dbc.getConnection());//ʵ������ʵ��
     }
    
    
	@Override
	public ArrayList<Order> SelectOrders() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Order> orders;
		try {
			orders = orderDAOImpl.SelectOrders(); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
		return orders;
	}


	@Override
	public ArrayList<Order> SelectPublished(User user) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Order> orders;
		try {
			orders = orderDAOImpl.SelectPublished(user); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
		return orders;
	}


	@Override
	public ArrayList<Order> SelectAccepted(User user) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Order> orders;
		try {
			orders = orderDAOImpl.SelectAccepted(user); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
		return orders;
	}


	@Override
	public int Create(Order order) throws Exception {
		// TODO Auto-generated method stub
		int flag;
		try {
            flag = orderDAOImpl.Create(order); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
        return flag;
	}


	@Override
	public Order SelectByID(int oid) throws Exception {
		// TODO Auto-generated method stub
		Order order;
		try {
			order = orderDAOImpl.SelectByID(oid); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
		return order;
	}


	@Override
	public int SetOrderedByID(int oid, String hid) throws Exception {
		// TODO Auto-generated method stub
		int flag;
		try {
			flag = orderDAOImpl.SetOrderedByID(oid, hid); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
		return flag;
	}


	@Override
	public int DeleteByID(int oid) throws Exception {
		// TODO Auto-generated method stub
		int flag;
		try {
			flag = orderDAOImpl.DeleteByID(oid); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
		return flag;
	}


	@Override
	public void DeleteByNID(String nid) throws Exception {
		// TODO Auto-generated method stub
		try {
			orderDAOImpl.DeleteByNID(nid); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
		return ;
	}


	@Override
	public void DeleteByHID(String hid) throws Exception {
		// TODO Auto-generated method stub
		try {
			orderDAOImpl.DeleteByHID(hid); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
		return ;
	}
}
