package codigo;

import java.util.Scanner;

public class BatallaDigital {

	   public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Ingrese el nombre del domador:");
	        String nombreDomador = scanner.nextLine();
	        Domador domador = new Domador(nombreDomador);


	    }
	
}
