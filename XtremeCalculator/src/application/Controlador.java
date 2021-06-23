package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener
{
	/* Version 1.0  23/05/2020
	 * Ejemplo Modelo-Vista-Controlador
	 * Creado por: Dr. Carlos Adrian Perez Cortez
	 * Para: Cursodia Diplomado Java 14
	 */
	Modelos mod;
	VistaPrincipal vprin;
	public Controlador(Modelos mod, VistaPrincipal vprin) 
	{
		this.mod = mod;
		this.vprin = vprin;
		ejecutar();
	}
	
	private void ejecutar()
	{
		vprin.lanzarVista();
		while(!vprin.finish)
		{	
			try 
			{
				Thread.sleep(2);
			} catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//esperando
		}
		AgregarListeners();
		vprin.txtDisplay.setText("0");
	}
	
	private void AgregarListeners()
	{
		//System.out.println("se hizo");
		vprin.btn0.addActionListener(this);
		vprin.btn1.addActionListener(this);
		vprin.btn2.addActionListener(this);
		vprin.btn3.addActionListener(this);
		vprin.btn4.addActionListener(this);
		vprin.btn5.addActionListener(this);
		vprin.btn6.addActionListener(this);
		vprin.btn7.addActionListener(this);
		vprin.btn8.addActionListener(this);
		vprin.btn9.addActionListener(this);
		vprin.btnDot.addActionListener(this);
		vprin.btnSum.addActionListener(this);
		vprin.btnRes.addActionListener(this);
		vprin.btnMult.addActionListener(this);
		vprin.btnDiv.addActionListener(this);
		vprin.btnIgual.addActionListener(this);
		vprin.btnC.addActionListener(this);
		vprin.btnChSim.addActionListener(this);
		vprin.btnCE.addActionListener(this);
		vprin.btnDel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()== vprin.btn0)
		{
			if(mod.seMostroResultado) 
			{
				mod.seMostroResultado = false;
				vprin.txtDisplay.setText("0");
				mod.btnC();
			}
			vprin.txtDisplay.setText(mod.btn0(vprin.txtDisplay.getText()));
		}
		else if(e.getSource()== vprin.btn1)
		{
			if(mod.seMostroResultado) 
			{
				mod.seMostroResultado = false;
				vprin.txtDisplay.setText("0");
				mod.btnC();
			}
			vprin.txtDisplay.setText(mod.btn1(vprin.txtDisplay.getText()));			
		}
		else if(e.getSource()== vprin.btn2)
		{
			if(mod.seMostroResultado) 
			{
				mod.seMostroResultado = false;
				vprin.txtDisplay.setText("0");
				mod.btnC();
			}
			vprin.txtDisplay.setText(mod.btn2(vprin.txtDisplay.getText()));	
		}
		else if(e.getSource()== vprin.btn3)
		{
			if(mod.seMostroResultado) 
			{
				mod.seMostroResultado = false;
				vprin.txtDisplay.setText("0");
				mod.btnC();
			}
			vprin.txtDisplay.setText(mod.btn3(vprin.txtDisplay.getText()));
		}
		else if(e.getSource()== vprin.btn4)
		{
			if(mod.seMostroResultado) 
			{
				mod.seMostroResultado = false;
				vprin.txtDisplay.setText("0");
				mod.btnC();
			}
			vprin.txtDisplay.setText(mod.btn4(vprin.txtDisplay.getText()));
		}
		else if(e.getSource()== vprin.btn5)
		{
			if(mod.seMostroResultado) 
			{
				mod.seMostroResultado = false;
				vprin.txtDisplay.setText("0");
				mod.btnC();
			}
			vprin.txtDisplay.setText(mod.btn5(vprin.txtDisplay.getText()));
		}
		else if(e.getSource()== vprin.btn6)
		{
			if(mod.seMostroResultado) 
			{
				mod.seMostroResultado = false;
				vprin.txtDisplay.setText("0");
				mod.btnC();
			}
			vprin.txtDisplay.setText(mod.btn6(vprin.txtDisplay.getText()));
		}
		else if(e.getSource()== vprin.btn7)
		{
			if(mod.seMostroResultado) 
			{
				mod.seMostroResultado = false;
				vprin.txtDisplay.setText("0");
				mod.btnC();
			}
			vprin.txtDisplay.setText(mod.btn7(vprin.txtDisplay.getText()));
		}
		else if(e.getSource()== vprin.btn8)
		{
			if(mod.seMostroResultado) 
			{
				mod.seMostroResultado = false;
				vprin.txtDisplay.setText("0");
				mod.btnC();
			}
			vprin.txtDisplay.setText(mod.btn8(vprin.txtDisplay.getText()));
		}
		else if(e.getSource()== vprin.btn9)
		{
			if(mod.seMostroResultado) 
			{
				mod.seMostroResultado = false;
				vprin.txtDisplay.setText("0");
				mod.btnC();
			}
			vprin.txtDisplay.setText(mod.btn9(vprin.txtDisplay.getText()));
		}
		else if(e.getSource()== vprin.btnDot)
		{
			vprin.txtDisplay.setText(mod.btnDot(vprin.txtDisplay.getText()));
		}
		else if(e.getSource()== vprin.btnSum)
		{
			vprin.txtDisplay.setText(mod.Sumar(vprin.txtDisplay.getText()));
			//System.out.println("Valor actual despues "+mod.valorActual);
		}
		else if(e.getSource()== vprin.btnMult)
		{
			vprin.txtDisplay.setText(mod.Multi(vprin.txtDisplay.getText()));
		}
		else if(e.getSource()== vprin.btnRes)
		{
			vprin.txtDisplay.setText(mod.Restar(vprin.txtDisplay.getText()));
		}
		else if(e.getSource()== vprin.btnDiv)
		{
			vprin.txtDisplay.setText(mod.Div(vprin.txtDisplay.getText()));
		}
		else if(e.getSource()== vprin.btnIgual)
		{
			vprin.txtDisplay.setText(mod.btnIgual(vprin.txtDisplay.getText()));
			//System.out.println("Valor actual despues "+mod.valorActual);
		}
		else if(e.getSource()== vprin.btnC)
		{
			vprin.txtDisplay.setText("0");
			mod.btnC();
		}
		else if(e.getSource()== vprin.btnChSim)
		{
			vprin.txtDisplay.setText(mod.btnChSim(vprin.txtDisplay.getText()));
		}
		else if(e.getSource()== vprin.btnChSim)
		{
			vprin.txtDisplay.setText(mod.btnChSim(vprin.txtDisplay.getText()));
		}
		else if(e.getSource()== vprin.btnCE)
		{
			mod.SoundManager(11);
			vprin.txtDisplay.setText("0");
		}
		else if(e.getSource()== vprin.btnDel)
		{
			vprin.txtDisplay.setText(mod.btnDel(vprin.txtDisplay.getText()));
		}
	}
}
