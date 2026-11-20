public class Nodo {

    int dorsal;
    String jugador;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int dorsal, String jugador) {
        this.dorsal = dorsal;
        this.jugador = jugador;
    }

    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }
}
