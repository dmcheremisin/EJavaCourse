package exercises.module2.school;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dmch0916
 *         Date: 22.08.2017
 *         Time: 15:49
 */
public class Group {
    private String name;
    private Map<Discipline, Discipline> disciplines;
    private Set<Student> students;

    public Group(String name) {
        this.name = name;
        this.disciplines = new HashMap<>();
        students = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void getDisciplines() {
        for (Discipline discipline : disciplines.keySet()) {
            System.out.println(discipline);
        }
    }

    public void getStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void addDiscipline(Discipline discipline) {
        disciplines.put(discipline, discipline);
    }

    public void addStudent(Student student, Discipline discipline) {
        students.add(student);
        if (discipline != null) {
            if (disciplines.containsKey(discipline)) {
                Discipline groupDiscipline = disciplines.get(discipline);
                groupDiscipline.addStudent(student);
            } else {
                discipline.addStudent(student);
                disciplines.put(discipline, discipline);
            }
        }
    }

    public void addStudents(List<Student> students, List<Discipline> disciplines) {
        if (students != null && students.size() > 0) {
            for (Student student : students) {
                if (disciplines != null && disciplines.size() > 0) {
                    for (Discipline discipline : disciplines) {
                        addStudent(student, discipline);
                    }
                } else {
                    addStudent(student, null);
                }
            }
        }
    }

    public Discipline getDiscipline(Discipline discipline) {
        if (disciplines.containsKey(discipline)) {
            return disciplines.get(discipline);
        }
        return null;
    }

    public Student getStudent(Integer id, String name, String lastname) {
        Student searchStudent = null;
        if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(lastname)) {
            searchStudent = new Student(name, lastname);
        }
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(lastname) && searchStudent.equals(student)) {
                return student;
            } else if (id != null && id.equals(student.getId())) {
                return student;
            }
        }
        return null;
    }

    public void addMarkToStudent(Discipline discipline, Student student, Double mark) {
        if (disciplines.containsKey(discipline)) {
            disciplines.get(discipline).addMark(student, mark);
        }
    }

    @Override
    public String toString() {
        return "Group name=" + name;
    }
}