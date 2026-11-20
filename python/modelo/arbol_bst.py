from collections import deque

from modelo.nodo import Nodo


class ArbolBST:
    def __init__(self):
        self.raiz = None
        self.tamano = 0

    def esta_vacio(self):
        return self.raiz is None

    def __len__(self):
        return self.tamano

    def __contains__(self, dorsal):
        return self.buscar(dorsal) is not None

    def insertar(self, dorsal, jugador):
        self.raiz = self._insertar(self.raiz, dorsal, jugador)

    def _insertar(self, nodo, dorsal, jugador):
        if nodo is None:
            self.tamano += 1
            return Nodo(dorsal, jugador)
        if dorsal < nodo.dorsal:
            nodo.izquierdo = self._insertar(nodo.izquierdo, dorsal, jugador)
        elif dorsal > nodo.dorsal:
            nodo.derecho = self._insertar(nodo.derecho, dorsal, jugador)
        else:
            nodo.jugador = jugador
        return nodo

    def buscar(self, dorsal):
        actual = self.raiz
        while actual is not None:
            if dorsal == actual.dorsal:
                return actual.jugador
            if dorsal < actual.dorsal:
                actual = actual.izquierdo
            else:
                actual = actual.derecho
        return None

    def camino(self, dorsal):
        recorrido = []
        actual = self.raiz
        while actual is not None:
            recorrido.append(actual.dorsal)
            if dorsal == actual.dorsal:
                break
            if dorsal < actual.dorsal:
                actual = actual.izquierdo
            else:
                actual = actual.derecho
        return recorrido

    def eliminar(self, dorsal):
        antes = self.tamano
        self.raiz = self._eliminar(self.raiz, dorsal)
        return self.tamano < antes

    def _eliminar(self, nodo, dorsal):
        if nodo is None:
            return None
        if dorsal < nodo.dorsal:
            nodo.izquierdo = self._eliminar(nodo.izquierdo, dorsal)
        elif dorsal > nodo.dorsal:
            nodo.derecho = self._eliminar(nodo.derecho, dorsal)
        else:
            if nodo.izquierdo is None:
                self.tamano -= 1
                return nodo.derecho
            if nodo.derecho is None:
                self.tamano -= 1
                return nodo.izquierdo
            sucesor = self._minimo(nodo.derecho)
            nodo.dorsal = sucesor.dorsal
            nodo.jugador = sucesor.jugador
            nodo.derecho = self._eliminar(nodo.derecho, sucesor.dorsal)
        return nodo

    def minimo(self):
        if self.raiz is None:
            return None
        return self._minimo(self.raiz).dorsal

    def _minimo(self, nodo):
        while nodo.izquierdo is not None:
            nodo = nodo.izquierdo
        return nodo

    def maximo(self):
        if self.raiz is None:
            return None
        nodo = self.raiz
        while nodo.derecho is not None:
            nodo = nodo.derecho
        return nodo.dorsal

    def altura(self):
        return self._altura(self.raiz)

    def _altura(self, nodo):
        if nodo is None:
            return -1
        return 1 + max(self._altura(nodo.izquierdo), self._altura(nodo.derecho))

    def inorden(self):
        resultado = []
        self._inorden(self.raiz, resultado)
        return resultado

    def _inorden(self, nodo, resultado):
        if nodo is not None:
            self._inorden(nodo.izquierdo, resultado)
            resultado.append(nodo.dorsal)
            self._inorden(nodo.derecho, resultado)

    def preorden(self):
        resultado = []
        self._preorden(self.raiz, resultado)
        return resultado

    def _preorden(self, nodo, resultado):
        if nodo is not None:
            resultado.append(nodo.dorsal)
            self._preorden(nodo.izquierdo, resultado)
            self._preorden(nodo.derecho, resultado)

    def postorden(self):
        resultado = []
        self._postorden(self.raiz, resultado)
        return resultado

    def _postorden(self, nodo, resultado):
        if nodo is not None:
            self._postorden(nodo.izquierdo, resultado)
            self._postorden(nodo.derecho, resultado)
            resultado.append(nodo.dorsal)

    def por_niveles(self):
        niveles = []
        if self.raiz is None:
            return niveles
        cola = deque([self.raiz])
        while cola:
            nivel = []
            for _ in range(len(cola)):
                nodo = cola.popleft()
                nivel.append(nodo.dorsal)
                if nodo.izquierdo is not None:
                    cola.append(nodo.izquierdo)
                if nodo.derecho is not None:
                    cola.append(nodo.derecho)
            niveles.append(nivel)
        return niveles
