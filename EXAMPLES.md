# 📘 Ejemplos de Uso de las APIs

## 1. API SOAP (Puerto 8081)

### Endpoint
- **URL**: http://localhost:8081/services/cliente
- **WSDL**: http://localhost:8081/services/cliente?wsdl

### Ejemplo 1: Listar Clientes

```xml
POST http://localhost:8081/services/cliente
Content-Type: text/xml; charset=utf-8

<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.soap.edu.espe/">
  <soapenv:Header/>
  <soapenv:Body>
    <ser:listarClientes/>
  </soapenv:Body>
</soapenv:Envelope>
```

### Ejemplo 2: Crear Cliente

```xml
POST http://localhost:8081/services/cliente
Content-Type: text/xml; charset=utf-8

<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.soap.edu.espe/">
  <soapenv:Header/>
  <soapenv:Body>
    <ser:crearCliente>
      <arg0>
        <cedula>1234567890</cedula>
        <nombre>Juan Pérez</nombre>
        <telefono>0987654321</telefono>
        <email>juan@email.com</email>
        <direccion>Av. Principal 123</direccion>
      </arg0>
    </ser:crearCliente>
  </soapenv:Body>
</soapenv:Envelope>
```

### Ejemplo 3: Obtener Cliente por ID

```xml
POST http://localhost:8081/services/cliente
Content-Type: text/xml; charset=utf-8

<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.soap.edu.espe/">
  <soapenv:Header/>
  <soapenv:Body>
    <ser:obtenerClientePorId>
      <arg0>1</arg0>
    </ser:obtenerClientePorId>
  </soapenv:Body>
</soapenv:Envelope>
```

### Ejemplo 4: Actualizar Cliente

```xml
POST http://localhost:8081/services/cliente
Content-Type: text/xml; charset=utf-8

<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.soap.edu.espe/">
  <soapenv:Header/>
  <soapenv:Body>
    <ser:actualizarCliente>
      <arg0>
        <idCliente>1</idCliente>
        <cedula>1234567890</cedula>
        <nombre>Juan Pérez Actualizado</nombre>
        <telefono>0999999999</telefono>
        <email>juan.nuevo@email.com</email>
        <direccion>Av. Secundaria 456</direccion>
      </arg0>
    </ser:actualizarCliente>
  </soapenv:Body>
</soapenv:Envelope>
```

### Ejemplo 5: Eliminar Cliente

```xml
POST http://localhost:8081/services/cliente
Content-Type: text/xml; charset=utf-8

<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.soap.edu.espe/">
  <soapenv:Header/>
  <soapenv:Body>
    <ser:eliminarCliente>
      <arg0>1</arg0>
    </ser:eliminarCliente>
  </soapenv:Body>
</soapenv:Envelope>
```

---

## 2. API gRPC (Puerto 50051)

### Cliente Java

```java
// Conectar
ManagedChannel channel = ManagedChannelBuilder
    .forAddress("localhost", 50051)
    .usePlaintext()
    .build();

ClienteServiceGrpc.ClienteServiceBlockingStub stub = 
    ClienteServiceGrpc.newBlockingStub(channel);

// Crear Cliente
ClienteRequest request = ClienteRequest.newBuilder()
    .setCedula("1234567890")
    .setNombre("Juan Pérez")
    .setTelefono("0987654321")
    .setEmail("juan@email.com")
    .setDireccion("Av. Principal 123")
    .build();

ClienteResponse response = stub.crearCliente(request);
System.out.println("Cliente creado con ID: " + response.getIdCliente());

// Obtener Cliente
ClienteIdRequest idRequest = ClienteIdRequest.newBuilder()
    .setIdCliente(1)
    .build();

ClienteResponse cliente = stub.obtenerCliente(idRequest);
System.out.println("Nombre: " + cliente.getNombre());

// Listar Clientes
Empty empty = Empty.newBuilder().build();
ClienteListResponse lista = stub.listarClientes(empty);
for (ClienteResponse c : lista.getClientesList()) {
    System.out.println("- " + c.getNombre());
}

// Actualizar Cliente
ClienteRequest updateRequest = ClienteRequest.newBuilder()
    .setIdCliente(1)
    .setCedula("1234567890")
    .setNombre("Juan Pérez Actualizado")
    .setTelefono("0999999999")
    .setEmail("juan.nuevo@email.com")
    .setDireccion("Av. Secundaria 456")
    .build();

BoolResponse updateResponse = stub.actualizarCliente(updateRequest);
System.out.println("Actualizado: " + updateResponse.getSuccess());

// Eliminar Cliente
ClienteIdRequest deleteRequest = ClienteIdRequest.newBuilder()
    .setIdCliente(1)
    .build();

BoolResponse deleteResponse = stub.eliminarCliente(deleteRequest);
System.out.println("Eliminado: " + deleteResponse.getSuccess());

// Cerrar conexión
channel.shutdown();
```

### Usando BloomRPC

1. Abre BloomRPC
2. Importa el archivo: `cliente-rpc/src/main/proto/cliente.proto`
3. Configura el servidor: `localhost:50051`
4. Selecciona el método y envía el request JSON:

**Crear Cliente:**
```json
{
  "cedula": "1234567890",
  "nombre": "Juan Pérez",
  "telefono": "0987654321",
  "email": "juan@email.com",
  "direccion": "Av. Principal 123"
}
```

