package dacstpi.beans;

import java.awt.HeadlessException;
import java.io.*;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 *
 * @author ea24
 */
public class mailBean {
    Properties mailProps;

    public mailBean(Properties mailProps) {
        this.mailProps = mailProps;
    }

    public boolean sendMail(String user, String pass, String recipient) {

        try {
            Session session = Session.getDefaultInstance(mailProps, null ) ;
            session.setDebug(true ) ;
            //Se compone la parte del texto
            BodyPart text = new MimeBodyPart( ) ;
            text.setContent("resources/img/BannerBorchi.jpg", "text/html" ) ;


            // Se compone el archivo adjunto
            BodyPart attached = new MimeBodyPart( ) ;
            attached.setDataHandler(new DataHandler(new FileDataSource("C:\\Users\\alan\\Desktop\\Gordi recatate no tome tanto porque me deja mal con la criatura.txt" ) ) ) ;
            attached.setFileName("Archivo adjunto.doc" ) ;

            // Una MultiParte para agrupar texto y adjunto.
            MimeMultipart multiPart = new MimeMultipart( ) ;
            multiPart.addBodyPart(text) ;
            multiPart.addBodyPart(attached ) ;

            // Se compone el correo, dando to, from, subject y el contenido.
            MimeMessage message = new MimeMessage(session ) ;
            message.setFrom(new InternetAddress(user) ) ;
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient) ) ;
            message.setSubject("Detalles de compra" ) ;
            message.setContent(multiPart ) ;

            // Se envia el correo.
            Transport transport = session.getTransport("smtp" ) ;
            transport.connect(user, pass ) ;
            transport.sendMessage(message, message.getAllRecipients() ) ;
            transport.close( ) ;
        } catch (HeadlessException e) {
            System.out.println(e.getMessage() ) ;
            return false;
        } catch (MessagingException e) {
            System.out.println(e.getMessage() ) ;
            return false;
        }
        return true;
    }

}






//Main


