package codigo;

import java.util.*;

/**
 * La clase Digimon representa un Digimon con atributos como nombre, nivel, ataque,
 * salud y puntos de poder digital (DP). Proporciona métodos para realizar ataques
 * y gestionar la salud del Digimon.
 * 
 */
public class Digimon {
    private String nombre;
    private int nivel;
    private int ataque;
    private int salud;
    private int dp1;
    private int dp2;
    private boolean muerto;

    /**
     * Obtiene el nombre del Digimon.
     * 
     * @return El nombre del Digimon.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el nivel del Digimon.
     * 
     * @return El nivel del Digimon.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Obtiene el valor de ataque del Digimon.
     * 
     * @return El valor de ataque del Digimon.
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Obtiene la salud del Digimon.
     * 
     * @return La salud del Digimon.
     */
    public int getSalud() {
        return salud;
    }

    /**
     * Obtiene los puntos de poder digital (DP) del primer ataque del Digimon.
     * 
     * @return Los puntos de poder digital (DP) del primer ataque.
     */
    public int getDp1() {
        return dp1;
    }

    /**
     * Obtiene los puntos de poder digital (DP) del segundo ataque del Digimon.
     * 
     * @return Los puntos de poder digital (DP) del segundo ataque.
     */
    public int getDp2() {
        return dp2;
    }

    /**
     * Verifica si el Digimon está muerto.
     * 
     * @return true si el Digimon está muerto, false en caso contrario.
     */
    public boolean isMuerto() {
        return muerto;
    }

    /**
     * Crea un nuevo Digimon con el nombre especificado. Los atributos nivel, ataque,
     * salud y DP se inicializan aleatoriamente.
     * 
     * @param nombre El nombre del Digimon.
     */
    public Digimon(String nombre) {
        this.nombre = nombre;
        Random random = new Random();
        this.nivel = random.nextInt(5) + 1; // Nivel aleatorio entre 1 y 5
        this.ataque = 5 * nivel; // Ataque es cinco veces el nivel
        this.salud = 10 * nivel; // Salud es diez veces el nivel
        this.dp1 = 10; // Inicialmente 10 DP para cada ataque digital
        this.dp2 = 10;
        this.muerto = false;
    }

    /**
     * Establece la salud del Digimon. Si la salud es menor o igual a cero, el Digimon
     * se considera muerto.
     * 
     * @param salud La nueva salud del Digimon.
     */
    public void setSalud(int salud) {
        this.salud = salud;
        if (this.salud <= 0) {
            this.muerto = true;
            this.salud = 0;
        }
    }

    /**
     * Realiza el primer ataque del Digimon sobre un enemigo. El ataque reduce la salud
     * del enemigo y consume un punto de poder digital (DP).
     * 
     * @param enemigo El Digimon enemigo que recibe el ataque.
     */
    public void usarAtaque1(Digimon enemigo) {
        if (dp1 > 0) {
            enemigo.setSalud(enemigo.getSalud() - ataque);
            dp1--;
            System.out.println(nombre + " ha usado Ataque1 y ha hecho " + ataque + " puntos de daño.");
        } else {
            System.out.println(nombre + " no tiene suficientes DP para Ataque1");
        }
    }

    /**
     * Realiza el segundo ataque del Digimon sobre un enemigo. El ataque es dos veces
     * más fuerte que el primer ataque y consume dos puntos de poder digital (DP).
     * 
     * @param enemigo El Digimon enemigo que recibe el ataque.
     */
    public void usarAtaque2(Digimon enemigo) {
        if (dp2 > 1) {
            int danio = 2 * ataque;
            enemigo.setSalud(enemigo.getSalud() - danio);
            dp2 -= 2;
            System.out.println(nombre + " ha usado Ataque2 y ha hecho " + danio + " puntos de daño.");
        } else {
            System.out.println(nombre + " no tiene suficientes DP para Ataque2");
        }
    }
}
