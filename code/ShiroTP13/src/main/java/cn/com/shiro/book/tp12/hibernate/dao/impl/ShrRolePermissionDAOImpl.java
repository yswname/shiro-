package cn.com.shiro.book.tp12.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import cn.com.shiro.book.tp12.dao.IShrRoleDAO;
import cn.com.shiro.book.tp12.dao.IShrRolePermissionDAO;
import cn.com.shiro.book.tp12.entity.ShrRole;
import cn.com.shiro.book.tp12.entity.ShrRolePermission;
@Repository("shrRolePermissionDAOImpl")
public class ShrRolePermissionDAOImpl implements IShrRolePermissionDAO {
	@Autowired
	@Qualifier("shrRoleDAOImpl")
    private IShrRoleDAO roleDAO;
	@Override
	public void updateOperateCodeByRoleId(Map<String, Integer> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ShrRolePermission> selectByRoleId(int rlId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShrRolePermission> selectByRoleIds(List<Integer> rlIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShrRolePermission> selectByRoleName(String roleName) {
		List<ShrRolePermission> list = null;
        ShrRole role = this.roleDAO.selectByRoleName(roleName);
        if(role != null && role.getShrRolePermissions() != null && role.getShrRolePermissions().size()>0){
        	list = new ArrayList<ShrRolePermission>();
        	list.addAll(role.getShrRolePermissions());
        }
		return list;
	}

	@Override
	public int deleteByPrimaryKey(Integer prmId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ShrRolePermission record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(ShrRolePermission record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShrRolePermission selectByPrimaryKey(Integer prmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShrRolePermission selectSelective(ShrRolePermission record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ShrRolePermission record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ShrRolePermission record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
