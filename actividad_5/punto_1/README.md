# Actividad 5 - Punto 1: Manejo de Excepciones con Interfaz Gráfica

## Descripción

Este ejercicio corresponde a un punto práctico de la materia **Programación Orientada a Objetos (POO)**.

El objetivo principal era **desarrollar una aplicación con interfaz gráfica de usuario (GUI)** que permita realizar la división entre dos números, manejando adecuadamente las excepciones posibles que pueden ocurrir durante la operación aritmética.

La ventana permite ingresar un numerador y un denominador y, al presionar el botón **Calcular**, muestra el resultado de la división en un campo de texto. Si el usuario intenta dividir por cero o ingresa un dato no numérico, se lanza una excepción que es capturada y mostrada mediante un cuadro de diálogo.

## Estructura del proyecto

El ejercicio está compuesto por las siguientes clases:

- `Principal`: contiene el método `main` que inicia la aplicación, creando una instancia de la clase `VentanaPrincipal`.
- `VentanaPrincipal`: contiene todos los elementos de la interfaz gráfica (labels, campos de texto y botones), así como la lógica necesaria para:
  - Obtener los valores ingresados.
  - Calcular la división entre los dos números.
  - Manejar las excepciones de tipo `ArithmeticException` y `NumberFormatException`.
  - Limpiar los campos de entrada.

## Funcionalidad

- Al ejecutar la aplicación se abre una ventana con campos para ingresar numerador y denominador.
- Al hacer clic en el botón **Calcular**, el programa:
  - Realiza la división y muestra el resultado.
  - Si el denominador es cero, muestra un mensaje de error indicando "División por cero no permitida".
  - Si el usuario ingresa un valor no numérico, muestra un mensaje de error indicando "Ingresa un valor numérico válido".
- El botón **Limpiar** borra el contenido de los campos de entrada y resultado.

## UML

![Diagrama de clases UML](/actividad_5/punto_1/POO-UML-ejercicio1.png)
