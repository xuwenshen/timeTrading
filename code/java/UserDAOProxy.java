package test3;

import test3.User;
import test3.UserDAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import test3.DataBaseConnection;
import test3.UserDAOImpl;

public class UserDAOProxy implements UserDAO{

	private DataBaseConnection dbc = null; //定义数据库连接类
    private UserDAO userDAOImpl = null;    //声明DAO
 
    public UserDAOProxy() throws Exception {  //构造方法中实例化连接与实例化DAO对象
        this.dbc = new DataBaseConnection();  //连接数据库
        this.userDAOImpl = new UserDAOImpl(this.dbc.getConnection());//实例化真实类
     }
    
	@Override
	public User SelectByID(String uid) throws Exception {
		// TODO Auto-generated method stub
	    
        User user;  //首先要定义要返回的变量
        try {
        	user = userDAOImpl.SelectByID(uid); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
        return user;
    }

	@Override
	public int Create(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag;
		try {
            flag = userDAOImpl.Create(user); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
        return flag;
	}

	@Override
	public User ViewUserInfo(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			user = userDAOImpl.ViewUserInfo(user); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
        return user;
	}

	@Override
	public void UpdateUserInfo(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			userDAOImpl.UpdateUserInfo(user); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
        return ;
	}

	@Override
	public int DeleteByID(String uid) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		try {
			flag = userDAOImpl.DeleteByID(uid); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
        return flag;
	}

	@Override
	public ArrayList<User> SelectUsers() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<User> users;
		try {
			users = userDAOImpl.SelectUsers(); //调用真实主题操作   
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close(); //关闭数据库
        }
		return users;
	}
}
