package Sesion1;

import javax.swing.JOptionPane;

public class Areas {

	public static void main(String[]args)
	{
		Areas area = new Areas();
		boolean salir = false;
		
		while(!salir)
		{
			System.out.println("1.- Calcular el area de un triagulo.");
			System.out.println("2.- Calcular el area de un rectangulo.");
			System.out.println("3.- Calcular el area de un circulo. ");
			System.out.println("4.- Salir");
			int opcion = Integer.parseInt(JOptionPane.showInputDialog("Que opcion desea: "));
			switch(opcion)
			{
			
			case 1 : 
				area.calcularTriangulo();
				break;
				
			case 2 : 
				area.calcularRectangulo();
				break;
				
			case 3 : 
				area.calcularCirculo();
				break;
				
			case 4 : 
				salir = true;
				break;
				
			default : 
				System.out.println("ERROR, eliga una opcion correcta");
				break;
			}
					
		}
	
	}
	
	private void calcularTriangulo()
	{
		try
		{
			System.out.println("Calcular el area del triangulo");
			float base = Float.parseFloat(JOptionPane.showInputDialog("Ingresa el valor de la base: "));
		    float altura = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de la altura: "));
		    System.out.println("El valor del area de el triangulo es igual a: "+((base*altura)/2));
		}
		catch(Exception e )
		{
			JOptionPane.showMessageDialog(null, "ERROR ingrese valores unicamente numericos!!");
		}
		
	}
	
	private void calcularRectangulo() 
	{
		try
		{
			System.out.println("Calcular el area de un rectangulo");
		    float base = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de la base: "));
		    float altura = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor de la altura: "));
		    System.out.println("El valor del area del rcetangulo es igual a: " + ((base)*(altura)));
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "ERROR ingresa un valor numerico correcto");
		}
		
	}
	
	private void calcularCirculo()
	{
		try
		{
			System.out.println("Calcular el area de un circulo");
			float radio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor del radio: "));
			System.out.println("El valor del area del circulo es igual a: " + Math.pow( ( (3.1416) * (radio) ),2));
		}
		catch(Exception e )
		{
			JOptionPane.showMessageDialog(null, "ERROR, ingrese un valor numerico correcto");
		}
	}
	
}
