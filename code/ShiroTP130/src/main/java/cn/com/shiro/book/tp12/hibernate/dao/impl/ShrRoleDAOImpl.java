package cn.com.shiro.book.tp12.hibernate.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import cn.com.shiro.book.tp12.dao.IShrRoleDAO;
import cn.com.shiro.book.tp12.entity.ShrRole;
import cn.com.shiro.book.tp12.hibernate.dao.ShrRoleDAO;

@Repository("shrRoleDAOImpl")
public class ShrRoleDAOImpl implements IShrRoleDAO {
	@Autowired
	@Qualifier("ShrRoleDAO")
	private ShrRoleDAO roleDAO;

	@Override
	public List<ShrRole> selectAll() {
		List<ShrRole> roleList = null;
		roleList = this.roleDAO.findAll();
		return roleList;
	}

	@Override
	public List<ShrRole> selectByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShrRole> selectByUrId(int urId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShrRole selectByRoleName(String roleName) {
		ShrRole role = null;
		List<ShrRole> roleList = this.roleDAO
				.findByProperty("rlName", roleName);
		if (roleList != null && roleList.size() > 0) {
			role = roleList.get(0);
		}
		return role;
	}

	@Override
	public int deleteByPrimaryKey(Integer rlId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ShrRole record) {
		int result = 0;
		this.roleDAO.save(record);
		if (record.getRlId() != null) {
			result = 1;
		}
		return result;
	}

	@Override
	public int insertSelective(ShrRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShrRole selectByPrimaryKey(Integer rlId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ShrRole record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ShrRole record) {
		// TODO Auto-generated method stub
		return 0;
	}
}
