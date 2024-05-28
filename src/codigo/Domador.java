package codigo;

import java.util.*;

public class Domador {
    private String nombre;
    private List<Digimon> equipo;

    public Domador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>(3);
        equipo.add(new Digimon("Agumon"));
        equipo.add(new Digimon("Gabumon"));
        equipo.add(new Digimon("Patamon"));
    }

    public String getNombre() {
        return nombre;
    }

    public List<Digimon> getEquipo() {
        return equipo;
    }
}