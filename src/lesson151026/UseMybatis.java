package lesson151026;

import lesson151022.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Dmitrii on 13.10.2017.
 */
public class UseMybatis {

    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        try {
            Reader resourceReader = Resources.getResourceAsReader("lesson151026/config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceReader);
            sqlSessionFactory.getConfiguration().addMapper(StudentMapper.class);
            sqlSessionFactory.getConfiguration().addMapper(DeptMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        doWork();
    }

    private static void doWork() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = mapper.getStudent(1);
            System.out.println(student.getName());

            DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
            Department department = deptMapper.getDepartment(2);
            System.out.println(department.name);

        } finally {
            sqlSession.close();
        }
    }
}
