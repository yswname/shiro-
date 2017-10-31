package cn.com.shiro.book.tp12.dao;

import java.util.List;

import cn.com.shiro.book.tp12.entity.ShrRole;
/**
 * 实现ShrRole对象持久化接口
 * 
 * @author Noble Yang
 * @version 1.0
 * */
public interface IShrRoleDAO {
	/**
	 * 查询自定用户名的所有角色对象
	 * 
	 * @param userName String 用户名
	 * @return List<ShrRole> 指定用户名用户拥有的所有角色集合，没有返回null
	 * */
	List<ShrRole> selectByUserName(String userName);
	/**
	 * 查询自定用户名id的所有角色对象
	 * 
	 * @param urId int 用户id
	 * @return List<ShrRole> 指定用户id用户拥有的所有角色集合，没有返回null
	 * */
	List<ShrRole> selectByUrId(int urId);
	/**
	 * 根据角色名称获取角色对象
	 * */
	ShrRole selectByRoleName(String roleName);
    /**
     * 根据角色id删除对应的角色对象
     * 
     * @param rlId Integer 角色id
     * @return int 删除的角色对象数量
     */
    int deleteByPrimaryKey(Integer rlId);

    /**
     * 插入一个新的角色对象，包括为null值的属性
     * 
     * @param record ShrRole 插入的角色对象
     * @return int 返回插入的角色对象数量
     */
    int insert(ShrRole record);

    /**
     * 插入一个新的角色对象，不包括null值的属性
     * 
     * @param record ShrRole 插入的角色对象
     * @return int 返回插入的角色对象数量
     */
    int insertSelective(ShrRole record);

    /**
     * 根据角色id，查询对应的角色对象
     * 
     * @param rlId Integer 角色对象id
     * @return ShrRole 角色对象，如果不存在，返回null
     */
    ShrRole selectByPrimaryKey(Integer rlId);

    /**
     * 根据角色id，更新角色对象中不为null的属性
     * @param record ShrRole 要更新的角色对象
     * @return int 更新的角色对象数量
     */
    int updateByPrimaryKeySelective(ShrRole record);

    /**
     * 根据角色id，更新角色对象中所有属性，包括为null值的属性
     * 
     * @param record ShrRole 要更新的角色对象
     * @return int 更新的角色对象数量
     */
    int updateByPrimaryKey(ShrRole record);
    
    List<ShrRole> selectAll();
}