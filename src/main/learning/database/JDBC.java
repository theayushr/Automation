package main.learning.database;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws SQLException {

        String uri = "jdbc:postgresql://localhost:5432/qat";
        String username = "hosting-db";
        String password = "<none>";

        String sql = "select * from qat";

        Connection con = DriverManager.getConnection(uri, username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        rs.next();
        String name = rs.getString(1);
        System.out.println(name);

    }
}
