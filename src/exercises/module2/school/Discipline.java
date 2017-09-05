package exercises.module2.school;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dmch0916
 *         Date: 22.08.2017
 *         Time: 15:50
 */
public enum Discipline {

    LITERATURE("Literature", false),
    ALGEBRA("Algebra", true),
    GEOMETRY("Geometry", false),
    PHYSICS("Physics", true);

    private String name;
    private boolean isFloatMark;
    private Map<Student, List<Integer>> intMarks;
    private Map<Student, List<BigDecimal>> bigDecimalMarks;

    Discipline(String name, boolean isFloatMark) {
        this.name = name;
        this.isFloatMark = isFloatMark;
        if (isFloatMark) {
            this.bigDecimalMarks = new HashMap<>();
        } else {
            this.intMarks = new HashMap<>();
        }
    }

    public String getName() {
        return name;
    }

    public boolean isFloatMark() {
        return isFloatMark;
    }

    public List getStudentMarks(Student student) {
        if (isFloatMark && bigDecimalMarks.containsKey(student)) {
            return bigDecimalMarks.get(student);
        } else if(!isFloatMark && intMarks.containsKey(student)) {
            return intMarks.get(student);
        }
        return Collections.EMPTY_LIST;
    }

    public void addStudent(Student student){
        if (isFloatMark && !bigDecimalMarks.containsKey(student)) {
            this.bigDecimalMarks.put(student, new ArrayList<>());
        } else if (!isFloatMark && !intMarks.containsKey(student)) {
            this.intMarks.put(student, new ArrayList<>());
        }
    }

    public void addMark(Student student, Double mark) {
        if (isFloatMark) {
            if (!bigDecimalMarks.containsKey(student)) {
                addStudent(student);
            }
            List<BigDecimal> bigDecimals = bigDecimalMarks.get(student);
            if (bigDecimals != null){
                bigDecimals.add(new BigDecimal(mark));
            }
        } else {
            if (!intMarks.containsKey(student)) {
                addStudent(student);
            }
            List<Integer> integers = intMarks.get(student);
            if (integers != null) {
                double studentMark = mark;
                integers.add((int) studentMark);
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}