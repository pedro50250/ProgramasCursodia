package Controlador;

import Modelo.ModeloLogin;
import Vista.Login;

public class LanzadorLogin {
	
	@SuppressWarnings("unused")
	public static void main(String[]args)
	{
		Login vista = new Login();
		ModeloLogin modelo = new ModeloLogin();
		ControladorLogin controlador;
		controlador = new ControladorLogin(vista,modelo);
	}
}