package cn.com.shiro.book.tp12.dao;

import java.util.List;
import java.util.Map;

import cn.com.shiro.book.tp12.entity.ShrUser;
/**
 * 实现ShrUser对象持久化接口
 * 
 * @author Noble Yang
 * @version 1.0
 * */
public interface IShrUserDAO {
	/**
	 * 给指定的用户添加一个角色，Map中包含两个键值对象，一个是用户id的键值对，urId为key；一个是角色id的键值对，rlId为key
	 * 
	 * @param urRlId Map<String,Integer> 包含要添加的用户id键值对和角色id键值对
	 * @return void
	 * */
	void addRole(Map<String,Integer> urRlId);
	/**
	 * 删除指定用户的一个角色。Map中包含两个键值对象，一个是用户id的键值对，urId为key；一个是角色id的键值对，rlId为key
	 * 
	 * @param urRlId Map<String,Integer> 包含要删除的用户id键值对和角色id键值对
	 * @return void
	 * */
	void removeRole(Map<String,Integer> urRlId);
	/**
	 * 删除指定用户的多个角色。Map中包含两个键值对象，一个是用户id的键值对，urId为key；多个角色id集合的键值对，list为key，值为List<Integer>
	 * 
	 * @param urRlId Map<String,Integer> 包含要删除的用户id键值对和角色id键值对
	 * @return void
	 * */
	void removeRoles(Map<String,Object> map);
	/**
	 * 删除指定用户的所有角色
	 * @param urId Integer 用户id
	 * @return void
	 * */
	void removeAllRole(Integer urId);
	/**
	 * 查询指定角色包含的用户
	 * 
	 * @param rlId int 角色id
	 * @return List<ShrUser> 指定角色对应分配的所有用户结合
	 * */
	List<ShrUser> selectByRoleId(int rlId);
	/**
	 * 根据用户名查询唯一的用户
	 * @param userName String 用户名
	 * @return ShrUser 用户对象
	 * */
	ShrUser selectByUserName(String userName);
    /**
     * 根据用户主键id删除对应的用户
     * 
     * @param urId Integer 用户id
     * @return int 删除的用户对象数量
     */
    int deleteByPrimaryKey(Integer urId);

    /**
     * 插入一个新的用户对象，包括值为null的属性
     * 
     * @param record ShrUser 用户对象
     * @return int 插入的用户对象数量
     */
    int insert(ShrUser record);

    /**
     * 插入一个新的用户对象，不包括值为null的属性
     * 
     * @param record ShrUser 用户对象
     * @return int 插入的用户对象数量
     */
    int insertSelective(ShrUser record);

    /**
     *  根据用户名id查询唯一的用户
	 * @param urId Integer 用户id
	 * @return ShrUser 用户对象
     */
    ShrUser selectByPrimaryKey(Integer urId);

    /**
     * 根据主键更新用户对象，不包括值为null的属性
     * 
     * @param record ShrUser 用户对象
     * @return int 用户对象数量
     */
    int updateByPrimaryKeySelective(ShrUser record);

    /**
     * 根据主键更新用户对象，包括值为null的属性
     * 
     * @param record ShrUser 用户对象
     * @return int 用户对象数量
     */
    int updateByPrimaryKey(ShrUser record);
}