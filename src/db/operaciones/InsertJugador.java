package db.operaciones;

import db.DBConnection;

import java.sql.*;

public class InsertJugador {
    public static void main(String[] args) {
        String add_jugador = "INSERT INTO jugador (nombre, dorsal, posicion, activo) VALUES (?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement query_insert = conn.prepareStatement(add_jugador)
        ) {
            query_insert.setString(1,"Zidane");
            query_insert.setInt(2,99);
            query_insert.setString(3,"CABEZEADOR");
            query_insert.setBoolean(4, false);
            query_insert.executeUpdate();

            System.out.println("Jugador adicionado con exito");
        }
        catch (SQLException e)
        {
            System.err.println("Error: "+e.getMessage());
        }

    }


}
