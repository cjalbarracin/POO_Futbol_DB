package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Esta clase es la encargada de abrir la puerta hacia la base de datos
public class DBConnection {
    // Aquí guardaremos los datos (usuario, pass, url) que leemos del archivo
    private static Properties prop = new Properties();

    // Este bloque se ejecuta una sola vez, apenas arrancas el programa
    static {
        try (FileInputStream input = new FileInputStream("config.properties")) {
            // Leemos el archivo y guardamos los datos en la memoria
            prop.load(input);
        } catch (IOException ex) {
            // Si el archivo no existe, avisamos en la consola
            System.err.println("Error: No se encuentra el archivo config.properties");
        }
    }

    // Este método es el que usas cuando necesitas conectarte para hacer algo
    public static Connection getConnection() throws SQLException {
        // Usamos los datos que guardamos al principio para pedir la conexión
        return DriverManager.getConnection(
                prop.getProperty("db.url"),
                prop.getProperty("db.user"),
                prop.getProperty("db.pass")
        );
    }
}
