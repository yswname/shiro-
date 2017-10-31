package cn.com.shiro.book.tp12.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shiro.book.tp12.dao.IShrRoleDAO;
import cn.com.shiro.book.tp12.entity.ShrPermission;
import cn.com.shiro.book.tp12.entity.ShrRole;
import cn.com.shiro.book.tp12.service.IRoleService;
@Service("roleServiceImpl")
@Transactional
public class RoleServiceImpl implements IRoleService {
	@Autowired
	@Qualifier("shrRoleDAOImpl")
    private IShrRoleDAO roleDAO;
	
	
	@Override
	@Transactional(readOnly=true)
	public List<ShrRole> findAll() {
		
		return roleDAO.selectAll();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public ShrRole createRole(ShrRole role) {
		roleDAO.insert(role);
		return role;
	}

	@Override
	public void deleteRole(ShrRole role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignPermission(ShrRole role, ShrPermission permission) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignPermissions(ShrRole role, List<ShrPermission> permissions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unAssignPermission(ShrRole role, ShrPermission permission) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unAssignPermissions(ShrRole role,
			List<ShrPermission> permissions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unAssignPermissions(ShrRole role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShrRole> findRoles(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
