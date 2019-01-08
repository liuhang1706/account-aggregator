package com.liuhang.mvnbook.account.persist;

/**
 * 请填写类注释
 *
 * @author hang.liu01
 * @since 2018年12月21日
 */
public class AccountPersistException extends Exception {
    private static final long serialVersionUID = -4253621481934350797L;

    AccountPersistException(){
        super();
    }
    AccountPersistException(String message, Throwable throwable) {
        super(message,throwable);
    }
}
