package cn.com.shiro.book.tp12.dao;

import java.util.List;
import java.util.Map;

import cn.com.shiro.book.tp12.entity.ShrUserPermission;

/**
 * 实现ShrUserPermission对象持久化接口
 * 
 * @author Noble Yang
 * @version 1.0
 * */
public interface IShrUserPermissionDAO {
	/**
	 * 根据用户id查询所有的用户权限对象
	 * 
	 * @param urId
	 *            int 用户id
	 * @return List<ShrUserPermission> 用户权限对象
	 * */
	List<ShrUserPermission> selectByUrId(int urId);

	/**
	 * 根据用户名查询所有的用户权限对象
	 * 
	 * @param userName
	 *            String 用户名
	 * @return List<ShrUserPermission> 用户权限对象
	 * */
	List<ShrUserPermission> selectByUserName(String userName);

	/**
	 * 查询多个用户id对应的所有用户权限对象
	 * 
	 * @param list
	 *            List<Integer> 用户id集合
	 * @return List<ShrUserPermission> 用户权限对象
	 * */
	List<ShrUserPermission> selectByUrIds(List<Integer> list);

	/**
	 * 查询多个用户名对应的所有用户权限对象
	 * 
	 * @param list
	 *            List<String> 用户名集合
	 * @return List<ShrUserPermission> 用户权限对象
	 * */
	List<ShrUserPermission> selectByUserNames(List<String> list);

	/**
	 * 根据用户权限对象的主键id删除用户权限对象
	 * 
	 * @param prmId
	 *            Integer 用户权限对象id
	 * @return int 删除用户权限对象数量
	 */
	int deleteByPrimaryKey(Integer prmId);

	/**
	 * 插入一个新的用户权限对象，包括值为null的属性
	 * 
	 * @param record
	 *            ShrUserPermission 用户权限对象
	 * @return int 用户权限对象数量
	 */
	int insert(ShrUserPermission record);

	/**
	 * 插入一个新的用户权限对象，不包括值为null的属性
	 * 
	 * @param record
	 *            ShrUserPermission 用户权限对象
	 * @return int 用户权限对象数量
	 */
	int insertSelective(ShrUserPermission record);

	/**
	 * 根据用户权限对象的主键id，查询用户权限对象
	 * 
	 * @param prmId
	 *            Integer 用户权限对象主键id
	 * @return ShrUserPermission 用户权限对象
	 */
	ShrUserPermission selectByPrimaryKey(Integer prmId);

	/**
	 * 根据用户id和资源id，查询用户权限对象
	 * 
	 * @param record
	 *            ShrUserPermission 包含用户id和资源id
	 * @return ShrUserPermission 用户权限对象
	 */
	ShrUserPermission selectSelective(ShrUserPermission record);

	/**
	 * 根据主键更新用户权限对象，不包括值为null的属性
	 * 
	 * @param record
	 *            ShrUserPermission 用户权限对象
	 * @return int 更新的用户权限对象的数量
	 */
	int updateByPrimaryKeySelective(ShrUserPermission record);

	/**
	 * 根据主键更新用户权限对象，包括值为null的属性
	 * 
	 * @param record
	 *            ShrUserPermission 用户权限对象
	 * @return int 更新的用户权限对象的数量
	 */
	int updateByPrimaryKey(ShrUserPermission record);

	/**
	 * 更新用户id对应的所有用户权限项对象的操作Code。Map中有两个键值对，一个是以urId为key的用户id键值对象;
	 * 一个是以opCode为key的新操作Code
	 * 
	 * @param map
	 *            Map<String,Integer> 包括两个键值对，urId为key的用户id和opCode为key的新操作Code
	 * @return void
	 * */
	void updateOperateCodeByUserId(Map<String, Integer> map);
}