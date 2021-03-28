package com.jchen.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @Auther: jchen
 * @Date: 2021/03/27/21:55
 */
@Repository("alphaHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao {

    @Override
    public String select() {
        return "Hibernate";
    }
}
