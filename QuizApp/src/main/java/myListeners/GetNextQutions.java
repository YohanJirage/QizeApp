package myListeners;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetQutions
 */
@WebServlet("/getNextQutions")
public class GetNextQutions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		con = (Connection) config.getServletContext().getAttribute("jdbccon");
	}

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		HttpSession session = request.getSession();
		 Integer qn = (Integer) session.getAttribute("qn");
		List<Integer> quetions = (List<Integer>) session.getAttribute("quetions");
		 if(qn == null)
		 {
			 qn = -1;
		 }
		 String ans ="";
		 
		 
		 
		 PreparedStatement ps;
		 ResultSet rs;

		 
		 try 
		 {
			ps = con.prepareStatement("select * from questions where qid=?");
			
			if(qn < quetions.size()-1)
			{
				qn++;
				
			}
			else
			{
				qn = 0;
				
				
			}
			ps.setInt(1, quetions.get(qn));
			rs = ps.executeQuery();
			session.setAttribute("qn", qn);
			
			
			char ch = 'a';
			
			out.print(qn +"<br/>");
			if(rs.next())
			{
				
		ans = rs.getString(7);
				

	       out.print("<html><head>"
                   + "<meta charset='ISO-8859-1'> "
                   + "<title>Insert title here</title>"
                   + "<!-- Latest compiled and minified CSS -->"
                   + "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>"
                   + "<!-- jQuery library -->"
                   + "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js'></script>"
                   + "<!-- Latest compiled JavaScript -->"
                   + "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>"
                   + "<script>"
                   + "$(document).ready(function() { "
                   + "  $('input[type=\"radio\"]').change(function() {"
                   + "    if ($(this).is(':checked')) {"
                   + "      var value = $(this).val();"
                   + "      if(value === '" + ans + "') {"
                   + "			 $('#answer').empty();"
                   + "        $('#answer').append('<p>Correct</p>');"
                   + "      } else {"
                   + "			$('#answer').empty();"
                   + "        $('#answer').append('<p>Wrong</p>');"
                   + "      }"
                   + "    }"
                   + "  });"
                   + "});"
                   + "</script>"
                   + "</head>"
                   + "<body>");
				
				out.print("<h2>"+rs.getInt(1)+" "+rs.getString(2)+"</h2>");
				out.print( ch +" <input type='radio' name='options' value='"+ ch++ +"'> "+rs.getString(3) +"</input><br/>");
				out.print( ch +" <input type='radio' name='options' value='"+ ch++ +"'> "+rs.getString(4) +"</input><br/>");
				out.print( ch +" <input type='radio' name='options' value='"+ ch++ +"'> "+rs.getString(5) +"</input><br/>");
				out.print( ch +" <input type='radio' name='options' value='"+ ch++ +"'> "+rs.getString(6) +"</input><br/>");
				
				
				out.print("<div id='answer'><p></p></div>");
				
			}
			
			
			
			
			
		 } 
		 catch
		 (Exception e)
		 {
			// TODO: handle exception
		 }
		 
			out.print("<form action='getPrevQuetion' method='post'>");
			out.print("<br/><input type='submit' class='btn-success' value='Previos' /> ");
			out.print("</form >");
			
			out.print("<form action='getNextQutions' method='post'>");
			out.print("<input type='submit' class='btn-success' value='Next' /><br/> ");
			out.print("</form >");
			
			out.print("<form action='home' method='post'>");
			out.print("<input type='submit' class='btn-success' value='Select_Topic' /><br/> ");
			out.print("</form >");
			
			out.print("</body>"
					+ "</html>");
		 
		
	}

}
