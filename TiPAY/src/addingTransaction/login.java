package addingTransaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter pt = response.getWriter();
		if (username != "" && password != ""){
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:login";
				Connection con = (Connection) DriverManager.getConnection(url, "system", "Nitish");
				Statement st = ((java.sql.Connection) con).createStatement();
				ResultSet rs;		
				String sql = "select * from login where username='"+username+"' and password='"+password+"'";
				rs = st.executeQuery(sql);
				while(rs.next()){
					String uname = rs.getString(1);
					String pwd = rs.getString(2);
					if (uname.equalsIgnoreCase(username) && pwd.equalsIgnoreCase(password)){
						response.sendRedirect("welcome.jsp");					
					}			
				}
				con.close();		
			}catch(Exception ex){
			pt.println("Unable to connect to database"+ex);}	
		}
	}

}
