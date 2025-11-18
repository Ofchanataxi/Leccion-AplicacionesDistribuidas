# 🚀 CÓMO EJECUTAR EL PROYECTO - GUÍA VISUAL

## ⚡ OPCIÓN 1: Ejecución Automática (RECOMENDADA)

### Simplemente ejecuta este archivo:

```
EJECUTAR-TODO.bat
```

Este script hará **TODO** automáticamente:
1. ✅ Compilará el proyecto
2. ✅ Abrirá 3 ventanas con los servidores
3. ✅ Te dará opciones para probar las APIs

---

## 📋 OPCIÓN 2: Ejecución Manual Paso a Paso

### PASO 1️⃣: Compilar el Proyecto

Abre PowerShell o CMD en la carpeta raíz del proyecto:

```bash
mvn clean install
```

⏱️ **Tiempo estimado**: 2-3 minutos

✅ **Verás**: Mensajes de compilación y al final "BUILD SUCCESS"

---

### PASO 2️⃣: Iniciar los Servidores

Necesitas **3 terminales diferentes**. Abre 3 ventanas de PowerShell o CMD:

#### 🔷 Terminal 1 - Servidor SOAP

```bash
cd cliente-soap
mvn spring-boot:run
```

**Espera hasta ver**:
```
Started SoapApplication in X seconds
Setting the server's publish address to be http://localhost:8081/services/cliente
```

✅ **Servidor SOAP listo en puerto 8081**

---

#### 🔶 Terminal 2 - Servidor gRPC

```bash
cd cliente-rpc
mvn spring-boot:run
```

**Espera hasta ver**:
```
Started RpcApplication in X seconds
Servidor gRPC iniciado en el puerto 50051
```

✅ **Servidor gRPC listo en puerto 50051**

---

#### 🔵 Terminal 3 - Servidor WebSocket

```bash
cd cliente-socket
mvn spring-boot:run
```

**Espera hasta ver**:
```
Started WebSocketApplication in X seconds
```

✅ **Servidor WebSocket listo en puerto 8083**

---

### PASO 3️⃣: Probar las APIs

Ahora que los 3 servidores están corriendo, tienes varias opciones:

---

## 🌐 OPCIÓN A: Cliente Web (MÁS FÁCIL)

### Para WebSocket

1. Abre tu navegador
2. Ve a: **http://localhost:8083/index.html**
3. Haz clic en **"🔌 Conectar"**
4. ¡Listo! Usa la interfaz para probar operaciones

**Capturas de lo que verás:**
- ✅ Conexión WebSocket establecida
- 📋 Formularios para crear, obtener, listar, actualizar y eliminar clientes
- 📡 Panel de respuestas en tiempo real

---

## 💻 OPCIÓN B: Cliente Java Interactivo

### Desde tu IDE (IntelliJ, Eclipse, VS Code)

1. Abre el proyecto en tu IDE
2. Navega a: `src/main/java/espe/edu/clientes/ClienteApiTestMain.java`
3. **Ejecuta** el archivo (Run o F5)
4. Verás un menú en la consola:

```
==============================================
   CLIENTE PARA CONSUMIR APIS DISTRIBUIDAS
==============================================

--- SELECCIONA LA API A PROBAR ---
1. API SOAP
2. API gRPC
3. API WebSocket
0. Salir
Opción: 
```

5. Selecciona la opción que desees probar

---

## 🛠️ OPCIÓN C: Herramientas Externas

### Para SOAP - Usar SoapUI o Postman

1. Abre SoapUI o Postman
2. Crea una nueva petición SOAP
3. Usa el WSDL: **http://localhost:8081/services/cliente?wsdl**
4. Ejemplo de petición:

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

---

### Para gRPC - Usar BloomRPC o Postman

1. Descarga BloomRPC o usa Postman con soporte gRPC
2. Importa el archivo proto: `cliente-rpc/src/main/proto/cliente.proto`
3. Configura el servidor: **localhost:50051**
4. Prueba los métodos disponibles

---

### Para WebSocket - Cliente Web Incluido

Ya lo tienes en: **http://localhost:8083/index.html**

---

## 🎯 Resumen Rápido de URLs

| API | URL para Probar |
|-----|----------------|
| **SOAP** | http://localhost:8081/services/cliente?wsdl |
| **gRPC** | localhost:50051 (necesitas cliente gRPC) |
| **WebSocket** | http://localhost:8083/index.html |

---

## ❓ Solución de Problemas

