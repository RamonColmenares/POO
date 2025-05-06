# Actividad 4 - Punto 3:

## Descripción

Este ejercicio corresponde al **punto 3 de la Actividad 4** de la materia **Programación Orientada a Objetos (POO)**.

El objetivo principal de este ejercicio es **modelar distintas figuras geométricas** utilizando clases, atributos y métodos que permiten calcular propiedades importantes como **área, perímetro, hipotenusa** (en el caso del triángulo rectángulo), y también **determinar el tipo de triángulo** según la longitud de sus lados. Además, se pone en práctica la definición de **métodos con y sin valores de retorno**, cumpliendo con la estructura de signatura especificada en la consigna.

Cada clase representa una figura geométrica:

* **Círculo**: tiene como atributo el radio (tipo `int`).
* **Rectángulo**: tiene como atributos la base y la altura (tipo `int`).
* **Cuadrado**: tiene como atributo el lado (tipo `int`).
* **TriánguloRectángulo**: tiene como atributos la base y la altura (tipo `int`). Incluye métodos adicionales para calcular la hipotenusa y determinar el tipo de triángulo (equilátero, isósceles o escaleno).

Los métodos utilizados incluyen:

* Métodos **con valor de retorno** como `calcularArea()`, `calcularPerimetro()` y `calcularHipotenusa()`, que retornan un valor de tipo `double`.
* Métodos **sin valor de retorno** como `determinarTipoTriangulo()`, que simplemente imprime en consola el tipo de triángulo según las longitudes de sus lados.

Este ejercicio permite reforzar los siguientes conceptos clave:

* Uso de clases y objetos en Java.
* Definición de métodos con diferentes tipos de retorno y parámetros.
* Comprensión del estado y comportamiento de los objetos.

## Ejecución

El archivo `Ejercicio4.java` contiene la clase `main`, donde se crean objetos de cada figura geométrica: `Círculo`, `Rectángulo`, `Cuadrado` y `TriánguloRectángulo`. Para cada objeto, se ejecutan los métodos correspondientes para calcular e imprimir en consola su **área** y **perímetro**. En el caso del triángulo rectángulo, además, se calcula la **hipotenusa** y se determina qué tipo de triángulo es.


## 🧩 Diagrama UML

![Diagrama UML](POO_A_2-Ejercicio%204.png)
