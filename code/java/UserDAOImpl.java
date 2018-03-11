package test3;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import test3.UserDAO;
import test3.User;

public class UserDAOImpl implements UserDAO{
	
	private Connection conn = null;
    private PreparedStatement pstmt = null;
	 
    public UserDAOImpl(Connection conn) {//构造方法取得与数据库连接
       this.conn = conn;
    }

	@Override
	public User SelectByID(String uid) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0; //0表示成功，1表示不存在用户，2表示密码错误
        String sql = "SELECT * FROM user where uid=?";  
        this.pstmt = this.conn.prepareStatement(sql);   //预编译
        this.pstmt.setString(1, uid);
        ResultSet rs = pstmt.executeQuery();  
        
        User user = new User();
        
        if (rs.next()) {
            user.setUsername(rs.getString("uid"));
            user.setPwd(rs.getString("loginpwd"));
        }
        else{
            user.setUsername("");
            user.setPwd("");
        }
        this.pstmt.close();  //关闭打开的操作
        return user;
	}

	@Override
	public int Create(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0; //0表示成功，1表示存在用户
		
		String username = user.getUsername();
		String pwd = user.getPwd();
		
        String sql = "SELECT * FROM user where uid=?";  
        this.pstmt = this.conn.prepareStatement(sql);   //预编译
        this.pstmt.setString(1, username);
        
        ResultSet rs;
        System.out.println("Before select");
        rs = pstmt.executeQuery();  
        if (rs.next()){
        	System.out.println("user exits");
        	flag = 1;
        }else{
        	System.out.println("Before insert");
        	sql = "insert into User(UID,LoginPwd,NickName,Skills,Signature) values ('"
					+ username + "','" + pwd + "','" + "NickName" + "','" + "Skills" + "','" + "Signature" + "')";
        	this.pstmt = this.conn.prepareStatement(sql);   //预编译
        	System.out.println(this.pstmt.toString());
        	int cnt = pstmt.executeUpdate();
        	System.out.println("update ready");
			flag = 0;
        }
        
		return flag;
	}

	@Override
	public User ViewUserInfo(User user) throws Exception {
		// TODO Auto-generated method stub
		
		String username = user.getUsername();
		
        String sql = "SELECT * FROM user where uid=?";  
        this.pstmt = this.conn.prepareStatement(sql);   //预编译
        this.pstmt.setString(1, username);
        ResultSet rs = pstmt.executeQuery();
        
		System.out.println("UserInfo username " + username);
		
		if (rs.next()){
			user.setNickname(rs.getString("nickname"));
			user.setSkill(rs.getString("skills"));
			user.setSignature(rs.getString("signature"));
			System.out.println("Signature " + rs.getString("signature"));
		}
		
		System.out.println("UserInfo" + rs.getString("signature"));
		return user;
	}

	@Override
	public void UpdateUserInfo(User user) throws Exception {
		// TODO Auto-generated method stub
		String username = user.getUsername();
		System.out.println(user.getNickname());
        System.out.println("Update Info " + user.getNickname() + " " + user.getSkill() + " " + user.getSignature());
		String sql = "update User set NickName=?,Skills=?,Signature=? where UID=?";
        this.pstmt = this.conn.prepareStatement(sql);   //预编译
        this.pstmt.setString(1, user.getNickname());
        this.pstmt.setString(2, user.getSkill());
        this.pstmt.setString(3, user.getSignature());
        this.pstmt.setString(4, user.getUsername());
        
		System.out.println(this.pstmt.toString());
        
        int rs = pstmt.executeUpdate();
        if (rs > 0){
    		System.out.println("UserInfo username " + username);
        }
	}

	@Override
	public int DeleteByID(String uid) throws Exception {
		// TODO Auto-generated method stub
		int flag; // 0表示成功删除；1表示数据错误无法删除
		String sql = "DELETE FROM user where uid=?"; 
        this.pstmt = this.conn.prepareStatement(sql);   //预编译
        this.pstmt.setString(1, uid);
        System.out.println(this.pstmt.toString());
        
        int cnt = pstmt.executeUpdate();  
        if (cnt > 0){
        	flag = 0;
        }else{
        	flag = 1;
        }
		return flag;
	}

	@Override
	public ArrayList<User> SelectUsers() throws Exception {
		// TODO Auto-generated method stub

        System.out.println("SelectUsers()");
		String sql = "SELECT * FROM user where uid != ?";  
        this.pstmt = this.conn.prepareStatement(sql);   //预编译
        this.pstmt.setString(1, "root");
        ResultSet rs = pstmt.executeQuery();
    	
        ArrayList<User> users = new ArrayList<User>();
        while (rs.next()) {
        	
        	String nid = rs.getString("UID");
        	
        	User user = new User();
        	user.setUsername(nid);
        	users.add(user);
        	System.out.println(user.getUsername());
        	
        }
		return users;

	}
}
