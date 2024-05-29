package codigo;

import java.util.*;

/**
 * Clase principal que inicia el programa y gestiona la interacción del usuario.
 * 
 * @version 1.0
 * @author Julio García
 */

public class Principal {

    /**
     * Método principal que inicia el programa.
     * 
     * @param args Los argumentos de la línea de comandos (no se usan).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Martin elige el nombre del domador:");
        String nombreDomador = scanner.nextLine();
        Domador domador = new Domador(nombreDomador);

        while (true) {
            System.out.println("1. Iniciar batalla");
            System.out.println("2. Salir");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                BatallaDigital batalla = new BatallaDigital();
                batalla.elige(domador);
            } else if (opcion == 2) {
                System.out.println("Estas saliendo del programa.");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
}
