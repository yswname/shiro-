package cn.com.shiro.book.tp12.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import cn.com.shiro.book.tp12.dao.IShrUserDAO;
import cn.com.shiro.book.tp12.dao.IShrUserPermissionDAO;
import cn.com.shiro.book.tp12.entity.ShrUser;
import cn.com.shiro.book.tp12.entity.ShrUserPermission;
@Repository("shrUserPermissionDAOImpl")
public class ShrUserPermissionDAOImpl implements IShrUserPermissionDAO {
	@Autowired
	@Qualifier("shrUserDAOImpl")
    private IShrUserDAO userDAO;
	@Override
	public List<ShrUserPermission> selectByUrId(int urId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShrUserPermission> selectByUserName(String userName) {
		List<ShrUserPermission> list = null;
		ShrUser user = this.userDAO.selectByUserName(userName);
		if(user != null ){
			Set<ShrUserPermission> set = user.getShrUserPermissions();
			if(set != null && set.size()>0){
				list = new ArrayList<ShrUserPermission>();
				list.addAll(set);
			}
		}
		return list;
	}

	@Override
	public List<ShrUserPermission> selectByUrIds(List<Integer> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShrUserPermission> selectByUserNames(List<String> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPrimaryKey(Integer prmId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ShrUserPermission record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(ShrUserPermission record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShrUserPermission selectByPrimaryKey(Integer prmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShrUserPermission selectSelective(ShrUserPermission record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ShrUserPermission record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ShrUserPermission record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateOperateCodeByUserId(Map<String, Integer> map) {
		// TODO Auto-generated method stub

	}

}
