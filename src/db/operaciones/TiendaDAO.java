package db.operaciones;

import db.DBConnection;
import model.celular;
import model.inventario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TiendaDAO {

    
    public void registrarCelularCompleto(celular c, inventario i) {
        String sqlCelular = "INSERT INTO celular (marca, modelo, camara, bateria) VALUES (?, ?, ?, ?)";
        String sqlInventario = "INSERT INTO inventario (celular_id, almacenamiento, precio, ram) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false); // Iniciar transacción

            
            try (PreparedStatement ps1 = conn.prepareStatement(sqlCelular, Statement.RETURN_GENERATED_KEYS)) {
                ps1.setString(1, c.getMarca());
                ps1.setString(2, c.getModelo());
                ps1.setInt(3, c.getCamara());
                ps1.setInt(4, c.getBateria());
                ps1.executeUpdate();

                ResultSet rs = ps1.getGeneratedKeys();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);

                    
                    try (PreparedStatement ps2 = conn.prepareStatement(sqlInventario)) {
                        ps2.setInt(1, idGenerado);
                        ps2.setInt(2, i.getAlmacenamiento());
                        ps2.setDouble(3, i.getPrecio());
                        ps2.setInt(4, i.getRam());
                        ps2.executeUpdate();
                    }
                }
                conn.commit(); 
                System.out.println("Registro exitoso en ambas tablas.");
            } catch (SQLException e) {
                conn.rollback(); // Si algo falla, deshacer todo
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void listarInventarioCompleto() {
        String sql = "SELECT c.marca, c.modelo, i.precio, i.almacenamiento, i.ram " +
                "FROM celular c " +
                "JOIN inventario i ON c.id = i.celular_id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- LISTADO COMPLETO ---");
            while (rs.next()) {
                System.out.println("Marca: " + rs.getString("marca") +
                        " | Modelo: " + rs.getString("modelo") +
                        " | Precio: $" + rs.getDouble("precio") +
                        " | Almacenamiento: " + rs.getInt("almacenamiento") + "GB" +
                        " | RAM: " + rs.getInt("ram") + "GB");
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

     List<celular> filtrarPorMarca(String marca) {
        List<celular> lista = new ArrayList<>();
        String sql = "SELECT * FROM celular WHERE marca ILIKE ?";
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