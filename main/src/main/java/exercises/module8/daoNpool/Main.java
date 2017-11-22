package exercises.module8.daoNpool;

import exercises.module8.daoNpool.dao.impl.H2SqlDaoFactory;
import exercises.module8.daoNpool.dao.interfaces.DaoFactory;
import exercises.module8.daoNpool.dao.interfaces.GroupDao;
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
 * Date: 22.11.2017
 * Time: 15:57
 */
public class Main {

    private static Connection c;

    private static final String CREATE_TABLE =
            "CREATE SCHEMA IF NOT EXISTS  `daotalk`;" +

            "SET SCHEMA `daotalk`; " +

            "DROP TABLE IF EXISTS `Group` ; " +

            "CREATE  TABLE IF NOT EXISTS `Group` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT ," +
            "  `number` INT NOT NULL ," +
            "  `department` VARCHAR(45) NULL ," +
            "  PRIMARY KEY (`id`) );" +

            "DROP TABLE IF EXISTS `Student` ; " +

            "CREATE  TABLE IF NOT EXISTS `Student` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT ," +
            "  `name` VARCHAR(45) NULL ," +
            "  `surname` VARCHAR(45) NULL ," +
            "  `enrolment_date` DATE NULL ," +
            "  `group_id` INT ," +
            "  PRIMARY KEY (`id`) );";

    private static final String ADD_SAMPLE_DATA =
            "INSERT INTO `Group` (`number`, `department`)" +
            "VALUES ('230750', 'Кибернетики');" +
            "INSERT INTO `Group` (`number`, `department`) " +
            "VALUES ('320890', 'Естественнонаучный');" +
            "INSERT INTO `Group` (`number`, `department`) " +
            "VALUES ('440120', 'Экономики');" +
            "" +
            "INSERT INTO `Student` (`surname`, `name`, `enrolment_date`, `group_id`) " +
            "VALUES ('Ступенько', 'Василий', '2010-09-01', '1');" +
            "INSERT INTO `Student` (`surname`, `name`, `enrolment_date`, `group_id`) " +
            "VALUES ('Ступенько', 'Наталья', '2010-09-01', '1');" +
            "INSERT INTO `Student` (`surname`, `name`, `enrolment_date`, `group_id`) " +
            "VALUES ('Иванов', 'Николай', '2005-09-01', '1');" +
            "INSERT INTO `Student` (`surname`, `name`, `enrolment_date`, `group_id`) " +
            "VALUES ('Петрова', 'Анастасия', '2007-09-01', '1');" +
            "" +
            "INSERT INTO `Student` (`surname`, `name`, `enrolment_date`, `group_id`) " +
            "VALUES ('Васильева', 'Валентина', '2010-09-01', '2');" +
            "INSERT INTO `Student` (`surname`, `name`, `enrolment_date`, `group_id`) " +
            "VALUES ('Цапко', 'Игорь', '2010-09-01', '2');" +
            "" +
            "INSERT INTO `Student` (`surname`, `name`, `enrolment_date`, `group_id`) " +
            "VALUES ('Кузницова', 'Светлана', '2010-09-01', '3');" +
            "INSERT INTO `Student` (`surname`, `name`, `enrolment_date`, `group_id`) " +
            "VALUES ('Прокопенко', 'Ольга', '2010-09-01', '3');" +
            "" +
            "INSERT INTO `Student` (`surname`, `name`, `enrolment_date`) " +
            "VALUES ('Новиков', 'Жан', '2010-09-01');";

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
        DaoFactory df = new H2SqlDaoFactory();
        List<Group> list = null;
        try(Connection c = df.getConnection()){
            GroupDao groupDao = df.getGroupDao(c);
            list = groupDao.getAll();
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println(list);
//        prepareData();
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
            PreparedStatement st = c.prepareStatement("SELECT * FROM `Student`;");
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
