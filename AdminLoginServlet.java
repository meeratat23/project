package cart;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet
{

	  protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		request.getRequestDispatcher("/admin.jsp").forward(request,response);
	}
}

