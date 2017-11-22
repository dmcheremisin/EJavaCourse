package exercises.module8.daoNpool.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Dmitrii
 * Date: 22.11.2017
 * Time: 18:59
 */

/**
 * Фабрика объектов для работы с базой данных
 */
public interface DaoFactory {

    /**
     * Возвращает подключение к базе данных
     */
    public Connection getConnection() throws SQLException;

    /**
     * Возвращает объект для управления персистентным состоянием объекта Group
     */
    public GroupDao getGroupDao(Connection connection);

    /**
     * Возвращает объект для управления персистентным состоянием объекта Student
     */
    public StudentDao getStudentDao(Connection connection);
}