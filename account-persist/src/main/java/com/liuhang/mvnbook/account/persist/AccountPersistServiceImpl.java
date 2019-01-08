package com.liuhang.mvnbook.account.persist;

/**
 * 请填写类注释
 *
 * @author hang.liu01
 * @since 2018年12月21日
 */
public class AccountPersistServiceImpl implements AccountPersistService {

    @Override
    public Account readAccount(String id) throws AccountPersistException {
        Account account = new Account();
        account.setId("liuhang");
        account.setName("Liu Hang");
        account.setEmail("hang.liu01@qq.com");
        account.setPassword("`1212");
        return account;
    }

}
