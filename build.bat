@echo off
echo ==========================================
echo  Compilando Proyecto Completo
echo ==========================================
call mvn clean install
echo.
echo ==========================================
echo  Compilacion completada!
echo ==========================================
echo.
echo Para iniciar los servidores usa:
echo - start-soap.bat (Puerto 8081)
echo - start-grpc.bat (Puerto 50051)
echo - start-websocket.bat (Puerto 8083)
echo.
pause