---

## 3. API WebSocket (Puerto 8083)

### Cliente Web (Navegador)

1. Abre: http://localhost:8083/index.html
2. Haz clic en "Conectar"
3. Usa la interfaz gráfica para realizar operaciones

### Cliente JavaScript

```javascript
// Conectar usando SockJS y STOMP
const socket = new SockJS('http://localhost:8083/ws-clientes');
const stompClient = Stomp.over(socket);

stompClient.connect({}, function(frame) {
    console.log('Conectado: ' + frame);
    
    // Suscribirse a las respuestas
    stompClient.subscribe('/topic/cliente', function(response) {
        const data = JSON.parse(response.body);
        console.log('Respuesta:', data);
    });
    
    // Crear Cliente
    const createMessage = {
        action: 'CREATE',
        cliente: {
            cedula: '1234567890',
            nombre: 'Juan Pérez',
            telefono: '0987654321',
            email: 'juan@email.com',
            direccion: 'Av. Principal 123'
        }
    };
    stompClient.send("/app/cliente", {}, JSON.stringify(createMessage));
    
    // Obtener Cliente
    const readMessage = {
        action: 'READ',
        cliente: {
            idCliente: 1
        }
    };
    stompClient.send("/app/cliente", {}, JSON.stringify(readMessage));
    
    // Listar Clientes
    const listMessage = {
        action: 'LIST',
        cliente: {}
    };
    stompClient.send("/app/cliente", {}, JSON.stringify(listMessage));
    
    // Actualizar Cliente
    const updateMessage = {
        action: 'UPDATE',
        cliente: {
            idCliente: 1,
            cedula: '1234567890',
            nombre: 'Juan Pérez Actualizado',
            telefono: '0999999999',
            email: 'juan.nuevo@email.com',
            direccion: 'Av. Secundaria 456'
        }
    };
    stompClient.send("/app/cliente", {}, JSON.stringify(updateMessage));
    
    // Eliminar Cliente
    const deleteMessage = {
        action: 'DELETE',
        cliente: {
            idCliente: 1
        }
    };
    stompClient.send("/app/cliente", {}, JSON.stringify(deleteMessage));
});
```

### Cliente Java WebSocket

```java
StandardWebSocketClient webSocketClient = new StandardWebSocketClient();
SockJsClient sockJsClient = new SockJsClient(
    Arrays.asList(new WebSocketTransport(webSocketClient)));

WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
stompClient.setMessageConverter(new MappingJackson2MessageConverter());

StompSession session = stompClient.connectAsync(
    "http://localhost:8083/ws-clientes",
    new StompSessionHandlerAdapter() {
        @Override
        public void afterConnected(StompSession session, StompHeaders headers) {
            session.subscribe("/topic/cliente", new StompFrameHandler() {
                @Override
                public Type getPayloadType(StompHeaders headers) {
                    return String.class;
                }

                @Override
                public void handleFrame(StompHeaders headers, Object payload) {
                    System.out.println("Respuesta: " + payload);
                }
            });
        }
    }
).get(5, TimeUnit.SECONDS);

// Enviar mensaje
String message = "{\"action\":\"LIST\",\"cliente\":{}}";
session.send("/app/cliente", message);
```

---

## 📊 Comparación de las APIs

| Característica | SOAP | gRPC | WebSocket |
|----------------|------|------|-----------|
| **Protocolo** | HTTP/XML | HTTP/2 + Protobuf | WebSocket |
| **Puerto** | 8081 | 50051 | 8083 |
| **Formato** | XML | Binary (Protobuf) | JSON |
| **Bidireccional** | ❌ No | ✅ Sí (streaming) | ✅ Sí |
| **Tiempo Real** | ❌ No | ⚠️ Parcial | ✅ Sí |
| **Complejidad** | Alta | Media | Baja |
| **Rendimiento** | Bajo | Alto | Medio-Alto |
| **Cliente Web** | ⚠️ Complejo | ❌ No nativo | ✅ Nativo |

## 🎯 Casos de Uso Recomendados

### SOAP
- Sistemas legacy
- Integración con servicios empresariales
- Cuando se requiere contrato estricto (WSDL)
- Transacciones complejas

### gRPC
- Microservicios
- Comunicación entre servicios internos
- Aplicaciones de alto rendimiento
- Cuando el tamaño de los mensajes importa

### WebSocket
- Aplicaciones en tiempo real
- Chat, notificaciones push
- Dashboards en vivo
- Juegos multiplayer
- Cuando se necesita comunicación bidireccional constante

---

## 🛠️ Herramientas Recomendadas

### Para SOAP:
- **SoapUI** - Cliente y testing completo
- **Postman** - Pruebas rápidas
- **Apache CXF** - Desarrollo Java

### Para gRPC:
- **BloomRPC** - Cliente GUI
- **Postman** (versión reciente) - Con soporte gRPC
- **grpcurl** - Cliente CLI

### Para WebSocket:
- **Cliente Web incluido** - http://localhost:8083/index.html
- **Postman** - Testing WebSocket
- **Chrome DevTools** - Debug en navegador

---

¡Usa estos ejemplos para probar las 3 APIs! 🚀

