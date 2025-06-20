# Actividad 5 - Punto 2: Validación de Edad con Interfaz Gráfica

## Descripción

Este ejercicio corresponde a un punto práctico de la materia **Programación Orientada a Objetos (POO)**.

El objetivo principal era **desarrollar una aplicación con interfaz gráfica de usuario (GUI)** que permita solicitar al usuario su nombre, apellidos y edad, validando que la edad ingresada sea válida según las siguientes condiciones:

- La edad no puede ser menor o igual a 0 ni mayor a 120.
- La edad debe ser mayor o igual a 18.
- En caso de error en el ingreso de datos o si algún campo está vacío, se muestra un mensaje de advertencia.

El resultado de la validación es mostrado en un área de texto dentro de la misma ventana.

## Estructura del proyecto

El ejercicio está compuesto por las siguientes clases:

- `Principal`: contiene el método `main` que inicia la aplicación creando una instancia de la clase `VentanaPrincipal`.
- `VentanaPrincipal`: contiene todos los elementos de la interfaz gráfica (labels, campos de texto, área de texto y botones), además de la lógica necesaria para:
  - Verificar que todos los campos estén diligenciados.
  - Validar la edad ingresada de acuerdo a las condiciones establecidas.
  - Mostrar mensajes de advertencia mediante cuadros de diálogo (`JOptionPane`) si el usuario no ingresa datos válidos.
  - Limpiar los campos para permitir una nueva entrada de datos.

## Funcionalidad

- Al ejecutar la aplicación se abre una ventana con campos para ingresar:
  - Nombre.
  - Apellidos.
  - Edad.
- Al hacer clic en el botón **Validar edad**, el programa:
  - Comprueba que ningún campo esté vacío.
  - Convierte el valor de edad a numérico y valida:
    - Si la edad es menor o igual a 0 o mayor a 120, muestra un mensaje indicando que no es válida.
    - Si la edad es menor a 18, muestra un mensaje indicando que debe ser mayor o igual a 18.
    - Si la edad es válida, muestra el mensaje correspondiente.
  - Si se ingresa un valor no numérico en el campo de edad, se muestra un mensaje de error.
- El botón **Limpiar** borra el contenido de todos los campos.

## UML

![Diagrama de clases UML](/actividad_5/punto_2/POO-UML-ejercicio2.png)
