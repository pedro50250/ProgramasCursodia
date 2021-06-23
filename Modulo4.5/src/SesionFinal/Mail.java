package SesionFinal;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	public static void main(String[] args) throws IOException {
		Mail mail =  new Mail();
		mail.sendMailComp("Pedro.2001@live.com.mx", "Pedrooo", "pedro.alarcon50250@outlook.com", "pE2121200");

	}
	
	public void sendMailComp(String _email,String _nombre, String _usuario, String _contrase�a) throws IOException
	{
		//final String username="";
		//final String password="";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(_usuario,_contrase�a);
			}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(_usuario));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(_email) );
			message.setSubject("Correo de Bienvenida");
			message.setText("<!DOCTYPE HTML>\r\n" + 
					"<html>\r\n" + 
					"  <head>\r\n" + 
					"    <title>C�mo hacer una p�gina web con HTML</title>\r\n" + 
					"  </head>\r\n" + 
					"  <body>\r\n" + 
					"    <h1>C�mo hacer una p�gina web con HTML</h1>\r\n" + 
					"    <p> En el post de hoy voy a ense�arte <strong>c�mo hacer una p�gina web con HTML</strong>, pero antes �</p>\r\n" + 
					"    <h2>Conceptos b�sicos sobre p�ginas web</h2>\r\n" + 
					"    <p>�Cu�l es entonces la diferencia entre una p�gina web y un sitio web?�</p>\r\n" + 
					"    <h3>Diferencias entre una p�gina web y un sitio web</h3>\r\n" + 
					"    <p>Una <a href=�https://es.wikipedia.org/wiki/P%C3%A1gina_web�>p�gina web</a> es un <strong>�nico documento electr�nico</strong> que�</p>\r\n" + 
					"  </body>\r\n" + 
					"</html>");
			Transport.send(message);
			System.out.println("Enviado correctamente");
			
		}
		catch(MessagingException e)
		{
			throw new RuntimeException(e);
		}
	}

}
