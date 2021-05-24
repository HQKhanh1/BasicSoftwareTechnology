package DTTT.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    
    public static Connection getConnection() {
        Connection conn=null;
        String url="jdbc:sqlserver://;databaseName=SQLTinNhaTro";
        String user="sa";
        String pass="123";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url,user,pass);System.out.println("SQL connected!");
        }
        catch(ClassNotFoundException |SQLException e){
            e.printStackTrace();
            System.out.println("SQL ket noi ko thanh cong!");
        }
        return conn;
    }
}
