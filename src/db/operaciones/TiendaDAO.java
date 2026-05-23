package db.operaciones;

import db.DBConnection;
import model.celular;
import model.inventario;
import java.sql.*;

public class TiendaDAO {

    public void insertarCelular(celular c){
        String add_celular = "INSERT INTO celulares (marca, modelo, camara, bateria) VALUES (?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement query_insert = conn.prepareStatement(add_celular)
        ) {
            query_insert.setString(1, c.getmarca());
            query_insert.setString(2, c.getmodelo());
            query_insert.setInt(3, c.getcamara());
            query_insert.setInt(4, c.getbateria());
            query_insert.executeUpdate();

            System.out.println("Celular adicionado con exito");
        }
        catch (SQLException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void insertarInventario(inventario i){
        String add_inventario = "INSERT INTO inventario (celular_id, almacenamiento, precio, ram) VALUES (?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement query_insert = conn.prepareStatement(add_inventario)
        ) {
            query_insert.setInt(1, i.getCelular_id());
            query_insert.setInt(2, i.getAlmacenamiento());
            query_insert.setDouble(3, i.getPrecio());
            query_insert.setInt(4, i.getRam());
            query_insert.executeUpdate();

            System.out.println("Inventario adicionado con exito");
        }
        catch (SQLException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
}