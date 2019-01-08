package com.liuhang.mvnbook.account.captcha;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashSet;

/**
 * 请填写类注释
 *
 * @author hang.liu01
 * @since 2018年12月29日
 */
public class RandomGeneratorTest {

    @Test
    public void testGetRandomString() throws Exception{
        HashSet<String> randoms = new HashSet<>(100);
        for (int i = 0; i < 100; i++) {
            String randomString = RandomGenerator.getRandomString();
            Assert.assertFalse(randoms.contains(randomString));
            randoms.add(randomString);
        }
    }
}
