package exercises.module8.daoNpool.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Dmitrii on 30.11.2017.
 */
public class ConnectionPool {

    private static final String DB_USER_NAME = "";
    private static final String DB_PASSWORD = "";
    private static final String DB_URL = "jdbc:h2:~/daoNpool/daotalk";
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final int DB_MAX_CONNECTIONS = 5;
    private static ConnectionPool cp;

    private Queue<MyConnection> freeConnections;
    private Queue<MyConnection> usedConnections;

    private ConnectionPool() throws ClassNotFoundException, SQLException {
        ArrayBlockingQueue<MyConnection> freeConnections = new ArrayBlockingQueue<>(DB_MAX_CONNECTIONS);
        ArrayBlockingQueue<MyConnection> usedConnections = new ArrayBlockingQueue<>(DB_MAX_CONNECTIONS);
        Class.forName(DB_DRIVER);
        while(freeConnections.size() < DB_MAX_CONNECTIONS) {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
            MyConnection myConnection = MyConnection.create(connection, freeConnections);
            freeConnections.add(myConnection);
        }
        this.freeConnections = freeConnections;
        this.usedConnections = usedConnections;
    }

    private static ConnectionPool getConnectionPool() throws SQLException, ClassNotFoundException {
        if (cp == null) {
            cp = new ConnectionPool();
        }
        return cp;
    }


    public static MyConnection getConnectionFromPool() throws SQLException, ClassNotFoundException {
        return getConnectionPool().freeConnections.poll();
    }

    public static void returnConnectionToPool(MyConnection connection) throws SQLException, ClassNotFoundException {
        if (getConnectionPool().usedConnections.remove(connection)) {
            getConnectionPool().freeConnections.add(connection);
        }
    }
}

