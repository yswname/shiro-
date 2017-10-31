package cn.com.shiro.book.tp12.hibernate.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import cn.com.shiro.book.tp12.dao.IShrUserDAO;
import cn.com.shiro.book.tp12.entity.ShrUser;
import cn.com.shiro.book.tp12.hibernate.dao.ShrUserDAO;
@Repository("shrUserDAOImpl")
public class ShrUserDAOImpl implements IShrUserDAO {
	@Autowired
	@Qualifier("ShrUserDAO")
    private ShrUserDAO userDAO;
	
	@Override
	public void addRole(Map<String, Integer> urRlId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRole(Map<String, Integer> urRlId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRoles(Map<String, Object> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAllRole(Integer urId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ShrUser> selectByRoleId(int rlId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShrUser selectByUserName(String userName) {
		ShrUser user = null;
		List<ShrUser> userList = this.userDAO.findByProperty("urUserName", userName);
		if(userList != null && userList.size()>0){
			user = userList.get(0);
			userList = null;
		}
		return user;
	}

	@Override
	public int deleteByPrimaryKey(Integer urId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ShrUser record) {
		this.userDAO.save(record);
		return record.getUrId();
	}

	@Override
	public int insertSelective(ShrUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShrUser selectByPrimaryKey(Integer urId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ShrUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ShrUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
