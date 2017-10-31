package cn.com.shiro.book.tp03.authz;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.StringUtils;

public class DemoAuthenticator implements Authenticator {
	// realm 唯一
    private String name;
    /**
     * 实现身份验证接口
     * 
     * AuthenticationToken --》UsernamePasswordToken
     * */
	public AuthenticationInfo authenticate(
			AuthenticationToken token)
			throws AuthenticationException {
		// 获取token信息
		// 验证
		// 返回结果
		
		// AuthenticationInfo的子类对象SimpleAuthenticationInfo
		SimpleAuthenticationInfo authInfo = null;
		// 对token进行基本校验
		if(token == null){
			throw new AuthenticationException("验证token不能为null");
		}
		if(!(token instanceof UsernamePasswordToken)){
			throw new AuthenticationException("暂时只能支持UsernamePasswordToken类型的凭证");
		}
		// 将AuthenticationInfo转换成UsernamePasswordToken
		UsernamePasswordToken userPswToken = (UsernamePasswordToken)token;
		// 获取token中的身份(用户名)和凭证(密码)
		String userName = userPswToken.getUsername();
		String password = new String(userPswToken.getPassword());
		
		// 验证逻辑
		// 校验用户名和密码的合法性 ""   null
		if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
			throw new AuthenticationException("用户名或密码输入不合法");
		}
		
		// 验证逻辑  zhangsan 1234    (zhantestxx  123434352)
		if(userName.contains("test") && password.startsWith("123")){
			// 创建信息对象
			authInfo = new SimpleAuthenticationInfo();
			// 封装验证通过后的身份(用户名)和凭证(密码)
			authInfo.setCredentials(password.toCharArray());
			authInfo.setPrincipals(new SimplePrincipalCollection(userName, this.name));
		}else{
			throw new AuthenticationException("验证失败");
		}
		return authInfo;
	}
	
	// set和get方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
