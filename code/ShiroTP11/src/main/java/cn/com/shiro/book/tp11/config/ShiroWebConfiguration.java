package cn.com.shiro.book.tp11.config;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.RolePermissionResolver;
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

import cn.com.shiro.book.tp07.authz.permission.BitAndWildcardPermissionResolver;
import cn.com.shiro.book.tp07.authz.permission.ShiroRolePermissionResovler;
import cn.com.shiro.book.tp07.realm.ShiroRealm;

// 支持注解
@Configuration
// 注解扫描包
@ComponentScan("cn.com.shiro.book")
public class ShiroWebConfiguration {
	@Bean(name = "shiroFilter")//可以自定义，但是要记住（web.xml中的配置同它对应）
	public ShiroFilterFactoryBean createShiroFilterFactoryBean() {
		System.out
				.println("*******************create shiroFilter *************");
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		// 设置安全管理器
		shiroFilter.setSecurityManager(this.createSecurityManager());
		String chainDefinitions = "/welcomeTags.jsp=anon\r\n/index.jsp=anon\r\n" + "#/welcome.jsp=authc\r\n"
				+ "#/unauthorized.jsp=authc\r\n" + "/login=authc\r\n"
				+ "/admin/adminServlet=authc,roles[admin]\r\n"
				+ "/user/createUserServlet=authc, roles[role1]\r\n"
				+ "/user/deleteUserServlet=authc, roles[role1,role2]\r\n"
				+ "/user/updateUserServlet=authc, perms[1:4]\r\n"
				+ "/user/queryUserServlet=authcBasic, perms[1:8]\r\n"
				+ "/logout=logout\r\n" + "/*=authc";
		// 设置url同filter拦截器的关系
		shiroFilter.setFilterChainDefinitions(chainDefinitions);
		// 初始化filter拦截器
		this.setFilterAttributes(shiroFilter);
		return shiroFilter;
	}

	// 初始化authc、logout、roles、perms和authcBasic拦截器
	private void setFilterAttributes(ShiroFilterFactoryBean shiroFilter) {
		// 获取ShiroFilter里面的功能拦截器集合
		Map<String, Filter> filters = shiroFilter.getFilters();
		
		FormAuthenticationFilter authc = (FormAuthenticationFilter) filters
				.get("authc");
		if (authc == null) {
			authc = new FormAuthenticationFilter();
			filters.put("authc", authc);
		}
		// 初始化属性
		authc.setSuccessUrl("/welcome.jsp");
		authc.setLoginUrl("/login");
		authc.setUsernameParam("userName");
		authc.setPasswordParam("password");
        // logout
		LogoutFilter logout = (LogoutFilter) filters.get("logout");
		if (logout == null) {
			logout = new LogoutFilter();
			filters.put("logout", logout);
		}
		logout.setRedirectUrl("/login");
        // roles
		RolesAuthorizationFilter roles = (RolesAuthorizationFilter) filters
				.get("roles");
		if (roles == null) {
			roles = new RolesAuthorizationFilter();
			filters.put("roles", roles);
		}
		roles.setUnauthorizedUrl("/unauthorized.jsp");
		// anyRole
		//.....

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
		authcBasic.setApplicationName("ShiroBook 登录");
	}

	// shiro生命周期处理器 （web.xml中指定）
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
		// web环境下，一定要创建DefaultWebSecurityManager对象
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 设置验证器
		securityManager.setAuthorizer(this.createModularRealmAuthorizer());
		// 设置域
		securityManager.setRealms(Arrays.asList(this.createRealm()));
		return securityManager;
	}

	// 创建ShiroRealm
	@Bean(name = "shiroRealm")
	public Realm createRealm() {
		ShiroRealm realm = new ShiroRealm();
		// passwordService
		realm.setPasswordService(this.createPasswordService());
		// 凭证匹配器
		realm.setCredentialsMatcher(this.createPasswordMatcher());
		return realm;
	}

	@Bean(name = "authorizer")
	public ModularRealmAuthorizer createModularRealmAuthorizer() {
		// 创建授权器
		ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
		// 设置权限解析器 和 角色权限解析器
		authorizer.setPermissionResolver(this.createPermissionResolver());
		authorizer.setRolePermissionResolver(this.createRolePermissionResolver());
		return authorizer;
	}

	@Bean(name = "rolePermissionResolver")
	public RolePermissionResolver createRolePermissionResolver() {
		// 角色权限转换器
		RolePermissionResolver rolePermResolver = new ShiroRolePermissionResovler();
		return rolePermResolver;
	}

	@Bean(name = "permResolver")
	public PermissionResolver createPermissionResolver() {
		// 权限转换器
		PermissionResolver permResolver = new BitAndWildcardPermissionResolver();
		return permResolver;
	}

	@Bean(name = "passwordMatcher")
	public PasswordMatcher createPasswordMatcher() {
		// 创建PasswordMatcher
		PasswordMatcher passwordMatcher = new PasswordMatcher();
		// 设置passwordService
		passwordMatcher.setPasswordService(this.createPasswordService());
		return passwordMatcher;
	}

	// PasswordService
	@Bean(name = "passwordService")
	public PasswordService createPasswordService() {
		// 创建PasswordService对象
		DefaultPasswordService passwordService = new DefaultPasswordService();
		// 设置需要的属性
		passwordService.setHashFormat(this.createHashFormat());
		passwordService.setHashFormatFactory(this.createHashFormatFactory());
		passwordService.setHashService(this.createHashService());
		return passwordService;
	}
	
    // HashFormatFactory
	@Bean(name = "hashFormatFactory")
	public HashFormatFactory createHashFormatFactory() {
		return new DefaultHashFormatFactory();
	}
   // HashFormat
	@Bean(name = "hashFormat")
	public HashFormat createHashFormat() {
		return new Shiro1CryptFormat();
	}
    // HashService
	@Bean(name = "hashService")
	public HashService createHashService() {
		HashService hashService = new DefaultHashService();
		return hashService;
	}
	
}
