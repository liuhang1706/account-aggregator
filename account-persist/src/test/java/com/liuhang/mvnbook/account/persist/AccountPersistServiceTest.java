package com.liuhang.mvnbook.account.persist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * 请填写类注释
 *
 * @author hang.liu01
 * @since 2018年12月21日
 */
public class AccountPersistServiceTest {

    private AccountPersistService service;

    @Before
    public void prepare() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-persist.xml");
        service = (AccountPersistService)ctx.getBean("accountPersistService");
    }

    @Test
    public void testReadAccount() throws Exception{
        Account account = service.readAccount("liuhang");
        Assert.assertNotNull(account);
        Assert.assertEquals("Liu Hang", account.getName());
        Assert.assertEquals("hang.liu01@qq.com", account.getEmail());
        Assert.assertEquals("`1212", account.getPassword());
    }
}
