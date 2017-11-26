package exercises.module8.daoNpool.dao.impl;

import exercises.module8.daoNpool.dao.interfaces.DaoFactory;
import exercises.module8.daoNpool.dao.interfaces.GenericDao;
import exercises.module8.daoNpool.dao.models.Group;
import exercises.module8.daoNpool.dao.models.Student;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dmitrii
 *         Date: 22.11.2017
 *         Time: 19:13
 */
public class DaoFactoryImpl implements DaoFactory {
    private Map<Class, GenericDao> daoCreators = new HashMap<>();

    public DaoFactoryImpl(Connection c) {
        daoCreators.put(Group.class, new GroupDao(c));
        daoCreators.put(Student.class, new StudentDao(c));
    }

    public GenericDao getDao(Class clazz) {
        return daoCreators.get(clazz);
    }
}
