package exercises.module8.daoNpool.dao.impl;

import exercises.module8.daoNpool.dao.interfaces.DaoFactory;
import exercises.module8.daoNpool.dao.interfaces.GroupDao;
import exercises.module8.daoNpool.dao.interfaces.StudentDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Dmitrii
 * Date: 22.11.2017
 * Time: 19:13
 */
public class H2SqlDaoFactory implements DaoFactory {
    private String url = "jdbc:h2:~/daoNpool/daotalk";//URL адрес

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    @Override
    public GroupDao getGroupDao(Connection connection) {
        return new H2SqlGroupDao(connection);
    }

    @Override
    public StudentDao getStudentDao(Connection connection) {
        return null;
    }
}
