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
	public void captura(Digimon enemigo) {
		if (enemigo.getSalud() <= 20) { //Se captura el Digimon si tiene 20 puntos menos de salud que al principio
			this.equipo.add(enemigo); //Añado el digimon al equipo
			System.out.println(enemigo.getNombre() + " se ha unido a su equipo.");
		} else {
			System.out.println("No se puede unir.");
		}
	}

}