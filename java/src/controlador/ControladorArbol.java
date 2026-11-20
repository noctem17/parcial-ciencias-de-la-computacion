package controlador;

import modelo.ArbolBST;
import vista.VistaConsola;

public class ControladorArbol {

    private final ArbolBST modelo;
    private final VistaConsola vista;

    public ControladorArbol(ArbolBST modelo, VistaConsola vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void ejecutar(int[] dorsales, String[] jugadores) {
        convocar(dorsales, jugadores);

        vista.mostrarTitulo("2. Busqueda: el camino del balon");
        buscar(9);
        buscar(23);
        buscar(8);
        consultar(7);

        vista.mostrarTitulo("3. Recorridos");
        mostrarRecorridos();

        eliminar(2, "4. Eliminar caso 1: una hoja (sale el 2)");
        eliminar(13, "5. Eliminar caso 2: un solo hijo (sale el 13)");
        eliminar(10, "6. Eliminar caso 3: dos hijos (sale la raiz 10)");
        vista.mostrarEspacio();
        vista.mostrarInordenFinal(modelo.inorden());

        peorCaso(6);
    }

    public void convocar(int[] dorsales, String[] jugadores) {
        vista.mostrarTitulo("1. Convocatoria: armando el arbol");
        for (int i = 0; i < dorsales.length; i++) {
            modelo.insertar(dorsales[i], jugadores[i]);
            vista.mostrarConvocado(dorsales[i], jugadores[i]);
        }
        vista.mostrarEspacio();
        vista.mostrarArbol(modelo.getRaiz());
        vista.mostrarEspacio();
        vista.mostrarResumen("Convocados", modelo.tamano(), modelo.altura());
    }

    public void buscar(int dorsal) {
        vista.mostrarBusqueda(dorsal, modelo.buscar(dorsal), modelo.camino(dorsal));
    }

    public void consultar(int dorsal) {
        vista.mostrarPertenencia(dorsal, modelo.contiene(dorsal));
    }

    public void mostrarRecorridos() {
        vista.mostrarRecorridos(modelo.inorden(), modelo.preorden(), modelo.postorden(), modelo.porNiveles());
        vista.mostrarExtremos(modelo.minimo(), modelo.maximo());
    }

    public void eliminar(int dorsal, String titulo) {
        vista.mostrarTitulo(titulo);
        modelo.eliminar(dorsal);
        vista.mostrarArbol(modelo.getRaiz());
    }

    public void peorCaso(int cantidad) {
        vista.mostrarTitulo("7. Peor caso: arbol degenerado");
        ArbolBST fila = new ArbolBST();
        for (int dorsal = 1; dorsal <= cantidad; dorsal++) {
            fila.insertar(dorsal, "Jugador " + dorsal);
        }
        vista.mostrarArbol(fila.getRaiz());
        vista.mostrarEspacio();
        vista.mostrarResumen("Nodos", fila.tamano(), fila.altura());
    }
}
