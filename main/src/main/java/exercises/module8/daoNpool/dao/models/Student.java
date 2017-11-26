package exercises.module8.daoNpool.dao.models;

import exercises.module8.daoNpool.dao.interfaces.Identifiable;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Dmitrii
 * Date: 22.11.2017
 * Time: 19:02
 */
public class Student implements Identifiable {

    public Student() {
        this.groupId = 1;
        this.name = "";
        this.surname = "";
        this.enrolmentDate = LocalDate.now();
    }

    private Integer id;
    private Integer groupId;
    private String name;
    private String surname;
    private LocalDate enrolmentDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getEnrolmentDate() {
        return enrolmentDate;
    }

    public void setEnrolmentDate(LocalDate enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }
}
