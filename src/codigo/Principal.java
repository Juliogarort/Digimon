package codigo;
import java.util.*;

public class Principal {

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
	                break;
	            } else {
	                System.out.println("Opción no válida.");
	            }
	        }
	    }
	}