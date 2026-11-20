class VistaConsola:
    def mostrar_titulo(self, texto):
        print()
        print("=" * 55)
        print(f"  {texto}")
        print("=" * 55)

    def mostrar_espacio(self):
        print()

    def mostrar_convocado(self, dorsal, jugador):
        print(f"Entra el {dorsal}: {jugador}")

    def mostrar_resumen(self, etiqueta, cantidad, altura):
        print(f"{etiqueta}: {cantidad}  |  Altura: {altura}")

    def mostrar_busqueda(self, dorsal, jugador, camino):
        pases = " -> ".join(str(d) for d in camino)
        if jugador is None:
            print(f"El {dorsal} no esta convocado. Pases: {pases}")
        else:
            print(f"El {dorsal} es {jugador}. Pases: {pases}")

    def mostrar_pertenencia(self, dorsal, esta):
        print(f"Esta el {dorsal}? {esta}")

    def mostrar_recorridos(self, inorden, preorden, postorden, niveles):
        print(f"Inorden:     {inorden}")
        print(f"Preorden:    {preorden}")
        print(f"Postorden:   {postorden}")
        print(f"Por niveles: {niveles}")

    def mostrar_extremos(self, minimo, maximo):
        print(f"Dorsal minimo: {minimo}  |  Dorsal maximo: {maximo}")

    def mostrar_inorden_final(self, inorden):
        print(f"Inorden sigue ordenado: {inorden}")

    def mostrar_arbol(self, raiz):
        if raiz is None:
            print("(arbol vacio)")
            return
        lineas = []
        self._dibujar(raiz, "", "raiz", lineas)
        print("\n".join(lineas))

    def _dibujar(self, nodo, prefijo, lado, lineas):
        if nodo is None:
            return
        conectores = {"raiz": "", "der": "/-- ", "izq": "\\-- "}
        arriba = "|   " if lado == "izq" else "    "
        abajo = "|   " if lado == "der" else "    "
        self._dibujar(nodo.derecho, prefijo + arriba, "der", lineas)
        lineas.append(f"{prefijo}{conectores[lado]}{nodo.dorsal} {nodo.jugador}")
        self._dibujar(nodo.izquierdo, prefijo + abajo, "izq", lineas)
