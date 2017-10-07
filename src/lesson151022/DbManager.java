package lesson151022;

import java.sql.*;

/**
 * Created by Dmitrii on 07.10.2017.
 */
public class DbManager {

    private static Connection connection;
    ;

    static {
        System.out.println("Initializing DB connection...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/students", "root", "root");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Shutting down DB connection...");
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static Student get(int id) {
        System.out.println("get");
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student WHERE id = " + id);
            Student student = getStudent(rs);
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Student getStudent(ResultSet rs) throws SQLException {
        Student st = new Student();
        if (!rs.next()) {
            return null;
        }
        st.id = rs.getInt(1);
        st.name = rs.getString(2);
        st.stip = rs.getInt(3);
        return st;
    }

    public static <T> void save(T t) {
        System.out.println("save");
    }
}
