import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ArbolBST {

    private Nodo raiz;
    private int tamano;

    public boolean estaVacio() {
        return raiz == null;
    }

    public int tamano() {
        return tamano;
    }

    public boolean contiene(int dorsal) {
        return buscar(dorsal) != null;
    }

    public void insertar(int dorsal, String jugador) {
        raiz = insertar(raiz, dorsal, jugador);
    }

    private Nodo insertar(Nodo nodo, int dorsal, String jugador) {
        if (nodo == null) {
            tamano++;
            return new Nodo(dorsal, jugador);
        }
        if (dorsal < nodo.dorsal) {
            nodo.izquierdo = insertar(nodo.izquierdo, dorsal, jugador);
        } else if (dorsal > nodo.dorsal) {
            nodo.derecho = insertar(nodo.derecho, dorsal, jugador);
        } else {
            nodo.jugador = jugador;
        }
        return nodo;
    }

    public String buscar(int dorsal) {
        Nodo actual = raiz;
        while (actual != null) {
            if (dorsal == actual.dorsal) {
                return actual.jugador;
            }
            if (dorsal < actual.dorsal) {
                actual = actual.izquierdo;
            } else {
                actual = actual.derecho;
            }
        }
        return null;
    }

    public List<Integer> camino(int dorsal) {
        List<Integer> recorrido = new ArrayList<>();
        Nodo actual = raiz;
        while (actual != null) {
            recorrido.add(actual.dorsal);
            if (dorsal == actual.dorsal) {
                break;
            }
            if (dorsal < actual.dorsal) {
                actual = actual.izquierdo;
            } else {
                actual = actual.derecho;
            }
        }
        return recorrido;
    }

    public boolean eliminar(int dorsal) {
        int antes = tamano;
        raiz = eliminar(raiz, dorsal);
        return tamano < antes;
    }

    private Nodo eliminar(Nodo nodo, int dorsal) {
        if (nodo == null) {
            return null;
        }
        if (dorsal < nodo.dorsal) {
            nodo.izquierdo = eliminar(nodo.izquierdo, dorsal);
        } else if (dorsal > nodo.dorsal) {
            nodo.derecho = eliminar(nodo.derecho, dorsal);
        } else {
            if (nodo.izquierdo == null) {
                tamano--;
                return nodo.derecho;
            }
            if (nodo.derecho == null) {
                tamano--;
                return nodo.izquierdo;
            }
            Nodo sucesor = minimo(nodo.derecho);
            nodo.dorsal = sucesor.dorsal;
            nodo.jugador = sucesor.jugador;
            nodo.derecho = eliminar(nodo.derecho, sucesor.dorsal);
        }
        return nodo;
    }

    public Integer minimo() {
        if (raiz == null) {
            return null;
        }
        return minimo(raiz).dorsal;
    }

    private Nodo minimo(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    public Integer maximo() {
        if (raiz == null) {
            return null;
        }
        Nodo nodo = raiz;
        while (nodo.derecho != null) {
            nodo = nodo.derecho;
        }
        return nodo.dorsal;
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }
        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    public List<Integer> inorden() {
        List<Integer> resultado = new ArrayList<>();
        inorden(raiz, resultado);
        return resultado;
    }

    private void inorden(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            inorden(nodo.izquierdo, resultado);
            resultado.add(nodo.dorsal);
            inorden(nodo.derecho, resultado);
        }
    }

    public List<Integer> preorden() {
        List<Integer> resultado = new ArrayList<>();
        preorden(raiz, resultado);
        return resultado;
    }

    private void preorden(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            resultado.add(nodo.dorsal);
            preorden(nodo.izquierdo, resultado);
            preorden(nodo.derecho, resultado);
        }
    }

    public List<Integer> postorden() {
        List<Integer> resultado = new ArrayList<>();
        postorden(raiz, resultado);
        return resultado;
    }

    private void postorden(Nodo nodo, List<Integer> resultado) {
        if (nodo != null) {
            postorden(nodo.izquierdo, resultado);
            postorden(nodo.derecho, resultado);
            resultado.add(nodo.dorsal);
        }
    }

    public List<List<Integer>> porNiveles() {
        List<List<Integer>> niveles = new ArrayList<>();
        if (raiz == null) {
            return niveles;
        }
        Queue<Nodo> cola = new ArrayDeque<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            List<Integer> nivel = new ArrayList<>();
            int cantidad = cola.size();
            for (int i = 0; i < cantidad; i++) {
                Nodo nodo = cola.poll();
                nivel.add(nodo.dorsal);
                if (nodo.izquierdo != null) {
                    cola.add(nodo.izquierdo);
                }
                if (nodo.derecho != null) {
                    cola.add(nodo.derecho);
                }
            }
            niveles.add(nivel);
        }
        return niveles;
    }

    public String dibujar() {
        if (raiz == null) {
            return "(arbol vacio)";
        }
        StringBuilder lineas = new StringBuilder();
        dibujar(raiz, "", "raiz", lineas);
        return lineas.toString().stripTrailing();
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
        dibujar(nodo.derecho, prefijo + arriba, "der", lineas);
        lineas.append(prefijo).append(conector).append(nodo.dorsal).append(" ").append(nodo.jugador).append("\n");
        dibujar(nodo.izquierdo, prefijo + abajo, "izq", lineas);
    }
}
