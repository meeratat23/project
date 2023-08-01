package cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/adminlogin";
	private String dbUname = "root";
	private String dbPassword = "siddhivinayak";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
  Connection con;
	
    public void loadDriver(String dbDriver)
    {
    	try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
       } catch(ClassNotFoundException e) {
	      e.printStackTrace();
          }
	
      }
	public Connection getConnection()
    {
    	Connection con = null;
    	try {
    	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adminlogin" ,"root" , "siddhivinayak");
       } catch(SQLException e) {
    	e.printStackTrace();
       }
    	return con;
    }
    
    
	public boolean validate(Admin admin) {
		
		loadDriver(dbDriver);
		 Connection con = getConnection();
		 boolean status = false;
		// String sql = "select * from admin where username = ? and password=?";
		 
		 PreparedStatement ps;
		 try {
		    ps = con.prepareStatement("select * from admin where username = ? and password=?");
		    ps.setString(1, admin.getUsername());
		    ps.setString(2, admin.getPassword());
		 
		 
		
		  ResultSet rs = ps.executeQuery();
		  status = rs.next();
		
		
		  } catch(SQLException e) {
		    	e.printStackTrace();
		  }
             
		  return status;
    }

}