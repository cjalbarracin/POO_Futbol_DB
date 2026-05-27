import db.operaciones.TiendaDAO;
import model.celular;
import model.inventario;
import java.util.Scanner;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        TiendaDAO dao = new TiendaDAO();
        Scanner leer = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ TIENDA DE CELULARES ===");
            System.out.println("1. Registrar nuevo celular e inventario");
            System.out.println("2. Consultar todos los celulares");
            System.out.println("3. Filtrar celulares por marca");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    registrarNuevo(dao, leer);
                    break;
                case 2:
                    System.out.println("\n--- LISTA DE CELULARES ---");
                    List<celular> lista = dao.listarTodos();
                    for (celular c : lista) {
                        System.out.println("- " + c.getMarca() + " " + c.getModelo() + " | Cam: " + c.getCamara() + "MP");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la marca a buscar: ");
                    String marca = leer.nextLine();
                    List<celular> filtrados = dao.filtrarPorMarca(marca);
                    for (celular c : filtrados) {
                        System.out.println(">> " + c.getMarca() + " " + c.getModelo());
                    }
                    break;
                case 4:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Método auxiliar para mantener el código limpio
    private static void registrarNuevo(TiendaDAO dao, Scanner leer) {
        System.out.println("\n--- REGISTRO DE CELULAR ---");
        System.out.print("Marca: "); String marca = leer.nextLine();
        System.out.print("Modelo: "); String modelo = leer.nextLine();
        System.out.print("Megapíxeles: "); int camara = leer.nextInt();
        System.out.print("Batería: "); int bateria = leer.nextInt();

        int id = dao.insertarCelular(new celular(marca, modelo, camara, bateria));

        if (id != -1) {
            System.out.println("Celular guardado con ID: " + id);
            System.out.print("Almacenamiento (GB): "); int almc = leer.nextInt();
            System.out.print("Precio: "); double precio = leer.nextDouble();
            System.out.print("RAM (GB): "); int ram = leer.nextInt();
            dao.insertarInventario(new inventario(id, almc, precio, ram));
        }
    }
}
