package exercises.module8.daoNpool.dao.interfaces;

import exercises.module8.daoNpool.dao.exception.PersistException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Dmitrii on 22.11.2017.
 */
public interface GenericDao<T> {

    /** Создает новую запись и соответствующий ей объект */
    public T create() throws PersistException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public T read(int key) throws PersistException;

    /** Сохраняет состояние объекта в базе данных */
    public void update(T group);

    /** Удаляет запись об объекте из базы данных */
    public void delete(T group);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<T> getAll() throws SQLException;
}
