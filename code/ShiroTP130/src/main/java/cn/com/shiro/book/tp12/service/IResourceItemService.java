package cn.com.shiro.book.tp12.service;

import java.util.List;

import cn.com.shiro.book.tp12.entity.ShrResourceItem;

public interface IResourceItemService {
    /**
     * 获取所有的资源项对象
     * */
	List<ShrResourceItem> searchAllResourceItems();
}
