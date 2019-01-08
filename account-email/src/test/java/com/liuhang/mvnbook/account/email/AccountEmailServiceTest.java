package com.liuhang.mvnbook.account.email;

import com.icegreen.greenmail.util.GreenMailUtil;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.internet.MimeMessage;
import java.util.ArrayList;

/**
 * 请填写类注释
 *
 * @author hang.liu01
 * @since 2018年12月18日
 */
public class AccountEmailServiceTest {

    private GreenMail greenMail;

    @Before
    public void startEmailService() throws Exception{
        greenMail = new GreenMail(ServerSetup.SMTP);
        greenMail.setUser("test@liuhang.com","123456");
        greenMail.start();
    }

    @Test
    public void testSendEmail() throws Exception{
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("account-email.xml");
        AccountEmailService accountEmailService =
            (AccountEmailService)classPathXmlApplicationContext.getBean("accountEmailService");
        String subject = "Test Subject";
        String htmlText = "<h1>Test</h1>";
        accountEmailService.sendEmail("test@liuhang.com",subject,htmlText);
        greenMail.waitForIncomingEmail(2000,1);

        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
        Assert.assertEquals(1,receivedMessages.length);
        Assert.assertEquals(subject,receivedMessages[0].getSubject());
        Assert.assertEquals(htmlText,GreenMailUtil.getBody(receivedMessages[0]).trim());
    }

    @Test
    public void testCompile() throws Exception{
        ArrayList<String> strings = new ArrayList<>();
    }

    @After
    public void stopMailServer() throws Exception{
        greenMail.stop();
    }
}
