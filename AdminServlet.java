package cart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
//import AdminDao;


   public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		
		AdminDao adminDao = new AdminDao();
		
		if(adminDao.validate(admin))
		   {
			//response.sendRedirect("/options.jsp");
			request.getRequestDispatcher("/options.jsp").forward(request,response);
		   }
		   
		else
		  {
			//response.sendRedirect("/admin.jsp");
			request.getRequestDispatcher("/admin.jsp").forward(request,response);
		  }
	}

}
