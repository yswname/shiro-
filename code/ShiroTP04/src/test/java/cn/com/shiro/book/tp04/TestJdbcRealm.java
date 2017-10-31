package cn.com.shiro.book.tp04;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class TestJdbcRealm {

	public static void main(String[] args) {
		// 1.创建IniSecurityManagerFactory，基于shiro.ini进行初始化
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro_jdbcRealm.ini");
		// 2.获取SecurityManager对象
		org.apache.shiro.mgt.SecurityManager securityManager = factory
				.getInstance();
		// 3.注册全局的SecurityManager对象
		SecurityUtils.setSecurityManager(securityManager);
		Subject currUser = SecurityUtils.getSubject();
		
		//创建用户名密码登录令牌
		UsernamePasswordToken token = new UsernamePasswordToken("wangwu","123456");
		currUser.login(token);
		
		System.out.println("登录成功");
		currUser.logout();
	}

}
