package codigo;
import java.util.*;

public class Digimon {
    private String nombre;
    private int nivel;
    private int ataque;
    private int salud;
    private int dp1;
    private int dp2;
    private boolean muerto;

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getSalud() {
        return salud;
    }

    public int getDp1() {
        return dp1;
    }

    public int getDp2() {
        return dp2;
    }

    public boolean isMuerto() {
        return muerto;
    }

    public Digimon(String nombre) {
        this.nombre = nombre;
        Random random = new Random();
        // Nivel aleatorio entre 1 y 5
        this.nivel = random.nextInt(5) + 1;
        // Ataque será cinco veces el nivel
        this.ataque = 5 * nivel;
        // Salud de puntos serán 10 veces el nivel
        this.salud = 10 * nivel;
        // Inicialmente 10 DP para cada ataque digital
        this.dp1 = 10;
        this.dp2 = 10;
        this.muerto = false;
    }
    
    
    public void setSalud(int salud) {
        this.salud = salud;
        if (this.salud <= 0) {
            this.muerto = true;
            this.salud = 0;
        }
    }

    public void usarAtaque1(Digimon enemigo) {
        if (dp1 > 0) {
            enemigo.setSalud(enemigo.getSalud() - ataque);
            dp1--;
            System.out.println(nombre + " ha usado Ataque1 y ha hecho " + ataque + " puntos de daño.");
        } else {
            System.out.println(nombre + " no tiene suficientes DP para Ataque1");
        }
    }

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
