import db.operaciones.TiendaDAO;
import model.celular;
import model.inventario;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        TiendaDAO dao = new TiendaDAO();
        Scanner leer = new Scanner(System.in);

        // 1. PEDIR DATOS DEL CELULAR
        System.out.println("=== REGISTRO DE CELULAR ===");
        System.out.println("Ingrese la marca:");
        String marca = leer.nextLine();
        System.out.println("Ingrese el modelo:");
        String modelo = leer.nextLine();
        System.out.println("Ingrese los megapixeles de la camara:");
        int camara = leer.nextInt();
        System.out.println("Ingrese la capacidad de la bateria:");
        int bateria = leer.nextInt();

        // Guardar el celular en la base de datos
        celular c = new celular(marca, modelo, camara, bateria);
        dao.insertarCelular(c);

        // 2. PEDIR DATOS DEL INVENTARIO
        System.out.println("\n=== REGISTRO DE INVENTARIO ===");
        System.out.println("Ingrese el ID del celular base que acabo de crear:");
        int celular_id = leer.nextInt();
        System.out.println("Ingrese el almacenamiento (GB):");
        int almacenamiento = leer.nextInt();
        System.out.println("Ingrese el precio:");
        double precio = leer.nextDouble();
        System.out.println("Ingrese la memoria RAM (GB):");
        int ram = leer.nextInt();

        // Guardar el inventario en la base de datos
        inventario i = new inventario(celular_id, almacenamiento, precio, ram);
        dao.insertarInventario(i);
    }
}