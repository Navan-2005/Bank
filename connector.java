package bank.management.system;
import java.sql.*;
//import java.sql.Connection;
//import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.Statement;

public class connector {
    Connection connection;
    Statement statement;
    public connector()
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","Navan@2005");
            statement = connection.createStatement();


        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
