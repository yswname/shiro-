package cn.com.shiro.book.tp12.dao;

import java.util.List;
import java.util.Map;

import cn.com.shiro.book.tp12.entity.ShrRolePermission;

/**
 * 实现ShrRolePermission对象持久化接口
 * 
 * @author Noble Yang
 * @version 1.0
 * */
public interface IShrRolePermissionDAO {
	/**
	 * 根据角色id更新该角色对所有资源的操作code(增删改查的标记),map中包含两个键值对象. 键值rlId表示角色id;
	 * 键值opCode表示新操作code;
	 * 
	 * @param map
	 *            Map<String,Integer>
	 *            里面包含两个键值对。rlId键值，对应要更新的角色id;opCode键值，对应新的操作code。两个键值是固定的
	 * @return void
	 * */
	void updateOperateCodeByRoleId(Map<String, Integer> map);
    /**
     * 根据角色id，查询对应的所有ShrRolePermission对象
     * @param rlId Integer 角色id
     * @return List<ShrRolePermission> ShrRolePermission对象的集合
     * */
	List<ShrRolePermission> selectByRoleId(int rlId);
    /**
     * 查询指定角色ID集合对应的所有ShrRolePermission对象
     * 
     * @param rlIds List<Integer> 角色id集合
     * @return List<ShrRolePermission> ShrRolePermission对象的集合
     * */
	List<ShrRolePermission> selectByRoleIds(List<Integer> rlIds);
	
    /**
     * 根据角色名称获取所有的权限
     * */
	public List<ShrRolePermission> selectByRoleName(String roleName);

	/**
	 * 根据主键id删除对应的ShrRolePermission对象
	 * 
	 * @param prmId Integer 角色权限对象对应的id
	 * @return int 删除的角色权限对象的数量
	 */
	int deleteByPrimaryKey(Integer prmId);

	/**
	 * 插入一个角色权限对象，包括为null值的属性
	 * 
	 * @param record ShrRolePermission 要插入的角色权限对象
	 * @return int 插入的角色权限对象数量
	 */
	int insert(ShrRolePermission record);

	/**
	 * 插入一个权限角色对象，值为null的属性不插入
	 * 
	 * @param record ShrRolePermission 角色权限对象
	 * @return int 插入的角色权限对象数量
	 */
	int insertSelective(ShrRolePermission record);

	/**
	 * 根据主键查询角色权限对象
	 * 
	 * @param prmId Integer 角色权限对象的主键值
	 * 
	 * @return ShrRolePermission 角色权限对象，如果不存在返回null
	 */
	ShrRolePermission selectByPrimaryKey(Integer prmId);

	/**
	 * 根据角色权限对象中的角色id和资源id，查询角色权限对象
	 * @param record ShrRolePermission 角色权限对象，包含要根据条件查询的资源id和角色id的属性
	 * @return ShrRolePermission 角色权限对象，不存在返回null
	 * */
	ShrRolePermission selectSelective(ShrRolePermission record);
	

	/**
	 * 根据主键更新角色权限对象，不包括值null的属性
	 * 
	 * @param record ShrRolePermission 角色权限对象
	 * @return int 更新的角色权限对象数量
	 */
	int updateByPrimaryKeySelective(ShrRolePermission record);

	/**
	 * 根据主键更新角色权限对象，包括值null的属性
	 * 
	 * @param record ShrRolePermission 角色权限对象
	 * @return int 更新的角色权限对象数量
	 */
	int updateByPrimaryKey(ShrRolePermission record);
}