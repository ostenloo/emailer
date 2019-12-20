package com.realtez.emailer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTests {

	@Autowired
	MailService mailSrv;

	static String smtpServer = "smtp.secureserver.net";
	static String smtpPort = "587";
	static String from = "communication@realtez.com";
	static String to = "xin.liudfdf@rentacenter.com";
	
 
	@Test
	public void sendMailTest() {
	 
		mailSrv.sendMail(to, "test", "This is just a test message");
	}

}
