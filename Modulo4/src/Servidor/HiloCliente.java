package Servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class HiloCliente implements Runnable{

	Cliente cli;
	ModeloChat modelo;
	Socket socketRecibir;
	Thread hilo;
	public void abrirHilo(Cliente cli,ModeloChat modelo) {
		this.cli = cli;
		this.modelo = modelo;
		hilo = new Thread(this);
		hilo.start();
	}

	@Override
	public void run() {
		try {
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(modelo.puertoLocal);
			while (true) {
				try {
					socketRecibir = ss.accept();
					ObjectInputStream ois = new ObjectInputStream(socketRecibir.getInputStream());
					String mensaje = (String) ois.readObject();
					if (mensaje != null || mensaje != "") {
						System.out.println(this.cli.getNomCliente() + " dice: " + mensaje);
						this.modelo.mensajeNuevo = mensaje;
						this.modelo.Mensaje = true;
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void cerrarHilo()
	{
		try {
			socketRecibir.close();
			hilo.stop();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
