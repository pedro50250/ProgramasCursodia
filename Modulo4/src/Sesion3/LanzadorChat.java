package Sesion3;

public class LanzadorChat {

	
	@SuppressWarnings("unused")
	public static void main(String[]args)
	{
		System.out.println("Server");
		VistaChat vista = new VistaChat();
		ModeloChat modelo = new ModeloChat();
		ControladorChat con = new ControladorChat(vista,modelo);
	}
}
