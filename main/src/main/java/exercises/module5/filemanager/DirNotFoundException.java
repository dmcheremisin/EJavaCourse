package exercises.module5.filemanager;

/**
 * Created by Dmitrii on 16.11.2017.
 */
public class DirNotFoundException extends RuntimeException {

    public DirNotFoundException(String message) {
        super(message);
    }
}
