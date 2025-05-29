# Actividad 4 - Punto 1: Notas

## 📚 Descripción

Este ejercicio corresponde a la actividad #4 punto 1 de la materia **Programación Orientada a Objetos (POO)**.

El objetivo principal era **desarrollar una aplicación con interfaz gráfica de usuario (GUI)** que permita ingresar cinco notas obtenidas por un estudiante y, con base en ello, calcular y mostrar:

- El promedio de las notas ingresadas.
- La desviación estándar de las notas.
- La mayor nota obtenida.
- La menor nota obtenida.

Para esto, se implementó una ventana que contiene campos de texto para el ingreso de datos y etiquetas para mostrar los resultados.

## Estructura del proyecto

El ejercicio está compuesto por las siguientes clases:

- `Principal`: contiene el método `main` que inicia el programa.
- `VentanaPrincipal`: contiene todos los elementos gráficos de la interfaz (labels, campos de texto y botones), además de la lógica para manejar eventos.
- `Notas`: clase encargada de realizar los cálculos (promedio, desviación estándar, nota mayor y menor) a partir de una lista de valores `Double`.

## ▶️ Funcionalidad

- Al ejecutar la aplicación se abre una ventana donde el usuario debe ingresar cinco notas.
- Al hacer clic en el botón **Calcular**, se muestran los resultados correspondientes en la parte inferior de la interfaz.
- El botón **Limpiar** permite restablecer los campos para una nueva entrada.

## UML

![Diagrama de clases UML](/actividad_4/punto_1/POO-UML-ejercicio1.png)
