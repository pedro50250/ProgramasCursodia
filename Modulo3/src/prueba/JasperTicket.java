package prueba;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class JasperTicket {

    public static void main(String[] args) {
        try {
            /* User home directory location */
          // String userHomeDirectory = System.getProperty("user.home");
            /* Output file location */

        	
            String outputFile = "C:/Users/Pedro Alarcon/Desktop/Ticket de Compra.pdf";

            /* List to hold Items */
            List<articulo> listItems = new ArrayList<articulo>();

            for(int i=0;i<100;i++)
            {
            	listItems.add(new articulo(i,"nombre" + i, 1, 102.3f + i, 12 + i, 100));
            }
            float total = 120.25f;
            /* Convert List to JRBeanCollectionDataSource */
            JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(listItems);

            /* Map to hold Jasper report Parameters */
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("ItemDataSource", itemsJRBean);
            parameters.put("Total", total);

            /* Using compiled version(.jasper) of Jasper report to generate PDF */
            JasperPrint jasperPrint = JasperFillManager.fillReport("reportes/template_Table.jasper", parameters, new JREmptyDataSource());

            /* outputStream to create PDF */
            OutputStream outputStream = new FileOutputStream(new File(outputFile));
            /* Write content to PDF file */
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            
            JOptionPane.showMessageDialog(null, "Ticket Generado");
        } catch (JRException ex) {
            ex.printStackTrace(System.out);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
}