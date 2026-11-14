import java.util.StringJoiner;

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

    private static void titulo(String texto) {
        System.out.println();
        System.out.println("=".repeat(55));
        System.out.println("  " + texto);
        System.out.println("=".repeat(55));
    }

    private static void mostrarBusqueda(ArbolBST seleccion, int dorsal) {
        String jugador = seleccion.buscar(dorsal);
        StringJoiner pases = new StringJoiner(" -> ");
        for (int paso : seleccion.camino(dorsal)) {
            pases.add(String.valueOf(paso));
        }
        if (jugador == null) {
            System.out.println("El " + dorsal + " no esta convocado. Pases: " + pases);
        } else {
            System.out.println("El " + dorsal + " es " + jugador + ". Pases: " + pases);
        }
    }

    public static void main(String[] args) {
        ArbolBST seleccion = new ArbolBST();

        titulo("1. Convocatoria: armando el arbol");
        for (int i = 0; i < DORSALES.length; i++) {
            seleccion.insertar(DORSALES[i], JUGADORES[i]);
            System.out.println("Entra el " + DORSALES[i] + ": " + JUGADORES[i]);
        }
        System.out.println();
        System.out.println(seleccion.dibujar());
        System.out.println();
        System.out.println("Convocados: " + seleccion.tamano() + "  |  Altura: " + seleccion.altura());

        titulo("2. Busqueda: el camino del balon");
        mostrarBusqueda(seleccion, 9);
        mostrarBusqueda(seleccion, 23);
        mostrarBusqueda(seleccion, 8);
        System.out.println("Esta el 7? " + seleccion.contiene(7));

        titulo("3. Recorridos");
        System.out.println("Inorden:     " + seleccion.inorden());
        System.out.println("Preorden:    " + seleccion.preorden());
        System.out.println("Postorden:   " + seleccion.postorden());
        System.out.println("Por niveles: " + seleccion.porNiveles());
        System.out.println("Dorsal minimo: " + seleccion.minimo() + "  |  Dorsal maximo: " + seleccion.maximo());

        titulo("4. Eliminar caso 1: una hoja (sale el 2)");
        seleccion.eliminar(2);
        System.out.println(seleccion.dibujar());

        titulo("5. Eliminar caso 2: un solo hijo (sale el 13)");
        seleccion.eliminar(13);
        System.out.println(seleccion.dibujar());

        titulo("6. Eliminar caso 3: dos hijos (sale el capitan 10)");
        seleccion.eliminar(10);
        System.out.println(seleccion.dibujar());
        System.out.println();
        System.out.println("Inorden sigue ordenado: " + seleccion.inorden());

        titulo("7. Peor caso: la fila de TransMilenio");
        ArbolBST fila = new ArbolBST();
        for (int dorsal = 1; dorsal <= 6; dorsal++) {
            fila.insertar(dorsal, "Jugador " + dorsal);
        }
        System.out.println(fila.dibujar());
        System.out.println();
        System.out.println("Nodos: " + fila.tamano() + "  |  Altura: " + fila.altura());
    }
}
