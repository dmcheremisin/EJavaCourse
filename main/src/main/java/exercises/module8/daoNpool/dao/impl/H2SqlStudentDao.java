package exercises.module8.daoNpool.dao.impl;

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
import java.util.List;

/**
 * @author Dmitrii
 * Date: 22.11.2017
 * Time: 19:15
 */
public class H2SqlStudentDao implements GenericDao<Student> {
    private final Connection connection;

    public H2SqlStudentDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Student create() {
        return null;
    }

    @Override
    public Student read(int key) {
        return null;
    }

    @Override
    public void update(Student group) {

    }

    @Override
    public void delete(Student group) {

    }

    @Override
    public List<Student> getAll() throws SQLException {
        String sql = "SELECT * FROM STUDENT;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt(1));
            student.setName(rs.getString(2));
            student.setSurname(rs.getString(3));
            student.setEnrolmentDate(LocalDate.parse(rs.getString(4)));
            student.setGroupId(rs.getInt(5));
            list.add(student);
        }
        return list;
    }
}
