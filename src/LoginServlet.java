import java.io.IOException;
import javax.servlet.http.Cookie;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");	
		String v1=request.getParameter("username");
		String v2=request.getParameter("pasword");	
		
		PrintWriter out=response.getWriter();
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/world","root","chethanbs@2610");
			String q=("select * from emp_table where userid=? and password=?");
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1, v1);
			pst.setString(2, v2);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				Cookie ck=new Cookie("name", v1);
			    ck.setMaxAge(600);
				response.addCookie(ck);
		        response.sendRedirect("mainpage.jsp");
		        return;
			}
			else
			{
				
				//out.print("<div style= margin:400px;position:absolute;left:160px;top:50px;>");
			    RequestDispatcher rd=request.getRequestDispatcher("login1.jsp");
			    out.println("<font color:red>Either user name or password is wrong.</font>");
			    rd.include(request, response);
			}	
			con.close();
			pst.close();
		}
		catch(Exception e)
		{
			System.out.println("--catch block--");
			e.printStackTrace();
		}
	}
}