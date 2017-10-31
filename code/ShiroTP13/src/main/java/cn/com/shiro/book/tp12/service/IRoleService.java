package cn.com.shiro.book.tp12.service;

import java.util.List;

import cn.com.shiro.book.tp12.entity.ShrPermission;
import cn.com.shiro.book.tp12.entity.ShrRole;
/**
 * 角色管理服务，实现所有的角色管理功能
 * 
 * @author Noble Yang
 * @version 1.0
 * */
public interface IRoleService {
	public List<ShrRole> findAll();
	/**
	 * 创建一个新的角色
	 * */
    public ShrRole createRole(ShrRole role);
    /**
     * 删除角色，角色对象中必须有rlId属性
     * */
    public void deleteRole(ShrRole role);
    /**
     * 给指定的角色分配一个权限
     * */
    public void assignPermission(ShrRole role, ShrPermission permission);
    /**
     * 给指定角色，分配多个权限
     * */
    public void assignPermissions(ShrRole role,List<ShrPermission> permissions);
    /**
     * 取消指定角色的一个权限
     * */
    public void unAssignPermission(ShrRole role, ShrPermission permission);
    /**
     * 取消指定角色的多个权限
     * */
    public void unAssignPermissions(ShrRole role,List<ShrPermission> permissions);
    /**
     * 取消指定角色的所有权限
     * */
    public void unAssignPermissions(ShrRole role);
    /**
     * 查找指定用户名对应用户拥有的所有角色
     * */
    public List<ShrRole> findRoles(String userName);
}
