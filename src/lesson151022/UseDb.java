package lesson151022;

/**
 * Created by Dmitrii on 07.10.2017.
 */
public class UseDb {

    public static void main(String[] args) {
        int id = 10;
        Student t = DbManager.get(id);
        if ( t == null ) {
            System.out.println("No such student with id = " + id);
        } else {
            System.out.println(t.name);
        }

        Student t2 = new Student();
        DbManager.save(t2);
    }
}
