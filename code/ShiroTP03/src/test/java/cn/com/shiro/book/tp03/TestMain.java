package cn.com.shiro.book.tp03;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class TestMain {
	
	public static void main(String[] args) {
		// 1.创建IniSecurityManagerFactory，基于shiro.ini进行初始化
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro.ini");
		// 2.获取SecurityManager对象
		org.apache.shiro.mgt.SecurityManager securityManager = factory
				.getInstance();
		// 3.注册全局的SecurityManager对象
		SecurityUtils.setSecurityManager(securityManager);
		
		// 获取当前subject对象(匿名用户)
		Subject currUser = SecurityUtils.getSubject();
		
		//UsernamePasswordToken token = new UsernamePasswordToken("root","123456");
		UsernamePasswordToken token = new UsernamePasswordToken("testAbc","123abc");
		currUser.login(token);
		
		System.out.println("登录成功");
		currUser.logout();
	}

}
