package Sesion2;

import javax.swing.JOptionPane;

public class FiguraGeometrica {

	double base;
	double altura;
	double AreaRectangulo;
	double AreaTriangulo;
	public static void main(String[] args)
	{
		FiguraGeometrica fg = new FiguraGeometrica();
		fg.LVT();
		fg.LVR();
	}
	protected void LVT()
	{
		double base = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el valor de la base del triangulo"));
		double altura = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el valor de la altura del triangulo"));
		CAT(base,altura);
	}
	protected void LVR()
	{
		double base = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el valor de la base del rectangulo"));
		double altura = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el valor de la altura del rectangulo"));
		CAR(base,altura);
	}
	private void CAT(double B,double A)
	{
		 AreaTriangulo = (B*A)/2;
		//System.out.println("El area del trianguo es: " + AreaTriangulo);
	}
	private void CAR(double B, double A)
	{
		AreaRectangulo = B*A;
		//System.out.println("El area del rectangulo es: "+ AreaRectangulo);
	}
}
