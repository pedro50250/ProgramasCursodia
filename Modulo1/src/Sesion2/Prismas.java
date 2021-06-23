package Sesion2;

import javax.swing.JOptionPane;

public class Prismas extends FiguraGeometrica{
	double VolumenPrRect;
	double VolumenPrTrian;
	double VolumenPiramide;
	public static void main(String[]args)
	{
		Prismas p =new  Prismas();
		p.CPR();
		p.CPT();
		p.CP();
	}
	//Calcular Prisma Rectangular
	protected void CPR()
	{
		LVR();
		double profRect = Double.parseDouble(JOptionPane.showInputDialog("Profundidad del prima Rectangular:"));
		 VolumenPrRect = AreaRectangulo * profRect;
		//System.out.println("El volumen del prisma rectangular es:" + VolumenPrRect);	
	}
	//Calcular Prisma Triangular
	protected void CPT()
	{
		LVT();
		double profTria = Double.parseDouble(JOptionPane.showInputDialog("Profundidad del prisma Triangular:"));
		 VolumenPrTrian = AreaTriangulo * profTria;
		//System.out.println("El volumen del prisma triangular es:" + VolumenPrTrian);
	}
	//Calcular Piramide
	protected void CP()
	{
		LVT();
		double profPiramide = Double.parseDouble(JOptionPane.showInputDialog("Profundidad de la piramide :"));
	    VolumenPiramide = (AreaTriangulo*profPiramide)/3;
		//System.out.println("El volumen del la piramide es: " + VolumenPiramide);
	}
	
}
