package cn.com.shiro.book.tp07;

import junit.framework.Assert;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.format.DefaultHashFormatFactory;
import org.apache.shiro.crypto.hash.format.Shiro1CryptFormat;
import org.junit.Test;

public class TestEncryptAndMatcher {
	//@Test
	public void testPasswordMatcher(){
		DefaultPasswordService pswService = new DefaultPasswordService();
    	pswService.setHashService(new DefaultHashService());
    	pswService.setHashFormat(new Shiro1CryptFormat());
    	pswService.setHashFormatFactory(new DefaultHashFormatFactory());
    	
		PasswordMatcher matcher = new PasswordMatcher();
		matcher.setPasswordService(pswService);
		
		AuthenticationToken token = new UsernamePasswordToken("zhangsan","你好，好啊yu","test");
		AuthenticationInfo info = new SimpleAuthenticationInfo("zhangsan","$shiro1$SHA-512$1$$MxtK7wQBV1lXC+U+oQegZKyKsKDKm3ZRTM00yoHnojFzTspHMndb9nFe+Ac20nmraBt1Zm+1sRVF+FtIYqV2VQ==","test");
		Assert.assertTrue(matcher.doCredentialsMatch(token, info));
	}
	@Test
    public void testPasswordService(){
    	// 加密，加密匹配
    	DefaultPasswordService pswService = new DefaultPasswordService();
    	pswService.setHashService(new DefaultHashService());
    	pswService.setHashFormat(new Shiro1CryptFormat());
    	pswService.setHashFormatFactory(new DefaultHashFormatFactory());
    	
    	String data = "你好，好啊yu";
    	String result = pswService.encryptPassword(data);
    	System.out.println(result);
    	Assert.assertTrue(pswService.passwordsMatch(data, result));
    }
}
