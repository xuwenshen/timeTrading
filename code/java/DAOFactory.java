package test3;

import test3.*;

public class DAOFactory {
    public static UserDAO getUserDAOInstance() throws Exception { //取得DAO接口实例
       return new UserDAOProxy(); //取得代理类的实例
    }
    
    public static OrderDAO getOrderDAOInstance() throws Exception { //取得DAO接口实例
        return new OrderDAOProxy(); //取得代理类的实例
     }
}