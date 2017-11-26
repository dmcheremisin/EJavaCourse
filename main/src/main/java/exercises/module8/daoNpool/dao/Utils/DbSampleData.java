package exercises.module8.daoNpool.dao.Utils;

/**
 * Created by Dmitrii on 26.11.2017.
 */
public class DbSampleData {
    public static final String CREATE_TABLE =
            "CREATE SCHEMA IF NOT EXISTS  DAOTALK;" +
                    "SET SCHEMA DAOTALK; " +
                    "DROP TABLE IF EXISTS GROUPS ; " +

                    "CREATE  TABLE IF NOT EXISTS GROUPS (" +
                    "id INT NOT NULL AUTO_INCREMENT ," +
                    "number INT NOT NULL ," +
                    "department VARCHAR(45) NULL ," +
                    "PRIMARY KEY (id) );" +

                    "DROP TABLE IF EXISTS STUDENT ; " +

                    "CREATE  TABLE IF NOT EXISTS STUDENT (" +
                    "id INT NOT NULL AUTO_INCREMENT ," +
                    "name VARCHAR(45) NULL ," +
                    "surname VARCHAR(45) NULL ," +
                    "enrolment_date DATE NULL ," +
                    "group_id INT ," +
                    "PRIMARY KEY (id)," +
                    "FOREIGN KEY (group_id) REFERENCES GROUPS(id));";

    public static final String ADD_SAMPLE_DATA =
            "INSERT INTO GROUPS VALUES (NULL, '230750', 'Кибернетики');" +
                    "INSERT INTO GROUPS VALUES (NULL, '320890', 'Естественнонаучный');" +
                    "INSERT INTO GROUPS VALUES (NULL, '440120', 'Экономики');" +
                    "INSERT INTO STUDENT VALUES (NULL, 'Ступенько', 'Василий', '2010-09-01', '1');" +
                    "INSERT INTO STUDENT VALUES (NULL, 'Ступенько', 'Наталья', '2010-09-01', '1');" +
                    "INSERT INTO STUDENT VALUES (NULL, 'Иванов', 'Николай', '2005-09-01', '1');" +
                    "INSERT INTO STUDENT VALUES (NULL, 'Петрова', 'Анастасия', '2007-09-01', '1');" +
                    "INSERT INTO STUDENT VALUES (NULL, 'Васильева', 'Валентина', '2010-09-01', '2');" +
                    "INSERT INTO STUDENT VALUES (NULL, 'Цапко', 'Игорь', '2010-09-01', '2');" +
                    "INSERT INTO STUDENT VALUES (NULL, 'Кузницова', 'Светлана', '2010-09-01', '3');" +
                    "INSERT INTO STUDENT VALUES (NULL, 'Прокопенко', 'Ольга', '2010-09-01', '3');" +
                    "INSERT INTO STUDENT VALUES (NULL, 'Новиков', 'Жан', '2010-09-01', NULL);";
}
