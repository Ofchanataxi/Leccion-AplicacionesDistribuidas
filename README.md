# Sistema de Clientes Distribuidos

Este proyecto implementa un sistema de gestión de clientes utilizando tres diferentes tecnologías de APIs distribuidas:
- **SOAP** (Puerto 8081)
- **gRPC** (Puerto 50051)
- **WebSocket** (Puerto 8083)

## 📋 Estructura del Proyecto

```
clientes-distribuidos/
├── cliente-common/          # Módulo compartido (modelos y DAO)
├── cliente-soap/            # API SOAP
├── cliente-rpc/             # API gRPC
├── cliente-socket/          # API WebSocket
└── src/main/java/espe/edu/clientes/  # Clientes de consumo
```

## 🚀 Compilar el Proyecto

Desde la raíz del proyecto, ejecuta:

```bash
mvn clean install
```

## ▶️ Iniciar los Servidores

### 1. Servidor SOAP (Puerto 8081)

```bash
cd cliente-soap
mvn spring-boot:run
```

**Endpoints:**
- Servicio: http://localhost:8081/services/cliente
- WSDL: http://localhost:8081/services/cliente?wsdl

### 2. Servidor gRPC (Puerto 50051)

```bash
cd cliente-rpc
mvn spring-boot:run
```

**Nota:** El servidor gRPC se inicia en el puerto 50051, mientras que Spring Boot corre en el puerto 8082.

### 3. Servidor WebSocket (Puerto 8083)

```bash
cd cliente-socket
mvn spring-boot:run
```

**Endpoints:**
- WebSocket: ws://localhost:8083/ws-clientes
- Cliente Web: http://localhost:8083/index.html

## 🧪 Probar las APIs

### Opción 1: Cliente Java Interactivo

Ejecuta el cliente Java desde la raíz del proyecto:

```bash
java -cp target/classes espe.edu.clientes.ClienteApiTestMain
```

Este cliente te permitirá:
- Seleccionar la API que deseas probar (SOAP, gRPC o WebSocket)
- Realizar operaciones CRUD interactivamente
- Ver las respuestas en tiempo real

### Opción 2: Cliente Web (Solo WebSocket)

1. Inicia el servidor WebSocket
2. Abre tu navegador en: http://localhost:8083/index.html
3. Haz clic en "Conectar"
4. Realiza operaciones desde la interfaz web

### Opción 3: Herramientas Externas

#### Para SOAP:
- **SoapUI**: Importa el WSDL desde http://localhost:8081/services/cliente?wsdl
- **Postman**: Configura una petición SOAP con el XML correspondiente

Ejemplo de Request SOAP:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.soap.edu.espe/">
  <soapenv:Header/>
  <soapenv:Body>
    <ser:listarClientes/>
  </soapenv:Body>
</soapenv:Envelope>
```

#### Para gRPC:
- **BloomRPC** o **Postman** (con soporte gRPC)
- Archivo proto: `cliente-rpc/src/main/proto/cliente.proto`

#### Para WebSocket:
- Cliente web incluido en el proyecto
- Cualquier cliente WebSocket que soporte STOMP

## 📚 Operaciones Disponibles

Todas las APIs implementan las siguientes operaciones:

1. **Crear Cliente**: Registra un nuevo cliente
2. **Obtener Cliente**: Busca un cliente por ID
3. **Listar Clientes**: Obtiene todos los clientes
4. **Actualizar Cliente**: Modifica los datos de un cliente
5. **Eliminar Cliente**: Elimina un cliente por ID

## 🔧 Modelo de Datos

```java
Cliente {
    int idCliente;
    String cedula;
    String nombre;
    String telefono;
    String email;
    String direccion;
    Date fechaRegistro;
}
```

## 📝 Notas Importantes

1. Asegúrate de que los puertos 8081, 8082, 8083 y 50051 estén disponibles
2. Ejecuta primero `mvn clean install` desde la raíz para compilar el módulo común
3. Los servidores deben estar corriendo antes de ejecutar los clientes
4. El módulo `cliente-common` contiene simulaciones de DAO (no hay base de datos real)

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.3.4**
- **Apache CXF 4.0.4** (SOAP)
- **gRPC 1.58.0**
- **Protocol Buffers 3.24.0**
- **Spring WebSocket** (STOMP)
- **Maven**

## 📞 Endpoints Resumen

| API | Puerto | Endpoint |
|-----|--------|----------|
| SOAP | 8081 | http://localhost:8081/services/cliente |
| gRPC | 50051 | localhost:50051 |
| WebSocket | 8083 | ws://localhost:8083/ws-clientes |

## 🐛 Solución de Problemas

### Error: "Could not find or load main class"
- Asegúrate de haber ejecutado `mvn clean install` primero

### Error: "Address already in use"
- Verifica que los puertos no estén siendo usados por otra aplicación
- Cierra cualquier instancia previa de los servidores

### Error de conexión en el cliente
- Verifica que el servidor correspondiente esté corriendo
- Confirma que el firewall no esté bloqueando los puertos

## 👨‍💻 Autor

Desarrollado para la materia de Aplicaciones Distribuidas - ESPE

## 📄 Licencia

Este proyecto es de uso académico.

