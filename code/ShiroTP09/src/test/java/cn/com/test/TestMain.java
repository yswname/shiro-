package cn.com.test;

import org.apache.shiro.web.env.IniWebEnvironment;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

public class TestMain {

	public static void main(String[] args) {
		LogoutFilter logoutFilter = null;
//		logoutFilter.setRedirectUrl(redirectUrl);
		RolesAuthorizationFilter rolesFilter = null;
//		rolesFilter.setUnauthorizedUrl(unauthorizedUrl);
		FormAuthenticationFilter authcFilter = null;
//		authcFilter.setLoginUrl(loginUrl);
		PathMatchingFilter  t = null;
		
		IniWebEnvironment web = null;
		RolesAuthorizationFilter roles; 
		
		
		
	}

}
