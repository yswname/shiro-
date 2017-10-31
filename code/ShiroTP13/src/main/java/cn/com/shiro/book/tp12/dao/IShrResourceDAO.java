package cn.com.shiro.book.tp12.dao;

import java.util.List;

import cn.com.shiro.book.tp12.entity.ShrResource;

/**
 * 实现ShrResource持久化的持久层接口
 * 
 * @author Noble Yang
 * @version 1.0
 * */
public interface IShrResourceDAO{
    /**
     * 根据主键，删除指定id的资源
     * 
     * @param rscId Integer，要删除资源对象的主键值
     * 
     * @return int 删除对象的数量（因为主键最多对应一个对象，所以结果只能是1或0）
     */
    int deleteByPrimaryKey(Integer rscId);

    /**
     * 插入一个新的ShrResource
     * 
     * @param record ShrResource 要插入的ShrSource对象，除了rscId属性不用设置外，其他不为空的属性都需要设置
     *               
     * @return int 返回插入的记录数
     */
    int insert(ShrResource record);

    /**
     * 插入一个新的ShrResource对象,同insert方法不同的是，只会插入有赋值的属性字段
     * 
     * @param record ShrResource 要插入的ShrSource对象
     * @return int 返回插入的对象数量
     */
    int insertSelective(ShrResource record);

    /**
     * 根据主键的id，查找对应的ShrResource对象
     * 
     * @param rscId Integer 主键id值
     * @return ShrResource 主键id对应的ShrResource对象，如果不存在，返回null
     */
    ShrResource selectByPrimaryKey(Integer rscId);
    /**
     * 根据对象中有值的属性进行条件查询
     * */
    List<ShrResource> selectSelective(ShrResource record);

    /**
     * 以主键id为条件，更新ShrResource对象的属性值。注意，只更新不为null的属性
     * 
     * @param record ShrResource 需要更新的ShrResource对象，其中不为null的属性，是需要更新的属性，主键属性一定要设置
     * @return int 返回更新的对象数量 
     */
    int updateByPrimaryKeySelective(ShrResource record);

    /**
     * 以主键id为条件，更新ShrResource对象。注意是更新所有属性（id做为条件除外），如果属性为null值，也将新值更新为null
     * 
     * @param record ShrResource 需要更新的，包含新数据的ShrResource对象
     * @return int 返回更新的对象数量
     */
    int updateByPrimaryKey(ShrResource record);
}