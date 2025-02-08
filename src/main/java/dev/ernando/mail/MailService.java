package dev.ernando.mail;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailService {
    private static final Logger log = Logger.getLogger(MailService.class.getName());

    private static final String EMAIL_SENDER = "your@gmail.com";
    private static final String PASSWORD = "your_password"; // Use App Password
    private static final String RECIPIENT = "recipients here";
    private static final String ATTACHMENT_PATH = "file.xlsx";

    public static void main(String[] args) {
        sendEmail();
    }

    // Send email with attachment
    public static void sendEmail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_SENDER, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_SENDER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(RECIPIENT));
            message.setSubject("User Report");

            // E-mail body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("The list of users is attached.");

            // Attachment
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File(ATTACHMENT_PATH));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Mail sent successful!");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed sending email {}", e.getMessage());
        }
    }
}

