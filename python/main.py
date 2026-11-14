from arbol_bst import ArbolBST


CONVOCADOS = [
    (10, "James Rodriguez"),
    (4, "Santiago Arias"),
    (16, "Jefferson Lerma"),
    (1, "David Ospina"),
    (7, "Luis Diaz"),
    (13, "Yerry Mina"),
    (23, "Davinson Sanchez"),
    (9, "Radamel Falcao"),
    (11, "Juan Guillermo Cuadrado"),
    (2, "Daniel Munoz"),
]


def titulo(texto):
    print()
    print("=" * 55)
    print(f"  {texto}")
    print("=" * 55)


def mostrar_busqueda(seleccion, dorsal):
    jugador = seleccion.buscar(dorsal)
    pases = " -> ".join(str(d) for d in seleccion.camino(dorsal))
    if jugador is None:
        print(f"El {dorsal} no esta convocado. Pases: {pases}")
    else:
        print(f"El {dorsal} es {jugador}. Pases: {pases}")


def main():
    seleccion = ArbolBST()

    titulo("1. Convocatoria: armando el arbol")
    for dorsal, jugador in CONVOCADOS:
        seleccion.insertar(dorsal, jugador)
        print(f"Entra el {dorsal}: {jugador}")
    print()
    print(seleccion.dibujar())
    print()
    print(f"Convocados: {len(seleccion)}  |  Altura: {seleccion.altura()}")

    titulo("2. Busqueda: el camino del balon")
    mostrar_busqueda(seleccion, 9)
    mostrar_busqueda(seleccion, 23)
    mostrar_busqueda(seleccion, 8)
    print(f"Esta el 7? {7 in seleccion}")

    titulo("3. Recorridos")
    print(f"Inorden:     {seleccion.inorden()}")
    print(f"Preorden:    {seleccion.preorden()}")
    print(f"Postorden:   {seleccion.postorden()}")
    print(f"Por niveles: {seleccion.por_niveles()}")
    print(f"Dorsal minimo: {seleccion.minimo()}  |  Dorsal maximo: {seleccion.maximo()}")

    titulo("4. Eliminar caso 1: una hoja (sale el 2)")
    seleccion.eliminar(2)
    print(seleccion.dibujar())

    titulo("5. Eliminar caso 2: un solo hijo (sale el 13)")
    seleccion.eliminar(13)
    print(seleccion.dibujar())

    titulo("6. Eliminar caso 3: dos hijos (sale el capitan 10)")
    seleccion.eliminar(10)
    print(seleccion.dibujar())
    print()
    print(f"Inorden sigue ordenado: {seleccion.inorden()}")

    titulo("7. Peor caso: la fila de TransMilenio")
    fila = ArbolBST()
    for dorsal in range(1, 7):
        fila.insertar(dorsal, f"Jugador {dorsal}")
    print(fila.dibujar())
    print()
    print(f"Nodos: {len(fila)}  |  Altura: {fila.altura()}")


if __name__ == "__main__":
    main()
