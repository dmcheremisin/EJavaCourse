package lesson151026;

import lesson151022.Student;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Dmitrii on 13.10.2017.
 */
public interface StudentMapper {
    @Select("SELECT * FROM student WHERE id = #{id}")
    Student getStudent(int id);
}
