package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class T_del
 */
@WebServlet("/T_del")
public class T_del extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T_del() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			   response.setContentType("text/html");
			   PrintWriter out=response.getWriter();
			   String n=request.getParameter("uname");
			   System.out.println(n);
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://root:_zq27kd-0f5w8g3qfucei-u$pph1onfx@monorail.proxy.rlwy.net:26454/railway","root","_zq27kd-0f5w8g3qfucei-u$pph1onfx");
			   PreparedStatement stmt=con.prepareStatement("delete from staff where t_id='"+n+"'");
			   int i=stmt.executeUpdate();
			   if(i==1)
			   {
				   RequestDispatcher rd=request.getRequestDispatcher("Adminlog");
				   rd.include(request, response);

				   
				   out.println(" <script>\r\n"
				   		+ "            alert(\"The data has been deleted\")\r\n"
				   		+ "        </script>");
				   
			   }
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
