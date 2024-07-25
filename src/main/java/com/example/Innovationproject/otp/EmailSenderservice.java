package com.example.Innovationproject.otp;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderservice {

	
	@Autowired
	private JavaMailSender mailSender;
	
	
	public String sendSimpleEmail(String toemail,String otp,String body,String subjcetString) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("prasanna.vsp80@gmail.com");
		message.setTo(toemail);
		message.setText(otp);
		message.setText(body);
		message.setSubject(subjcetString);
		try {
            mailSender.send(message);
            return "successfully";
        } catch (MailException e) {
             //Log the exception (you can use a logger here)
            e.printStackTrace();
            return "failed";
        }
		
	}
	public String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // Generate a 6-digit OTP
        return String.valueOf(otp);
    }
}
