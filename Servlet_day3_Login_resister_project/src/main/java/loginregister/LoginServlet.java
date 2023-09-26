package loginregister;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysqlconnection.ConnectionProvider;


public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		PrintWriter pw = response.getWriter();
		//response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");

		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			c = ConnectionProvider.getConnection();

			PreparedStatement ps = c.prepareStatement("select * from user where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet i = ps.executeQuery();
		
			if (i.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
				rd.forward(request, response);
			} else {
				pw.println("invalid user name and password");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}





