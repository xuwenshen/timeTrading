package test3;

import java.sql.* ;  

public class DataBaseConnection{   
  private final String DBDRIVER = "com.mysql.jdbc.Driver";  
  private final String DBURL = "jdbc:mysql://localhost:3306/data";  
  private final String DBUSER = "root";  
  private final String DBPASSWORD = "123456";
  private Connection conn = null ;  
  public DataBaseConnection(){  
      try{  
          Class.forName(DBDRIVER) ;  
          conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;    
      }  
      catch (Exception e){  
          System.out.println("loading error");  
      }  
  }  
  public Connection getConnection() {
      return this.conn;
   }   
  public void close(){  
      try{  
          conn.close() ;  
      }catch (Exception e){  
          System.out.println("connecting error");  
      }         
  }  
} 