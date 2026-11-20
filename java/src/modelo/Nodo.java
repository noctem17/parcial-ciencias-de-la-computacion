package modelo;

public class Nodo {

    int dorsal;
    String jugador;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int dorsal, String jugador) {
        this.dorsal = dorsal;
        this.jugador = jugador;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getJugador() {
        return jugador;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }
}
