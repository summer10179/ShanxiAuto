package utils;
import org.testng.annotations.Test;

import java.sql.*;

public class JDBCUtils1 {

@Test
    public static Connection   getConnection() throws SQLException {
        Connection connection=null;


        try {
            //String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl"
            //orcl:代表数据库的SID。
            String url="jdbc:oracle:thin:@172.19.188.198:1521:iimadev";
            String user="JC_PRO";
            String password="8P2621Xct-gFLUVm-_kV";

            Class.forName("oracle.jdbc.driver.OracleDriver");//加载数据驱动
            connection = DriverManager.getConnection(url, user, password);// 连接数据库

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载数据库驱动失败");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("连接数据库失败");

        }

        return connection;


    }
    public static void close(Connection connection, PreparedStatement ps, ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}


