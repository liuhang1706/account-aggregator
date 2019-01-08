package com.liuhang.mvnbook.account.email;

/**
 * 请填写类注释
 *
 * @author hang.liu01
 * @since 2018年12月17日
 */
public interface AccountEmailService {

    void sendEmail(String to, String subject, String htmlText);
}
