package vista;

import java.util.List;
import java.util.StringJoiner;
import modelo.Nodo;

public class VistaConsola {

    public void mostrarTitulo(String texto) {
        System.out.println();
        System.out.println("=".repeat(55));
        System.out.println("  " + texto);
        System.out.println("=".repeat(55));
    }

    public void mostrarEspacio() {
        System.out.println();
    }

    public void mostrarConvocado(int dorsal, String jugador) {
        System.out.println("Entra el " + dorsal + ": " + jugador);
    }

    public void mostrarResumen(String etiqueta, int cantidad, int altura) {
        System.out.println(etiqueta + ": " + cantidad + "  |  Altura: " + altura);
    }

    public void mostrarBusqueda(int dorsal, String jugador, List<Integer> camino) {
        StringJoiner pases = new StringJoiner(" -> ");
        for (int paso : camino) {
            pases.add(String.valueOf(paso));
        }
        if (jugador == null) {
            System.out.println("El " + dorsal + " no esta convocado. Pases: " + pases);
        } else {
            System.out.println("El " + dorsal + " es " + jugador + ". Pases: " + pases);
        }
    }

    public void mostrarPertenencia(int dorsal, boolean esta) {
        System.out.println("Esta el " + dorsal + "? " + esta);
    }

    public void mostrarRecorridos(List<Integer> inorden, List<Integer> preorden,
                                  List<Integer> postorden, List<List<Integer>> niveles) {
        System.out.println("Inorden:     " + inorden);
        System.out.println("Preorden:    " + preorden);
        System.out.println("Postorden:   " + postorden);
        System.out.println("Por niveles: " + niveles);
    }

    public void mostrarExtremos(Integer minimo, Integer maximo) {
        System.out.println("Dorsal minimo: " + minimo + "  |  Dorsal maximo: " + maximo);
    }

    public void mostrarInordenFinal(List<Integer> inorden) {
        System.out.println("Inorden sigue ordenado: " + inorden);
    }

    public void mostrarArbol(Nodo raiz) {
        if (raiz == null) {
            System.out.println("(arbol vacio)");
            return;
        }
        StringBuilder lineas = new StringBuilder();
        dibujar(raiz, "", "raiz", lineas);
        System.out.println(lineas.toString().stripTrailing());
    }

    private void dibujar(Nodo nodo, String prefijo, String lado, StringBuilder lineas) {
        if (nodo == null) {
            return;
        }
        String conector = switch (lado) {
            case "der" -> "/-- ";
            case "izq" -> "\\-- ";
            default -> "";
        };
        String arriba = lado.equals("izq") ? "|   " : "    ";
        String abajo = lado.equals("der") ? "|   " : "    ";
        dibujar(nodo.getDerecho(), prefijo + arriba, "der", lineas);
        lineas.append(prefijo).append(conector).append(nodo.getDorsal()).append(" ").append(nodo.getJugador()).append("\n");
        dibujar(nodo.getIzquierdo(), prefijo + abajo, "izq", lineas);
    }
}
