package myListeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ConnectionListener
 *
 */
@WebListener
public class ConnectionListener implements ServletContextListener {

	Connection con ;

 
	 public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
		 
		 String driver = sce.getServletContext().getInitParameter("Driver");
		 String jdbcurl = sce.getServletContext().getInitParameter("jdbcurl");
		 String user = sce.getServletContext().getInitParameter("user");
		 String password = sce.getServletContext().getInitParameter("password");
		 try 
		 {
			
			 Class.forName(driver);
			
			 con = DriverManager.getConnection(jdbcurl,user,password);
			 System.out.println("Connection Established with database");
			 sce.getServletContext().setAttribute("jdbccon", con);
		 } 
		 catch (ClassNotFoundException | SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
    }
	
	
	
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }


}
