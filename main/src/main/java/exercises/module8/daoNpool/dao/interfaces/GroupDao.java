package exercises.module8.daoNpool.dao.interfaces;

import exercises.module8.daoNpool.dao.models.Group;

import java.sql.SQLException;
import java.util.List;
/**
 * @author Dmitrii
 * Date: 22.11.2017
 * Time: 19:00
 */

/** Объект для управления персистентным состоянием объекта Group */
public interface GroupDao {

    /** Создает новую запись и соответствующий ей объект */
    public Group create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Group read(int key);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(Group group);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Group group);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Group> getAll() throws SQLException;
}
