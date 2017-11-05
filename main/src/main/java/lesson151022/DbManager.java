package lesson151022;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    public static <T> T get(Class<T> clazz, int id) {
        String tableName = clazz.getSimpleName().toLowerCase();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM "+ tableName +" WHERE id = ? ");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            T t = load(rs, clazz);
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static <T> T load(ResultSet rs, Class<T> clazz) throws SQLException {
        rs.next();
        try {
            T t = clazz.newInstance();
            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String name = metaData.getColumnName(i);
                char[] charArray = name.toCharArray();
                charArray[0] = name.toUpperCase().charAt(0);
                String setterName = "set" + new String(charArray);
                Method setter = clazz.getMethod(setterName, String.class);
                setter.invoke(t, rs.getString(i));
            }

//            for (Method method : clazz.getMethods()) {
//                String name = method.getName();
//                if (!name.startsWith("get")){
//                    continue;
//                }
//                String propertyName = name.substring(3);
//                Class<?> returnType = method.getReturnType();
//                Method setter = clazz.getMethod("set" + propertyName, returnType);
//                String value = rs.getString(propertyName.toLowerCase());
//                setter.invoke(t, value);
//            }
            return t;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
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
        st.id = rs.getString(1);
        st.name = rs.getString(2);
        st.stip = rs.getString(3);
        return st;
    }

    public static <T> void save(T t) {
        System.out.println("save");
    }
}