### ❌ Error: "Port already in use"

**Problema**: Un puerto está siendo usado por otra aplicación

**Solución**:
```bash
# Ver qué proceso usa el puerto (ejemplo puerto 8081)
netstat -ano | findstr :8081

# Matar el proceso (reemplaza PID con el número que aparece)
taskkill /PID <numero_pid> /F
```

---

### ❌ Error: "BUILD FAILURE" al compilar

**Problema**: Error de compilación

**Soluciones**:
1. Verifica que tengas Java 17:
   ```bash
   java -version
   ```
   Debe decir: `java version "17.x.x"`

2. Verifica Maven:
   ```bash
   mvn -version
   ```

3. Limpia el cache de Maven:
   ```bash
   mvn clean
   ```

---

### ❌ Error: "Cannot connect" en los clientes

**Problema**: Los servidores no están corriendo

**Solución**:
1. Verifica que las 3 terminales con los servidores estén activas
2. Espera 1-2 minutos después de iniciar cada servidor
3. Busca los mensajes de "Started" en cada terminal

---

### ❌ No aparece nada en el navegador

**Problema**: Servidor WebSocket no está corriendo o puerto incorrecto

**Solución**:
1. Verifica que el servidor WebSocket esté corriendo (Terminal 3)
2. Asegúrate de usar: http://localhost:8083/index.html (no https)
3. Revisa la consola del navegador (F12) para ver errores

---

## 📊 Verificación de que Todo Funciona

### ✅ Checklist

Antes de probar, verifica que todo esté listo:

- [ ] ✅ Compilé con `mvn clean install` sin errores
- [ ] ✅ Terminal 1 muestra "Started SoapApplication"
- [ ] ✅ Terminal 2 muestra "Servidor gRPC iniciado en el puerto 50051"
- [ ] ✅ Terminal 3 muestra "Started WebSocketApplication"
- [ ] ✅ Puedo abrir http://localhost:8083/index.html en el navegador
- [ ] ✅ El cliente web se conecta correctamente

Si todos los puntos están marcados, ¡todo funciona! 🎉

---

## 🎬 VIDEO TUTORIAL (Paso a Paso)

### Opción Más Fácil - Script Automático:

1. Haz doble clic en: **EJECUTAR-TODO.bat**
2. Sigue las instrucciones en pantalla
3. ¡Listo!

### Opción Manual:

**Minuto 0:00 - 2:00**: Compilar
```bash
mvn clean install
```

**Minuto 2:00 - 4:00**: Iniciar Servidor 1 (SOAP)
```bash
cd cliente-soap
mvn spring-boot:run
```
*Esperar "Started SoapApplication"*

**Minuto 4:00 - 6:00**: Iniciar Servidor 2 (gRPC)
```bash
cd cliente-rpc
mvn spring-boot:run
```
*Esperar "Servidor gRPC iniciado"*

**Minuto 6:00 - 8:00**: Iniciar Servidor 3 (WebSocket)
```bash
cd cliente-socket
mvn spring-boot:run
```
*Esperar "Started WebSocketApplication"*

**Minuto 8:00+**: Probar las APIs
- Abrir http://localhost:8083/index.html
- Conectar
- Crear un cliente de prueba

---

## 💡 Consejos Útiles

1. **Deja las 3 terminales abiertas** mientras pruebas las APIs
2. **No cierres las ventanas** hasta que termines de probar
3. **El cliente web es la forma más fácil** de empezar
4. **Los logs en las terminales** muestran todas las operaciones
5. **Consulta EXAMPLES.md** para ejemplos detallados de cada API

---

## 🎯 ¿Qué Hacer Ahora?

### 1️⃣ Primera vez usando el proyecto:
   - Usa **EJECUTAR-TODO.bat** para una experiencia guiada

### 2️⃣ Ya conoces el proyecto:
   - Inicia los 3 servidores manualmente
   - Usa el cliente que prefieras

### 3️⃣ Quieres ver ejemplos:
   - Lee **EXAMPLES.md** para código de ejemplo
   - Consulta **README.md** para documentación completa

---

## 📚 Documentación Adicional

- 📖 **README.md** - Documentación completa del proyecto
- ⚡ **QUICKSTART.md** - Guía rápida resumida
- 💻 **EXAMPLES.md** - Ejemplos de código para cada API
- ✅ **PROJECT_COMPLETE.md** - Resumen de implementación

---

¡Disfruta probando las 3 APIs distribuidas! 🚀

