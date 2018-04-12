/**************************************************************************************
  Envio de mensajes, hora, fecha y temperatura a LCD por medio de conexion entre Arduino y Java
 **************************************************************************************
  Programa que su funcion es enviar la temperatura, la hora y diversos mensajes introducidos
  por el usuario, mendiante la conexion entre Java y Arduino la cual tendra una interfaz grafica
  realizada en java donde se controlaran todas las respectivas funciones.
  -----------------------------------------------------------------------------------------------
  El funcionamiento del programa es el siguiente:
  En el protoboard se encuentran dos botones, que desempeñaran la funcion de selectores de
  mensajes; es decir, como si se tratara de los botones de un teclado (Arriba y Abajo).
  Lo cual nos permitira ver todos los mensajes que el usuario ha introducido con anterioridad.
  Cada vez que el usuario presiones los botones, se escuchara un click proveniente del zumbador.
  -----------------------------------------------------------------------------------------------
  En la interfaz de Java se encuentran los botones que realizan su funcion respectivamente:
  Guardar---Guarda la cadena de caracteres que se ha introducido.
  Mostrar---Muestra la cadena de caracteres que se ha introducido.
  Hora -----Muestra la hotra del sistema.
  Fecha ----Muestra la fecha del sistema
  ----------------------------------------------------------------------------------------
  Instituto Tecnológico de León
  Ingenieria en Sistemas Computacionales
  Sistemas Programables
  Trabajo: Envio de Mensajes, hora y temperatura a LCD por Medio
         de Conexion Entre Arduino y Java.
  Profesor: Ing. Levy Rojas Carlos Rafael
  Presentado por: Alejandro Macario Gómez Ramírez
  HORARIO: Martes y jueves de 8:45 AM a 10:30 AM
  Enero - Junio
  ---------------------------------------------------------------------------------------
*/
//Inicio de programa

//Incluimos la libreria LiquidCrystal que nos habilita el uso de la pantalla LCD
#include <LiquidCrystal.h>

//Declaramos las variables que usaran los pines correspondientes a la pantalla LCD
const int rs = 12, en = 11, d4 = 5, d5 = 4, d6 = 3, d7 = 2;
//Agregamos las variables al metodo que llamara a la pantalla LCD
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);

//Indicamos el pin que usara el boton-arriba en la placa Arduino
int btup = 9;
//Indicamos el pin que usara el boton-abajo en la placa Arduino
int btdown = 8;
//Declaracion de un contador que enviara su valor a la interfaz de Java, para la seleccion de mensajes
int cont = 0;
//Declaracion de variable que usara el metodo para obtener la temperatura del Sensor LM35
int valor;
//Indicamos el pin que usara el zumbador en la placa Arduino
int buzzer = 1;
//Declaracion de la variable de la frecuencia a la que trabajara el zumbador
int frecuencia = 330;

//Metodo principal
void setup() {
  //Iniciamos el LCD e indicamos que su tamaño es de 16x2
  lcd.begin(16, 2);
    //Iniciamos la comunicacion serial
    Serial.begin(9600);
      //Declaramos que "btup" enviara señales de entrada
       pinMode(btup, INPUT);
         //Declaramos que "btdown" enviara señales de entrada
         pinMode(btdown, INPUT);
          //Declaramos que el zumbador sea la salida de los metodos
          pinMode(buzzer, OUTPUT);
}

//Metodo que se repite constantemente
void loop() {
  //Revisamos si hay una palabra disponible
  if (Serial.available()) {
          //Esperamos un poco para escribir el mensaje
         delay(100);
            //Limpiamos la pantalla por cada mensaje recibido
            lcd.clear();
    //Imprime si esta disponible, en este caso que el mensaje tenga mayor longitud
    while (Serial.available() > 0) {
            //Envia el mensaje recibido por el puerto serial, y lo envia al LCD
            lcd.write(Serial.read());
    }
  }
  //Si "btup" ha sido presionado
  if ( digitalRead(btup) == HIGH ) {
      //Se declara la condicion que cuando el contador sea mayor a 6, se envia ese valor a Java para crear una excepcion
      if (cont > 6) {
          //Se asigna 6 a cont
          cont = 6;
    //En caso de no cumplir con la condicion
    } else {
          //Aumentamos el valor mas uno a contador(selector para los mensajes)
          cont++;
            //El mensaje tarda en llegar 500 milisegundos
            delay(500);
              //Se envia el valor del contador por comunicacion serial a Java
              Serial.println(cont);
                //Se declara la variable para que el zumbador funcione
                tone(buzzer, frecuencia);
    }
  }

  //Si "btdown" ha sido presionado
  if ( digitalRead(btdown) == HIGH ) {
       //Se declara la condicion que cuando el contador sea mayor a 6, se envia ese valor a Java para crear una excepcion
       if (cont < 1) {
          //Se asigna 6 a cont
          cont = 1;
    //En caso de no cumplir con la condicion
    } else {
        //Decrementamos el valor menos uno a contador(selector para los mensajes)
        cont--;
          //El mensaje tarda en llegar 500 milisegundos
          delay(500);
            //Se envia el valor del contador por comunicacion serial a Java
            Serial.println(cont);
              //Se declara la variable para que el zumbador funcione
              tone(buzzer, frecuencia);
    }
  }
  //Inicio de instrucciones para mostrar temperatura en LCD
  //Ubicamos el cursor del LCD en la coordenada (0,1)
  lcd.setCursor(0, 1);
      //Declaramos la variable que contendra los grados centigrados, obtenidos del metodo Centi()
      float Centigrados = centi();
        //Recibidos los datos, ubicamos el cursor en la coordenada (0,1)
        lcd.setCursor(0, 1);
          //Enviamos al LCD los grados centigrados
          lcd.print(Centigrados);
            //Enviamos al LCD el simbolo caracteristico de grados centigrados "°"
            lcd.print((char) 223);
}
//Creacion del metodo que entregara un float como resultado
float centi() {
    //Declaracion de la variable que contendra los grados centigrados
    float c;
      //A traves de comunicacion analogica, Arduino enviara los datos del Sensor LM35 a esta variable
      valor = analogRead(A0);
        //Calculo de la temperatura con los datos de Arduino y del sensor LM35
        c = (500.0 * valor) / 1023;
//Regresamos el resultado de la operacion y la añadimos a la variable c  
return (c);
}
//Fin del programa



