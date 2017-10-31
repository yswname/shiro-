package cn.com.shiro.book.tp12.hibernate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import cn.com.shiro.book.tp12.dao.IShrResourceItemDAO;
import cn.com.shiro.book.tp12.entity.ShrResourceItem;
import cn.com.shiro.book.tp12.hibernate.dao.ShrResourceItemDAO;
@Repository("shrResourceItemDAOImpl")
public class ShrResourceItemDAOImpl implements IShrResourceItemDAO {
	@Autowired
	@Qualifier("ShrResourceItemDAO")
    private ShrResourceItemDAO itemDAO;
	@Override
	public List<ShrResourceItem> selectAll() {
		return this.itemDAO.findAll();
	}

	@Override
	public List<ShrResourceItem> selectResourceItemsByResourceId(Integer rscId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPrimaryKey(Integer itmId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ShrResourceItem record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(ShrResourceItem record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShrResourceItem selectByPrimaryKey(Integer itmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ShrResourceItem record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ShrResourceItem record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
