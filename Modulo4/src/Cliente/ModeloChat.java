package Cliente;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Servidor.Cliente;

public class ModeloChat implements Runnable {

	int puertoLocal = 666;
	String nombre;
	boolean usuarioConectado = false;
	//int puertoRemoto = 666;
	int puertoRemoto=5432;
	String nomServer = "";
	String ipRemota = "25.90.151.108";
	String mensajeNuevo = "";
	boolean Mensaje = false;
	private Thread hilo;
	Socket socketRecibir;
	ArrayList<Cliente> clientes;
	ControladorChat controlador;

	public void conectar(ControladorChat con) {
		this.controlador=con;
		// TRY QUE MANDA LOS DATOS DEL CLIENTE CONECTADO
		try {
			@SuppressWarnings("resource")
			
			Socket s = new Socket(ipRemota, puertoRemoto); // CONECTA CON LA IP DEL SERVER Y EL PUERTO
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());// INSTANCIA LA SALIDA DE DATOS
			oos.writeObject(nombre);// ENVIA EL NOMBRE
			//oos.write(this.puertoLocal);
			//oos.defaultWriteObject();
			oos.close(); 
			this.usuarioConectado=true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	public void recibirNombre() {
		if (this.usuarioConectado == true) {
			try {
				ServerSocket ss = new ServerSocket(puertoLocal); // ABRE EL PUERTO
				System.out.println("Esperando Conexion");

				Socket s = ss.accept(); // AL RECIBIR UNA CONEXION LA ACEPTA
				String ip = "" + s.getInetAddress(); // SACA LA IP DEL CLIENTE CONECTADO
				System.out.println("IP CORREGIDA: " + ip.replace("/", ""));

				ObjectInputStream ois = new ObjectInputStream(s.getInputStream()); // LEE EL MENSAJE QUE CONTIENE EL
																					// NOMBRE
			    										// DEL CLIENTE
				nomServer = (String) ois.readObject(); // SE GUARDA EL NOMBRE
				//this.clientes = (ArrayList<Cliente>) ois.readObject();
				System.out.println("Se conecto " + nomServer + " desde la IP: " + s.getInetAddress()); // SE IMPRIME
				ss.close();// CIERRA EL SOCKET PARA ABRIRLO AHORA EN EL HILO

			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void enviarMensajes(String mensaje) {
		if (this.usuarioConectado == true) {
			try {
				@SuppressWarnings("resource")
				Socket s = new Socket(this.ipRemota, this.puertoRemoto);
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(mensaje);
				oos.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			System.out.println("Desconectado");
		}

	}

	public void abrirHilo(ModeloChat modelo) {
		if(this.usuarioConectado==true)
		{
			hilo = new Thread(this);
			hilo.start();
		}
		
	}

	@Override
	public void run() {
		try {
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(puertoLocal);
			while (true) {
				try {
					socketRecibir = ss.accept();
					ObjectInputStream ois = new ObjectInputStream(socketRecibir.getInputStream());
					String mensaje = (String) ois.readObject();
					if (mensaje != null || mensaje != "") {
						System.out.println(this.nomServer + " dice: " + mensaje);
						this.mensajeNuevo = mensaje;
						this.Mensaje = true;
						this.controlador.mandarPantalla();
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ReproducirSonidoEnviar()  {
		// File miarchivo = new File("Sonidos/Enviar.wav");
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		Clip clip;
		try {
			stream = AudioSystem.getAudioInputStream(new File("Sonidos/Enviar.wav"));
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void ReproducirSonidoRecibir() {
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		Clip clip;
		try {
			stream = AudioSystem.getAudioInputStream(new File("Sonidos/Recibir.wav"));
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}

	}
	
}
