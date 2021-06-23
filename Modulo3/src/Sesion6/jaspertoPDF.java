package Sesion6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

public class jaspertoPDF {

	public static void main(String[] args) throws JRException, IOException {
		
		String servidor ="jdbc:mysql://localhost/learningsql";
		String usuarioDB= "student";
		String passwordDB ="Pe5025000";
		Connection conect = null;
		try
		{
			conect = DriverManager.getConnection(servidor,usuarioDB,passwordDB);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		if(conect !=null)
		{
			System.out.println("Conexion exitosa");
		
		}
		
		JasperPrint jasperPrint = JasperFillManager.fillReport("reportes/FirstJasperReport.jasper",null,conect);
		JRPdfExporter exp = new JRPdfExporter();
		exp.setExporterInput(new SimpleExporterInput(jasperPrint));
		exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteBanco.pdf"));
		SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
		exp.setConfiguration(conf);
		exp.exportReport();
		
		JasperPrint jasperPrintWindow = JasperFillManager.fillReport("reportes/FirstJasperReport.jasper", null,conect);
		JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow);
		jasperViewer.setVisible(true);
		
	}

}
