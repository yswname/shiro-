package cn.com.shiro.book.tp12.service;

import java.util.List;

import cn.com.shiro.book.tp12.entity.ShrPermission;
import cn.com.shiro.book.tp12.entity.ShrRole;
import cn.com.shiro.book.tp12.entity.ShrUser;
/**
 * 用户管理服务，实现所有的用户管理功能
 * 
 * @author Noble Yang
 * @version 1.0
 * */
public interface IUserService {
	/**
	 * 根据用户名查找登陆账号中的密码和盐
	 * 
	 * @return String[] 长度2，0：密码， 1：盐
	 * */
	String[] findPasswordAndSaltByUserName(String userName);
	/**
	 * 创建一个新用户
	 * */
    public ShrUser createUser(ShrUser user);
    /**
	 * 修改用户密码
	 * */
    public void changePassword(ShrUser user);
    /**
	 * 验证旧密码后修改密码
	 * */
    public void changePassword(ShrUser user,String oldPassword);
    /**
	 * 给用户分配多个角色
	 * */
    public void assignRoles(ShrUser user,List<ShrRole> roles);
    /**
	 * 给用户分配一个角色
	 * */
    public void assignRole(ShrUser user,ShrRole role);
    /**
	 * 取消用户的多个角色
	 * */
    public void unAssignRoles(ShrUser user,List<ShrRole> roles);
    /**
	 * 取消用户的某个角色
	 * */
    public void unAssignRole(ShrUser user,ShrRole role);
    /**
	 * 取消用户的所有角色
	 * */
    public void unAssignRoles(ShrUser user);
    
    /**
	 * 给用户单独分配一个权限(用户权限，不包含角色对应的权限)
	 * */
    public void assignPermission(ShrUser user, ShrPermission permission);
    /**
	 * 给用户分配多个权限(用户权限，不包含角色对应的权限)
	 * */
    public void assignPermissions(ShrUser user,List<ShrPermission> permissions);
    /**
	 * 取消用户的一个权限(用户权限，不包含角色对应的权限)
	 * */
    public void unAssignPermission(ShrUser user, ShrPermission permission);
    /**
	 * 取消用户的多个权限(用户权限，不包含角色对应的权限)
	 * */
    public void unAssignPermissions(ShrUser user,List<ShrPermission> permissions);
    /**
	 * 取消用户的所有权限(用户权限，不包含角色对应的权限)
	 * */
    public void unAssignPermissions(ShrUser user);
    
    /**
     * 根据用户名查找用户对象
     * */
    public ShrUser findByUserName(String userName);
    /**
     * 查找用户的所有角色
     * */
    public List<ShrRole> findRoles(String userName);
    /**
     * 查找用户的所有权限，包括角色对应的权限和用户单独分配的权限
     * */
    public List<ShrPermission> findPermissions(String userName);
    /**
     * 查找用户的权限(用户权限，不包含角色对应的权限)
     * */
    public List<ShrPermission> findUserPermissions(String userName);
}
