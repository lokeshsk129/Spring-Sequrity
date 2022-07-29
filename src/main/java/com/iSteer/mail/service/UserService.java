package com.iSteer.mail.service;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iSteer.mail.model.UserPojo;
import com.iSteer.mail.repository.UserRepository;
import com.iSteer.mail.repository.UserSessionRepository;
import com.iSteer.mail.tokenGen.Cache;
import com.iSteer.mail.tokenGen.TokenGenerator;
import com.iSteer.mail.user.User;

@Service
public class UserService {

	@Autowired
	UserSessionRepository userSessionRepository;

	@Autowired
	UserRepository userRepository;

	String timeStamp = null;
	String userPresent = null;
	
    /*fixing the length of OTP */
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
     }

	/*User id verification and sending OTP*/
	public String userIdVerification(UserPojo request) {
        String to = request.getUserEmail();
		String from = "lokesh.s@isteer.com";
		Properties p = new Properties();
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(p, new javax.mail.Authenticator() {
		protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
		return new javax.mail.PasswordAuthentication("lokesh.s@isteer.com", "noochwmrmchiwpct");
			}
		});
		try {
			int n = 4;
			int rand_int;
			if (n == 4) {
				rand_int = getRandomNumber(1000, 9999);
			} else {
				rand_int = getRandomNumber(1000000, 9999999);
			}

			
			if (Cache.otpMap.containsKey(request.getUserEmail())) {
				Cache.otpMap.remove(request.getUserEmail());
				Cache.otpMap.put(request.getUserEmail(), rand_int);
				timeStamp = new SimpleDateFormat("yy/MM/dd HH:mm:ss").format(new Date());
				Cache.otpSessionMap.put(rand_int, timeStamp);

				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(to)));

				message.setSubject("your OTP is" + " " + rand_int);
				message.setSubject("iSteer Registration");
				message.setText("your OTP is" + " " + rand_int);
				Transport.send(message);

				System.out.println("message send");
			} else {
				Cache.otpMap.put(request.getUserEmail(), rand_int);
				timeStamp = new SimpleDateFormat("yy/MM/dd HH:mm:ss").format(new Date());
				Cache.otpSessionMap.put(rand_int, timeStamp);

				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(to)));
				message.setSubject("your OTP is" + rand_int);
				message.setSubject("iSteer Registration");
				message.setText("your OTP is" + " " + rand_int);
				Transport.send(message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "OTP sent successfully please verify to Register";
}
	
	
      /*verifying the OTP and sending success to user*/
	  public String otpVerify(UserPojo request) throws NoSuchAlgorithmException {
            if (Cache.otpSessionMap.containsKey(request.getOtp())) {
			String otpSendTime = Cache.otpSessionMap.get(request.getOtp());
            Date d1 = null;
			Date d2 = new Date();

			SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
			try {
				d1 = format.parse(otpSendTime);

			} catch (Exception e) {
				e.printStackTrace();
			}

			long diff = d2.getTime() - d1.getTime();
			long diffMin = diff / (60 * 1000);

			if (diffMin > 1) {
				return "otp expired";
			}
		}
		if (Cache.otpMap.containsKey(request.getUserEmail())) {

			int value = Cache.otpMap.get(request.getUserEmail());
			if (value == request.getOtp()) {

				String hash = request.getUserEmail() + request.getOtp();
				String token = TokenGenerator.MD5(hash);
				Cache.sessionInfo.put(token, request.getUserEmail());
				try {
					userPresent = userSessionRepository.findById(request.getUserEmail());
				}

				catch (NullPointerException e) {
					e.printStackTrace();
				}
				if (userPresent != null) {
					String login = timeStamp = new SimpleDateFormat("yy/MM/dd HH:mm:ss").format(new Date());
					String logout = null;
					userSessionRepository.updateToken(request.getUserEmail(), token, login, logout);
				} else {
					String login = timeStamp = new SimpleDateFormat("yy/MM/dd HH:mm:ss").format(new Date());
					userSessionRepository.insertToken(request.getUserEmail(), token, login);
				}

				return token;
            }

		}
		return "not verified";

	}

	public User createUser(User user) {
		return this.userRepository.save(user);

	}
}
