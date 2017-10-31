package cn.com.test;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.web.env.IniWebEnvironment;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.filter.mgt.DefaultFilter;

public class TestMain {

	public static void main(String[] args) {
		LogoutFilter logoutFilter = null;
//		logoutFilter.setRedirectUrl(redirectUrl);
		RolesAuthorizationFilter rolesFilter = null;
//		rolesFilter.setUnauthorizedUrl(unauthorizedUrl);
		FormAuthenticationFilter authcFilter = null;
//		authcFilter.setUsernameParam(usernameParam);
//		authcFilter.setPasswordParam(passwordParam);
//		authcFilter.setLoginUrl(loginUrl);
//		authcFilter.setSuccessUrl(successUrl);
		PathMatchingFilter  t = null;
		
		IniWebEnvironment web = null;
		RolesAuthorizationFilter roles; 
		IniRealm ini;
		DefaultFilter s;
		JdbcRealm jdbc;
	}

}
