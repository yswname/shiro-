package cn.com.shiro.book.tp12.config;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashService;
import org.apache.shiro.crypto.hash.format.DefaultHashFormatFactory;
import org.apache.shiro.crypto.hash.format.HashFormat;
import org.apache.shiro.crypto.hash.format.HashFormatFactory;
import org.apache.shiro.crypto.hash.format.Shiro1CryptFormat;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cn.com.shiro.book.tp12.authz.permission.ShiroRolePermissionResovler;
import cn.com.shiro.book.tp12.realm.ShiroRealm;

// 支持注解
@Configuration
// 注解扫描包
@ComponentScan("cn.com.shiro.book")
public class ShiroWebConfiguration {
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean createShiroFilterFactoryBean() {
		System.out
				.println("*******************create shiroFilter *************");
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		// 设置安全管理器
		shiroFilter.setSecurityManager(this.createSecurityManager());
		// 设置url同filter拦截器的关系
		shiroFilter.setFilterChainDefinitions(this.getChainDefinitions());
		// 初始化filter拦截器
		this.setFilterAttributes(shiroFilter);
		
		return shiroFilter;
	}
	
	private String getChainDefinitions(){
		StringBuilder builder = new StringBuilder();
		builder.append("/login.jsp=authc\r\n");
		builder.append("/logout=logout\r\n");
		builder.append("/adminManager.jsp=authcBasic,roles[admin]\r\n");
		builder.append("/demo/userAction!add.action=perms[user:add]\r\n");
		builder.append("/demo/userAction!edit.action=perms[user:edit]\r\n");
		builder.append("/demo/userAction!delete.action=perms[user:delete]\r\n");
		builder.append("/demo/userAction!query.action=perms[user:query]\r\n");
		
		builder.append("/demo/orderAction!add.action=perms[order:add]\r\n");
		builder.append("/demo/orderAction!edit.action=perms[order:edit]\r\n");
		builder.append("/demo/orderAction!delete.action=perms[order:delete]\r\n");
		builder.append("/demo/orderAction!query.action=perms[order:query]\r\n");
		
		builder.append("/demo/**=authcBasic\r\n");
		builder.append("/welcome.jsp=authcBasic\r\n");
		builder.append("/**=anon\r\n");
		return builder.toString();
	}

	// 初始化authc、logout、roles、perms和authcBasic拦截器
	private void setFilterAttributes(ShiroFilterFactoryBean shiroFilter) {
		Map<String, Filter> filters = shiroFilter.getFilters();
		FormAuthenticationFilter authc = (FormAuthenticationFilter) filters
				.get("authc");
		if (authc == null) {
			authc = new FormAuthenticationFilter();
			// 注册authc拦截器
			filters.put("authc", authc);
		}
		// 设置authc的属性
		authc.setSuccessUrl("/welcome.jsp");
		authc.setLoginUrl("/login.jsp");
		authc.setUsernameParam("userName");
		authc.setPasswordParam("password");

		LogoutFilter logout = (LogoutFilter) filters.get("logout");
		if (logout == null) {
			logout = new LogoutFilter();
			filters.put("logout", logout);
		}
		logout.setRedirectUrl("/login.jsp");

		RolesAuthorizationFilter roles = (RolesAuthorizationFilter) filters
				.get("roles");
		if (roles == null) {
			roles = new RolesAuthorizationFilter();
			filters.put("roles", roles);
		}
		roles.setUnauthorizedUrl("/unauthorized.jsp");

		PermissionsAuthorizationFilter perms = (PermissionsAuthorizationFilter) filters
				.get("perms");
		if (perms == null) {
			perms = new PermissionsAuthorizationFilter();
			filters.put("perms", perms);
		}
		perms.setUnauthorizedUrl("/unauthorized.jsp");

		BasicHttpAuthenticationFilter authcBasic = (BasicHttpAuthenticationFilter) filters
				.get("authcBasic");
		if (authcBasic == null) {
			authcBasic = new BasicHttpAuthenticationFilter();
			filters.put("authcBasic", authcBasic);
		}
		//authcBasic.setLoginUrl("/login.jsp");
		authcBasic.setSuccessUrl("/welcome.jsp");
		authcBasic.setApplicationName("ShiroBook 登录");
	}

	// shiro生命周期处理器
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor createLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	// 调用SecurityUtils注册全局SecurityManager对象
	@Bean
	public MethodInvokingFactoryBean createMethodInvokingFactoryBean() {
		MethodInvokingFactoryBean factoryBean = new MethodInvokingFactoryBean();
		factoryBean
				.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
		factoryBean.setArguments(new Object[] { this.createSecurityManager() });
		return factoryBean;
	}

	@Bean(name = "securityManager")
	public org.apache.shiro.mgt.SecurityManager createSecurityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 设置授权器
		securityManager.setAuthorizer(this.createModularRealmAuthorizer());
		// 设置Realm
		securityManager.setRealms(Arrays.asList(this.createRealm()));
		return securityManager;
	}

	@Bean(name = "shiroRealm")
	public Realm createRealm() {
		ShiroRealm realm = new ShiroRealm();
		// demo里面的辅助
		realm.setPasswordService(this.createPasswordService());
		// 身份凭证匹配器
		realm.setCredentialsMatcher(this.createPasswordMatcher());
		return realm;
	}

	@Bean(name = "authorizer")
	public ModularRealmAuthorizer createModularRealmAuthorizer() {
		ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
		// 权限转换器
		authorizer.setPermissionResolver(this.createPermissionResolver());
		// 角色权限转换器
		authorizer.setRolePermissionResolver(this
				.createRolePermissionResolver());
		return authorizer;
	}

	@Bean(name = "rolePermissionResolver")
	public RolePermissionResolver createRolePermissionResolver() {
		RolePermissionResolver rolePermResolver = new ShiroRolePermissionResovler();
		return rolePermResolver;
	}

	@Bean(name = "permResolver")
	public PermissionResolver createPermissionResolver() {
		PermissionResolver permResolver = new WildcardPermissionResolver();
		return permResolver;
	}

	@Bean(name = "passwordMatcher")
	public PasswordMatcher createPasswordMatcher() {
		// 密码匹配
		PasswordMatcher passwordMatcher = new PasswordMatcher();
		// 设置密码服务
		passwordMatcher.setPasswordService(this.createPasswordService());
		return passwordMatcher;
	}

	@Bean(name = "passwordService")
	public PasswordService createPasswordService() {
		// 密码服务对象
		DefaultPasswordService passwordService = new DefaultPasswordService();
		
		passwordService.setHashFormat(this.createHashFormat());
		passwordService.setHashFormatFactory(this.createHashFormatFactory());
		passwordService.setHashService(this.createHashService());
		return passwordService;
	}

	@Bean(name = "hashFormatFactory")
	public HashFormatFactory createHashFormatFactory() {
		return new DefaultHashFormatFactory();
	}

	@Bean(name = "hashFormat")
	public HashFormat createHashFormat() {
		return new Shiro1CryptFormat();
	}

	@Bean(name = "hashService")
	public HashService createHashService() {
		HashService hashService = new DefaultHashService();
		return hashService;
	}
}
