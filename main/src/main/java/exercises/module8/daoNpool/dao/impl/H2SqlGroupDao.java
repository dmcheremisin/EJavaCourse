package exercises.module8.daoNpool.dao.impl;

import exercises.module8.daoNpool.dao.exception.PersistException;
import exercises.module8.daoNpool.dao.interfaces.GenericDao;
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
public class H2SqlGroupDao implements GenericDao<Group> {
    private final Connection connection;

    public H2SqlGroupDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Group create() throws PersistException {
        Group g = new Group();
        String sql = "INSERT INTO DAOTALK.GROUPS VALUES(NULL, ?, ?);";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, g.getNumber());
            stm.setString(2, g.getDepartment());
            int i = stm.executeUpdate();
            if (i != 1) {
                throw new PersistException("On create more then 1 record: " + i);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return null;
    }

    @Override
    public Group read(int key) throws PersistException {
        String sql = "SELECT * FROM DAOTALK.GROUPS WHERE ID = ?;";
        Group g = new Group();
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, key);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                g.setId(key);
                g.setNumber(rs.getInt(2));
                g.setDepartment(rs.getString(3));
            } else {
                throw new PersistException("No records found for the id = " + key);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return g;
    }

    @Override
    public void update(Group group) {

    }

    @Override
    public void delete(Group group) {

    }

    @Override
    public List<Group> getAll() throws SQLException {
        String sql = "SELECT * FROM DAOTALK.GROUPS ;";
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
