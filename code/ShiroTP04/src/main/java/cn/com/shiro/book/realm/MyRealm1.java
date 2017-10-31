package cn.com.shiro.book.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;

public class MyRealm1 implements Realm {
	public String getName() {
		return name;
	}

	public boolean supports(AuthenticationToken token) {
		// 只支持UsernamePasswordToken
		return token instanceof UsernamePasswordToken;
	}

	/**
	 * 根据token获取应用中匹配上的AuthenticationInfo
	 * */
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		SimpleAuthenticationInfo info = null;
		if (token != null) {
			// 获取从Subject中传入的用户名
			String userName = token.getPrincipal().toString();
			// 获取从subject中出入的密码
			String password = new String((char[]) token.getCredentials());
			// 返回的Principals是输入的用户名+":"+realmName
			if ("testUserName".equals(userName)) {
				// testUserName用户可以输入任何密码
				info = new SimpleAuthenticationInfo("testUserName:"
						+ this.getName(), "anyPassword", this.getName());
			} else if ((userName + "psw").equals(password)) {
				// 其他用户的密码是用户名+psw
				info = new SimpleAuthenticationInfo(userName + ":"
						+ this.getName(), password, this.getName());
			}else{
				throw new AuthenticationException("身份验证失败");
			}
		}
		return info;
	}

	private String name = "myRealm1";

	public void setName(String name) {
		this.name = name;
	}
}
