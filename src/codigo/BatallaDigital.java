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
		// Obtener el equipo del domador
		List<Digimon> equipo = domador.getEquipo();
		// Generar un índice aleatorio dentro del rango del equipo
		int indiceAleatorio = new Random().nextInt(equipo.size());
		// Seleccionar el Digimon correspondiente al índice aleatorio
		Digimon elegido = equipo.get(indiceAleatorio);

	}
	
	
}