# Sistema de Gestión de Estudiantes - CRUD

## Descripción
Aplicación de escritorio desarrollada en Java que implementa operaciones CRUD (Create, Read, Update, Delete) para la gestión de estudiantes, utilizando una interfaz gráfica con Swing y almacenamiento en archivos CSV.

## Características Principales

### ✨ Funcionalidades
- **Crear**: Agregar nuevos estudiantes al sistema
- **Leer**: Visualizar todos los estudiantes en una tabla
- **Actualizar**: Modificar información de estudiantes existentes
- **Eliminar**: Remover estudiantes del sistema
- **Buscar**: Filtrar estudiantes por nombre, apellido, carrera o email
- **Estadísticas**: Mostrar información resumida del sistema

### 🏗️ Arquitectura
- **Patrón MVC**: Modelo-Vista-Controlador
- **Modelo**: Clase `Estudiante` con atributos y métodos
- **Vista**: Interfaz gráfica con Swing (`VentanaPrincipal`)
- **Controlador**: Lógica de negocio (`ControladorEstudiantes`)
- **Utilidades**: Manejo de archivos (`ArchivoEstudiantes`)

### 💾 Almacenamiento
- Archivos CSV para persistencia de datos
- No requiere base de datos
- Formato: `ID,Nombre,Apellido,Email,Edad,Carrera,Promedio`

## Estructura del Proyecto

```
actividad_6/
├── src/
│   ├── modelo/
│   │   └── Estudiante.java
│   ├── vista/
│   │   └── VentanaPrincipal.java
│   ├── controlador/
│   │   └── ControladorEstudiantes.java
│   ├── util/
│   │   └── ArchivoEstudiantes.java
│   └── principal/
│       └── Principal.java
├── docs/
│   ├── diagrama_clases.png
│   ├── casos_uso.md
│   └── interfaz_grafica.png
├── estudiantes.csv
└── README.md
```

## Requisitos del Sistema

### Software Necesario
- Java Development Kit (JDK) 8 o superior
- IDE compatible con Java (recomendado: IntelliJ IDEA, Eclipse, NetBeans)

### Dependencias
- Swing (incluido en Java SE)
- Java IO para manejo de archivos

## Instalación y Ejecución

### 1. Compilación
```bash
# Navegar al directorio del proyecto
cd actividad_6/src

# Compilar todas las clases
javac -d ../bin principal/*.java vista/*.java controlador/*.java modelo/*.java util/*.java

# O compilar individualmente
javac modelo/Estudiante.java
javac util/ArchivoEstudiantes.java
javac controlador/ControladorEstudiantes.java
javac vista/VentanaPrincipal.java
javac principal/Principal.java
```

### 2. Ejecución
```bash
# Ejecutar la aplicación
java -cp ../bin principal.Principal

# O desde el directorio src
java principal.Principal
```

### 3. Uso de IDE
1. Importar el proyecto en tu IDE favorito
2. Configurar el classpath
3. Ejecutar la clase `Principal.java`

## Manual de Usuario

### Interfaz Principal
La aplicación presenta una interfaz dividida en secciones:

1. **Formulario de Datos**: Campos para ingresar información del estudiante
2. **Tabla de Estudiantes**: Lista de todos los estudiantes registrados
3. **Botones de Acción**: Operaciones CRUD disponibles
4. **Panel de Búsqueda**: Filtros para encontrar estudiantes específicos

### Operaciones Disponibles

#### ➕ Agregar Estudiante
1. Completar todos los campos del formulario
2. Hacer clic en "Agregar"
3. El sistema validará los datos y mostrará confirmación

#### 📖 Consultar Estudiantes
- La tabla se actualiza automáticamente
- Hacer clic en "Mostrar Todos" para recargar

#### ✏️ Actualizar Estudiante
1. Seleccionar un estudiante de la tabla
2. Modificar los campos necesarios
3. Hacer clic en "Actualizar"

#### 🗑️ Eliminar Estudiante
1. Seleccionar un estudiante de la tabla
2. Hacer clic en "Eliminar"
3. Confirmar la eliminación

#### 🔍 Buscar Estudiantes
1. Seleccionar criterio de búsqueda
2. Ingresar valor a buscar
3. Hacer clic en "Buscar"

### Validaciones
- **ID**: Debe ser único
- **Edad**: Entre 16 y 100 años
- **Promedio**: Entre 0.0 y 5.0
- **Email**: Formato básico (contiene @ y .)
- **Campos obligatorios**: Todos los campos son requeridos

## Casos de Uso

### Caso de Uso 1: Registro de Nuevo Estudiante
**Actor**: Administrador del sistema
**Precondición**: Sistema iniciado
**Flujo Principal**:
1. Usuario completa formulario con datos del estudiante
2. Sistema valida información
3. Sistema guarda estudiante en archivo CSV
4. Sistema muestra confirmación

### Caso de Uso 2: Consulta de Estudiantes
**Actor**: Administrador del sistema
**Precondición**: Existen estudiantes registrados
**Flujo Principal**:
1. Usuario visualiza tabla de estudiantes
2. Sistema carga datos desde archivo CSV
3. Sistema muestra lista actualizada

### Caso de Uso 3: Búsqueda de Estudiante
**Actor**: Administrador del sistema
**Precondición**: Existen estudiantes registrados
**Flujo Principal**:
1. Usuario selecciona criterio de búsqueda
2. Usuario ingresa valor a buscar
3. Sistema filtra y muestra resultados

## Diagrama de Clases

### Clases Principales
- **Estudiante**: Entidad principal con atributos y métodos
- **ArchivoEstudiantes**: Singleton para manejo de archivos
- **ControladorEstudiantes**: Lógica de negocio y validaciones
- **VentanaPrincipal**: Interfaz gráfica de usuario
- **Principal**: Clase de inicio de la aplicación

### Relaciones
- **VentanaPrincipal** utiliza **ControladorEstudiantes**
- **ControladorEstudiantes** utiliza **ArchivoEstudiantes**
- **ArchivoEstudiantes** maneja **Estudiante**

## Archivos Generados

### estudiantes.csv
Archivo de datos con formato:
```csv
ID,Nombre,Apellido,Email,Edad,Carrera,Promedio
E001,Juan,Pérez,juan.perez@email.com,20,Ingeniería,4.5
E002,María,García,maria.garcia@email.com,19,Medicina,4.8
```
