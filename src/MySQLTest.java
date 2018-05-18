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
    	String username = "root";   	//�d�ҡA�ϥΪ�ID
    	String password = "123456789";	//�d�ҡA�ϥΪ̱K�X
    	Connection con = null;
    	Statement stat = null; 	//����,�ǤJ��sql������r�� 
    	ResultSet rs = null; 	//���G�� 
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
