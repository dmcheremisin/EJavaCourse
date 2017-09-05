package exercises.module1.notepad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dmitr on 20.08.2017.
 */
public class Notepad {
    private static List<Note> notes = new ArrayList<>();


    public static void main(String[] args) {
        addNote(new Note("Hello"));
        addNote(new Note("World"));
        addNote(new Note("Dima"));
        addNote(new Note("Anya"));
        addNote(new Note("Mark"));
        deleteNote("World");
        showAll();
        changeNote(1, "Family");
        showAll();
    }

    private static void changeNote(int i, String text) {
        i--;
        if (i < notes.size()) {
            Note note = notes.get(i);
            note.text = text;
        }
    }

    private static void showAll() {
        for(Note note : notes){
            System.out.println("Date: " + note.d);
            System.out.println(note.text);
        }
    }

    private static void deleteNote(String text) {
        Iterator<Note> iterator = notes.iterator();
        while (iterator.hasNext()){
            Note next = iterator.next();
            if (text.equals(next.text)) {
                iterator.remove();
            }
        }
    }

    private static void addNote(Note note) {
        notes.add(note);
    }




}
