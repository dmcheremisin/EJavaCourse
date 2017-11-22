package exercises.module8.daoNpool.dao.models;

/**
 * @author Dmitrii
 * Date: 22.11.2017
 * Time: 19:02
 */
public class Group {
    private Integer id;
    private int number;
    private String department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
