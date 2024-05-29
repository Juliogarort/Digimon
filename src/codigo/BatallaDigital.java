package codigo;

import java.util.*;

/**
 * La clase BatallaDigital representa una batalla entre Digimons.
 * Permite al jugador elegir un Digimon para pelear contra un enemigo generado aleatoriamente.
 * 
 */
public class BatallaDigital {
    private Digimon enemigo;
    private Domador domador;
    private Scanner leer;

    /**
     * Constructor de la clase BatallaDigital.
     * Genera un Digimon enemigo aleatorio y crea un nuevo Scanner para la entrada del usuario.
     */
    public BatallaDigital() {
        this.enemigo = generarDigimonAleatorio();
        this.leer = new Scanner(System.in);
    }

    /**
     * Genera un Digimon enemigo aleatorio.
     *
     * @return un objeto Digimon generado aleatoriamente.
     */
    private Digimon generarDigimonAleatorio() {
        String[] digimones = {"Agumon", "Gabumon", "Patamon"};
        String digimonElegido = digimones[new Random().nextInt(digimones.length)];
        return new Digimon(digimonElegido);
    }

    /**
     * Se selecciona un Digimon de forma aleatoria con el que jugaremos
     *
     * @param domador el domador que posee el equipo de Digimons.
     * @throws InputMismatchException si el usuario ingresa un tipo de dato incorrecto al elegir un Digimon.
     */
	public void elige(Domador domador) {
		this.domador = domador;

		List<Digimon> equipo = domador.getEquipo();
		
		int indiceAleatorio = new Random().nextInt(equipo.size());

		Digimon elegido = equipo.get(indiceAleatorio);
		pelea(domador, elegido);
	}

    /**
     * Ejecuta la batalla entre el Digimon del jugador y el Digimon enemigo.
     *
     * @param domador el domador que posee el Digimon del jugador.
     * @param miDigimon el Digimon del jugador que participará en la batalla.
     */
    public void pelea(Domador domador, Digimon miDigimon) {
        while (miDigimon.getSalud() > 0 && enemigo.getSalud() > 0) {
            System.out.println("\nTu Digimon: " + miDigimon.getNombre() + " \nNivel: " + miDigimon.getNivel() + "\nSalud: " + miDigimon.getSalud() + "\nAtaque: " + miDigimon.getAtaque() + "\nDP1: " + miDigimon.getDp1() + "\nDP2: " + miDigimon.getDp2());
            System.out.println("\nEnemigo: " + enemigo.getNombre() + " Nivel: " + enemigo.getNivel() + ", Salud: " + enemigo.getSalud() + ", Ataque: " + enemigo.getAtaque() + ", DP1: " + enemigo.getDp1() + ", DP2: " + enemigo.getDp2() + ").");
            System.out.println("\nOpciones:");
            System.out.println("1. Ataque 1");
            System.out.println("2. Ataque 2");
            System.out.println("3. Capturar enemigo");

            int opcion = 0;
            boolean aux1 = true;

            while (aux1) {
                try {
                    System.out.print("Elige una opción: ");
                    opcion = leer.nextInt();
                    if (opcion < 1 || opcion > 3) {
                        System.out.println("Elige una opción entre 1 y 3");
                    } else {
                        aux1 = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error. Introduce un número");
                    leer.next(); // Limpiar el buffer del Scanner
                }
            }

            switch (opcion) {
                case 1:
                    miDigimon.usarAtaque1(enemigo);
                    System.out.println(miDigimon.getNombre() + " ha hecho " + miDigimon.getAtaque() + " puntos de daño con Ataque 1.");
                    break;
                case 2:
                    miDigimon.usarAtaque2(enemigo);
                    System.out.println(miDigimon.getNombre() + " ha hecho " + (2 * miDigimon.getAtaque()) + " puntos de daño con Ataque 2.");
                    break;
                case 3:
                    domador.captura(enemigo);
                    return;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }

            if (enemigo.getSalud() > 0) {
                if (new Random().nextBoolean()) {
                    enemigo.usarAtaque1(miDigimon);
                } else {
                    enemigo.usarAtaque2(miDigimon);
                }
                System.out.println(enemigo.getNombre() + " ha hecho daño a tu Digimon.");
            }
        }

        if (miDigimon.getSalud() <= 0) {
            System.out.println("Tu Digimon " + miDigimon.getNombre() + " ha sido derrotado.");
            if (domador.getEquipo().isEmpty()) {
                System.out.println("¡Todos tus Digimon han sido derrotados! ¡Fin del juego!");
                return;
            } else {
                System.out.println("Elige otro Digimon para continuar la batalla:");
                elige(domador);
            }
        }
    }
}
