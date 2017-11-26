package exercises.module8.daoNpool.dao.impl;

import exercises.module8.daoNpool.dao.exception.PersistException;
import exercises.module8.daoNpool.dao.interfaces.GenericDao;
import exercises.module8.daoNpool.dao.interfaces.Identifiable;

import java.sql.*;
import java.util.List;

/**
 * Created by Dmitrii on 26.11.2017.
 */
public abstract class AbstractJdbcDAO<T extends Identifiable> implements GenericDao<T> {

    public static final String WHERE_ID = " WHERE ID = ?";
    protected Connection c;

    public AbstractJdbcDAO(Connection c) {
        this.c = c;
    }
    public abstract String getTableName();
    public abstract String getInsertQuery();
    public abstract String getUpdateQuery();
    public abstract PreparedStatement prepareStatementForUpdate (PreparedStatement st, T entity) throws SQLException, PersistException;
    public abstract PreparedStatement prepareStatementForInsert (PreparedStatement st, T entity) throws PersistException;
    public abstract List<T> parseResultSet (ResultSet rs) throws PersistException;

    private String getSelectQuery() {
        return "SELECT * FROM " + getTableName();
    }
    private String getDeleteQuery() {
        return "DELETE FROM " + getTableName() + WHERE_ID;
    }

    public T get(int id) throws PersistException {
        String sql = getSelectQuery() + WHERE_ID;
        List<T> list;
        try {
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        if (list == null || list.size() == 0 || list.size() > 1) {
            throw new PersistException("Can't find unique object in the database");
        }
        return list.get(0);
    }

    public void insert(T entity) throws PersistException {
        String sql = getInsertQuery();
        try {
            PreparedStatement stm = c.prepareStatement(sql);
            stm = prepareStatementForInsert(stm, entity);
            int i = stm.executeUpdate();
            if (i != 1) {
                throw new PersistException("On insert more than 1 record returned: " + i);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    public void update(T entity) throws PersistException {
        String sql = getUpdateQuery();
        try {
            PreparedStatement stm = c.prepareStatement(sql);
            stm = prepareStatementForUpdate(stm, entity);
            int i = stm.executeUpdate();
            if (i != 1) {
                throw new PersistException("On insert more than 1 record returned: " + i);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    public void delete(T entity) throws PersistException {
        String sql = getDeleteQuery();
        try {
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, entity.getId());
            int i = stm.executeUpdate();
            if (i != 1) {
                throw new PersistException("On delete more than 1 record returned: " + i);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    public List<T> getAll() throws PersistException {
        try {
            String sql = getSelectQuery();
            PreparedStatement stm = c.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            return parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException(e.getMessage());
        }
    }

}
