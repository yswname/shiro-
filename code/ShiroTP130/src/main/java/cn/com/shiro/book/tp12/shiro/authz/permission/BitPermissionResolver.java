package cn.com.shiro.book.tp12.shiro.authz.permission;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;
/**
 * 基于权限字符串，解析出权限对象
 * */
public class BitPermissionResolver implements PermissionResolver {
	// 只能解析+开头的权限字符串
	@Override
	public Permission resolvePermission(String permissionString) {
		if (permissionString.startsWith("+")) {
			return new BitPermission(permissionString);
		}
		throw new AuthorizationException("权限描述格式不支持["+permissionString+"]");
	}

}
