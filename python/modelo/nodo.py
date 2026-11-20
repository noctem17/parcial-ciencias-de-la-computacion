class Nodo:
    def __init__(self, dorsal, jugador):
        self.dorsal = dorsal
        self.jugador = jugador
        self.izquierdo = None
        self.derecho = None

    def es_hoja(self):
        return self.izquierdo is None and self.derecho is None
