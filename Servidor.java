
package juegosEnRed;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
private static ServerSocket serverSocket;
public static void main(String[] args) throws IOException {
int numeroSeleccionado = -1;
int numeroAleatorio=(int)(Math.random()*100);
int numeroIntentos=1;		

// Creamos el serverSocket con el ip requerido.
serverSocket = new ServerSocket();
InetSocketAddress addr = new InetSocketAddress("localhost", 5050);
serverSocket.bind(addr);
System.out.println("CONEXION EN ESPERA");  
//Esperamos a que el clientese conecte
Socket socket = serverSocket.accept();
System.out.println("CONEXION ESTABLECIDA");
//Creamos la salida y entrada de datos
BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
PrintStream salida = new PrintStream(socket.getOutputStream());

//Creamos un while que controle la entrada de los numeros que introduce el usuario
while (numeroSeleccionado!=numeroAleatorio) {
//Recivimos el numero seleccionado
numeroSeleccionado = Integer.parseInt(br.readLine());    
//y lo pasamos por un if/else que ira dando pistas sobre el temaño del numero
if(numeroSeleccionado>numeroAleatorio) {
    
salida.println("El numero que buscas es menor");
}else if(numeroSeleccionado<numeroAleatorio) {
salida.println("El numero que buscas es mayor");}
numeroIntentos++;}
//Cuando el numero cuincida se cerrara el bucle while
//Enviado la palabra clave FIN que cerrara el bucle del cliente
salida.println("FIN");
salida.println("Numero de intentos: " + numeroIntentos);			
//Ceramos la conexion
socket.close();}}