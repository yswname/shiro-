package cn.com.shiro.book.tp07;

import junit.framework.Assert;

import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.codec.Hex;
import org.junit.Test;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class TestEncoding {
	//@Test
    public void testBase64EncodeDecode(){
    	String data = "hello,how are you!";
    	// 基于Base64进行编码
    	String base64Encoded = Base64.encode(data.getBytes());
    	System.out.println(base64Encoded);
    	// 解码
    	try {
			String result = new String(Base64.decode(base64Encoded));
			Assert.assertEquals(data, result);
		} catch (Base64DecodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
    }
	//@Test
	public void testHexEncodeDecode(){
		String data = "Hello,你好";
		String encoded = Hex.encodeToString(data.getBytes());
		System.out.println(encoded);
		String result = new String(Hex.decode(encoded));
		Assert.assertEquals(data, result);
	}
	
	@Test
	public void testCodecSupport(){
		String data = "Hello,你好吗!";
		byte[] bytes = CodecSupport.toBytes(data, "utf-8");
		String result = CodecSupport.toString(bytes,"utf-8");
		Assert.assertEquals(data, result);
	}
}
