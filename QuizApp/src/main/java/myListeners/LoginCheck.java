package myListeners;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.*;


@WebServlet("/logincheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;

	
	
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		 
		super.init(config);
		con = (Connection) config.getServletContext().getAttribute("jdbccon");
			
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		response.setContentType("text/html");
		
		 PrintWriter out = response.getWriter();
		 String uid = request.getParameter("uid");
		 String pwd = request.getParameter("pwd");
		 PreparedStatement ps=null ;
		 ResultSet rs=null;
		 try 
		 {
			ps = con.prepareStatement("select * from users where u_id = ? and password = ?");
			ps.setString(1, uid);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			
			 
			  
			if(rs.next())
			{
				User user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				session.setAttribute("userlogin", user) ;
				
	
				getServletContext().setAttribute("username", rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/home");

			        // Forward the request and response objects to the target servlet
			        dispatcher.forward(request, response);
//				out.print("Success");
			}
			else
			{
				response.sendRedirect("/QuizApp/Login.jsp");
				
					
				
			}
				
				
		 }
		 catch (SQLException e) 
		 {
			e.printStackTrace();
		 
		 }
		 finally
		 {
			 try 
			 {
				 rs.close();
				 ps.close();
			 } 
			 catch (SQLException e) 
			 {
				e.printStackTrace();
			 }
			
		 }
		 
	}

}
