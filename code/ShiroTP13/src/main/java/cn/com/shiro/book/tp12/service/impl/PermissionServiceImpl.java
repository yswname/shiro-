package cn.com.shiro.book.tp12.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.com.shiro.book.tp12.dao.IShrRolePermissionDAO;
import cn.com.shiro.book.tp12.dao.IShrUserPermissionDAO;
import cn.com.shiro.book.tp12.entity.ShrRolePermission;
import cn.com.shiro.book.tp12.entity.ShrUserPermission;
import cn.com.shiro.book.tp12.service.IPermissionService;

@Service("permissionServiceImpl")
public class PermissionServiceImpl implements IPermissionService {
	@Autowired
	@Qualifier("shrUserPermissionDAOImpl")
    private IShrUserPermissionDAO userPermissionDAO;
	@Autowired
	@Qualifier("shrRolePermissionDAOImpl")
    private IShrRolePermissionDAO rolePermissionDAO;
	@Override
	public ShrUserPermission createPermission(ShrUserPermission permission) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserPermission(ShrUserPermission permission) {
		// TODO Auto-generated method stub

	}

	@Override
	public ShrUserPermission searchUserPermissionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShrUserPermission> searchUserPermissionsByUserName(
			String userName) {
		List<ShrUserPermission> permList = this.userPermissionDAO.selectByUserName(userName);
		return permList;
	}

	@Override
	public List<ShrUserPermission> searchUserPermissionsByUserId(Integer urId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShrUserPermission> searchUserPermissionsByUserNames(
			List<String> userNames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShrUserPermission> searchUserPermissionsByUserIds(
			List<Integer> urIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShrRolePermission createPermission(ShrRolePermission permission) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRolePermission(ShrRolePermission permission) {
		// TODO Auto-generated method stub

	}

	@Override
	public ShrRolePermission searchRolePermissionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShrRolePermission> searchRolePermissionByRoleName(
			String roleName) {
		return this.rolePermissionDAO.selectByRoleName(roleName);
	}

	@Override
	public List<ShrRolePermission> searchRolePermissionsByRoleId(int rlId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShrRolePermission> searchRolePermissionsByRoleIds(
			List<Integer> rlIds) {
		// TODO Auto-generated method stub
		return null;
	}

}
