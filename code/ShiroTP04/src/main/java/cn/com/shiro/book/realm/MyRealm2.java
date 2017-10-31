package cn.com.shiro.book.realm;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm2 extends AuthorizingRealm {
    private Map<String,String> users = new HashMap<String,String>();
    {
    	users.put("zhangsan", "123456");
    	users.put("lisi", "12345a");
    	users.put("wangwu", "12345b");
    }
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// 没有做授权控制实现,暂时不会测试到
		return null;
	}

	// 根据token的principals获取AuthenticationInfo，以便同token的Credentials匹配
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		SimpleAuthenticationInfo info = null;
		
		UsernamePasswordToken myToken = (UsernamePasswordToken)token;
		String userName = myToken.getPrincipal().toString();
		// 根据username，从数据库中找到密码啊
		String dbPassword = this.users.get(userName);
		if(dbPassword != null){
			info = new SimpleAuthenticationInfo(userName+":"+this.getName(),dbPassword,this.getName());
		}else{
			throw new  AccountException("账号不存在");
		}
//		if (token != null) {
//			String userName = token.getPrincipal().toString();
//			String password = new String((char[]) token.getCredentials());
//			if ("testUserName".equals(userName)) {
//				info = new SimpleAuthenticationInfo("testUserName:"
//						+ this.getName(), "anyPassword", this.getName());
//				UsernamePasswordToken t = (UsernamePasswordToken) token;
//				// 修改token的密码，以便同返回的info密码一致，AuthorizingRealm里面才能成功匹配
//				t.setPassword("anyPassword".toCharArray());
//			} else if ((userName + "psw").equals(password)) {
//				info = new SimpleAuthenticationInfo(userName + ":"
//						+ this.getName(), password, this.getName());
//			}
//		}
		return info;
	}

}
