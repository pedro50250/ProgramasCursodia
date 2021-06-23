package Sesion1;

import javax.swing.JOptionPane;

public class Fibonacci {

	public static void main(String[]args)
	{
		int a,b,c;
		a=0;
		b=1;
		int n = Integer.parseInt(JOptionPane.showInputDialog("Cuantos numero desea mostrar de la serie: "));
	    for (int i = 0; i < n; i++) {
            System.out.println(a);
            c = a + b;
            a = b;
            b = c;
        }
	}
}
