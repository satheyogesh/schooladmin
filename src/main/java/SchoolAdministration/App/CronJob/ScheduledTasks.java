/**
 * 
 */
/**
 * @author ysathe
 *
 */
package SchoolAdministration.App.CronJob;

import java.sql.ResultSet;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import SchoolAdministration.util.SqlServerUtils;

@Component
public class ScheduledTasks {
	
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	
//	@Scheduled(cron = "0/20 * * * * ?")
	
	@Scheduled(fixedDelay = 2000)
	public void scheduleTaskWithInitialDelay() {
		System.out.println("Scheduled task running");
		sendEmail("satheyogesh@gmail.com","Testing task");
	}
	
	
/*	 @Scheduled(fixedDelay = 1000, initialDelay = 10000)
    public void VerifyTasksAndSendEmails() {
		
		try {

		SqlServerUtils sql = new SqlServerUtils();
		sql.connect();
		ResultSet resultSet = sql.SelectData("SELECT * FROM tasks order by dt desc");

		System.out.println("Scheduled task running");
		sendEmail("satheyogesh@gmail.com","Testing task");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	*/
	private void sendEmail(String sendEmailTo,String taskDesc) 
	{
		try {

		
		// Step1
				System.out.println("\n 1st ===> setup Mail Server Properties..");
				mailServerProperties = System.getProperties();
				mailServerProperties.put("mail.smtp.port", "587");
				mailServerProperties.put("mail.smtp.auth", "true");
				mailServerProperties.put("mail.smtp.starttls.enable", "true");
				System.out.println("Mail Server Properties have been setup successfully..");
		 
				// Step2
				System.out.println("\n\n 2nd ===> get Mail Session..");
				getMailSession = Session.getDefaultInstance(mailServerProperties, null);
				generateMailMessage = new MimeMessage(getMailSession);
				generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(sendEmailTo));
				generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("satheyogesh@hotmail.com"));
				generateMailMessage.setSubject("Reminder " + taskDesc);
				String emailBody = "Reminder " + taskDesc;
				generateMailMessage.setContent(emailBody, "text/html");
				System.out.println("Mail Session has been created successfully..");
		 
				// Step3
				System.out.println("\n\n 3rd ===> Get Session and Send mail");
				Transport transport = getMailSession.getTransport("smtp");
		 
				// Enter your correct gmail UserID and Password
				// if you have 2FA enabled then provide App Specific Password
				transport.connect("smtp.gmail.com", "", "");
				transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
				transport.close();
				
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

    }


}