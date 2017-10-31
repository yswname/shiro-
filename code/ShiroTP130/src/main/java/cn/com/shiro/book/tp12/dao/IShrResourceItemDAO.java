package cn.com.shiro.book.tp12.dao;

import java.util.List;

import cn.com.shiro.book.tp12.entity.ShrResourceItem;
/**
 * 实现ShrResourceItem对象持久化接口
 * 
 * @author Noble Yang
 * @version 1.0
 * */
public interface IShrResourceItemDAO{
	/**
	 * 查询所有资源项
	 * 
	 * @return List<ShrResourceItem> selectAll();
	 * */
	List<ShrResourceItem> selectAll();
	/**
	 * 查询指定资源id对应的所有资源项
	 * 
	 * @param rscId Integer 资源主键id
	 * @return List<ShrResourceItem> 资源id对应资源项的集合，如果没有，返回null
	 * */
	List<ShrResourceItem> selectResourceItemsByResourceId(Integer rscId);
    /**
     * 删除指定id对应的资源项
     * 
     * @param itemId Integer 要删除的资源项的id
     * @return int 返回删除资源项的数量
     */
    int deleteByPrimaryKey(Integer itmId);

    /**
     * 插入一个新的资源项
     * 
     * @param record ShrResourceItem 要插入的资源项。资源项中的所有属性都会插入到数据库中，包括null值的属性
     * 
     * @return int 返回插入的资源项数量
     */
    int insert(ShrResourceItem record);

    /**
     * 插入一个新的资源项。为null值的属性不会插入到数据库中
     * 
     * @param record ShrResourceItem
     * @return int 返回插入的资源项数量
     */
    int insertSelective(ShrResourceItem record);

    /**
     * 根据资源项的主键id，查询资源项对象
     * 
     * @param itmId Integer 要查询资源项对象的主键id值
     * 
     * @return ShrResourceItem 资源项对象，如果不存在，返回null
     */
    ShrResourceItem selectByPrimaryKey(Integer itmId);

    /**
     * 根据资源项id为条件，更新资源项对象中，不为null值的属性
     * 
     * @param record ShrResourceItem 要更新的资源项对象
     * @return int 更新的资源项对象数量
     * 
     */
    int updateByPrimaryKeySelective(ShrResourceItem record);

    /**
     * 根据资源项id为条件，更新资源项对象，包括为null值的属性
     * 
     * @param record ShrResourceItem 要更新的资源项对象
     * @return int 更新资源项对象的数量
     */
    int updateByPrimaryKey(ShrResourceItem record);
}