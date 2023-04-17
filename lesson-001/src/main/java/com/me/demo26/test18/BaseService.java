package com.me.demo26.test18;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @title: BaseService
 * @author: GXW
 * @date: 2023/4/17 20:14
 */
public class BaseService<T> {

    @Autowired
    private IDao<T> dao; //@1

    public IDao<T> getDao() {
        return dao;
    }

    public void setDao(IDao<T> dao) {
        this.dao = dao;
    }

}
