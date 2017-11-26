package exercises.module8.daoNpool.dao.impl;

import exercises.module8.daoNpool.dao.exception.PersistException;
import exercises.module8.daoNpool.dao.interfaces.DaoFactory;
import exercises.module8.daoNpool.dao.interfaces.GenericDao;
import exercises.module8.daoNpool.dao.models.Group;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Dmitrii
 *         Date: 22.11.2017
 *         Time: 19:21
 */
public class H2SqlGroupDaoTest {
    Connection c;

    @Before
    public void setUp() {
        try {
            c = DriverManager.getConnection("jdbc:h2:~/daoNpool/daotalk");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void shutDown() {
        try {
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAll() throws Exception {
        DaoFactory df = new DaoFactoryImpl(c);
        GenericDao<Group> groupDao = df.getDao(Group.class);
        List<Group> list = groupDao.getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void deleteTest() throws Exception {
        DaoFactory df = new DaoFactoryImpl(c);
        GenericDao<Group> groupDao = df.getDao(Group.class);
        Group g = new Group(524, "Зоологии");
        groupDao.insert(g);
        List<Group> groups = groupDao.getAll();
        Assert.assertNotNull(groups);
        int oldSize = groups.size();
        Assert.assertTrue(oldSize > 0);
        groupDao.delete(groups.get(oldSize - 1 ));
        groups = groupDao.getAll();
        int newSize = groups.size();
        Assert.assertTrue(oldSize - newSize == 1);
    }

}