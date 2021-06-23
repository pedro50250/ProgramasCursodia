package Sesion1;

import javax.swing.JOptionPane;

public class temperatura {
/* Programa que transforma una temperatura otorgada en grados Celcius a Fahrenheiy
 * y kelvin*/
	public static void main(String[] args)
	{
		temperatura temp = new temperatura();
		float C = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la cantidad de grados en celsius: "));
		temp.Caf(C);
		System.out.println("La temperatura en grados Kelvin es " + temp.CaK(C));
		
	}
	
	private void Caf(float gradosC)
	{
		float F = (gradosC*1.8f)+32;
		System.out.println("La temperatura en grados Farenheit es " + F);
	}
	
	private float CaK(float C)
	{
		float K = C+ 273.15f;
	    return K;
	}
}

