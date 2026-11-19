# Condicion de carrera en Java

Practica de hilos: dos hilos incrementan **1000 veces** un contador compartido.
El resultado esperado es **2000**.

## Requisitos

- JDK 17 o superior
- VS Code (opcional, con Extension Pack for Java)

## Ejecutar en PowerShell

Abre la terminal en la carpeta principal del proyecto.

### 1. Sin sincronizacion

```powershell
javac -d out src/SinSincronizacion.java
java -cp out SinSincronizacion
```

### 2. Con sincronizacion

```powershell
javac -d out src/ConSincronizacion.java
java -cp out ConSincronizacion
```

En VS Code tambien puedes abrir la carpeta, seleccionar la clase y pulsar **Run** encima de `main`.

## Que observar

- **Sin `synchronized`:** puede aparecer un resultado inferior a 2000 por perdida de actualizaciones (condicion de carrera). El resultado varia de una ejecucion a otra; `Thread.yield()` no asegura un resultado inferior.
- **Con `synchronized`:** siempre se contabilizan los 2000 incrementos si ambos hilos finalizan correctamente.

## Explicacion

`contador++` no es una operacion atomica: implica leer, sumar y escribir. Dos hilos pueden leer un mismo valor y sobrescribir el incremento del otro.
El metodo `static synchronized` usa el monitor de la clase para ejecutar la seccion critica con exclusion mutua.
`join()` espera a que ambos hilos terminen antes de mostrar el resultado.

## Evidencia para entregar

Captura la terminal ejecutando ambas versiones. Ejecuta varias veces la version sin sincronizacion si inicialmente muestra 2000.
