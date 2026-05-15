package db.operaciones;
import db.DBConnection;
import java.sql.*;

public class ReadJugadores {

    public static void main(String[] args) {

        String read_query = "SELECT * FROM jugador WHERE activo = FALSE";

        try( Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(read_query)
        )
        {
            System.out.println("ID | NOMBRE | DORSAL");
            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("nombre");
                int dorsal = rs.getInt("dorsal");

                System.out.println(id + " | " + name + " | " + dorsal);
            }
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }


    }



}
