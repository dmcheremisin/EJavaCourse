package exercises.module8.daoNpool.dao.models;

import java.util.Date;

/**
 * @author Dmitrii
 * Date: 22.11.2017
 * Time: 19:02
 */
public class Student {

    private Integer id;
    private Integer groupId;
    private String name;
    private String surname;
    private Date enrolmentDate;

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

    public Date getEnrolmentDate() {
        return enrolmentDate;
    }

    public void setEnrolmentDate(Date enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }
}
