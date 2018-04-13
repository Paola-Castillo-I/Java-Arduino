## **JAVA-ARDUINO**

Instituto Tecnológico de León<br>
Ingenieria en Sistemas Computacionales<br>
Sistemas Programables<br>
Trabajo: Envio de Temperatura, fecha, hora y mensajes a LCD por medio de conexion entre Java y Arduino<br>
Profesor: Ing. Levy Rojas Carlos Rafael<br>
Presentado por: Alejandro Macario Gómez Ramírez<br>
HORARIO: Martes y jueves de 8:45 AM a 10:30 AM<br>
Enero - Junio<br>

Envio de mensajes, hora, fecha y temperatura a LCD por medio de conexion entre Arduino y Java.
***
## **DESCRIPCION**

Programa que su funcion es enviar la temperatura, la hora y diversos mensajes introducidos
por el usuario, mendiante la conexion entre Java y Arduino la cual tendra una interfaz grafica
realizada en java donde se controlaran todas las respectivas funciones.

El funcionamiento del programa es el siguiente:
En el protoboard se encuentran dos botones, que desempeñaran la funcion de selectores de
mensajes; es decir, como si se tratara de los botones de un teclado (Arriba y Abajo).
Lo cual nos permitira ver todos los mensajes que el usuario ha introducido con anterioridad.
Cada vez que el usuario presione los botones, se escuchara un click proveniente del zumbador.

En la interfaz de Java se encuentran los botones que realizan su funcion respectivamente:<br>
  Guardar---Guarda la cadena de caracteres que se ha introducido.<br>
  Mostrar---Muestra la cadena de caracteres que se ha introducido.<br>
  Hora -----Muestra la hotra del sistema.<br>
  Fecha ----Muestra la fecha del sistema<br>

## **REQUISITOS PARA LA INSTALACION DEL SOFTWARE NECESARIO PARA LA REALIZACION DE EL PROYECTO**
* Se requiere del uso de una libreria especial para lograr la conexión serial entre Arduino y Java. 
  La libreria posee por Nombre "PanamaHitek_Arduino-3.0.0.jar. 
* Para instalarlo, solamente se descarga la libreria y se importa al proyecto por medio del IDE que sea
  de su preferencia.

## **REQUISITOS PARA LA UTILIZACION DEL PROGRAMA**
* Se requiere ejecutar primero el codigo Arduino, para que este se cargue en la placa Arduino y pueda ejecutar
  todas las funciones basadas en hardware.
* Despues de ello, ejecutamos el codigo Java y nos mostrara la interfaz correspondiente con los botones antes
  mencionados. 
* Solo se permite la introducción de 6 mensajes. En caso de introducir mas, se mandara un mensaje de error.
* Tambien se requiere que el circuito sea ensamblado de manera correcta y en base al diagrama que ha sido
  anexado.
* La codificación del programa ha sido elaborado en un sistema operativo LINUX/UBUNTU.

## **MATERIAL**
1. 1 Placa Arduino UNO
2. 1 Potenciomento de 10K
3. 3 Resistencias de 330 Ohms
4. 1 Pantalla LCD de 16x2
5. 25 Conectores de 10 mm
6. 1 Buzzer / Zumbador
7. 2 Push-Buttons

## **DIAGRAMA ELECTRICO**

![imagen](https://github.com/macario96/Java-Arduino/blob/master/Imagenes/Diagrama.png "Diagrama Electrico")
***

**CONTACTO**<br>
Cualquier duda o aclaracion, puede enviar mensaje al siguiente correo electronico:<br>
Correo electronico - mac@fatrian.com<br>
Elaborado por: Alejandro Macario Gómez Ramírez<br>
