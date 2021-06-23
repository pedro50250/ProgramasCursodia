package Servidor;

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

public class ModeloChat {

	int puertoLocal = 5432;
	String nombre;
	boolean usuarioConectado = false;
	int puertoRemoto = 666;
	String nomUsuario = "";
	String ipRemota = "";
	String mensajeNuevo = "";
	boolean Mensaje = false;
	ModeloChat modelo;

	ArrayList<Cliente> clientes;
	ArrayList<Thread> hilos = new ArrayList<Thread>();
	boolean abierto=false;
	ServerSocket ss;
	public void abrirSocket()
	{
		if(abierto==false)
		{
			try {
				ss = new ServerSocket(puertoLocal);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // ABRE EL PUERTO
		}
	}
	public void levantarServer(ModeloChat modelo) {
		this.modelo = modelo;
		this.clientes = new ArrayList<Cliente>();
			try {
			    String nombre,ip;
			    int puerto;
			    this.abrirSocket();
				System.out.println("Esperando Conexion");

				Socket s = ss.accept(); // AL RECIBIR UNA CONEXION LA ACEPTA
				this.ipRemota = "" + s.getInetAddress(); // SACA LA IP DEL CLIENTE CONECTADO
				StringBuilder sb = new StringBuilder(ipRemota);
				sb.deleteCharAt(0);
				ip = sb.toString();
				//this.ipRemota = sb.toString();
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream()); // LEE EL MENSAJE QUE CONTIENE EL NOMBRE DEL CLIENTE
				//this.nomUsuario = (String) ois.readObject(); // SE GUARDA EL NOMBRE
				nombre = (String) ois.readObject();
				puerto = Integer.parseInt((String) ois.readObject());
				System.out.println("Se conecto " + nomUsuario + " desde la IP: " + s.getInetAddress()); // SE IMPRIME
				if(clientes.isEmpty())
				{
					Cliente cli = new Cliente(ip,nombre,puerto);
					this.enviarNombre(cli);
				    this.clientes.add(cli);
				}
				else
				{
					boolean repetido=false;
					for(Cliente cli : clientes)
					{
						if(cli.getNomCliente().equals(nombre))
						{
							repetido=true;
						}
					}
					if(repetido==false)
					{
						Cliente cli = new Cliente(ip,nombre,puerto);
						this.enviarNombre(cli);
					    this.clientes.add(cli);
					}
				}
				/*this.puertoRemoto= s.getPort();
				System.out.println("Puerto remoto de el:  " + puertoRemoto);
				this.puertoRemoto= 666;
				System.out.println("Socket address" + s.getRemoteSocketAddress());*/
				//ss.close();// CIERRA EL SOCKET PARA ABRIRLO AHORA EN EL HILO
				this.usuarioConectado = true;
				this.abierto=true;
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public void enviarNombre(Cliente cli) {
		if (this.usuarioConectado == true) {
			try {
				Socket s = new Socket(cli.getIpAddress(), cli.getPuertoRemoto()); // CONECTA CON LA IP DEL SERVER Y EL PUERTO
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());// INSTANCIA LA SALIDA DE DATOS
				oos.writeObject(nombre);// ENVIA EL NOMBRE
				oos.writeObject(clientes);
				oos.close(); // CIERRA EL FLUJO PARA ABRIRLO EN EL WHILE
				this.abrirHilo(this.modelo, cli);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void enviarMensajes(String mensaje) {
		if (this.usuarioConectado == true) {
			try {
				for(Cliente cli: this.clientes)
				{
					Socket s = new Socket(cli.getIpAddress(), cli.getPuertoRemoto());
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(mensaje);
					oos.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			System.out.println("Desconectado");
		}
	}

	public void abrirHilo(ModeloChat modelo,Cliente cli) {
		if(this.usuarioConectado==true)
		{
			HiloCliente hilo = new HiloCliente();
			cli.setHilo(hilo);
			hilo.cli = cli;
			hilo.abrirHilo(cli, modelo);
		}
	}

	

	public void ReproducirSonidoEnviar()  {
		
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
	
	public void cerrarHilo()
	{
		for(Cliente cli: this.clientes)
		{
			cli.getHilo().cerrarHilo();
		}
	}
	

}
