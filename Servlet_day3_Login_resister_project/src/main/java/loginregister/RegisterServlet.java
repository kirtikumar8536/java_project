package loginregister;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysqlconnection.ConnectionProvider;

public class RegisterServlet extends HttpServlet {
	@Override
	//	public void init() throws ServletException {
	//		
	////		try {
	////			Class.forName("com.mysql.cj.jdbc.Driver");//database connection of mysql
	////			//com.mysql.jdbc.Driver-depricated
	////			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AndroLoginRegistration","root", "Root@123");
	////		} 
	////		catch (ClassNotFoundException | SQLException e) {
	////			
	////			e.printStackTrace();
	////		}
	////		
	//		
	//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c=null;
		PrintWriter pw = response.getWriter();

		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String password = request.getParameter("password");
			//String repassword = request.getParameter("repassword");
			c=ConnectionProvider.getConnection();
			System.out.println(c);
			PreparedStatement ps = c.prepareStatement("insert into user(name, email, mobile, password) values(?, ?, ?, ?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, mobile);
			ps.setString(4, password);


			int i = ps.executeUpdate();
			
			if(i>0) {
				//pw.println("register success");
				response.sendRedirect("index.html");
				//response.sendRedirect("https://www.facebook.com/");
//				RequestDispatcher rd= request.getRequestDispatcher("index.html");
//				rd.forward(request, response);
			}
			else
				pw.println("register fail");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}

	
}
