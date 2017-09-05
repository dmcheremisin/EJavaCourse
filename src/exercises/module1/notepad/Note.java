package exercises.module1.notepad;

import java.util.Date;

/**
 * Created by dmitr on 20.08.2017.
 */
public class Note {
    public Date d;
    public String text;

    public Note(String text) {
        this.d = new Date();
        this.text = text;
    }
}
