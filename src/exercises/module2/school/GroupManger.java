package exercises.module2.school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static exercises.module2.school.Discipline.ALGEBRA;
import static exercises.module2.school.Discipline.LITERATURE;
import static exercises.module2.school.Discipline.PHYSICS;

/**
 * @author dmch0916
 *         Date: 22.08.2017
 *         Time: 16:32
 */
public class GroupManger {
    static int counter = 0;

    static List<Group> groups = new ArrayList<>();

    public static void main(String[] args) {
        groups.add(getGoup());
        Group newGoup = getGoup();
        newGoup.addStudent(new Student("Benny", "Hill", new Date(12, 11, 10), "New addr"), null);
        groups.add(newGoup);
        groups.add(getGoup());
        System.out.println(findStudentsGroups("Dmitrii", "Cheremisin"));
        System.out.println(findStudentsGroups("Benny", "Hill"));
    }

    private static List<Group> findStudentsGroups(String name, String lastname){
        List<Group> foundGroup = new ArrayList<>();
        for (Group group : groups){
            if(group.getStudent(null, name, lastname) != null){
                foundGroup.add(group);
            }
        }
        return foundGroup;
    }

    private static Group getGoup() {
        Group group = new Group("Group" + ++counter);
        group.addStudents(getStudentList(), Arrays.asList(PHYSICS, LITERATURE));
        group.addDiscipline(ALGEBRA);
        group.getDisciplines();
        group.getStudents();
        Discipline algebra = group.getDiscipline(ALGEBRA);
        group.addMarkToStudent(algebra, group.getStudent(1, null, null), 10.0);
        group.addMarkToStudent(PHYSICS, group.getStudent(0, null, null), 10.0);
        group.addMarkToStudent(PHYSICS, group.getStudent(1, null, null), 10.0);
        group.addMarkToStudent(LITERATURE, group.getStudent(0, null, null), 10.0);

        System.out.println(group.getDiscipline(PHYSICS).getStudentMarks(group.getStudent(1, null, null)));
        System.out.println(group.getDiscipline(ALGEBRA).getStudentMarks(group.getStudent(1, null, null)));
        return group;
    }

    public static List<Student> getStudentList(){
        List<Student> students = new ArrayList<Student>(){{
            add(new Student("Dmitrii", "Cheremisin", new Date(11, 1, 1989), "SPb, vitebskii 97/1, 185"));
            add(new Student("Anna", "Cheremisina", new Date(30, 07, 1988), "SPb, vitebskii 97/1, 185"));
        }};
        return students;
    }

}