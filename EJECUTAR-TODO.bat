@echo off
echo ========================================================
echo     GUIA COMPLETA DE EJECUCION - PASO A PASO
echo ========================================================
echo.
echo Este script te guiara para ejecutar el proyecto completo
echo.
pause

echo.
echo ========================================================
echo PASO 1: COMPILANDO EL PROYECTO
echo ========================================================
echo.
echo Ejecutando: mvn clean install
echo Esto puede tomar unos minutos...
echo.

call mvn clean install

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ========================================================
    echo ERROR: La compilacion fallo
    echo ========================================================
    echo.
    echo Verifica que:
    echo 1. Tengas Java 17 instalado: java -version
    echo 2. Maven este configurado correctamente: mvn -version
    echo.
    pause
    exit /b 1
)

echo.
echo ========================================================
echo COMPILACION EXITOSA!
echo ========================================================
echo.
pause

echo.
echo ========================================================
echo PASO 2: INICIAR LOS SERVIDORES
echo ========================================================
echo.
echo Ahora vamos a iniciar los 3 servidores en ventanas separadas
echo.
echo Presiona cualquier tecla para abrir:
echo   - Servidor SOAP (Puerto 8081)
echo   - Servidor gRPC (Puerto 50051)
echo   - Servidor WebSocket (Puerto 8083)
echo.
pause

echo.
echo Abriendo servidores...
echo.

start "Servidor SOAP - Puerto 8081" cmd /k "cd cliente-soap && echo Iniciando Servidor SOAP... && mvn spring-boot:run"
timeout /t 2 /nobreak >nul

start "Servidor gRPC - Puerto 50051" cmd /k "cd cliente-rpc && echo Iniciando Servidor gRPC... && mvn spring-boot:run"
timeout /t 2 /nobreak >nul

start "Servidor WebSocket - Puerto 8083" cmd /k "cd cliente-socket && echo Iniciando Servidor WebSocket... && mvn spring-boot:run"

echo.
echo ========================================================
echo SERVIDORES INICIANDOSE...
echo ========================================================
echo.
echo Se abrieron 3 ventanas nuevas. Espera a que aparezca:
echo.
echo   [SOAP]      "Started SoapApplication"
echo   [gRPC]      "Servidor gRPC iniciado en el puerto 50051"
echo   [WebSocket] "Started WebSocketApplication"
echo.
echo Esto puede tomar 1-2 minutos...
echo.
pause

echo.
echo ========================================================
echo PASO 3: PROBAR LAS APIs
echo ========================================================
echo.
echo Ahora puedes probar las APIs de 3 formas:
echo.
echo OPCION 1: Cliente Web (WebSocket)
echo   Abre tu navegador en: http://localhost:8083/index.html
echo.
echo OPCION 2: Cliente Java Interactivo
echo   Ejecuta desde tu IDE: ClienteApiTestMain.java
echo   (Ubicacion: src/main/java/espe/edu/clientes/)
echo.
echo OPCION 3: Herramientas Externas
echo   - SOAP: http://localhost:8081/services/cliente?wsdl
echo   - gRPC: localhost:50051 (usa BloomRPC o Postman)
echo   - WebSocket: http://localhost:8083/index.html
echo.
echo ========================================================
echo.
echo Deseas abrir el cliente web de WebSocket? (S/N)
set /p opcion="> "

if /i "%opcion%"=="S" (
    echo.
    echo Abriendo navegador...
    start http://localhost:8083/index.html
)

echo.
echo ========================================================
echo PROYECTO EN EJECUCION!
echo ========================================================
echo.
echo Los servidores estan corriendo. Para detenerlos:
echo   - Cierra las ventanas de los servidores, o
echo   - Presiona Ctrl+C en cada ventana
echo.
echo Consulta README.md para mas informacion
echo.
echo ========================================================
pause

