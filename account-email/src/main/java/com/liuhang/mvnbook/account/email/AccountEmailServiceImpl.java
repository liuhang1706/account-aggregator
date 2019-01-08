package com.liuhang.mvnbook.account.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 请填写类注释
 *
 * @author hang.liu01
 * @since 2018年12月17日
 */
public class AccountEmailServiceImpl implements AccountEmailService {

    private JavaMailSender javaMailSender;

    private String systemEmail;

    @Override
    public void sendEmail(String to, String subject, String htmlText) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(systemEmail);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(htmlText);
            javaMailSender.send(mimeMessage);
        } catch(MessagingException e) {
            e.printStackTrace();
        }
    }

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }
}
