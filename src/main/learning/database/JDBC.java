package main.learning.database;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws SQLException {

        //tulusko

        String uri = "jdbc:postgresql://localhost:5432/sysquare";
        String username = "postgres";
        String password = "Sysq@3338";

        String sql = "select * from ";

        Connection con = DriverManager.getConnection(uri, username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        rs.next();
        String name = rs.getString(1);
        System.out.println(name);

        con.close();

    }
}
