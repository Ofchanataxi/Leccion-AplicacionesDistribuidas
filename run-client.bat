@echo off
echo ==========================================
echo  Cliente de Pruebas - APIs Distribuidas
echo ==========================================
echo.
echo Asegurate de que los servidores esten corriendo:
echo - SOAP (Puerto 8081)
echo - gRPC (Puerto 50051)
echo - WebSocket (Puerto 8083)
echo.
pause
echo.
echo Compilando cliente...
cd src\main\java
javac -cp ".;..\..\..\cliente-rpc\target\classes;..\..\..\cliente-socket\target\classes;..\..\..\cliente-common\target\classes;..\..\..\lib\*" espe\edu\clientes\*.java 2>nul

if %ERRORLEVEL% NEQ 0 (
    echo Error al compilar. Usa tu IDE o asegurate de tener las dependencias.
    echo.
    echo Alternativa: Ejecuta ClienteApiTestMain desde tu IDE
    pause
    exit /b 1
)

echo Iniciando cliente...
java -cp ".;..\..\..\cliente-rpc\target\classes;..\..\..\cliente-socket\target\classes;..\..\..\cliente-common\target\classes;..\..\..\lib\*" espe.edu.clientes.ClienteApiTestMain

cd ..\..\..
pause

