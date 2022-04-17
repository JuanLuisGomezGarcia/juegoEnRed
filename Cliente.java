
package juegosEnRed;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Cliente {
public static void main(String[] args) throws IOException {
String datoRecivido = "";
String datoEnviado;	
	
// Creamos el socketc del cliente con el puerto que pide la actividad
Socket clienteSocket = new Socket("localhost", 5050);
//Creamos la salida y entrada de datos
BufferedReader entradaDatos = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
PrintStream salidaDatos = new PrintStream(clienteSocket.getOutputStream(), true);
		
System.out.println("Empezamos el juego: \nADIVINA EL NUMERO \nSelecciona un numero entre 0 y 100");

//Creamos un while que controle
while (!datoRecivido.equals("FIN")) {
int numeroSeleccionado = pedirInt();
datoEnviado = String.valueOf(numeroSeleccionado);
salidaDatos.println(datoEnviado);
salidaDatos.flush();
datoRecivido = entradaDatos.readLine();
System.out.println(datoRecivido);}

//Cerramos las conexiones	
entradaDatos.close();
clienteSocket.close();}

//Fucion para pedir int
public static int pedirInt(){
        int numeroRetornar=0;
        int clave_pedirInt;
        do{ clave_pedirInt=0;
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brm = br.readLine();
        numeroRetornar = Integer.parseInt(brm);
        if(numeroRetornar<0  || numeroRetornar>100){
            System.out.println("Introdusca un valor entre el 0 y el 100");
            clave_pedirInt=-1;
        }
        }catch(Exception e){ clave_pedirInt=-1;System.out.println("Introdusca un numero por favor");}
        }while(!(clave_pedirInt==0));
        return numeroRetornar;} }