package cn.com.shiro.book.tp12.shiro.config;

import java.util.List;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StringUtils;

import cn.com.shiro.book.tp12.entity.ShrResourceItem;
import cn.com.shiro.book.tp12.service.IResourceItemService;

public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean implements
		InitializingBean {
	private IResourceItemService itemService;

	// 初始化好对象后再执行
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setFilterChainDefinitions(this.getChainDefinitions());
		this.setFilterAttributes(this);
		// 注册全局SecurityManager对象
		SecurityUtils.setSecurityManager(this.getSecurityManager());
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
		authc.setSuccessUrl("/resourceAction!findAll.action");
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
		// authcBasic.setLoginUrl("/login.jsp");
		authcBasic.setSuccessUrl("/resourceAction!findAll.action");
		authcBasic.setApplicationName("ShiroBook 登录");
	}

	private String getChainDefinitions() {
		StringBuilder builder = new StringBuilder();
		builder.append("/login.jsp=authc\r\n");
		builder.append("/logout=logout\r\n");
		
		// 获取所有的资源项对象
		List<ShrResourceItem> itemList = this.itemService
				.searchAllResourceItems();
		if (itemList != null) {
			// 循环每个资源项
			for (ShrResourceItem item : itemList) {
				// 判断一定要有url    /user/addUser.jsp=perms[+3+5]\r\n
				if (StringUtils.hasLength(item.getItmUrl())) {
					// url
					builder.append(item.getItmUrl());
					builder.append("=perms[+");
					builder.append(item.getShrResource().getRscId());
					builder.append("+");
					builder.append(item.getItmType());
					builder.append("]\r\n");
				}
			}
		}

		builder.append("/**=anon\r\n");
		System.out.println(builder.toString());
		return builder.toString();
	}

	public void setItemService(IResourceItemService itemService) {
		this.itemService = itemService;
	}

}
