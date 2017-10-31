package cn.com.shiro.book.tp04;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.shiro.authc.pam.AllSuccessfulStrategy;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.CachingRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;


public class TestMain {
	
	public static void main(String[] args) {
//		// 1.创建IniSecurityManagerFactory，基于shiro.ini进行初始化
//		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory(
//				"classpath:shiro.ini");
//		// 2.获取SecurityManager对象
//		org.apache.shiro.mgt.SecurityManager securityManager = factory
//				.getInstance();
//		// 3.注册全局的SecurityManager对象
//		SecurityUtils.setSecurityManager(securityManager);
//		Subject currUser = SecurityUtils.getSubject();
//		
//		//UsernamePasswordToken token = new UsernamePasswordToken("root","123456");
//		UsernamePasswordToken token = new UsernamePasswordToken("1test2","123abc");
//		currUser.login(token);
//		
//		System.out.println("登录成功");
//		currUser.logout();
//		
//		Realm realm;
	
		AuthorizingRealm au;
		org.apache.shiro.mgt.DefaultSecurityManager abc;
        //abc.setRealms(realms);
		CachingRealm cache = null;
		AuthenticatingRealm auth = null;
		IniRealm iniRealm = null;
		//iniRealm.setResourcePath(resourcePath);
		//iniRealm.setResourcePath(resourcePath);
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUsername("");
		dataSource.setPassword("");
		dataSource.setDriverClassName("");
		dataSource.setUrl("");
		
		JdbcRealm jdbc = null;
		jdbc.setAuthenticationQuery("");
		
		AtLeastOneSuccessfulStrategy atLeastStrategy = null;
		FirstSuccessfulStrategy firstStrategy = null;
		AllSuccessfulStrategy allStrategy = null;
	}

}
