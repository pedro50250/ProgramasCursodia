package Sesion2;

import javax.swing.JOptionPane;

public class Menu extends Esfera {
	
public static void main(String[]args)
{
	Menu menu = new Menu();
	menu.elegirSistemaDeMedida();
}
	
private void elegirSistemaDeMedida()
{
	try
	{
	int entrada = Integer.parseInt(JOptionPane.showInputDialog("¿En que unidad de medida gusta realizar la entrada de datos?"
			+ "\n 1. Centimetros" + " \n 2. Pulgadas"));
	int salida = Integer.parseInt(JOptionPane.showInputDialog("¿En que unidad de medida gusta realizar la salida de datos?"
			+ "\n 1. Centimetros" + " \n 2. Pulgadas"));
	elegirOpcion(entrada,salida);
		
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "ERROR, Eliga opciones correctamente y utilice"
				+ " unicamente valores numericos como el 1 y 2");
	}
}

private void elegirOpcion(int entrada,int salida)
{
    boolean salir = false;
	while(!salir)
	{
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("Eliga una opcion: \n"
				+ "1. Calcular Area triangulo \n" + "2. Calcular Area Rectangulo \n" + 
				"3. Calcular Prisma Rectangular \n " + "4. Calcular Prisma Triangular \n"
				+ "5. Calcular Piramide \n" + "6. Calcular Esfera \n" + "7. Salir" ));
		switch(opcion)
		{
		
		case 1:
			{
				//Centimetros a Pulgadas
				if(entrada ==1 && salida == 2 )
				{
					super.LVT();
					System.out.println("El area del triangulo en pulgadas es: " + AreaTriangulo/2.54);
				}
				//Centimetros a Centimetros o Pulgadas a Pulgadas
				else if(entrada == salida)
				{
					LVT();
					System.out.println("El area del triangulo es: " + AreaTriangulo);
				}
				//Pulgadas a Centimetros
				else if(entrada == 2 && salida==1)
				{
					LVT();
					System.out.println("El area del triangulo en centimetros es: " + AreaTriangulo*2.54);
				}
				break;
			}
		
		case 2:
		{
			//Centimetros a Pulgadas
			if(entrada ==1 && salida == 2 )
			{
				LVR();
				System.out.println("El area del Rectangulo en pulgadas es: " + AreaRectangulo/2.54);
			}
			//Centimetros a Centimetros o Pulgadas a Pulgadas
			else if(entrada == salida)
			{
				LVR();
				System.out.println("El area del Rectangulo es: " + AreaRectangulo);
			}
			//Pulgadas a Centimetros
			else if(entrada == 2 && salida==1)
			{
				LVR();
				System.out.println("El area del Rectangulo  en centimetros es: " + AreaRectangulo*2.54);
			}
			break;
		}
		
		case 3: 
		{
			//Centimetros a Pulgadas
			if(entrada ==1 && salida == 2 )
			{
				CPR();
				System.out.println("El Volumen del prisma Rectangular es: " + VolumenPrRect/2.54);
			}
			//Centimetros a Centimetros o Pulgadas a Pulgadas
			else if(entrada == salida)
			{
				CPR();
				System.out.println("El Volumen del prisma Rectangular es: " + VolumenPrRect);
			}
			//Pulgadas a Centimetros
			else if(entrada == 2 && salida==1)
			{
				CPR();
				System.out.println("El Volumen del prisma Rectangular es: " + VolumenPrRect*2.54);
			}
			break;
		}
		
		case 4: 
		{
			//Centimetros a Pulgadas
			if(entrada ==1 && salida == 2 )
			{
				CPT();
				System.out.println("El Volumen del prisma Triangular es: " + VolumenPrTrian/2.54);
			}
			//Centimetros a Centimetros o Pulgadas a Pulgadas
			else if(entrada == salida)
			{
				CPT();
				System.out.println("El Volumen del prisma Triangular es: " + VolumenPrTrian);
			}
			//Pulgadas a Centimetros
			else if(entrada == 2 && salida==1)
			{
				CPT();
				System.out.println("El Volumen del prisma Triangular es: " + VolumenPrTrian*2.54);
			}
			break;
		}
		
		case 5:
		{
			//Centimetros a Pulgadas
			if(entrada ==1 && salida == 2 )
			{
				CP();
				System.out.println("El Volumen de la Piramide es: " + VolumenPiramide/2.54);
			}
			//Centimetros a Centimetros o Pulgadas a Pulgadas
			else if(entrada == salida)
			{
				CP();
				System.out.println("El Volumen de la Piramide es: " + VolumenPiramide);
			}
			//Pulgadas a Centimetros
			else if(entrada == 2 && salida==1)
			{
				CP();
				System.out.println("El Volumen de la Piramide es: " + VolumenPiramide*2.54);
			}
			break;
		}
		
		case 6:
		{
			//Centimetros a Pulgadas
			if(entrada ==1 && salida == 2 )
			{
				LVE();
				System.out.println("\"El valor del volumen de la esfera es igual a: " + volEsfera/2.54);
			}
			//Centimetros a Centimetros o Pulgadas a Pulgadas
			else if(entrada == salida)
			{
				LVE();
				System.out.println("El valor del volumen de la esfera es igual a: " + volEsfera);
			}
			//Pulgadas a Centimetros
			else if(entrada == 2 && salida==1)
			{
				LVE();
				System.out.println("El valor del volumen de la esfera es igual a: " + volEsfera*2.54);
			}
			break;
		}
		
		case 7: salir = true;
				break;
				
		}
	}
}

}
