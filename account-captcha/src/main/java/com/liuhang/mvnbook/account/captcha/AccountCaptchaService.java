package com.liuhang.mvnbook.account.captcha;

import java.util.List;

/**
 * 请填写类注释
 *
 * @author hang.liu01
 * @since 2018年12月28日
 */
public interface AccountCaptchaService {

    String generateCaptchaKey() throws Exception;

    byte[] generateCaptchaImage(String captchaKey) throws Exception;

    boolean validateCaptcha(String captchaKey, String captchaValue) throws Exception;

    List<String> getPreDefinedTexts();

    void setPreDefinedTexts(List<String> preDefinedTexts);
}
