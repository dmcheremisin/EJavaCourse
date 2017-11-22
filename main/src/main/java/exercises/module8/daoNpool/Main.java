package exercises.module8.daoNpool;


import exercises.module8.daoNpool.dao.impl.H2SqlDaoFactory;
import exercises.module8.daoNpool.dao.interfaces.DaoFactory;
import exercises.module8.daoNpool.dao.interfaces.GenericDao;
import exercises.module8.daoNpool.dao.models.Group;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author Dmitrii
 *         Date: 22.11.2017
 *         Time: 15:57
 */
public class Main {

    private static Connection c;

    private static final String CREATE_TABLE =
            "CREATE SCHEMA IF NOT EXISTS  DAOTALK;" +
            "SET SCHEMA DAOTALK; " +
            //"DROP TABLE IF EXISTS GROUPS ; " +

            "CREATE  TABLE IF NOT EXISTS GROUPS (" +
            "id INT NOT NULL AUTO_INCREMENT ," +
            "number INT NOT NULL ," +
            "department VARCHAR(45) NULL ," +
            "PRIMARY KEY (id) );" +

            //"DROP TABLE IF EXISTS STUDENT ; " +

            "CREATE  TABLE IF NOT EXISTS STUDENT (" +
            "id INT NOT NULL AUTO_INCREMENT ," +
            "name VARCHAR(45) NULL ," +
            "surname VARCHAR(45) NULL ," +
            "enrolment_date DATE NULL ," +
            "group_id INT ," +
            "PRIMARY KEY (id)," +
            "FOREIGN KEY (group_id) REFERENCES GROUPS(id));";

    private static final String ADD_SAMPLE_DATA =
            "INSERT INTO GROUPS VALUES (NULL, '230750', 'Кибернетики');" +
            "INSERT INTO GROUPS VALUES (NULL, '320890', 'Естественнонаучный');" +
            "INSERT INTO GROUPS VALUES (NULL, '440120', 'Экономики');" +
            "INSERT INTO STUDENT VALUES (NULL, 'Ступенько', 'Василий', '2010-09-01', '1');" +
            "INSERT INTO STUDENT VALUES (NULL, 'Ступенько', 'Наталья', '2010-09-01', '1');" +
            "INSERT INTO STUDENT VALUES (NULL, 'Иванов', 'Николай', '2005-09-01', '1');" +
            "INSERT INTO STUDENT VALUES (NULL, 'Петрова', 'Анастасия', '2007-09-01', '1');" +
            "INSERT INTO STUDENT VALUES (NULL, 'Васильева', 'Валентина', '2010-09-01', '2');" +
            "INSERT INTO STUDENT VALUES (NULL, 'Цапко', 'Игорь', '2010-09-01', '2');" +
            "INSERT INTO STUDENT VALUES (NULL, 'Кузницова', 'Светлана', '2010-09-01', '3');" +
            "INSERT INTO STUDENT VALUES (NULL, 'Прокопенко', 'Ольга', '2010-09-01', '3');" +
            "INSERT INTO STUDENT VALUES (NULL, 'Новиков', 'Жан', '2010-09-01', NULL);";

    public static Connection getConnection(String connection) {
        try {
            if (c == null) {
                c = DriverManager.getConnection(connection);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public static void main(String[] args) {
        //prepareData();
        DaoFactory df = new H2SqlDaoFactory();
        List<Group> list = null;
        try(Connection c = df.getConnection()){
            GenericDao<Group> groupDao = df.getGroupDao(c);
            list = groupDao.getAll();
        } catch (SQLException e) {
            System.out.println(e);
        }
        list.forEach(a -> System.out.println(a.getDepartment()));
//        testListStudents();
    }

    private static void prepareData() {
        Connection connection = getConnection("jdbc:h2:~/daoNpool/daotalk");
        if (connection != null) {
            try {
                Statement st = connection.createStatement();
                st.addBatch(CREATE_TABLE);
                st.addBatch(ADD_SAMPLE_DATA);
                int[] countWithoutException = st.executeBatch();
                System.out.println("Inserted = " + countWithoutException.length);
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testListStudents() {
        try {
            System.out.println(" ============== List all users ====================");
            PreparedStatement st = c.prepareStatement("SELECT * FROM Student;");
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String role = resultSet.getString(3);
                System.out.println(String.format("id = %s, name = %s, surname = %s", id, name, role));
            }
            st.close();
        } catch (Exception e) {
            System.out.println("Can't list users");
            System.out.println(e.getMessage());
        }
    }

}
