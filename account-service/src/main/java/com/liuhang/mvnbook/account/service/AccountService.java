package com.liuhang.mvnbook.account.service;

/**
 * 请填写类注释
 *
 * @author hang.liu01
 * @since 2019年01月02日
 */
public interface AccountService {

    byte[] generateCaptchaImage(String captchaKey) throws Exception;

    String generateCaptchaKey() throws Exception;
}
