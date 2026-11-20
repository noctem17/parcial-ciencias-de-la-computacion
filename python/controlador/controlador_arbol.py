from modelo.arbol_bst import ArbolBST


class ControladorArbol:
    def __init__(self, modelo, vista):
        self.modelo = modelo
        self.vista = vista

    def ejecutar(self, convocados):
        self.convocar(convocados)

        self.vista.mostrar_titulo("2. Busqueda: el camino del balon")
        self.buscar(9)
        self.buscar(23)
        self.buscar(8)
        self.consultar(7)

        self.vista.mostrar_titulo("3. Recorridos")
        self.mostrar_recorridos()

        self.eliminar(2, "4. Eliminar caso 1: una hoja (sale el 2)")
        self.eliminar(13, "5. Eliminar caso 2: un solo hijo (sale el 13)")
        self.eliminar(10, "6. Eliminar caso 3: dos hijos (sale la raiz 10)")
        self.vista.mostrar_espacio()
        self.vista.mostrar_inorden_final(self.modelo.inorden())

        self.peor_caso(6)

    def convocar(self, convocados):
        self.vista.mostrar_titulo("1. Convocatoria: armando el arbol")
        for dorsal, jugador in convocados:
            self.modelo.insertar(dorsal, jugador)
            self.vista.mostrar_convocado(dorsal, jugador)
        self.vista.mostrar_espacio()
        self.vista.mostrar_arbol(self.modelo.raiz)
        self.vista.mostrar_espacio()
        self.vista.mostrar_resumen("Convocados", len(self.modelo), self.modelo.altura())

    def buscar(self, dorsal):
        jugador = self.modelo.buscar(dorsal)
        camino = self.modelo.camino(dorsal)
        self.vista.mostrar_busqueda(dorsal, jugador, camino)

    def consultar(self, dorsal):
        self.vista.mostrar_pertenencia(dorsal, dorsal in self.modelo)

    def mostrar_recorridos(self):
        self.vista.mostrar_recorridos(
            self.modelo.inorden(),
            self.modelo.preorden(),
            self.modelo.postorden(),
            self.modelo.por_niveles(),
        )
        self.vista.mostrar_extremos(self.modelo.minimo(), self.modelo.maximo())

    def eliminar(self, dorsal, titulo):
        self.vista.mostrar_titulo(titulo)
        self.modelo.eliminar(dorsal)
        self.vista.mostrar_arbol(self.modelo.raiz)

    def peor_caso(self, cantidad):
        self.vista.mostrar_titulo("7. Peor caso: arbol degenerado")
        fila = ArbolBST()
        for dorsal in range(1, cantidad + 1):
            fila.insertar(dorsal, f"Jugador {dorsal}")
        self.vista.mostrar_arbol(fila.raiz)
        self.vista.mostrar_espacio()
        self.vista.mostrar_resumen("Nodos", len(fila), fila.altura())
