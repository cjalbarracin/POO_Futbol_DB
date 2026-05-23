package db.operaciones;

import db.DBConnection;
import model.celular;
import model.inventario;
import java.sql.*;

public class TiendaDAO {

    public int insertarCelular(celular c) {
        int idGenerado = -1;
        String sql = "INSERT INTO celular (marca, modelo, camara, bateria) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, c.getMarca());
            ps.setString(2, c.getModelo());
            ps.setInt(3, c.getCamara());
            ps.setInt(4, c.getBateria());
            ps.executeUpdate();

            // Aquí recuperamos el ID que Neon asignó automáticamente
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idGenerado;
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