package codigo;

import java.util.*;

/**
 * La clase Domador representa a un domador de Digimon con un equipo de Digimon. 
 * Proporciona métodos para capturar nuevos Digimon y gestionar el equipo.
 * 
 */
public class Domador {
    private String nombre;
    private List<Digimon> equipo;

    /**
     * Crea un nuevo Domador con el nombre especificado e inicializa el equipo
     * con tres Digimon predeterminados: Agumon, Gabumon y Patamon.
     * 
     * @param nombre El nombre del domador.
     */
    public Domador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>(3);
        equipo.add(new Digimon("Agumon"));
        equipo.add(new Digimon("Gabumon"));
        equipo.add(new Digimon("Patamon"));
    }

    /**
     * Obtiene el nombre del domador.
     * 
     * @return El nombre del domador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el equipo de Digimon del domador.
     * 
     * @return Una lista con los Digimon del equipo del domador.
     */
    public List<Digimon> getEquipo() {
        return equipo;
    }

    /**
     * Intenta capturar un Digimon enemigo y añadirlo al equipo del domador. 
     * El Digimon enemigo solo se captura si su salud es menor o igual a 20.
     * 
     * @param enemigo El Digimon enemigo que se intenta capturar.
     */
    public void captura(Digimon enemigo) {
        if (enemigo.getSalud() <= 20) { // Se captura el Digimon si tiene 20 puntos o menos de salud
            this.equipo.add(enemigo); // Añado el digimon al equipo
            System.out.println(enemigo.getNombre() + " se ha unido a su equipo.");
        } else {
            System.out.println("No se puede unir.");
        }
    }
}
