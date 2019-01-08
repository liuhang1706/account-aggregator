package com.liuhang.mvnbook.account.persist;

/**
 * 请填写类注释
 *
 * @author hang.liu01
 * @since 2018年12月21日
 */
public interface AccountPersistService {

    /**
     * 查
     * @param id
     * @return
     * @throws AccountPersistException
     */
    Account readAccount(String id) throws AccountPersistException;
}
