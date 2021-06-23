package TareaSesion2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {

	int puertoLocal = 5432;
	String nombre = "El Pedro";
	boolean clienteConectado = false;
	int puertoRemoto = 666;
	String nomCliente = "";
	String ipRemota = "";

	public static void main(String[] args) {
		server ser = new server();

		ser.levantarServer();
		ser.enviarNombre();
		// serverHilo sh = new serverHilo(puertoLocal, nomCliente);
		ser.abrirHilo();
		ser.enviarMensajes();

	}

	private void levantarServer() {
		try {
			ServerSocket ss = new ServerSocket(puertoLocal); // ABRE EL PUERTO
			System.out.println("Esperando Conexion");

			Socket s = ss.accept(); // AL RECIBIR UNA CONEXION LA ACEPTA

			this.ipRemota = "" + s.getInetAddress(); // SACA LA IP DEL CLIENTE CONECTADO
			StringBuilder sb = new StringBuilder(ipRemota);
			sb.deleteCharAt(0);
			this.ipRemota = sb.toString();
			// System.out.println("ip recibida" + this.ipRemota);
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream()); // LEE EL MENSAJE QUE CONTIENE EL NOMBRE
																				// DEL CLIENTE
			this.nomCliente = (String) ois.readObject(); // SE GUARDA EL NOMBRE
			System.out.println("Se conecto " + nomCliente + " desde la IP: " + s.getInetAddress()); // SE IMPRIME
			ss.close();// CIERRA EL SOCKET PARA ABRIRLO AHORA EN EL HILO

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void enviarNombre() {
		try {
			@SuppressWarnings("resource")
			Socket s = new Socket(ipRemota, puertoRemoto); // CONECTA CON LA IP DEL SERVER Y EL PUERTO
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());// INSTANCIA LA SALIDA DE DATOS
			oos.writeObject(nombre);// ENVIA EL NOMBRE
			oos.close(); // CIERRA EL FLUJO PARA ABRIRLO EN EL WHILE
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void enviarMensajes() {
		// WHILE QUE MANTIENE VIVO LA OPCION DE MANDAR MENSAJES

		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);

			while (true) {
				@SuppressWarnings("resource")
				Socket s = new Socket(this.ipRemota, this.puertoRemoto);
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

				// envio un nombre
				// System.out.println("Ingrese su mensaje: ");
				String nom = sc.nextLine();
				oos.writeObject(nom);
				oos.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void abrirHilo() {
		serverHilo sh = new serverHilo(puertoLocal, nomCliente);
	}

}
