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

public class AddItemDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub


        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        Item item = new Item();
         
        
        item.setName(request.getParameter("name"));
        item.setDescription(request.getParameter("description"));
        String price = request.getParameter("price");
        item.setPrice(Double.parseDouble(price));

        ItemDAO dao = new ItemDAO();
        try {
            
            dao.addItem(item);
        }   catch (Exception e) {

            pw.print(e);

        }

    }


}
