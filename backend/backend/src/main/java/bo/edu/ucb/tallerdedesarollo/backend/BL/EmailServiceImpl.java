package bo.edu.ucb.tallerdedesarollo.backend.BL;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.ibatis.javassist.compiler.ast.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import bo.edu.ucb.tallerdedesarollo.backend.DTO.EventoRecepcionDTO;

@Component
public class EmailServiceImpl{

    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    public void sendSimpleMessage(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        emailSender.send(message);
    }
     
    public void templatesMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(to);
        message.setSubject(subject);
        
        message.setText(text);
        emailSender.send(message);
    }
    public void sendHtmlEmail(String to, String subject, String titulo, EventoRecepcionDTO detalle) throws MessagingException {
        System.out.println("Esto es la data"+ detalle);
        MimeMessage message = emailSender.createMimeMessage();
    
        message.setFrom("noreply@baeldung.com");
        message.setRecipients(MimeMessage.RecipientType.TO, to);
        message.setSubject(subject);
        String htmlContent = "<h1>Titulo:"+ detalle.getTitulo()+"</h1>" +
                             "<h2>Descripcion:"+detalle.getDescripcion() +"</h2>"+
                             "<img src="+fileSystemStorageService.loadAsResource(detalle.getId_imagen()) +">";
        message.setContent(htmlContent, "text/html"); 
        // message.setContent(htmlContent, "text/html; charset=utf-8");
    
        emailSender.send(message);
        
    }
}
