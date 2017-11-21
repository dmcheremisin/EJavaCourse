package exercises.module8;

import java.sql.*;

/**
 * Created by Dmitrii on 21.11.2017.
 */
public class JDBCexampleH2 {
    private static final Connection c = getConnection();

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:h2:mem:");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static void closeConnection() {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println("Can't close the connection!");
        }
    }

    private static PreparedStatement getPreparedStatement(String sql) {
        try {
            return c.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Can't create prepared statement");
            System.out.println(e.getMessage());
        }
        return null;
    }


    public static void main(String[] args) {
        createTable();
        addUsers();
        updateUser();
        printSpecialUser(4);
        addNewUser("Dmitrii", "Boss");
        listUsers();
        deleteTable("USERS");
        listUsers();
        closeConnection();
    }

    private static void deleteTable(String tableName) {
        try {
            Statement st = c.createStatement();
            st.execute(String.format("DROP TABLE IF EXISTS %s", tableName));
            System.out.println(String.format("Table with name %s is successfully deleted!", tableName));
            st.close();
        } catch (Exception e) {
            System.out.println(String.format("Can't delete table with name %s !", tableName));
            System.out.println(e.getMessage());
        }
    }

    private static void addNewUser(String name, String role) {
        try {
            PreparedStatement st = getPreparedStatement("INSERT INTO USERS (name, role) VALUES (?,?)");
            st.setString(1, name);
            st.setString(2, role);
            st.execute();
            st.close();
        } catch (Exception e) {
            System.out.println(String.format("Can't add new user with name %s and role %s", name, role));
            System.out.println(e.getMessage());
        }
    }

    private static void printSpecialUser(int userId) {
        try {
            PreparedStatement st = getPreparedStatement("SELECT * FROM USERS WHERE id = ?");
            st.setInt(1, userId);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String role = resultSet.getString(3);
                System.out.println(String.format("Special user info: id = %s, name = %s, role = %s", id, name, role));
            }
            st.close();
        } catch (Exception e) {
            System.out.println("Can't get info about user with id = " + userId);
            System.out.println(e.getMessage());
        }
    }

    private static void createTable() {
        try (Statement st = c.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS USERS (id INT PRIMARY KEY auto_increment, name VARCHAR(30), role VARCHAR(20));");
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updateUser() {
        int user3 = 3, user4 = 4;
        String role3 = "sysadmin", role4 = "accountant";
        try {
            PreparedStatement st = getPreparedStatement("UPDATE USERS SET role = ? WHERE id = ?");
            st.setString(1, role3);
            st.setInt(2, user3);
            st.execute();
            st.setString(1, role4);
            st.setInt(2, user4);
            st.execute();
            st.close();
        } catch (Exception e) {
            System.out.println("Can't update user with id = " + user3);
            System.out.println(e.getMessage());
        }
    }

    private static void addUsers() {
        try {
            PreparedStatement st = getPreparedStatement("INSERT INTO USERS (name, role) VALUES (?, ?)");
            for (int i = 0; i < 5; i++) {
                st.setString(1, "User " + (i + 1));
                st.setString(2, "manager");
                st.execute();
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listUsers() {
        try {
            System.out.println(" ============== List all users ====================");
            PreparedStatement st = getPreparedStatement("SELECT * FROM USERS;");
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String role = resultSet.getString(3);
                System.out.println(String.format("id = %s, name = %s, role = %s", id, name, role));
            }
            st.close();
        } catch (Exception e) {
            System.out.println("Can't list users");
            System.out.println(e.getMessage());
        }
    }


}

