package cn.com.shiro.book.tp12.service;

import cn.com.shiro.book.tp12.entity.ShrSession;

public interface ISessionService {
    public ShrSession addSession(ShrSession session);
    public ShrSession updateSession(ShrSession session);
    public void deleteSession(ShrSession session);
    public ShrSession searchSessionById(String sessionId);
}
