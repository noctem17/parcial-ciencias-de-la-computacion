import controlador.ControladorArbol;
import modelo.ArbolBST;
import vista.VistaConsola;

public class Main {

    private static final int[] DORSALES = {10, 4, 16, 1, 7, 13, 23, 9, 11, 2};

    private static final String[] JUGADORES = {
        "James Rodriguez",
        "Santiago Arias",
        "Jefferson Lerma",
        "David Ospina",
        "Luis Diaz",
        "Yerry Mina",
        "Davinson Sanchez",
        "Radamel Falcao",
        "Juan Guillermo Cuadrado",
        "Daniel Munoz"
    };

    public static void main(String[] args) {
        ControladorArbol controlador = new ControladorArbol(new ArbolBST(), new VistaConsola());
        controlador.ejecutar(DORSALES, JUGADORES);
    }
}
