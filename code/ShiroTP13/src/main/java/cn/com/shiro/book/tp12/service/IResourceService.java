package cn.com.shiro.book.tp12.service;

import java.util.List;

import cn.com.shiro.book.tp12.entity.ShrResource;
import cn.com.shiro.book.tp12.entity.ShrResourceItem;

/**
 * 资源管理服务，实现所有的资源管理功能
 * 
 * @author Noble Yang
 * @version 1.0
 * */
public interface IResourceService {
	/**
	 * 根据资源id，查找一个资源对象
	 * 
	 * @param id int 资源id
	 * @return ShrResource 资源对象
	 * */
	public ShrResource findResourceById(int id);
	
	public void addResource(ShrResource resource,List<ShrResourceItem> resItemList);
	public void editResource(ShrResource resource,List<ShrResourceItem> resItemList);
	
	List<ShrResource> findAllResources();
}
