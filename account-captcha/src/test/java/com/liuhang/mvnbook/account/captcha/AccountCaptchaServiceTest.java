package com.liuhang.mvnbook.account.captcha;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * 请填写类注释
 *
 * @author hang.liu01
 * @since 2018年12月29日
 */
public class AccountCaptchaServiceTest {

    private AccountCaptchaService service;

    @BeforeMethod
    public void prepare() throws Exception{
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("account-captcha.xml");
        service = (AccountCaptchaService) ctx.getBean("accountCaptchaService");
    }

    @Test
    public void testGenerateCaptcha() throws Exception{
        String captchaKey = service.generateCaptchaKey();
        Assert.assertNotNull(captchaKey);
        byte[] bytes = service.generateCaptchaImage(captchaKey);
        Assert.assertTrue(bytes.length >0);
        File image = new File("target/" + captchaKey + ".jpg");
        OutputStream outPut = null;
        try {
            outPut = new FileOutputStream(image);
            outPut.write(bytes);
        } finally {
            if (outPut != null) {
                outPut.close();
            }
        }
        Assert.assertTrue(image.exists() && image.length()>0);
    }

    @Test
    public void testValidateCaptchaCorrect() throws Exception{
        ArrayList<String> preDefinedTexts = new ArrayList<>();
        preDefinedTexts.add("12345");
        preDefinedTexts.add("abcde");
        service.setPreDefinedTexts(preDefinedTexts);
        String captchaKey = service.generateCaptchaKey();
        service.generateCaptchaImage(captchaKey);
        Assert.assertTrue(service.validateCaptcha(captchaKey,"12345"));
        captchaKey = service.generateCaptchaKey();
        service.generateCaptchaImage(captchaKey);
        Assert.assertTrue(service.validateCaptcha(captchaKey,"abcde"));
    }

    @Test
    public void testValidateCaptchaIncorrect() throws Exception{
        ArrayList<String> preDefinedTexts = new ArrayList<>();
        preDefinedTexts.add("123456");
        service.setPreDefinedTexts(preDefinedTexts);
        String captchaKey = service.generateCaptchaKey();
        service.generateCaptchaImage(captchaKey);
        Assert.assertFalse(service.validateCaptcha(captchaKey,"67890"));
    }
}
