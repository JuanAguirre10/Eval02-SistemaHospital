# Sistema de Gestión Hospitalaria - Backend

Sistema integral de gestión hospitalaria desarrollado con Spring Boot que permite administrar pacientes, médicos, citas, consultas, hospitalizaciones y facturación.

## 🚀 Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **MySQL 8.0**
- **Maven**

## 📋 Requisitos Previos

- JDK 17 o superior
- MySQL 8.0
- Maven 3.6+
- IDE (IntelliJ IDEA recomendado)

## 🗄️ Configuración de Base de Datos

### 1. Crear la Base de Datos

Ejecutar el siguiente script en MySQL:

```sql
CREATE DATABASE hospital_db;
USE hospital_db;
```

### 2. Ejecutar Script de Tablas

Ejecutar el script SQL ubicado en `database/schema.sql` que contiene las 17 tablas del sistema.

### 3. Configurar Credenciales

Editar el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/hospital_db
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=none
```

## 📦 Instalación

### 1. Ubicación del proyecto
```
C:\Users\Juan\IdeaProjects\SistemaHospital
```

### 2. Instalar dependencias
```bash
mvn clean install
```

### 3. Ejecutar la aplicación
```bash
mvn spring-boot:run
```

O desde IntelliJ IDEA:
- Abrir el proyecto
- Ejecutar `SistemaHospitalApplication.java`

La aplicación estará disponible en: `http://localhost:8080`

## 📁 Estructura del Proyecto

```
SistemaHospital/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── hospital/
│       │           ├── pacientes/
│       │           │   ├── model/
│       │           │   ├── dao/
│       │           │   ├── service/
│       │           │   └── controller/
│       │           ├── medicos/
│       │           ├── citas/
│       │           ├── consultas/
│       │           ├── hospitalizacion/
│       │           ├── facturacion/
│       │           └── seguridad/
│       └── resources/
│           └── application.properties
└── pom.xml
```

## 🔐 Autenticación

### Usuario por defecto:
- **Usuario:** juan
- **Contraseña:** 1234
- **Rol:** admin

### Endpoint de Login:
```
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
  "nombreUsuario": "juan",
  "contrasena": "1234"
}
```

## 📚 API Endpoints

### Pacientes
- `GET /api/pacientes` - Listar todos los pacientes
- `GET /api/pacientes/{id}` - Obtener paciente por ID
- `GET /api/pacientes/dni/{dni}` - Buscar por DNI
- `POST /api/pacientes` - Crear nuevo paciente
- `PUT /api/pacientes/{id}` - Actualizar paciente
- `DELETE /api/pacientes/{id}` - Eliminar paciente

### Médicos
- `GET /api/medicos` - Listar todos los médicos
- `GET /api/medicos/{id}` - Obtener médico por ID
- `GET /api/medicos/activos` - Listar médicos activos
- `POST /api/medicos` - Crear nuevo médico
- `PUT /api/medicos/{id}` - Actualizar médico
- `DELETE /api/medicos/{id}` - Eliminar médico

### Citas
- `GET /api/citas` - Listar todas las citas
- `GET /api/citas/{id}` - Obtener cita por ID
- `GET /api/citas/paciente/{idPaciente}` - Citas por paciente
- `GET /api/citas/medico/{idMedico}` - Citas por médico
- `GET /api/citas/estado/{estado}` - Citas por estado
- `POST /api/citas` - Crear nueva cita
- `PUT /api/citas/{id}` - Actualizar cita
- `PATCH /api/citas/{id}/estado?estado={estado}` - Cambiar estado
- `PATCH /api/citas/{id}/cancelar` - Cancelar cita

### Consultas
- `GET /api/consultas` - Listar todas las consultas
- `GET /api/consultas/paciente/{idPaciente}` - Consultas por paciente
- `POST /api/consultas` - Crear nueva consulta
- `PUT /api/consultas/{id}` - Actualizar consulta

### Diagnósticos
- `GET /api/diagnosticos/consulta/{idConsulta}` - Diagnósticos por consulta
- `POST /api/diagnosticos` - Crear diagnóstico

### Recetas Médicas
- `GET /api/recetas/consulta/{idConsulta}` - Recetas por consulta
- `POST /api/recetas` - Crear receta
- `GET /api/detalle-recetas/receta/{idReceta}` - Detalles de receta
- `POST /api/detalle-recetas` - Agregar detalle a receta

### Hospitalización
- `GET /api/hospitalizaciones` - Listar hospitalizaciones
- `GET /api/hospitalizaciones/estado/{estado}` - Por estado
- `GET /api/hospitalizaciones/paciente/{idPaciente}` - Por paciente
- `POST /api/hospitalizaciones` - Registrar hospitalización
- `PATCH /api/hospitalizaciones/{id}/alta?fechaAlta={fecha}` - Dar de alta

### Habitaciones
- `GET /api/habitaciones` - Listar habitaciones
- `GET /api/habitaciones/estado/{estado}` - Por estado
- `GET /api/habitaciones/disponibles/{tipo}` - Disponibles por tipo
- `POST /api/habitaciones` - Crear habitación

### Facturación
- `GET /api/facturas` - Listar facturas
- `GET /api/facturas/paciente/{idPaciente}` - Facturas por paciente
- `GET /api/facturas/estado/{estado}` - Por estado
- `POST /api/facturas` - Crear factura
- `PATCH /api/facturas/{id}/pagar` - Marcar como pagada
- `POST /api/detalle-facturas` - Agregar detalle a factura
- `GET /api/detalle-facturas/factura/{idFactura}` - Detalles de factura

## 🧪 Pruebas con Postman

### Importar Colección
1. Abrir Postman
2. Importar la colección desde `postman/Hospital-API.postman_collection.json`

### Variables de Entorno
- `base_url`: http://localhost:8080

## 📊 Base de Datos

### Tablas Principales (17 en total):
1. Paciente
2. HistoriaClinica
3. AntecedenteMedico
4. Medico
5. Especialidad
6. MedicoEspecialidad
7. Cita
8. Consulta
9. Diagnostico
10. RecetaMedica
11. DetalleReceta
12. Habitacion
13. Hospitalizacion
14. Factura
15. DetalleFactura
16. Usuario
17. Bitacora

## 🔧 Configuración Adicional

### Puerto del Servidor
Por defecto: `8080`

Para cambiar el puerto, editar `application.properties`:
```properties
server.port=8081
```

### Logs
Los logs de SQL están habilitados:
```properties
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 🐛 Solución de Problemas

### Error de conexión a MySQL
- Verificar que MySQL esté corriendo
- Confirmar puerto (3306 o 3307)
- Validar credenciales en `application.properties`

### Error de dependencias
```bash
mvn clean install -U
```

### Puerto 8080 ocupado
Cambiar puerto en `application.properties` o detener proceso:
```bash
netstat -ano | findstr :8080
taskkill /PID [PID] /F
```

