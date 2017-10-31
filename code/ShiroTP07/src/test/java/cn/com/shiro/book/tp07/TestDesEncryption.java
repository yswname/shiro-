package cn.com.shiro.book.tp07;

import java.security.Key;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.BlowfishCipherService;
import org.junit.Assert;
import org.junit.Test;

public class TestDesEncryption {
	//@Test
	public void testBlowfishCipherSerivce() {
		BlowfishCipherService blowfishCipherSerivce = new BlowfishCipherService();
		blowfishCipherSerivce.setKeySize(128);

		String text = "你好";
		Key key = blowfishCipherSerivce.generateNewKey();
		// 加密
		String encrptText = blowfishCipherSerivce.encrypt(text.getBytes(),
				key.getEncoded()).toHex();
		// 解密
		String text2 = new String(blowfishCipherSerivce.decrypt(
				Hex.decode(encrptText), key.getEncoded()).getBytes());
        System.out.println(encrptText);
		Assert.assertEquals(text, text2);
	}

	//@Test
	public void testAesCipherService() {
		AesCipherService aesCipherService = new AesCipherService();
		aesCipherService.setKeySize(128); // 设置key长度
		// 生成key
		Key key = aesCipherService.generateNewKey();
		String text = "hello,how are you";
		// 加密
		String encrptText = aesCipherService.encrypt(text.getBytes(),
				key.getEncoded()).toHex();
		// 解密
		String text2 = new String(aesCipherService.decrypt(
				Hex.decode(encrptText), key.getEncoded()).getBytes());
		 System.out.println(encrptText);
		Assert.assertEquals(text, text2);

	}
}
