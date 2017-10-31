package cn.com.shiro.book.tp07.realm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class ShiroRealm extends AuthorizingRealm {
	private PasswordService passwordService;
	private Map<String, String> accountMap = new HashMap<String, String>();
	private Map<String, List<String>> userRolesMap = new HashMap<String, List<String>>();
	private Map<String, List<String>> userPermsMap = new HashMap<String, List<String>>();
	// 模拟数据源初始化数据
	{
		// 初始化用户角色信息
		userRolesMap.put("zhangsan", Arrays.asList("admin"));
		userRolesMap.put("lisi", Arrays.asList("role1", "role2"));
		userRolesMap.put("wangwu", Arrays.asList("role3"));
		// 初始化用户权限信息
		userPermsMap.put("wangwu",
				Arrays.asList("order:create", "order:delete"));
		userPermsMap.put("lisi", Arrays.asList("1:1","1:2","1:4","1:8"));

	}

	/**
	 * 获取指定principals包含的角色和权限信息
	 * */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("!!!!!!!!!doGetAuthorizationInfo");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (this.userRolesMap.get(principals.getPrimaryPrincipal()) != null) {
			info.addRoles(this.userRolesMap.get(principals
					.getPrimaryPrincipal()));
		}
		if (this.userPermsMap.get(principals.getPrimaryPrincipal()) != null) {
			info.addStringPermissions(this.userPermsMap.get(principals
					.getPrimaryPrincipal()));
		}
		return info;
	}

	/**
	 * 根据token的principals返回从数据源中获取的对应AuthenticationInfo
	 * */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("!!!!!!doGetAuthenticationInfo");
		SimpleAuthenticationInfo info = null;
		String password = this.accountMap.get(token.getPrincipal().toString());
		if (password != null) {
			info = new SimpleAuthenticationInfo(token.getPrincipal(),
					password,
					this.getName());
		}
		return info;
	}

	public PasswordService getPasswordService() {
		return passwordService;
	}

	public void setPasswordService(PasswordService passwordService) {
		this.passwordService = passwordService;
		initAccounts();
	}

	// 使用passwordService初始化账号信息，密码加密
	private void initAccounts() {
		System.out.println("!!!!!!!初始化账号信息！！！！！！！！！");
		// 初始化用户账号信息
		accountMap.put("zhangsan",
				this.passwordService.encryptPassword("abc123"));
		accountMap.put("lisi", this.passwordService.encryptPassword("123456"));
		accountMap
				.put("wangwu", this.passwordService.encryptPassword("123456"));
	}
}
