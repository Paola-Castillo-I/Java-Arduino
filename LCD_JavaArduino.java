/*
*******************************************************************************
Instituto Tecnológico de León
Ingenieria en Sistemas Computacionales
Sistemas Programables
Trabajo: Envio de Mensajes, hora, fecha y temperatura a LCD por Medio 
         de Conexion Entre Arduino y Java.
Profesor: Ing. Levy Rojas Carlos Rafael
Presentado por: Alejandro Macario Gómez Ramírez
HORARIO: Martes y jueves de 8:45 AM a 10:30 AM
Enero - Junio
*******************************************************************************
*/
//Inicio de programa
package arduinojava;
//Comienza la importacion de paquetes y librerias
//Libreria Panama-Hitek, encargada de contener lo necesario para que la conexion entre Arduino y Java funcione
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
//Fin de importacion de paquetes y librerias
//Creacion de la clase publica que contendra todos los metodos
public class LCD_JavaArduino extends javax.swing.JFrame {
//Declaracion de variables
    //Declaracion de la variable que contendra el mensaje introducido
    String cadena = "";
    //Declaracion de arreglo de longitud 6, que almancenara todos los mensajes introducidos
    String[] datos = new String[6];
    //Declaracion de arreglo que guardara el valor que enviara arduino a java
    String[] valorARD = new String[1];
    //Declaracion de un contador, servira para indicar la posicion del arreglo
    int cont = 0;
    //Declaracion de variable de tipo Panama-Hiteck que llamara a los metodos de Arduino
    private static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    //Declaracion de variable listener que enviara los datos al puerto serial
    private final SerialPortEventListener listener = new SerialPortEventListener() {
//Fin de declaracion de variables
        //Sobrecarga de metodos
        @Override
//Inicio de declaracion de metodos y constructores
        //Creacion de metodo que activara la comunicacion al puerto serial
        public void serialEvent(SerialPortEvent spe) {
            //Declaracion de try-catch para obtener valores y errores
            try {
                //Si existe algun mensaje disponible
                if (ino.isMessageAvailable()) {
                    //Arduino envia un 0 y java imprime ese mensaje
                    valorARD[0] = ino.printMessage();
                    //Recepcion del valor de arduino a java
                    System.out.println(valorARD[0]);
                    //Enviamos el valor recibido en java a Arduino
                    ino.sendData(datos[Integer.parseInt(valorARD[0]) - 1]);
                }
            //Atrapamos errores en caso de no lograr la conexion serial
            } catch (SerialPortException | ArduinoException ex) {
                //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
                Logger.getLogger(Int1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    //Declaracion de constructor
    public Int1() {
        //Indica el titulo que llevara la ventana de la interfaz
        super("JAVA-ARDUINO");
        //Iniciamos componentes de la interfaz
        initComponents();
        //Declaracion de try-catch para obtener valores y errores
        try {
            //Esto indica que nuestro programa enviara y recibira datos de Java a Arduino
            //Y viceversa. Es decir, una comunicacion constante entre los dos
            //Declaramos el puerto por donde se iniciara la comunicacion serial
            ino.arduinoRXTX("/dev/ttyACM0", 9600, listener);
        //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion    
        } catch (ArduinoException ex) {
            //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
            Logger.getLogger(Int1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Generacion de codigo que contiene la interfaz grafica
    //Generado por el IDE NetBeans
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        BTNGuarda = new javax.swing.JButton();
        BTNMostrar = new javax.swing.JButton();
        BTNHora = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tablero = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TFIngresa = new javax.swing.JTextField();
        BtnFecha = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BTNGuarda.setText("Guardar");
        BTNGuarda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNGuardaActionPerformed(evt);
            }
        });

        BTNMostrar.setText("Mostrar");
        BTNMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNMostrarActionPerformed(evt);
            }
        });

        BTNHora.setText("Hora");
        BTNHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNHoraActionPerformed(evt);
            }
        });

        jLabel1.setText("Introduzca su mensaje");

        Tablero.setEditable(false);
        Tablero.setColumns(20);
        Tablero.setRows(5);
        jScrollPane2.setViewportView(Tablero);

        jLabel2.setText("Solo 6 mensajes");

        jLabel3.setText("Usted ha introducido");

        BtnFecha.setText("Fecha");
        BtnFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFIngresa, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(BTNHora, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BtnFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(BTNGuarda, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BTNMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(64, 64, 64)))))))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TFIngresa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNGuarda)
                    .addComponent(BTNMostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNHora)
                    .addComponent(BtnFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>
    //Fin de codigo generado por NetBeans                        
    
    //Creacion del metodo correspondiente al boton que guarda los mensajes en el arreglo
    private void BTNGuardaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        //Declaracion de try-catch para obtener valores y errores
        try {
            //Indicamos que datos obtendra los valor del cuadro de texto y los guardara
            //segun la posicion que indique el contador
            datos[cont] = TFIngresa.getText();
            //Aumentamos mas uno la variable contador por cada mensaje introducido
            cont++;
            //Obtenemos el valor introducido en el cuadro de texto
            TFIngresa.setText("");
        //En caso de sobrepasar el tamaño definido del arreglo   
        } catch (ArrayIndexOutOfBoundsException ex) {
            //Envio de advertencia para el usuario
            JOptionPane.showMessageDialog(null, "No puede introducir mas mensajes");
        }
    }                                         

    //Creacion del metodo que mostrara los mensajes introducidos con anterioridad
    private void BTNMostrarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        //Declaramos un ciclo que realizara el recorrido del arreglo
        for (int i = 0; i < 6; i++) {
            //Envio de la cadena a consola, para propositos de revision de variables
            System.out.println(datos[i]);
        }
        //Creacion de la variable que se introducira a la zona de texto
        String texto = "";
        //Declaramos un ciclo que realizara el recorrido del arreglo
        for (int i = 0; i < 6; i++) {
            //Agregamos formato a los mensajes introducidos
            texto += datos[i] + "\n";
        }
        //Introducimos la cadena de mensajes a la zona de texto
        Tablero.setText(texto);
    }                                          

    //Creacion del metodo que enviara la hora al presionar el boton
    private void BTNHoraActionPerformed(java.awt.event.ActionEvent evt) {                                        
        //Mandamos llamar el metodo CALENDAR para obtener los datos
        Calendar calendario = Calendar.getInstance();
        //Declaracion de variable que obtendra las horas del sistema
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        //Declaracion de variable que obtendra los minutos del sistema
        int minutos = calendario.get(Calendar.MINUTE);
        //Declaracion de la variable que enviaremos a Arduino con las horas y minutos
        String tiempo = "Hora " + hora + ":" + minutos;
        //Declaracion de try-catch para obtener valores y errores
        try {
            //Enviamos la hora del sistema a Arduino por puerto serial
            ino.sendData(tiempo);
        //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion    
        } catch (ArduinoException | SerialPortException ex) {
            //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
            Logger.getLogger(Int1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                       
    
    //Creacion del metodo para obtener la fecha del sistema
    private void BtnFechaActionPerformed(java.awt.event.ActionEvent evt) {                                         
       //Mandamos llamar el metodo CALENDAR para obtener los datos
        Calendar calendario2 = Calendar.getInstance();
        //Variable que contiene el dia del sistema
        String dia = Integer.toString(calendario2.get(Calendar.DATE));
        //Variable que contiene el mes del sistema
        String mes = Integer.toString(calendario2.get(Calendar.MONTH));
        //Variable que contiene el año del sistema
        String annio = Integer.toString(calendario2.get(Calendar.YEAR));
        //Variable que contiene todos los datos de la fecha
        String fecha = "Fecha " + dia + "/" + mes + "/" + annio;
        //Declaracion de try-catch para obtener valores y errores
        try {
            //Enviamos la hora del sistema a Arduino por puerto serial
            ino.sendData(fecha);
        //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion    
        } catch (ArduinoException | SerialPortException ex) {
            //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
            Logger.getLogger(Int1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        

    //Creacion del metodo principal
    public static void main(String args[]) {
        //Iniciamos la variable de eventos
        java.awt.EventQueue.invokeLater(new Runnable() {
            //Iniciamos programa
            public void run() {
                //Hacemos visible la interfaz grafica
                new Int1().setVisible(true);
            }
        });
    }
//Creacion de Gets y Sets para obtener los datos necesarios
    //Obtenemos el valor del contador
    public int getCont() {
        //Retorno del valor actual de contador
        return cont;
    }
    //Establecemos el valor del contador
    public void setCont(int cont) {
        //Establcemos el valor actual del contador
        this.cont = cont;
    }
    //Obtenemos el valor que recibimos de Arduino
    public static PanamaHitek_Arduino getIno() {
        //Retorno de valor actual recibido por Arduino
        return ino;
    }
    //Establecemos el valor del contador
    public static void setIno(PanamaHitek_Arduino ino) {
        //Establecemos el valor actual recibido por Arduino
        Int1.ino = ino;
    }
    //Obtenemos el valor de la cadena cada vez que el boton Guardar se presiona
    public JButton getBTNGuarda() {
        //Obtenemos el valor actual de la cadena
        return BTNGuarda;
    }
    //Establecemos el valor de la cadena cada vez que el boton guardar sea presionado
    public void setBTNGuarda(JButton BTNGuarda) {
        //Establecemos el valor actual de la cadena
        this.BTNGuarda = BTNGuarda;
    }
    //Obtenemos el valor de la hora del sistema cada vez que el boton Hora sea presionado
    public JButton getBTNHora() {
        //Retorno del valor actual de la hora del sistema
        return BTNHora;
    }
    //Establecemos el valor de la hora del sistema cada vez que el boton Hora sea presionado
    public void setBTNHora(JButton BTNHora) {
        //Establecemos el valor actual de la hora del sistema
        this.BTNHora = BTNHora;
    }
    //Obtenemos el valor del boton guardar y de la cadena de caracteres
    public JButton getBTNMostrar() {
        //Retorno del valor actual de la cadena de caracteres
        return BTNMostrar;
    }
    //Establecemos el valor de la cadena de mensaje cada vez que el boton Mostrar sea presionado
    public void setBTNMostrar(JButton BTNMostrar) {
        //Establecemos el valor actual de la cadena de mensajes
        this.BTNMostrar = BTNMostrar;
    }
    //Obtenemos el valor del cuadro de texto
    public JTextField getTFIngresa() {
        //Retorno del valor actual del cuadro de texto
        return TFIngresa;
    }
    //Establecemos el valor del cuadro de texto
    public void setTFIngresa(JTextField TFIngresa) {
        //Establecemos el valor actual del cuadro de texto
        this.TFIngresa = TFIngresa;
    }
    //Etiqueta
    public JLabel getjLabel1() {
        //Valor de la etiqueta
        return jLabel1;
    }
    //Establecemos el mensaje de la etiqueta
    public void setjLabel1(JLabel jLabel1) {
        //Establecemos el valor de la etiqueta
        this.jLabel1 = jLabel1;
    }
    //Activacion de scroll en la zona de texto
    public JScrollPane getjScrollPane1() {
        //Scroll
        return jScrollPane1;
    }
    //Establecemos el scroll en la zona de texto
    public void setjScrollPane1(JScrollPane jScrollPane1) {
        //Scroll
        this.jScrollPane1 = jScrollPane1;
    }
//Fin de declaracion de Gets y Sets para obtener datos necesarios
    //Declaracion de todos los elementos que conforman la interfaz grafica
    // Variables declaration - do not modify                     
    private javax.swing.JButton BTNGuarda;
    private javax.swing.JButton BTNHora;
    private javax.swing.JButton BTNMostrar;
    private javax.swing.JButton BtnFecha;
    private javax.swing.JTextField TFIngresa;
    private javax.swing.JTextArea Tablero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration                   
}
//Fin de programa
