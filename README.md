# Parcial Ciencias de la Computacion - Arbol BST

Arbol Binario de Busqueda implementado en **Java** y **Python**.
Para el ejemplo usamos la nomina de la Seleccion Colombia: cada jugador es un nodo y se ordena por su dorsal.

**Integrantes:** Gabriela, Cristian y Reynel

## Operaciones

| Operacion | Python | Java |
| --- | --- | --- |
| Insertar | `insertar` | `insertar` |
| Buscar | `buscar` | `buscar` |
| Camino de busqueda | `camino` | `camino` |
| Eliminar (hoja, un hijo, dos hijos) | `eliminar` | `eliminar` |
| Minimo y maximo | `minimo` / `maximo` | `minimo` / `maximo` |
| Altura | `altura` | `altura` |
| Inorden, preorden, postorden | `inorden` / `preorden` / `postorden` | `inorden` / `preorden` / `postorden` |
| Recorrido por niveles | `por_niveles` | `porNiveles` |
| Dibujar el arbol | `dibujar` | `dibujar` |

## Estructura

```
python/
    nodo.py
    arbol_bst.py
    main.py
java/
    src/
        Nodo.java
        ArbolBST.java
        Main.java
```

## Como correrlo

Python (3.10 o superior):

```
cd python
python main.py
```

Java (17 o superior):

```
javac -d out java/src/*.java
java -cp out Main
```
