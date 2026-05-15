package db.operaciones;

import db.DBConnection;
import model.Jugador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {

    public void insertarJugador(Jugador j){
        String add_jugador = "INSERT INTO jugador (nombre, dorsal, posicion, activo) VALUES (?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement query_insert = conn.prepareStatement(add_jugador)
        ) {
            query_insert.setString(1,j.getNombre());
            query_insert.setInt(2,j.getDorsal());
            query_insert.setString(3,j.getPosicion());
            query_insert.setBoolean(4, j.getActivo());
            query_insert.executeUpdate();

            System.out.println("Jugador adicionado con exito");
        }
        catch (SQLException e)
        {
            System.err.println("Error: "+e.getMessage());
        }

    }



}
