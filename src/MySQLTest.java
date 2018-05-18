import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.util.ArrayList;  
  
public class MySQLTest {  
	
    public static void main(String[] args) {  
    	
    	try {
    	    System.out.println("Loading driver...");
    	    Class.forName("com.mysql.jdbc.Driver");
    	    System.out.println("Driver loaded!");
    	} catch (ClassNotFoundException e) {
    	    throw new RuntimeException("Cannot find the driver in the classpath!", e);
    	}
    	
    	
    	String url = "jdbc:mysql://localhost:3306/?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
    	String username = "root";   	//範例，使用者ID
    	String password = "123456789";	//範例，使用者密碼
    	Connection con = null;
    	Statement stat = null; 	//執行,傳入之sql為完整字串 
    	ResultSet rs = null; 	//結果集 
    	PreparedStatement pst = null; 
    	try {
    	    System.out.println("Connecting database...");
    	    con = DriverManager.getConnection(url, username, password);
    	    System.out.println("Database connected!");
    	} catch (SQLException e) {
    	    throw new RuntimeException("Cannot connect the database!", e);
    	} finally {
    	    System.out.println("Closing the connection.");
    	    if (con != null) try { con.close(); } catch (SQLException ignore) {}
    	}
             
    }  
  
}  
