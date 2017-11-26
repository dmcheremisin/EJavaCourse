package exercises.module8.daoNpool.dao.interfaces;

import exercises.module8.daoNpool.dao.exception.PersistException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Dmitrii on 22.11.2017.
 */
public interface GenericDao<T> {

    /** Создает новую запись и соответствующий ей объект */
    public void insert(T object) throws PersistException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public T get(int key) throws PersistException;

    /** Сохраняет состояние объекта в базе данных */
    public void update(T object) throws PersistException;

    /** Удаляет запись об объекте из базы данных */
    public void delete(T object) throws PersistException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<T> getAll() throws PersistException;
}
