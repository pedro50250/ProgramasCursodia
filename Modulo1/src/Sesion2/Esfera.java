package Sesion2;

import javax.swing.JOptionPane;

public class Esfera extends Prismas{

	double volEsfera;
	public static void main(String[]args)
	{
		Esfera es = new Esfera();
		es.LVE();
		
	}
	
	protected void LVE()
	{
		double radio = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el valor del radio de la esfera: "));
		CVE(radio);
	}
	
	protected void CVE(double radio)
	{
		 volEsfera = ((4)*(Math.PI)*(Math.pow(radio, 3)))/3;
		//System.out.println("El valor del volumen de la esfera es igual a: " + volEsfera);
	}
}
