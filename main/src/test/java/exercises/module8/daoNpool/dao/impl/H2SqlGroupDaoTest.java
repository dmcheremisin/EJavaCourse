package exercises.module8.daoNpool.dao.impl;

import exercises.module8.daoNpool.dao.interfaces.DaoFactory;
import exercises.module8.daoNpool.dao.interfaces.GroupDao;
import exercises.module8.daoNpool.dao.models.Group;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author Dmitrii
 * Date: 22.11.2017
 * Time: 19:21
 */
public class H2SqlGroupDaoTest {
    @Test
    public void getAll() throws Exception {
        DaoFactory df = new H2SqlDaoFactory();
        List<Group> list = null;
        try(Connection c = df.getConnection()){
            GroupDao groupDao = df.getGroupDao(c);
            list = groupDao.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

}