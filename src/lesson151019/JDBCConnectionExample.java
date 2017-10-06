package lesson151019;

import java.sql.*;

/**
 * Created by dmitr on 06.10.2017.
 */
public class JDBCConnectionExample {
    public static void main(String[] args) {
        System.out.println("start");
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver"); // load driver
            connection = DriverManager.getConnection("jdbc:mysql://localhost/students", "root", "root"); // make connection
            System.out.println(connection.getClass().getName());

            Statement statement = connection.createStatement(); // create request
//
//            ResultSet resultSet = statement.executeQuery("SELECT now()"); // send request and get results
//            print(resultSet);
//
//            ResultSet resultSet2 = statement.executeQuery("SELECT * FROM student");
//
//            print(resultSet2);

            queryAndPrint(statement, "select now();");
            queryAndPrint(statement, "select * from student;");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close(); // close connection
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("finish");
    }

    private static void queryAndPrint(Statement statement, String query) {
        try {
            ResultSet rs = statement.executeQuery(query);
            print(rs);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void print(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columns = metaData.getColumnCount();
        while(rs.next()) {
            for (int i = 1; i <= columns; i++) {
                System.out.print(rs.getString(i) + " ");
            }
            System.out.println();
        }
    }
}
