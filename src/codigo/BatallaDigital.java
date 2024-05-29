package codigo;

import java.util.*;

public class BatallaDigital {
    private Digimon enemigo;
    private Domador domador;
    private Scanner leer;

    public BatallaDigital() {
        this.enemigo = generarDigimonAleatorio();
        this.leer = new Scanner(System.in);
    }

    private Digimon generarDigimonAleatorio() {
        String[] digimones = {"Agumon", "Gabumon", "Patamon"};
        String digimonElegido = digimones[new Random().nextInt(digimones.length)];
        return new Digimon(digimonElegido);
    }

    public void elige(Domador domador) {
        this.domador = domador;

        List<Digimon> equipo = domador.getEquipo();
        
        int indiceAleatorio = new Random().nextInt(equipo.size());

        Digimon elegido = equipo.get(indiceAleatorio);
        pelea(domador, elegido);
    }
    
    public void pelea(Domador domador, Digimon miDigimon) {
        while (miDigimon.getSalud() > 0 && enemigo.getSalud() > 0) {
            System.out.println("\nTu Digimon: " + miDigimon.getNombre() + " \nNivel: " + miDigimon.getNivel() + "\nSalud: " + miDigimon.getSalud() + "\nAtaque: " + miDigimon.getAtaque() + "\nDP1: " + miDigimon.getDp1() + "\nDP2: " + miDigimon.getDp2());
            System.out.println("\nEnemigo: " + enemigo.getNombre() + " Nivel: " + enemigo.getNivel() + ", Salud: " + enemigo.getSalud() + ", Ataque: " + enemigo.getAtaque() + ", DP1: " + enemigo.getDp1() + ", DP2: " + enemigo.getDp2() + ").");
            System.out.println("\nOpciones:");
            System.out.println("1. Ataque 1");
            System.out.println("2. Ataque 2");
            System.out.println("3. Capturar enemigo");

            int opcion = 0;
            boolean menu = true;

            while (menu) {
                try {
                    System.out.print("Elige una opción: ");
                    opcion = leer.nextInt();
                    if (opcion < 1 || opcion > 3) {
                        System.out.println("Elige una opción entre 1 y 3");
                    } else {
                        menu = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error. Introduce un número");
                    leer.next(); // Limpiar el buffer del Scanner
                }
            }

            switch (opcion) {
            case 1:
                miDigimon.usarAtaque1(enemigo);
                break;
            case 2:
                miDigimon.usarAtaque2(enemigo);
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
            // Si el Domador no tiene más Digimon en su equipo, termina la partida
            if (domador.getEquipo().isEmpty()) {
                System.out.println("¡Todos tus Digimon han sido derrotados! ¡Fin del juego!");
                return;
            } else {
                // Si el Domador tiene más Digimon en su equipo, permite elegir otro Digimon
                System.out.println("Elige otro Digimon para continuar la batalla:");
                elige(domador);
                miDigimon = domador.getEquipo().get(0); // Cambia al primer Digimon del equipo como el nuevo Digimon del jugador
                System.out.println("Ahora luchas con " + miDigimon.getNombre());
            }
        }
    }
}
