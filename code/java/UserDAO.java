package test3;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import test3.User;
public interface UserDAO {
	
	public User SelectByID(String uid) throws Exception;
	
	public int Create(User user) throws Exception;
	
	public User ViewUserInfo(User user) throws Exception;
	
	public void UpdateUserInfo(User user) throws Exception;
	
	public int DeleteByID(String uid) throws Exception;
	
	public ArrayList<User> SelectUsers() throws Exception;
}
