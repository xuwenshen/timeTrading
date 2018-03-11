package test3;

import test3.User;
import test3.UserDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import test3.DataBaseConnection;
import test3.UserDAOImpl;

public class UserDAOProxy implements UserDAO{

	private DataBaseConnection dbc = null; //�������ݿ�������
    private UserDAO userDAOImpl = null;    //����DAO
 
    public UserDAOProxy() throws Exception {  //���췽����ʵ����������ʵ����DAO����
        this.dbc = new DataBaseConnection();  //�������ݿ�
        this.userDAOImpl = new UserDAOImpl(this.dbc.getConnection());//ʵ������ʵ��
     }
    
	@Override
	public User SelectByID(String uid) throws Exception {
		// TODO Auto-generated method stub
	    
        User user;  //����Ҫ����Ҫ���صı���
        try {
        	user = userDAOImpl.SelectByID(uid); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
        return user;
    }

	@Override
	public int Create(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag;
		try {
            flag = userDAOImpl.Create(user); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
        return flag;
	}

	@Override
	public User ViewUserInfo(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			user = userDAOImpl.ViewUserInfo(user); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
        return user;
	}

	@Override
	public void UpdateUserInfo(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			userDAOImpl.UpdateUserInfo(user); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
        return ;
	}

	@Override
	public int DeleteByID(String uid) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			flag = userDAOImpl.DeleteByID(uid); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
        return flag;
	}

	@Override
	public ArrayList<User> SelectUsers() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<User> users;
		try {
			users = userDAOImpl.SelectUsers(); //������ʵ�������   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //�ر����ݿ�
        }
		return users;
	}
}
