package com.liuhang.mvnbook.account.service;

import com.liuhang.mvnbook.account.captcha.AccountCaptchaService;
import com.liuhang.mvnbook.account.email.AccountEmailService;
import com.liuhang.mvnbook.account.persist.AccountPersistService;

import java.util.HashMap;
import java.util.Map;

/**
 * 请填写类注释
 *
 * @author hang.liu01
 * @since 2019年01月02日
 */
public class AccountServiceImpl implements AccountService {

    private AccountPersistService accountPersistService;

    private AccountEmailService accountEmailService;

    private AccountCaptchaService accountCaptchaService;

    private Map<String, String> activationMap = new HashMap<>();

    public AccountPersistService getAccountPersistService() {
        return accountPersistService;
    }

    public void setAccountPersistService(AccountPersistService accountPersistService) {
        this.accountPersistService = accountPersistService;
    }

    public AccountEmailService getAccountEmailService() {
        return accountEmailService;
    }

    public void setAccountEmailService(AccountEmailService accountEmailService) {
        this.accountEmailService = accountEmailService;
    }

    public AccountCaptchaService getAccountCaptchaService() {
        return accountCaptchaService;
    }

    public void setAccountCaptchaService(AccountCaptchaService accountCaptchaService) {
        this.accountCaptchaService = accountCaptchaService;
    }

    @Override
    public byte[] generateCaptchaImage(String captchaKey) throws Exception{
        try{
            return accountCaptchaService.generateCaptchaImage(captchaKey);
        }catch (Exception e){
            throw new Exception("Unable to generate captcha image",e);
        }
    }

    @Override
    public String generateCaptchaKey() throws Exception {
        try {
            return accountCaptchaService.generateCaptchaKey();
        } catch (Exception e){
            throw new Exception("Unable to generate captcha key",e);
        }
    }
}
