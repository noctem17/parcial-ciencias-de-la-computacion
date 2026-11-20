from controlador.controlador_arbol import ControladorArbol
from modelo.arbol_bst import ArbolBST
from vista.vista_consola import VistaConsola


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


def main():
    controlador = ControladorArbol(ArbolBST(), VistaConsola())
    controlador.ejecutar(CONVOCADOS)


if __name__ == "__main__":
    main()
