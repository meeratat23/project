package cart;

import javax.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
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

/**
 * Servlet implementation class AdminServlet
 */

public class RemoveItemDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub


        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
          

        
        String o = request.getParameter("id");
        pw.println("o"+ o );
       // System.out.println("id" + id );

        int id = Integer.parseInt(o);
          //request.getParameter("id"); 
        //  system.out.println("id"+ id );


        


        ItemDAO dao = new ItemDAO();

        try {
            
            dao.removeItem(id);
        }   catch (Exception e) {

            pw.print(e);
             
        }

    }


}
