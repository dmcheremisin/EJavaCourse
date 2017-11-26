package exercises.module8.daoNpool.dao.impl;

import exercises.module8.daoNpool.dao.exception.PersistException;
import exercises.module8.daoNpool.dao.models.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dmitrii
 * Date: 22.11.2017
 * Time: 19:15
 */
public class GroupDao extends AbstractJdbcDAO<Group> {

    public GroupDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return "DAOTALK.GROUPS";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO DAOTALK.GROUPS VALUES(NULL, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE DAOTALK.GROUPS SET number= ? department = ? WHERE id= ?;";
    }

    @Override
    public PreparedStatement prepareStatementForInsert(PreparedStatement st, Group entity) throws PersistException {
        try {
            st.setInt(1, entity.getNumber());
            st.setString(2, entity.getDepartment());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return st;
    }

    @Override
    public PreparedStatement prepareStatementForUpdate(PreparedStatement st, Group entity) throws PersistException {
        try {
            st.setInt(1, entity.getNumber());
            st.setString(2, entity.getDepartment());
            st.setInt(3, entity.getId());
        } catch (SQLException e) {
            throw new PersistException(e);
        }
        return st;
    }

    @Override
    public List<Group> parseResultSet(ResultSet rs) throws PersistException {
        List<Group> groups = new LinkedList<>();
        try {
            if(rs != null) {
                Group g;
                while(rs.next()) {
                    g = new Group();
                    g.setId(rs.getInt(1));
                    g.setNumber(rs.getInt(2));
                    g.setDepartment(rs.getString(3));
                    groups.add(g);
                }
            }
        } catch (Exception e) {
            throw new PersistException("Can't parse result set", e);
        }
        return groups;
    }

}
