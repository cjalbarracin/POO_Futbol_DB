package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // URL limpia: sin usuario ni contraseña dentro
    private static final String URL = "jdbc:postgresql://ep-restless-breeze-aptskfly-pooler.c-7.us-east-1.aws.neon.tech:5432/neondb?sslmode=require";
    private static final String USER = "neondb_owner";
    private static final String PASS = "npg_Om2ocUqjXE4C";

    public static Connection getConnection() throws SQLException {
        // El Driver se encarga de combinar estos tres datos correctamente
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
