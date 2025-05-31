# Aplicación de Geometría - Mejoras Implementadas

## Descripción del Proyecto

Esta aplicación de geometría permite calcular el volumen y superficie de diferentes figuras geométricas a través de una interfaz gráfica desarrollada en Java Swing.

## Mejoras Implementadas

### 1. Nuevas Figuras Geométricas

Se agregaron dos nuevas figuras geométricas al sistema:

#### **Cubo**
- **Clase**: `Cubo.java`
- **Parámetros**: Lado (en cms)
- **Cálculos**:
  - Volumen: `lado³`
  - Superficie: `6 × lado²`

#### **Prisma Rectangular**
- **Clase**: `Prisma.java`
- **Parámetros**: Base, Anchura, Altura (en cms)
- **Cálculos**:
  - Volumen: `base × anchura × altura`
  - Superficie: `2 × (base × anchura + base × altura + anchura × altura)`

### 2. Representaciones Gráficas

Se implementó la clase `GraficadorFiguras.java` que proporciona representaciones visuales de cada figura geométrica:

- **Cilindro**: Representación en azul con elipses superior e inferior
- **Esfera**: Representación en rojo con líneas de referencia
- **Pirámide**: Representación en verde con base cuadrada
- **Cubo**: Representación en naranja con perspectiva 3D
- **Prisma**: Representación en magenta con perspectiva 3D

### 3. Interfaz de Usuario Mejorada

#### Ventana Principal
- Se agregaron botones para acceder a las nuevas figuras (Cubo y Prisma)
- Se amplió el tamaño de la ventana para acomodar los nuevos botones
- Distribución mejorada de los elementos

#### Ventanas Individuales
Todas las ventanas de figuras ahora incluyen:
- **Gráfico visual** de la figura correspondiente (120x120 píxeles)
- **Campos de entrada** mejorados con mejor distribución
- **Etiquetas de resultados** más amplias para mostrar valores completos
- **Tamaño aumentado** para mejor visualización (400px de ancho mínimo)

### 4. Estructura del Proyecto

```
GeometriaApp/
├── Principal.java              # Clase principal
├── Figuras/
│   ├── FiguraGeométrica.java  # Clase base
│   ├── Cilindro.java          # Figura existente
│   ├── Esfera.java            # Figura existente
│   ├── Piramide.java          # Figura existente
│   ├── Cubo.java              # Nueva figura ✅
│   └── Prisma.java            # Nueva figura ✅
└── UI/
    ├── VentanaPrincipal.java  # Ventana principal mejorada ✅
    ├── VentanaCilindro.java   # Con gráfico ✅
    ├── VentanaEsfera.java     # Con gráfico ✅
    ├── VentanaPirámide.java   # Con gráfico ✅
    ├── VentanaCubo.java       # Nueva ventana ✅
    ├── VentanaPrisma.java     # Nueva ventana ✅
    └── GraficadorFiguras.java # Nueva clase para gráficos ✅
```

## Características Técnicas

### Tecnologías Utilizadas
- **Java**: Lenguaje de programación principal
- **Swing**: Framework para la interfaz gráfica
- **Graphics2D**: Para el renderizado de gráficos personalizados
- **POO**: Implementación con herencia y polimorfismo

### Patrón de Diseño
- **Herencia**: Todas las figuras extienden de `FiguraGeométrica`
- **Encapsulación**: Métodos específicos para cada figura
- **Polimorfismo**: Métodos `calcularVolumen()` y `calcularSuperficie()`

## Compilación y Ejecución

### Compilar el proyecto:
```bash
javac -d . GeometriaApp/Principal.java GeometriaApp/Figuras/*.java GeometriaApp/UI/*.java
```

### Ejecutar la aplicación:
```bash
java GeometriaApp.Principal
```

## Funcionalidades

### Operaciones Disponibles
1. **Cilindro**: Cálculo basado en radio y altura
2. **Esfera**: Cálculo basado en radio
3. **Pirámide**: Cálculo basado en base, altura y apotema
4. **Cubo**: Cálculo basado en lado ✅ **NUEVO**
5. **Prisma**: Cálculo basado en base, anchura y altura ✅ **NUEVO**

### Validaciones
- Verificación de formato numérico en todos los campos
- Manejo de excepciones con mensajes informativos
- Validación de campos vacíos

## Mejoras Visuales

### Gráficos Personalizados
La aplicación ahora utiliza un sistema de carga de imágenes PNG para mostrar representaciones visuales de las figuras geométricas.

#### Imágenes Requeridas
Para el funcionamiento completo de la aplicación, coloca los siguientes archivos PNG en la carpeta `GeometriaApp/imagenes/`:

- `cilindro.png` - Imagen de un cilindro
- `esfera.png` - Imagen de una esfera  
- `piramide.png` - Imagen de una pirámide
- `cubo.png` - Imagen de un cubo
- `prisma.png` - Imagen de un prisma rectangular

**Especificaciones recomendadas:**
- Tamaño: 120x120 píxeles (o proporcional)
- Formato: PNG con fondo transparente preferible
- Calidad: Imágenes claras y bien definidas

**Nota importante:** Los nombres de archivo deben coincidir exactamente (incluyendo minúsculas). Si una imagen no se encuentra, la aplicación mostrará el nombre de la figura como texto alternativo.

### Sistema de Carga de Imágenes
- **Carga automática**: Las imágenes se cargan dinámicamente desde la carpeta `imagenes/`
- **Manejo de errores**: Si una imagen no existe, se muestra texto alternativo
- **Centrado automático**: Las imágenes se centran automáticamente en sus paneles
- **Compatibilidad**: Soporte para diferentes tamaños de imagen

## Autor
Desarrollado como parte de la Actividad 4 - Punto 2
Programación Orientada a Objetos (POO)

## Versión
2.0 - Con figuras adicionales y representaciones gráficas
