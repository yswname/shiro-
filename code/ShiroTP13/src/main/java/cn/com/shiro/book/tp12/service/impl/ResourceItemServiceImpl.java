package cn.com.shiro.book.tp12.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shiro.book.tp12.dao.IShrResourceItemDAO;
import cn.com.shiro.book.tp12.entity.ShrResourceItem;
import cn.com.shiro.book.tp12.service.IResourceItemService;
@Transactional
@Service("resourceItemServiceImpl")
public class ResourceItemServiceImpl implements IResourceItemService {
	@Autowired
	@Qualifier("shrResourceItemDAOImpl")
    private IShrResourceItemDAO itemDAO;
	@Override
	public List<ShrResourceItem> searchAllResourceItems() {
		return this.itemDAO.selectAll();
	}

}
