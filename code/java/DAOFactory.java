package test3;

import test3.*;

public class DAOFactory {
    public static UserDAO getUserDAOInstance() throws Exception { //ȡ��DAO�ӿ�ʵ��
       return new UserDAOProxy(); //ȡ�ô������ʵ��
    }
    
    public static OrderDAO getOrderDAOInstance() throws Exception { //ȡ��DAO�ӿ�ʵ��
        return new OrderDAOProxy(); //ȡ�ô������ʵ��
     }
}