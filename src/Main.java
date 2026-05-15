import db.operaciones.JugadorDAO;
import model.Jugador;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JugadorDAO dao = new JugadorDAO();

        Scanner leer =  new Scanner(System.in);

        System.out.println("Ingrese el nombre del jugador");
        String name = leer.nextLine();
        System.out.println("Ingrese el dorsal");
        int dorsal = leer.nextInt();
        System.out.println("Ingrese el posicion del jugador");
        String posicion = leer.nextLine();
        //dao.insertarJugador(new Jugador("KOLO TOURE", 19,"DELANTERO",true));
        Jugador j = new Jugador(name, dorsal,posicion,true);

        dao.insertarJugador(j);
    }

}
