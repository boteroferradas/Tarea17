# Tarea 17 - Conteo de consonantes

El proyecto está compuesto por tres clases principales:

## 1. `Main.java` (Clase Principal)
    - Pide por teclado las 5 consonantes y el texto a analizar.
    - Aplica el `.repeat(2000)` al texto para aumentar la carga de trabajo.
    - Crea, configura y arranca un hilo independiente para cada consonante.
    - Utiliza `join()` para obligar al hilo principal a esperar a que todos los hilos terminen antes de mostrar
    el resultado global.

## 2. `Consonante.java` (Tarea del Hilo)
    - Implementa la interfaz `Runnable`.
    - Recorre el texto dividido buscando las coincidencias de su consonante asignada (ignorando mayúsculas/minúsculas).
    - Envía el recuento parcial al contador compartido y muestra su resultado individual por pantalla.

## 3. `ContadorConsonante.java` (Recurso Compartido)
    - Almacena el total global de apariciones de forma estática.
    - Contiene un método `synchronized` para sumar los resultados de forma segura, evitando que
    varios hilos modifiquen la variable al mismo tiempo y corrompan los datos.