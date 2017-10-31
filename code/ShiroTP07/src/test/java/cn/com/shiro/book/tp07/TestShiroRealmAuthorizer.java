package cn.com.shiro.book.tp07;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestShiroRealmAuthorizer {
	private Subject currUser;
	@Test
	public void testCheckPermission(){
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan",
				"abc123");
		this.currUser.login(token);
		System.out.println("***********testCheckPermission 输出：");
        //System.out.println(this.currUser.isPermitted("user:*"));
        //System.out.println(this.currUser.isPermitted("user:add"));
	}
    //@Test
	public void testAssertionRole() {
		// 登录
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan",
				"abc123");
		this.currUser.login(token);
		
		this.currUser.checkRole("role1");
		System.out.println(this.currUser.getPrincipal() + " 拥有role1角色，能执行role1相关的操作");
		
		this.currUser.checkRoles("role1","role2");
		System.out.println(this.currUser.getPrincipal() + " 拥有role1,role2角色，能执行role1,2相关的操作");
		
		this.currUser.checkRole("admin");
		System.out.println(this.currUser.getPrincipal() + " 拥有admin角色，能执行所有的操作");
	}

	//@Test
	public void testCheckRole() {
		// 登录
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan",
				"abc123");
		this.currUser.login(token);

		if (this.currUser.hasRole("admin")) {
			System.out.println(this.currUser.getPrincipal() + "是admin，拥有所有权限");
		} else {
			System.out.println(this.currUser.getPrincipal()
					+ " 不是admin，可能拥有部分权限");
		}

		List<String> roleNames = new ArrayList<String>();
		roleNames.add("role1");
		roleNames.add("role2");
		roleNames.add("admin");
		boolean[] hasRoles = this.currUser.hasRoles(roleNames);
		System.out.println(this.currUser.getPrincipal() + "拥有的角色请求:");
		for (int i = 0; i < roleNames.size(); i++) {
			System.out.println("   " + roleNames.get(i) + ":" + hasRoles[i]);
		}

		System.out.println(this.currUser.hasAllRoles(roleNames));
	}

	@Before
	public void init() {
		// 1.创建IniSecurityManagerFactory，基于shiro.ini进行初始化
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro_shiroRealm.ini");
		// 2.获取SecurityManager对象
		org.apache.shiro.mgt.SecurityManager securityManager = factory
				.getInstance();
		// 3.注册全局的SecurityManager对象
		SecurityUtils.setSecurityManager(securityManager);
		currUser = SecurityUtils.getSubject();
	}

	@After
	public void destory() {
		this.currUser.logout();
	}
}
