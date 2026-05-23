package db.operaciones;

import db.DBConnection;
import model.celular;
import model.inventario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TiendaDAO {

    // --- MÉTODOS DE INSERCIÓN (Ya los tenías bien) ---

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
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) idGenerado = rs.getInt(1);
        } catch (SQLException e) { e.printStackTrace(); }
        return idGenerado;
    }

    public void insertarInventario(inventario i){
        String sql = "INSERT INTO inventario (celular_id, almacenamiento, precio, ram) VALUES (?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, i.getCelular_id());
            ps.setInt(2, i.getAlmacenamiento());
            ps.setDouble(3, i.getPrecio());
            ps.setInt(4, i.getRam());
            ps.executeUpdate();
            System.out.println("Inventario adicionado con éxito");
        } catch (SQLException e) { System.err.println("Error: " + e.getMessage()); }
    }

    // --- MÉTODOS DE CONSULTA (Lo que te faltaba para el parcial) ---

    public List<celular> listarTodos() {
        List<celular> lista = new ArrayList<>();
        String sql = "SELECT * FROM celular";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new celular(rs.getString("marca"), rs.getString("modelo"),
                        rs.getInt("camara"), rs.getInt("bateria")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public List<celular> filtrarPorMarca(String marca) {
        List<celular> lista = new ArrayList<>();
        String sql = "SELECT * FROM celular WHERE marca ILIKE ?"; // ILIKE es insensible a mayúsculas
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + marca + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new celular(rs.getString("marca"), rs.getString("modelo"),
                        rs.getInt("camara"), rs.getInt("bateria")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }
}