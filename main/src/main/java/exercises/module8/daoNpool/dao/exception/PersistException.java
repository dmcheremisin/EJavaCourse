package exercises.module8.daoNpool.dao.exception;

/**
 * Created by Dmitrii on 23.11.2017.
 */
public class PersistException extends Exception {
    public PersistException(String message) {
        super(message);
    }

    public PersistException(Throwable cause) {
        super(cause);
    }

    public PersistException(String s, Exception e) {
        super(s, e);
    }
}
