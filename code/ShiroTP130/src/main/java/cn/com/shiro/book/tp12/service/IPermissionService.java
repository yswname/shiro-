package cn.com.shiro.book.tp12.service;

import java.util.List;

import cn.com.shiro.book.tp12.entity.ShrRolePermission;
import cn.com.shiro.book.tp12.entity.ShrUserPermission;
/**
 * 权限管理服务，实现对权限的所有管理
 * 
 * @author Noble Yang
 * @version 1.0
 * */
public interface IPermissionService {
	/**
	 * 创建一个新的用户权限对象
	 * @param permission ShrUserPermission 包含要创建的新用户权限对象信息，prmId属性没有值
	 * 
	 * @return ShrUserPermission 创建好的用户权限对象，prmId有值，同数据库中的主键值对应
	 * */
    public ShrUserPermission createPermission(ShrUserPermission permission);
    /**
     * 删除一个用户权限对象，必须设置prmId属性
     * 
     * @param permission ShrUserPermission 要删除的用户权限对象，必须要prmId属性
     * @return void
     * */
    public void deleteUserPermission(ShrUserPermission permission);
    /**
     * 根据用户权限对象的id，查询对应的用户权限对象
     * 
     * @param id int 用户权限对象的id
     * @return ShrUserPermission 用户权限对象
     * */
    public ShrUserPermission searchUserPermissionById(int id);
    /**
     * 查询指定用户名对应用户的所有用户权限对象
     * @param userName String 用户名
     * @return List<ShrUserPermission> 用户名对应用户拥有的所有用户权限对象集合
     * */
    public List<ShrUserPermission> searchUserPermissionsByUserName(String userName);
    /**
     * 查询指定用户id对应用户的所有用户权限对象
     * @param urId Integer 用户id
     * @return List<ShrUserPermission> 用户id对应用户拥有的所有用户权限对象集合
     * */
    public List<ShrUserPermission> searchUserPermissionsByUserId(Integer urId);
    /**
     * 查询指定多个用户名对应用户的所有用户权限对象
     * @param userNames List<String> 用户名集合
     * @return List<ShrUserPermission> 用户名集合对应用户拥有的所有用户权限对象集合
     * */
    public List<ShrUserPermission> searchUserPermissionsByUserNames(List<String> userNames);
    /**
     * 查询指定多个用户id对应用户的所有用户权限对象
     * @param urIds List<Integer> 用户id集合
     * @return List<ShrUserPermission> 用户id集合对应用户拥有的所有用户权限对象集合
     * */
    public List<ShrUserPermission> searchUserPermissionsByUserIds(List<Integer> urIds);
    /**
	 * 创建一个新的角色权限对象
	 * @param permission ShrShrPermission 包含要创建的新角色权限对象信息，prmId属性没有值
	 * 
	 * @return ShrShrPermission 创建好的角色权限对象，prmId有值，同数据库中的主键值对应
	 * */
    public ShrRolePermission createPermission(ShrRolePermission permission);
    /**
     * 删除一个角色权限对象，必须设置prmId属性
     * 
     * @param permission ShrRolePermission 要删除的角色权限对象，必须要prmId属性
     * @return void
     * */
    public void deleteRolePermission(ShrRolePermission permission);
    /**
     * 根据角色权限对象的id，查询对应的角色权限对象
     * 
     * @param id int 角色权限对象的id
     * @return ShrRolePermission 角色权限对象
     * */
    public ShrRolePermission searchRolePermissionById(int id);
    /**
     * 根据角色名称获取角色权限
     * */
    public List<ShrRolePermission> searchRolePermissionByRoleName(String roleName);
    /**
     * 根据角色对象的id，查询对应的角色权限对象
     * 
     * @param rlId int 角色对象的id
     * @return ShrRolePermission 角色权限对象
     * */
    public List<ShrRolePermission> searchRolePermissionsByRoleId(int rlId);
    /**
     * 根据多个角色对象的id，查询对应的角色权限对象
     * 
     * @param rlIds List<Integer> 多个角色对象的id
     * @return ShrRolePermission 角色权限对象
     * */
    public List<ShrRolePermission> searchRolePermissionsByRoleIds(List<Integer> rlIds);
}
