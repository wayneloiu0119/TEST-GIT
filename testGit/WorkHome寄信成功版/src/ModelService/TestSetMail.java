package ModelService;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ModelBean.MemberBean;
import ModelDAO.MemberDAO;

public class TestSetMail {

	public  MemberBean setMail(MemberBean mb ) {
		
		String host = "smtp.gmail.com";
		  int port = 587;
		  
		  final String username = "wayne.liutest@gmail.com";
		  final String password = "28432253";//your password
		 

		  Properties props = new Properties();
		  props.put("mail.smtp.host", host);
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.starttls.enable", "true");
		  props.put("mail.smtp.port", port);
		  Session session = Session.getInstance(props, new Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		    return new PasswordAuthentication(username, password);
		   }
		  });

		  try {

		   Message message = new MimeMessage(session);
		   message.setFrom(new InternetAddress("wayne.liutest@gmail.com"));
		   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mb.getEmail()));
		   message.setSubject("您的密碼");
		   message.setText(mb.getName()+"您好:"+"您的密碼為"+mb.getPassword());

		   Transport transport = session.getTransport("smtp");
		   transport.connect(host, port, username, password);

		   Transport.send(message);

		   System.out.println("寄送email結束.");

		  } catch (MessagingException e) {
		   throw new RuntimeException(e);
		  }
		return null;
		
		
		
	}
}
