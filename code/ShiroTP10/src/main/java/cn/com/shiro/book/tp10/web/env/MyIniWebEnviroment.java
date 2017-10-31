package cn.com.shiro.book.tp10.web.env;

import javax.servlet.Filter;

import org.apache.shiro.util.ClassUtils;
import org.apache.shiro.web.env.IniWebEnvironment;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;

import cn.com.shiro.book.tp10.filter.authc.MyFormLoginFilter;
import cn.com.shiro.book.tp10.filter.authc.MyRoleAccessControlFilter;

public class MyIniWebEnviroment extends IniWebEnvironment {
	@Override
	protected FilterChainResolver createFilterChainResolver() {
		System.out.println("**********MyIniWebEnviroment******");
		// 创建FilterChainResolver
		PathMatchingFilterChainResolver chainResolver = new PathMatchingFilterChainResolver();
		// 创建FilterChainManager
		DefaultFilterChainManager filterChainManager = new DefaultFilterChainManager();
		// 注册默认的Filter
		for (DefaultFilter filter : DefaultFilter.values()) {
			filterChainManager.addFilter(filter.name(),
					(Filter) ClassUtils.newInstance(filter.getFilterClass()));
		}
		// 注册自定义Filters
		filterChainManager.addFilter("myLogin", (Filter)ClassUtils.newInstance(MyFormLoginFilter.class));
		filterChainManager.addFilter("roleAccessFilter", (Filter)ClassUtils.newInstance(MyRoleAccessControlFilter.class));
		// 设置Filter的属性
		LogoutFilter logout = (LogoutFilter)filterChainManager.getFilter("logout");
		logout.setRedirectUrl("/login");
		MyFormLoginFilter myLogin = (MyFormLoginFilter)filterChainManager.getFilter("myLogin");
		myLogin.setLoginUrl("/login");
		myLogin.setSuccessUrl("/welcome.jsp");
		MyRoleAccessControlFilter roleAccessFilter = (MyRoleAccessControlFilter)filterChainManager.getFilter("roleAccessFilter");
		roleAccessFilter.setLoginUrl("/login");
		roleAccessFilter.setUnauthorizedUrl("/unauthorized.jsp");
		// 添加url和Filter的映射
//		/login=myLogin
//				/logout=logout
//				/admin/**=myLogin,roleAccessFilter[admin]
//				/user/**=myLogin, roleAccessFilter[role1]
//				/**=myLogin
		filterChainManager.addToChain("/index.jsp", "anon");
		filterChainManager.addToChain("/login", "myLogin");
		filterChainManager.addToChain("/logout", "logout");
		filterChainManager.addToChain("/admin/**", "roleAccessFilter","admin");
		filterChainManager.addToChain("/user/**", "roleAccessFilter","role1,admin");
		filterChainManager.addToChain("/**", "myLogin");
		
		chainResolver.setFilterChainManager(filterChainManager);
		
		return chainResolver;
	}

}
