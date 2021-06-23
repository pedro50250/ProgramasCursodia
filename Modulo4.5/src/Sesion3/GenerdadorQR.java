package Sesion3;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.EnumMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class GenerdadorQR {

	public static void main(String[]args)
	{
		GenerdadorQR gen = new GenerdadorQR();
		gen.generarQR(null, null);
	}
	public void generarQR(String myCodeText, String filePath)
	{
		myCodeText = "Que onda";
		filePath = "C:\\Users\\pedro\\Desktop";
		int size=250;
		String fileType ="png";
		File myFile = new File(filePath);
		try
		{
			Map<EncodeHintType,Object> hintMap = new EnumMap<EncodeHintType,Object>(EncodeHintType.class);
			hintMap.put(EncodeHintType.CHARACTER_SET,"UTF-8");
			
			hintMap.put(EncodeHintType.MARGIN,1);
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix byteMatrix = qrCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE,size,size,hintMap);
			int Crunchifywidth = byteMatrix.getWidth();
			BufferedImage image = new BufferedImage(Crunchifywidth, Crunchifywidth, BufferedImage.TYPE_INT_RGB);
			image.createGraphics();
			Graphics2D graphics = (Graphics2D) image.getGraphics();
			graphics.setColor(Color.white);
			graphics.fillRect(0, 0, Crunchifywidth, Crunchifywidth);
			graphics.setColor(Color.BLACK);
			for(int i=0;i<Crunchifywidth;i++)
			{
				for(int j=0;j<Crunchifywidth;j++)
				{
					if(byteMatrix.get(i,j))
					{
						graphics.fillRect(i, j, 1, 1);
					}
				}
			}
			ImageIO.write(image, fileType, myFile);
			
			System.out.println("/n /n Se a creado el codigo QR exitosamente");
		}
		catch(Exception e)
		{
			
		}
	}
}
