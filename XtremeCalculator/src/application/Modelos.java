package application;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Modelos 
{
	/* Version 1.0  23/05/2020
	 * Ejemplo Modelo-Vista-Controlador
	 * Creado por: Dr. Carlos Adrian Perez Cortez
	 * Para: Cursodia Diplomado Java 14
	 */
	double valorAlmacenado=0d, valorActual=0d;
	boolean haciendoSuma=false, haciendoResta=false, haciendoMul=false, haciendoDiv=false, reiniciar=false;
	boolean primerpar =false, seMostroResultado = false;
	ArrayList<String> sounds = new ArrayList<String>();
	String Sumar(String val)
	{
		SoundManager(18);
		double valor = Double.parseDouble(val);
		if(valor != 0d)
		{
			if(valorActual == 0)
			{
				valorActual = valor;
				primerpar=true;
			}
			else
			{	
				if(seMostroResultado)
				{
					seMostroResultado = false;
				}
				else
				{
					valorActual += valor;
				}
				primerpar=true;
			}
		}
		haciendoSuma = true;
		haciendoResta= false;
		haciendoMul = false;
		haciendoDiv = false;
		//System.out.println("ValorActual: "+valorActual+" Valor:"+valor);
		return "0";
	}
	String Restar(String val)
	{
		SoundManager(17);
		double valor = Double.parseDouble(val);
		if(valor != 0d)
		{
			if(valorActual == 0)
			{
				valorActual = valor;
				primerpar=true;
			}
			else
			{	
				if(seMostroResultado)
				{
					seMostroResultado = false;
				}
				else
				{
					valorActual -= valor;
					
				}
				primerpar=true;
			}
		}
		haciendoSuma = false;
		haciendoResta= true;
		haciendoMul = false;
		haciendoDiv = false;
		//System.out.println("ValorActual: "+valorActual+"\nValor"+valor);
		return "0";
	}
	String Multi(String val)
	{
		SoundManager(16);
		double valor = Double.parseDouble(val);
		if(valor != 0d)
		{
			if(valorActual == 0)
			{
				valorActual = valor;
				primerpar=true;
			}
			else
			{	
				if(seMostroResultado)
				{
					seMostroResultado = false;
				}
				else
				{
					valorActual *= valor;
					
				}
				primerpar=true;
			}
		}
		haciendoSuma = false;
		haciendoResta= false;
		haciendoMul = true;
		haciendoDiv = false;
		return "0";
	}
	String Div(String val)
	{
		SoundManager(13);
		double valor = Double.parseDouble(val);
		
		if(valor != 0d)
		{
			if(valorActual == 0)
			{
				valorActual = valor;
				haciendoDiv=true;
				primerpar=true;
			}
			else
			{	
				if(seMostroResultado)
				{
					seMostroResultado = false;
				}
				else
				{
					valorActual = valorActual/valor;
				}
				primerpar=true;
			}
		}
		haciendoSuma = false;
		haciendoResta= false;
		haciendoMul = false;
		haciendoDiv = true;
		//System.out.println("Valor:"+valor+" ValorActual:"+valorActual);
		return "0";
	}
	String btn1(String strAnt)
	{
		SoundManager(1);
		if(seMostroResultado) seMostroResultado = false;
		String valret;
		if(strAnt.equals("0"))
		{
			valret = "1";
		}
		else
		{
			valret = strAnt+"1";
		}
		return valret;
	}
	String btn2(String strAnt)
	{
		SoundManager(2);
		if(seMostroResultado) seMostroResultado = false;
		String valret;
		if(strAnt.equals("0"))
		{
			valret = "2";
		}
		else
		{
			valret = strAnt+"2";
		}
		return valret;
	}
	String btn3(String strAnt)
	{
		SoundManager(3);
		if(seMostroResultado) seMostroResultado = false;
		String valret;
		if(strAnt.equals("0"))
		{
			valret = "3";
		}
		else
		{
			valret = strAnt+"3";
		}
		return valret;
	}
	String btn4(String strAnt)
	{
		SoundManager(4);
		if(seMostroResultado) seMostroResultado = false;
		String valret;
		if(strAnt.equals("0"))
		{
			valret = "4";
		}
		else
		{
			valret = strAnt+"4";
		}
		return valret;
	}
	String btn5(String strAnt)
	{
		SoundManager(5);
		if(seMostroResultado) seMostroResultado = false;
		String valret;
		if(strAnt.equals("0"))
		{
			valret = "5";
		}
		else
		{
			valret = strAnt+"5";
		}
		return valret;
	}
	String btn6(String strAnt)
	{
		SoundManager(6);
		if(seMostroResultado) seMostroResultado = false;
		String valret;
		if(strAnt.equals("0"))
		{
			valret = "6";
		}
		else
		{
			valret = strAnt+"6";
		}
		return valret;
	}
	String btn7(String strAnt)
	{
		SoundManager(7);
		if(seMostroResultado) seMostroResultado = false;
		String valret;
		if(strAnt.equals("0"))
		{
			valret = "7";
		}
		else
		{
			valret = strAnt+"7";
		}
		return valret;
	}
	String btn8(String strAnt)
	{
		SoundManager(8);
		if(seMostroResultado) seMostroResultado = false;
		String valret;
		if(strAnt.equals("0"))
		{
			valret = "8";
		}
		else
		{
			valret = strAnt+"8";
		}
		return valret;
	}
	String btn9(String strAnt)
	{
		SoundManager(9);
		if(seMostroResultado) seMostroResultado = false;
		String valret;
		if(strAnt.equals("0"))
		{
			valret = "9";
		}
		else
		{
			valret = strAnt+"9";
		}
		return valret;
	}
	String btn0(String strAnt)
	{
		SoundManager(0);
		if(seMostroResultado) seMostroResultado = false;
		String valret;
		if(strAnt.equals("0"))
		{
			valret = "0";
		}
		else
		{
			valret = strAnt+"0";
		}
					
		return valret;
	}
	String btnDot(String strAnt)
	{
		SoundManager(14);
		return strAnt+".";
	}
	
	String btnIgual(String val)
	{
		SoundManager(15);
		Double valor = Double.parseDouble(val);
		System.out.println(primerpar+" "+haciendoDiv);
		if(primerpar && haciendoSuma)
		{
			valorActual += valor;
			primerpar=false;
			//System.out.println("ValorActual: "+valorActual+" Valor:"+valor);
		}
		else if(primerpar && haciendoResta)
		{
			valorActual -= valor;
			primerpar=false;
		}
		else if(primerpar && haciendoMul)
		{
			valorActual *= valor;
			primerpar=false;
		}
		else if(primerpar && haciendoDiv)
		{
			valorActual = valorActual/valor;
			primerpar=false;
		}
		seMostroResultado = true;
		return ""+valorActual;
	}
	void btnC()
	{
		SoundManager(10);
		valorAlmacenado = 0d;
		valorActual = 0d;
		primerpar=false;
		haciendoSuma = false;
		haciendoResta = false;
		haciendoMul = false;
		haciendoDiv = false;
	}
	
	String btnChSim(String val)
	{
		SoundManager(19);
		Double valor = Double.parseDouble(val);
		valor = valor *-1;
		return ""+valor;
	}
	String btnDel(String val)
	{
		SoundManager(12);
		String result = null;
	    if ((val != null) && (val.length() > 0))
	   	{
		      result = val.substring(0, val.length() - 1);
		}
	    return result;
	}
	void SoundManager(int sel)
	{
		try {
			//URL tmp = getClass().getResource("/sounds/01.wav");
			System.out.println("sounds/"+sounds.get(sel));
		    File miarchivo = new File("sounds/"+sounds.get(sel));
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;
		    Clip clip;
		    System.out.println(miarchivo);
		    stream = AudioSystem.getAudioInputStream(new File("sounds/"+sounds.get(sel)));
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
		    System.out.println(clip);
		}
		catch (Exception e) 
		{
		    //whatevers
		}
	}
	public Modelos()
	{
		for(int i=0;i<10;i++)
		{
			sounds.add("0"+i+".wav");
		}
		sounds.add("igual.wav");  //10
		sounds.add("CE.wav"); //11
		sounds.add("DEL.wav"); //12
		sounds.add("division.wav");//13
		sounds.add("DOT.wav");//14
		sounds.add("C.wav");//15
		sounds.add("multip.wav");//16
		sounds.add("resta.wav");//17
		sounds.add("suma.wav");//18
		sounds.add("ChSim.wav");//19
		//System.out.println(sounds.size());
	}
}
