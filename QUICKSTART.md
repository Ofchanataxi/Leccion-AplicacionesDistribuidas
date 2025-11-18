# 🚀 Guía Rápida de Inicio

## Paso 1: Compilar el Proyecto

Abre una terminal en la raíz del proyecto y ejecuta:

```bash
mvn clean install
```

O simplemente ejecuta el archivo:
```bash
build.bat
```

## Paso 2: Iniciar los Servidores

### Opción A: Usando los scripts .bat

Abre **tres terminales diferentes** y ejecuta en cada una:

**Terminal 1 - SOAP:**
```bash
start-soap.bat
```

**Terminal 2 - gRPC:**
```bash
start-grpc.bat
```

**Terminal 3 - WebSocket:**
```bash
start-websocket.bat
```

### Opción B: Usando Maven directamente

**Terminal 1 - SOAP:**
```bash
cd cliente-soap
mvn spring-boot:run
```

**Terminal 2 - gRPC:**
```bash
cd cliente-rpc
mvn spring-boot:run
```

**Terminal 3 - WebSocket:**
```bash
cd cliente-socket
mvn spring-boot:run
```

## Paso 3: Verificar que los Servidores estén Corriendo

Deberías ver mensajes similares a estos en cada terminal:

### SOAP (Terminal 1):
```
Started SoapApplication in X seconds
Setting the server's publish address to be http://localhost:8081/services/cliente
```

### gRPC (Terminal 2):
```
Started RpcApplication in X seconds
Servidor gRPC iniciado en el puerto 50051
```

### WebSocket (Terminal 3):
```
Started WebSocketApplication in X seconds
```

## Paso 4: Probar las APIs

### 🌐 Opción 1: Cliente Web (WebSocket)

1. Abre tu navegador en: **http://localhost:8083/index.html**
2. Haz clic en "🔌 Conectar"
3. Prueba las operaciones desde la interfaz

### 💻 Opción 2: Cliente Java Interactivo

Desde la raíz del proyecto:

```bash
cd src\main\java
javac -cp .;..\..\..\..\cliente-rpc\target\classes;..\..\..\..\cliente-common\target\classes espe\edu\clientes\*.java
java -cp .;..\..\..\..\cliente-rpc\target\classes;..\..\..\..\cliente-common\target\classes espe.edu.clientes.ClienteApiTestMain
```

O usa tu IDE favorito para ejecutar `ClienteApiTestMain.java`

### 🔧 Opción 3: Herramientas Externas

**Para SOAP:**
- SoapUI: Importa el WSDL desde http://localhost:8081/services/cliente?wsdl
- Postman: Crea una petición SOAP

**Para gRPC:**
- BloomRPC o Postman con soporte gRPC
- Archivo proto: `cliente-rpc/src/main/proto/cliente.proto`

**Para WebSocket:**
- Cliente web incluido: http://localhost:8083/index.html

## 🎯 Endpoints Rápidos

| API | URL de Prueba |
|-----|---------------|
| SOAP | http://localhost:8081/services/cliente?wsdl |
| gRPC | localhost:50051 |
| WebSocket | http://localhost:8083/index.html |

## ❓ Problemas Comunes

### "Port already in use"
- Cierra cualquier proceso usando los puertos 8081, 8082, 8083 o 50051
- En Windows: `netstat -ano | findstr :<puerto>` y luego `taskkill /PID <pid> /F`

### "Class not found"
- Asegúrate de haber ejecutado `mvn clean install` primero
- Verifica que estés en el directorio correcto

### Error de conexión en clientes
- Verifica que los servidores estén corriendo
- Espera unos segundos después de iniciar los servidores

## 📝 Notas

- Los DAO actuales son simulaciones (no hay BD real)
- Para agregar BD real, modifica los archivos en `cliente-common/src/main/java/espe/edu/common/dao/`
- Todos los servidores deben estar corriendo antes de usar los clientes

## ✅ Lista de Verificación

- [ ] Compilé el proyecto con `mvn clean install`
- [ ] Inicié los 3 servidores (SOAP, gRPC, WebSocket)
- [ ] Verifiqué que no hay errores en las consolas
- [ ] Probé al menos una operación en cada API

¡Listo! 🎉 Ahora puedes usar las 3 APIs distribuidas.

