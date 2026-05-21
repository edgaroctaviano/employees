# employees - Guía de Configuración y Ejecución

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de contar con las siguientes herramientas instaladas en tu entorno:

- Java 17
- Maven 3.8 o superior
- Un IDE compatible con proyectos Spring Boot:
  - IntelliJ IDEA
  - Eclipse
  - Spring Tool Suite (STS)
  - VS Code con extensiones Java

---

## Configuración del Proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/edgaroctaviano/employees.git
cd employees
```

---

### 2. Configurar Java 17 en el IDE

Asegúrate de que el proyecto esté configurado para utilizar **Java 17** como SDK principal.

---

### 3. Configurar Maven 3.8

Verifica que Maven esté correctamente instalado ejecutando:

```bash
mvn -version
```

La salida debe indicar una versión **3.8.x** o superior.

---

### 4. Descargar dependencias del proyecto

Desde la raíz del proyecto ejecuta el siguiente comando:

```bash
mvn clean install
```

Este comando realizará las siguientes acciones:

- Limpiar compilaciones anteriores
- Descargar todas las dependencias necesarias
- Compilar el proyecto
- Generar los artefactos requeridos

---

## Configuración de Lombok

El proyecto utiliza **Lombok** para reducir código boilerplate.

Es obligatorio instalar el plugin de Lombok en el IDE.

### Instalación

Descarga e instala Lombok desde el sitio oficial:

urlProject Lombokhttps://projectlombok.org/p2

### Configuración adicional

Después de instalar Lombok:

- Reinicia el IDE
- Habilita la opción de annotation processing

#### IntelliJ IDEA

Ruta:

```text
Settings > Build, Execution, Deployment > Compiler > Annotation Processors
```

Activar:

```text
Enable annotation processing
```

---

## Ejecución del Proyecto

El proyecto debe ejecutarse como una aplicación Spring Boot.

### Desde el IDE

Ubica la clase principal anotada con:

```java
@SpringBootApplication
```

Y ejecútala como:

```text
Spring Boot Application
```

---

## URL Local

Una vez iniciado correctamente, el servicio estará disponible en:

```text
http://localhost:8080
```

---

## Colección POSTMAN

En la raíz del proyecto se incluye una carpeta llamada:

```text
/docs
```

Dentro de esta carpeta se encuentra la colección de POSTMAN necesaria para probar los endpoints del sistema.

### Pasos para importar la colección

1. Abrir POSTMAN
2. Seleccionar "Import"
3. Elegir el archivo ubicado dentro de `/docs`
4. Ejecutar las peticiones disponibles

---

## Comandos Útiles

### Compilar el proyecto

```bash
mvn clean compile
```

### Ejecutar pruebas

```bash
mvn test
```

### Generar paquete

```bash
mvn clean package
```

---

## Tecnologías Utilizadas

- Java 17
- Spring Boot
- Maven 3.8
- Lombok
- POSTMAN

---

## Soporte

Si existen problemas relacionados con dependencias, compilación o Lombok:

- Verifica la versión de Java
- Verifica la versión de Maven
- Asegúrate de haber habilitado annotation processing
- Ejecuta nuevamente:

```bash
mvn clean install
```

