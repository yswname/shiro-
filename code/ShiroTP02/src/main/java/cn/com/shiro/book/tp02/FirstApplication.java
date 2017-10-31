package cn.com.shiro.book.tp02;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstApplication {
	private static final transient Logger log = LoggerFactory
			.getLogger(FirstApplication.class);

	public static void main(String[] args) {
		log.info("第一个Apache Shiro Application");
        // 1.创建IniSecurityManagerFactory，基于shiro.ini进行初始化
		Factory<org.apache.shiro.mgt.SecurityManager> factory = 
				new IniSecurityManagerFactory("classpath:shiro.ini");

		// 2.获取SecurityManager对象
		org.apache.shiro.mgt.SecurityManager securityManager = factory
				.getInstance();

		// 3.注册全局的SecurityManager对象
		SecurityUtils.setSecurityManager(securityManager);

		// 匿名用户
		Subject currUser = SecurityUtils.getSubject();
		
		Session session = currUser.getSession();
		session.setAttribute("userNo", "First User");

		if (!currUser.isAuthenticated()) {
			// 创建Token，封装用户名和密码
			UsernamePasswordToken token = new UsernamePasswordToken("lisi",
					"123456");
			// token.setRememberMe(true);
			try {
				// 实现基于用户名和密码的身份认证
				currUser.login(token);
				// 打印currUser的账号
				log.info("当前Subject的账号是:" + currUser.getPrincipal());
				// 判断currUser是否拥有指定的角色
				if(currUser.hasRole("shoperManager")){
					log.info(currUser.getPrincipal() + " 拥有shoperManager角色" );
				}else{
					log.info(currUser.getPrincipal() + " 没有shoperManager角色" );
				}
				
				if(currUser.hasRole("orderManager")){
					log.info(currUser.getPrincipal() + " 拥有orderManager角色" );
				}else{
					log.info(currUser.getPrincipal() + " 没有orderManager角色" );
				}
				//判断currUser是否有指定的权限
				if(currUser.isPermitted("userManager:create")){
					log.info(currUser.getPrincipal() + " 拥有userManager:create权限");
				}else{
					log.info(currUser.getPrincipal() + " 没有userManager:create权限");
				}
				
				// 退出登录subject
				currUser.logout();
			} catch (UnknownAccountException unk) {
				// 没有账号异常
				unk.printStackTrace();
			} catch (IncorrectCredentialsException inc) {
				// 账号密码不匹配异常
				inc.printStackTrace();
			} catch (LockedAccountException lock) {
				// 账号被锁定异常
				lock.printStackTrace();
			} catch (AuthenticationException auth) {
				// 其他凭证验证异常
				auth.printStackTrace();
			}
		}

		System.exit(0);
	}
}
