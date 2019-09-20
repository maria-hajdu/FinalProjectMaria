package pages;

import java.awt.dnd.DragGestureEvent;
import java.sql.*;

public class DBConnection {

    public void getConnection(String url, String username, String password, String query){
        try{
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            ResultSet results=statement.executeQuery(query);

            while(results.next()) {
                System.out.println(results.getString("first_name"));
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
