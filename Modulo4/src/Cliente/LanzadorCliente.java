package Cliente;

public class LanzadorCliente {

	
	@SuppressWarnings("unused")
	public static void main(String[]args)
	{
		VistaChat vista = new VistaChat();
		ModeloChat modelo = new ModeloChat();
		ControladorChat con = new ControladorChat(vista,modelo);
	}
}
