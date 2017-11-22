package exercises.module8.daoNpool.dao.impl;

import exercises.module8.daoNpool.dao.interfaces.GroupDao;
import exercises.module8.daoNpool.dao.models.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitrii
 * Date: 22.11.2017
 * Time: 19:15
 */
public class H2SqlGroupDao implements GroupDao {
    private final Connection connection;

    public H2SqlGroupDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Group create() {
        return null;
    }

    @Override
    public Group read(int key) {
        return null;
    }

    @Override
    public void update(Group group) {

    }

    @Override
    public void delete(Group group) {

    }

    @Override
    public List<Group> getAll() throws SQLException {
        String sql = "SELECT * FROM `daotalk`.`Group` ;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Group> list = new ArrayList<>();
        while (rs.next()) {
            Group g = new Group();
            g.setId(rs.getInt("id"));
            g.setNumber(rs.getInt("number"));
            g.setDepartment(rs.getString("department"));
            list.add(g);
        }
        return list;
    }
}
