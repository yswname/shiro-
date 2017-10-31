package cn.com.shiro.book.tp07;

import junit.framework.Assert;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Test;

public class TestHash {
	//@Test
    public void testMD5(){
		System.out.println("md5-->");
    	String data = "Hello,how are you!";
    	String salt = "你好";
    	Md5Hash md5Hash = new Md5Hash(data,salt);
    	// 输出加密结果
    	String result = md5Hash.toString();
    	
    	System.out.println("default:" + result);
    	result = md5Hash.toBase64();
    	System.out.println("base64:" + result);
    	result = md5Hash.toHex();
    	System.out.println("hex:" + result);
    	System.out.println("************************");
    	// 基于MD5多次加密
    	md5Hash = new Md5Hash(data,salt,2);
     	result = md5Hash.toString();
     	System.out.println("2default:" + result);
     	result = md5Hash.toBase64();
     	System.out.println("2base64:" + result);
     	result = md5Hash.toHex();
     	System.out.println("2hex:" + result);
    }
	
	//@Test
    public void testSHA256(){
		System.out.println("sha256-->");
    	String data = "Hello,how are you!";
    	String salt = "你好";
    	Sha256Hash md5Hash = new Sha256Hash(data,salt);
    	String result = md5Hash.toString();
    	System.out.println("default:" + result);
    	result = md5Hash.toBase64();
    	System.out.println("base64:" + result);
    	result = md5Hash.toHex();
    	System.out.println("hex:" + result);
    	
    	md5Hash = new Sha256Hash(data,salt,2);
     	result = md5Hash.toString();
     	System.out.println("2default:" + result);
     	result = md5Hash.toBase64();
     	System.out.println("2base64:" + result);
     	result = md5Hash.toHex();
     	System.out.println("2hex:" + result);
    }
	
	//@Test
    public void testSimpleHash(){
		System.out.println("SimpleHash-->");
    	String data = "Hello,how are you!";
    	String salt = "你好";
    	SimpleHash md5Hash = new SimpleHash("SHA-256",data,salt);//SHA-512
    	String result = md5Hash.toString();
    	System.out.println("default:" + result);
    	result = md5Hash.toBase64();
    	System.out.println("base64:" + result);
    	result = md5Hash.toHex();
    	System.out.println("hex:" + result);
    	
    	md5Hash = new Sha256Hash(data,salt,2);
     	result = md5Hash.toString();
     	System.out.println("2default:" + result);
     	result = md5Hash.toBase64();
     	System.out.println("2base64:" + result);
     	result = md5Hash.toHex();
     	System.out.println("2hex:" + result);
    }
	@Test
	public void testDefaultHashService(){
		System.out.println("***defaultHashService-->");
		String data = "hello,how are you !";
		String privateSalt = "privateSalt";
		String publicSalt = "publicSalt";
		
		DefaultHashService hashService = new DefaultHashService(); //默认算法SHA-512 
		hashService.setHashAlgorithmName("SHA-512"); 
		hashService.setPrivateSalt(new SimpleByteSource(privateSalt)); //私盐，默认无 
		hashService.setGeneratePublicSalt(true);//是否生成公盐，默认false 
		hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());//用于生成公盐。默认就这个 
		hashService.setHashIterations(1); //生成Hash值的迭代次数 
		
		HashRequest request = new HashRequest.Builder() 
        .setAlgorithmName("MD5").setSource(ByteSource.Util.bytes(data)) 
        .setSalt(ByteSource.Util.bytes(publicSalt)).setIterations(2).build(); 

        String result = hashService.computeHash(request).toHex();
        System.out.println(result);
        
        String r = "b475c1dd01076aabc82aba9ce7c63deb";
        Assert.assertEquals(r, result);
	}
}
