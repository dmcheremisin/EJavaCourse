package exercises.module8.daoNpool.dao.interfaces;

import exercises.module8.daoNpool.dao.models.Student;
import java.util.List;
/**
 * @author Dmitrii
 * Date: 22.11.2017
 * Time: 19:01
 */

/** Объект для управления персистентным состоянием объекта Student */
public interface StudentDao {

    /** Создает новую запись и соответствующий ей объект */
    public Student create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Student read(int key);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(Student student);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Student student);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Student> getAll();
}