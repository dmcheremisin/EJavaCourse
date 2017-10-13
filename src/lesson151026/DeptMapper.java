package lesson151026;

import org.apache.ibatis.annotations.Select;

/**
 * Created by Dmitrii on 13.10.2017.
 */
public interface DeptMapper {
    @Select("SELECT * FROM dept WHERE id = #{id}")
    Department getDepartment(int id);
}
