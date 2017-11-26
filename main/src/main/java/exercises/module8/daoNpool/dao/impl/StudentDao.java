package exercises.module8.daoNpool.dao.impl;

import exercises.module8.daoNpool.dao.exception.PersistException;
import exercises.module8.daoNpool.dao.interfaces.GenericDao;
import exercises.module8.daoNpool.dao.models.Group;
import exercises.module8.daoNpool.dao.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dmitrii
 * Date: 22.11.2017
 * Time: 19:15
 */
public class StudentDao extends AbstractJdbcDAO<Student> {

    public StudentDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return "DAOTALK.STUDENT";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO DAOTALK.STUDENT VALUES(NULL, ?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE DAOTALK.STUDENT SET NAME = ? SURNAME = ? ENROLMENT_DATE = ? GROUP_ID = ? WHERE ID = ?;";
    }

    @Override
    public PreparedStatement prepareStatementForInsert(PreparedStatement st, Student entity) throws PersistException {
        try {
            st.setString(1, entity.getName());
            st.setString(2, entity.getSurname());
            st.setString(3, entity.getEnrolmentDate().toString());
            st.setInt(4, entity.getGroupId());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return st;
    }

    @Override
    public PreparedStatement prepareStatementForUpdate(PreparedStatement st, Student entity) throws PersistException {
        try {
            st.setString(1, entity.getName());
            st.setString(2, entity.getSurname());
            st.setString(3, entity.getEnrolmentDate().toString());
            st.setInt(4, entity.getGroupId());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return st;
    }

    @Override
    public List<Student> parseResultSet(ResultSet rs) throws PersistException {
        List<Student> students = new LinkedList<>();
        try {
            if(rs != null) {
                Student student;
                while(rs.next()) {
                    student = new Student();
                    student.setId(rs.getInt(1));
                    student.setName(rs.getString(2));
                    student.setSurname(rs.getString(3));
                    student.setEnrolmentDate(LocalDate.parse(rs.getString(4)));
                    student.setGroupId(rs.getInt(5));
                    students.add(student);
                }
            }
        } catch (Exception e) {
            throw new PersistException("Can't parse result set", e);
        }
        return students;
    }
}
