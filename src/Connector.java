import java.sql.*;

public class Connector 
{
    Connection c;
    Statement s;

    Connector()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("D:\mysql-connector-j-8.2.0");
            c=DriverManager.getConnection("jdbc:mysql:///HotelManagementSystem" , "root" ,"ssssssssss");
            s=c.createStatement();
        } 
        catch (Exception e)
        {
           e.printStackTrace();
        }
    }
}
//
