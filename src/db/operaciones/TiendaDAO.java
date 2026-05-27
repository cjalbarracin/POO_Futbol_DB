//holaaaaa

package db.operaciones;

import db.DBConnection;
import model.celular;
import model.inventario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TiendaDAO {

    // 1. MÉTODO PARA LISTAR TODOS (Principal lo llama: dao.listarTodos())
    public List<celular> listarTodos() {
        List<celular> lista = new ArrayList<>();
        String sql = "SELECT * FROM celular";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new celular(rs.getString("marca"), rs.getString("modelo"),
                        rs.getInt("camara"), rs.getInt("bateria")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    // 2. MÉTODO PARA INSERTAR CELULAR Y OBTENER EL ID (Principal lo llama: dao.insertarCelular())
    public int insertarCelular(celular c) {
        String sql = "INSERT INTO celular (marca, modelo, camara, bateria) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, c.getMarca());
            ps.setString(2, c.getModelo());
            ps.setInt(3, c.getCamara());
            ps.setInt(4, c.getBateria());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) { e.printStackTrace(); }
        return -1;
    }

    // 3. MÉTODO PARA INSERTAR INVENTARIO (Principal lo llama: dao.insertarInventario())
    public void insertarInventario(inventario i) {
        String sql = "INSERT INTO inventario (celular_id, almacenamiento, precio, ram) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, i.getCelular_id()); // Nota: usamos el nombre exacto de tu getter
            ps.setInt(2, i.getAlmacenamiento());
            ps.setDouble(3, i.getPrecio());
            ps.setInt(4, i.getRam());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // 4. MÉTODO DE FILTRADO (Ahora marcado como PUBLIC)
    public List<celular> filtrarPorMarca(String marca) {
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