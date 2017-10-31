package cn.com.shiro.book.tp12.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shiro.book.tp12.dao.IShrResourceDAO;
import cn.com.shiro.book.tp12.entity.ShrResource;
import cn.com.shiro.book.tp12.entity.ShrResourceItem;
import cn.com.shiro.book.tp12.service.IResourceService;

@Service("resourceServiceImpl")
@Transactional
public class ResourceServiceImpl implements IResourceService {
	@Autowired
	@Qualifier("shrResourceDAOImpl")
	private IShrResourceDAO resDAO;

	@Transactional(readOnly = true)
	@Override
	public ShrResource findResourceById(int id) {
		return this.resDAO.selectByPrimaryKey(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addResource(ShrResource resource,
			List<ShrResourceItem> resItemList) {
		// 对输入的数据进行基本验证
		if (resource == null || resource.getRscName() == null) {
			throw new RuntimeException("输入的数据不完整");
		}
		// 创建DAO
		// IShrResourceDAO resDAO = new ShrResourceDAOImpl();
		// 装配source和item之间的关系
		if (resItemList != null) {
			for (ShrResourceItem item : resItemList) {
				// 在资源中添加item
				resource.getShrResourceItems().add(item);
				// 在item中设置资源
				item.setShrResource(resource);
			}
		}
		// 调用dAO保存source
		resDAO.insert(resource);
	}

	@Override
	public void editResource(ShrResource resource,
			List<ShrResourceItem> resItemList) {
		ShrResource dbResource = this.resDAO.selectByPrimaryKey(resource
				.getRscId());
		if (dbResource != null) {
			dbResource.setRscName(resource.getRscName());
			dbResource.setRscRemark(resource.getRscRemark());
			for (ShrResourceItem item : resItemList) {
				if (item.getItmId() == null || item.getItmId() == -1) {
					dbResource.getShrResourceItems().add(item);
					item.setShrResource(dbResource);
				} else {
					for (ShrResourceItem dbItem : dbResource
							.getShrResourceItems()) {
						if (dbItem.getItmId() == item.getItmId()) {
							dbItem.setItmRemark(item.getItmRemark());
							dbItem.setItmType(item.getItmType());
							dbItem.setItmUrl(item.getItmUrl());
							break;
						}
					}
				}
			}
			this.resDAO.updateByPrimaryKey(dbResource);
		} else {
			throw new RuntimeException("修改的资源不存在");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShrResource> findAllResources() {
		ShrResource record = new ShrResource();
		return this.resDAO.selectSelective(record);
	}

}
