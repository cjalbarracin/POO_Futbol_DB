import db.operaciones.TiendaDAO;
import model.celular;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TiendaDAO dao = new TiendaDAO();

        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese la marca");
        String marca = leer.nextLine();
        System.out.println("Ingrese el modelo");
        String modelo = leer.nextLine();
        System.out.println("Ingrese los megapixeles de la camara");
        int camara = leer.nextInt();
        System.out.println("Ingrese la capacidad de la bateria");
        int bateria = leer.nextInt();

        celular c = new celular(marca, modelo, camara, bateria);

        dao.insertarCelular(c);
    }
}