package cn.com.shiro.book.tp12.dao;

import java.io.Serializable;

import cn.com.shiro.book.tp12.entity.ShrSession;

public interface IShrSessionDAO {
    int deleteByPrimaryKey(Serializable id);
    int insert(ShrSession session);
    int update(ShrSession session);
    ShrSession selectByPrimaryKey(Serializable id);
}
