package main.learning.database;

import java.sql.*;

public class MySQL {
    public static void main(String[] args) throws SQLException {
        MySQL sql = new MySQL();

        sql.insertdata();
        sql.getSQLData();



    }


    public void getSQLData() throws SQLException {

        String uri = "jdbc:mysql://localhost:3306/selenium";
        String user = "root";
        String password = "password";
        String query = "select * from Credentials;";

        Connection con = DriverManager.getConnection(uri, user, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            System.out.println(rs.getString("emailid"));
            System.out.println(rs.getString("password"));
        }
    }

    public void insertdata() throws SQLException {


        String uri = "jdbc:mysql://localhost:3306/qat";
        String user = "root";
        String password = "password";
        //String query = String.format("INSERT INTO GreyHR (name, id, location, age) VALUES ('%s', %o, '%s', %o))", "Juhi", 34, "Mumbai", 20);

        String query = "INSERT INTO GreyHR (name, id, location, age) VALUES (\"Prashant\", 31, \"Jaipur\", 25);";

        Connection con = DriverManager.getConnection(uri, user, password);
        Statement st = con.createStatement();

        int rowsAffected = st.executeUpdate(query);

        if(rowsAffected>0){
            System.out.println("Values updates successfully");
        }else{
            System.out.println("Insertion failed");
        }
    }


    public void mysqldata() throws SQLException {
        String uri ="jdbc:mysql://localhost:3306/qat" ;
        String user = "root";
        String password = "password";

        String querry = "select * from GreyHR where id = 38;";

        Connection con = DriverManager.getConnection(uri, user, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(querry);

        while(rs.next()){
            System.out.print(rs.getString("name"));
            System.out.print(" -> ");
            System.out.println(rs.getString("location"));
        }
    }
}
