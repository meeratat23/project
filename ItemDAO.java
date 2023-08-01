package cart;

import javax.naming.*;
import javax.sql.*;

import org.apache.tomcat.dbcp.dbcp.PoolablePreparedStatement;

import java.sql.*;
import java.util.*;

public class ItemDAO
{
    Connection con;
    public ItemDAO()
    {
    }
    public Connection getConnection() throws ClassNotFoundException, SQLException
    
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cart","root","siddhivinayak");
        return con;
    }
    public void closeConnection() throws SQLException
    {
        con.close();
    }
    public Collection getAllItems() throws ClassNotFoundException,SQLException
    {
        Vector items=new Vector();
        getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs =stmt.executeQuery("select*from Items");
        while(rs.next())
        {
            Item item = new Item();
            item.setId(rs.getInt(1));
            item.setName(rs.getString(2));
            item.setImagePath(rs.getString(3));
            item.setDescription(rs.getString(4));
            item.setPrice(rs.getDouble(5));
            items.addElement(item);

        }
     rs.close();
     stmt.close();
     closeConnection();
     return items;   

    }
    public Item getItem(final int itemId) throws ClassNotFoundException,SQLException
    {
        Item item = new Item();
        getConnection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select *from Items where itemID ="+itemId);
        if(rs.next())
        {
            item.setId(rs.getInt(1));
            item.setName(rs.getString(2));
            item.setImagePath(rs.getString(3));
            item.setDescription(rs.getString(4));
            item.setPrice(rs.getDouble(5));
        }
        rs.close();
        stmt.close();
        closeConnection();
        return item;
    }
    public int getItemCount() throws ClassNotFoundException,SQLException
    {
        getConnection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select count(*) from items");
        rs.next();
        int itemCount = rs.getInt(1);
        rs.close();
        stmt.close();
        closeConnection();
        return itemCount;
    }

    public int addItem(Item item) throws ClassNotFoundException,SQLException{

        getConnection();
       // PreparedStatement pstmt;
        PreparedStatement pstmt= con.prepareStatement("Insert into items values(?,?,?,?,?)");
        pstmt.setString(1,null);
        pstmt.setString(2,item.getName());
        pstmt.setString(3,item.getImagePath());
        pstmt.setString(4,item.getDescription());
        pstmt.setDouble(5,item.getPrice());

        int i = pstmt.executeUpdate();
        return i ;
    }


    public int removeItem(int id ) throws ClassNotFoundException,SQLException{

        getConnection();
       // PreparedStatement pstmt;
        PreparedStatement pstmt= con.prepareStatement("Delete from items  where id = ? ");
        pstmt.setInt(1,id);
    
        int i = pstmt.executeUpdate();
        return i ;
    }
    
};
