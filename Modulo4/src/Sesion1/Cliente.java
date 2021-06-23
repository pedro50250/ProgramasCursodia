package Sesion1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Socket s = null;
		try {
			
			// instancio el server con la IP y el PORT
			s = new Socket("25.81.54.231", 1234);
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
	////////////////////////////////////////////////////////////////////////////////////

			//PREPARO EL MENSAJE A MANDAR
			System.out.println("Ingrese un numero entero:");
			int num1= Integer.parseInt(sc.nextLine());
			System.out.println("Ingrese un numero entero:");
			int num2= Integer.parseInt(sc.nextLine());
			// MANDO EL MENSAJE
			oos.writeObject(num1);
			oos.writeObject(num2);
			
			
			// LEO LA RESPUESTA RECIBIDA 
			int fac1 = (int) ois.readObject();
			int fac2 = (int) ois.readObject();
			
			//CALCULO LA DIVISION DE LOS FACTORIALES RECIVIDOS
			double div = (double) fac1/fac2;
			
			//IMPRIMO EN CONSOLA EL NUEVO RESULTADO
			System.out.println("Resultado: "+div);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ois != null)
				ois.close();
			if (oos != null)
				oos.close();
			if (s != null)
				s.close();
			if(sc != null) sc.close();
		}
	}
}
