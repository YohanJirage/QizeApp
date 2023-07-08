package myListeners;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/quetions")
public class Quetions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con ;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		con = (Connection) config.getServletContext().getAttribute("jdbccon");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Integer> quetions =   (List<Integer>) session.getAttribute("quetions");
		int topicid = Integer.parseInt(request.getParameter("topicid"));
		
		 Integer qn = (Integer) session.getAttribute("qn");
		 session.setAttribute("qn", -1);
		
		if(quetions == null)
		{
			quetions = new ArrayList<>();
			session.setAttribute("quetions", quetions);
		}
		
		quetions.clear();
		session.setAttribute("quetions", quetions);
		
		PreparedStatement ps;
		ResultSet rs;
		
		try 
		{
			ps = con.prepareStatement("select qid from questions where topicid=?");
			ps.setInt(1, topicid);
			rs =ps.executeQuery();
			while(rs.next())
			{
				quetions.add(rs.getInt(1));
			}
			session.setAttribute("quetions", quetions);
			
			RequestDispatcher rd = request.getRequestDispatcher("/getNextQutions");
			rd.forward(request, response);
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		

	}

}
