package cn.com.shiro.book.tp12.hibernate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import cn.com.shiro.book.tp12.dao.IShrResourceDAO;
import cn.com.shiro.book.tp12.entity.ShrResource;
import cn.com.shiro.book.tp12.hibernate.dao.ShrResourceDAO;

@Repository("shrResourceDAOImpl")
public class ShrResourceDAOImpl implements IShrResourceDAO {
	@Autowired
	@Qualifier("ShrResourceDAO")
    private ShrResourceDAO resourceDAO;
    @Override
	public int deleteByPrimaryKey(Integer rscId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ShrResource record) {
		int result = 0;
		resourceDAO.save(record);
		if(record.getRscId() != 0){
			result = 1;
		}
		return result;
	}

	@Override
	public int insertSelective(ShrResource record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShrResource selectByPrimaryKey(Integer rscId) {
		return this.resourceDAO.findById(rscId);
	}

	@Override
	public List<ShrResource> selectSelective(ShrResource record) {
		
		return this.resourceDAO.findByExample(record);
	}

	@Override
	public int updateByPrimaryKeySelective(ShrResource record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ShrResource record) {
		this.resourceDAO.merge(record);
		return 1;
	}

}
