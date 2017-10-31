package cn.com.shiro.book.tp12.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shiro.book.tp12.dao.IShrUserDAO;
import cn.com.shiro.book.tp12.entity.ShrPermission;
import cn.com.shiro.book.tp12.entity.ShrRole;
import cn.com.shiro.book.tp12.entity.ShrRolePermission;
import cn.com.shiro.book.tp12.entity.ShrUser;
import cn.com.shiro.book.tp12.entity.ShrUserPermission;
import cn.com.shiro.book.tp12.service.IPermissionService;
import cn.com.shiro.book.tp12.service.IUserService;

@Transactional
@Service("userServiceImpl")
@Order(1)
public class UserServiceImpl implements IUserService {
	@Autowired
	@Qualifier("shrUserDAOImpl")
	private IShrUserDAO userDAO;

	@Autowired
	@Qualifier("permissionServiceImpl")
	private IPermissionService permissionService;

	public UserServiceImpl(){}
	@Override
	public String[] findPasswordAndSaltByUserName(String userName) {
		String[] result = null;
		// 根据用户名找到用户对象
		ShrUser user = this.userDAO.selectByUserName(userName);
		if(user != null){
			result = new String[2];
			result[0] = user.getUrPassword();
			result[1] = user.getUrSalt();
		}
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ShrUser createUser(ShrUser user) {
		// 判断是否有存在
		ShrUser dbUser = this.userDAO.selectByUserName(user.getUrUserName());
		// 存在抛异常
		if (dbUser != null) {
			throw new RuntimeException(user.getUrUserName() + "用户已经存在");
		} else {
			// 不存在
			// 保存
			this.userDAO.insert(user);
		}
		return user;
	}

	@Override
	public void changePassword(ShrUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(ShrUser user, String oldPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignRoles(ShrUser user, List<ShrRole> roles) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignRole(ShrUser user, ShrRole role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unAssignRoles(ShrUser user, List<ShrRole> roles) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unAssignRole(ShrUser user, ShrRole role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unAssignRoles(ShrUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignPermission(ShrUser user, ShrPermission permission) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignPermissions(ShrUser user, List<ShrPermission> permissions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unAssignPermission(ShrUser user, ShrPermission permission) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unAssignPermissions(ShrUser user,
			List<ShrPermission> permissions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unAssignPermissions(ShrUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public ShrUser findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShrRole> findRoles(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
    // 获取当前用户的所有权限实体对象
	@Override
	public List<ShrPermission> findPermissions(String userName) {
		List<ShrPermission> perms = null;
		// 根据用户名获取用户对象
		ShrUser user = this.userDAO.selectByUserName(userName);
		if (user != null) {
			// 获取用权限实体
			List<ShrUserPermission> userPerms = this.permissionService
					.searchUserPermissionsByUserName(userName);
			// 获取用户的所有角色
			Set<ShrRole> roles = user.getShrRoles();
			List<ShrRolePermission> rolePerms = null;
			// 获取所有角色的权限实体
			if (roles != null) {
				// 定义存放角色权限实体的集合
				rolePerms = new ArrayList<ShrRolePermission>();
				List<ShrRolePermission> rolePerm = null;
				// 循环每个角色
				for (ShrRole role : roles) {
					// 根据角色名称，获取对应的角色权限实体
					rolePerm = this.permissionService
							.searchRolePermissionByRoleName(role.getRlName());
					if (rolePerm != null) {
						// 合并角色权限实体
						rolePerms.addAll(rolePerm);
					}
				}
			}
			// 合并角色权限实体和用户权限实体
			perms = new ArrayList<ShrPermission>();
			if(userPerms != null){
				perms.addAll(userPerms);
			}
			if(rolePerms != null){
				perms.addAll(rolePerms);
			}
		}
		return perms;
	}

	@Override
	public List<ShrPermission> findUserPermissions(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
